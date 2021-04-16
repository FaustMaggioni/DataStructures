package test.lineales;

import TPFinalEDAT.Cola;
import TPFinalEDAT.Pila;
import TPFinalEDAT.Lista;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class MixLineales {

    public static void main(String[] args) {
       
        Lista n = new Lista();
        System.out.println("Pruebo el método con lista vacía por parametro, espero otra lista vacia: ");
        Lista aux= generarOtraLista(n);
        System.out.println("Aux: "+aux);
        n.insertar('A', 1);
        System.out.println("Testeo método con una lista solamente con A, espero AAA: ");
        aux=generarOtraLista(n);
        System.out.println("Aux: "+aux);
        n.insertar('B', 2);
        n.insertar('*', 3);
        System.out.println("Testeo método con lista con una unica secuencia de letras y que termina en '*', espero ABBAAB*");
        aux= generarOtraLista(n);
        System.out.println("Aux: "+aux);
        n.insertar('C', 4);
        n.insertar('C', 5);
        n.insertar('D', 6);
        n.insertar('*', 7);
        n.insertar('A', 8);
        n.insertar('F', 9);
        n.insertar('A', 10);
        n.insertar('*', 11);
        System.out.println("Lista original: "+n.toString());
        Lista otra= generarOtraLista(n);
        System.out.println("Otra: "+otra);
        System.out.println("Elimino al principio en otra");
        for(int i=1; i<=3;i++){
            otra.eliminar(1);
        }
        System.out.println("Lista otra sin primeros 3 caracteres: "+otra.toString());
        
        System.out.println("Pruebo en lista sin * al final");
        
        n.eliminar(11);
        Lista nueva= generarOtraLista(n);
        System.out.println("Nueva: "+nueva);
        System.out.println("Elimino al final en nueva");
        int j=nueva.longitud();
        for(int i=1; i<= 5; i++){
            nueva.eliminar(j);
            j--;
        }
        System.out.println("Nueva sin 5 elementos al final: ");
        
        System.out.println("Nueva: "+nueva);
        System.out.println("Clono nueva");
        Lista cuarta= nueva.clone();
        System.out.println("Cuarta: "+cuarta);
        System.out.println("Elimino en nueva y no afecta a su clone");
        System.out.println("Nueva: "+nueva);
        System.out.println("Cuarta (clone): "+cuarta);
        
        System.out.println("Con nueva genero otra lista:");
        
        Lista x= generarOtraLista(nueva);
        System.out.println("X: "+x);
        x.vaciar();
        x.insertar('*', 1);
        System.out.println("Testeo método con lista unicamente compuesta por: '*', espero: '*'. ");
        aux= generarOtraLista(x);
        System.out.println("Aux: "+aux);
        System.out.println("Pruebo método en una lista que tenga cadenas separadas por otro simbolo != '*', debe tomarlo como una sola 'vuelta'");
        aux.vaciar();
        aux.insertar('D', 1);
        aux.insertar('C', 2);
        aux.insertar('F', 3);
        aux.insertar('$', 4);
        aux.insertar('B', 5);
        aux.insertar('T', 6);
        aux.insertar('%', 7);
        aux.insertar('R', 8);
        aux.insertar('E', 9);
        aux.insertar('Y', 10);
        Lista z= generarOtraLista(aux);
        System.out.println("Lista z: "+z);
        }
    public static Lista generarOtraLista(Lista lis) {
        Lista res = new Lista();
        
        int i=1, j= 1, largo= lis.longitud();
        Pila aux = new Pila();
        Cola ayu = new Cola();
        while(j<=largo){
        while ( j<=largo && ! lis.recuperar(j).equals('*')) {
            res.insertar(lis.recuperar(j), i);
            aux.apilar(lis.recuperar(j));
            ayu.poner(lis.recuperar(j));
            i++;
            j++;
        }

        while (!aux.esVacia()) {
            res.insertar(aux.obtenerTope(), i);
            aux.desapilar();
            i++;

        }
        while (!ayu.esVacia()) {
            res.insertar(ayu.obtenerFrente(), i);
            ayu.sacar();
            i++;
        }
        if (j<=largo) {
            res.insertar('*', i);
            i++;
            j++;
        }
        }
        return res;
    }

    public static Cola generar(Cola c1) {
        Cola res = new Cola(), aux = c1.clone();
        while (!aux.esVacia()) {
            Pila auxP = new Pila();
            Lista auxL = new Lista();
            while (!aux.esVacia() && !aux.obtenerFrente().equals('#')) {
                res.poner(aux.obtenerFrente());
                auxP.apilar(aux.obtenerFrente());
                auxL.insertar(aux.obtenerFrente(), auxL.longitud() + 1);
                aux.sacar();
            }
            while (!auxP.esVacia()) {
                res.poner(auxP.obtenerTope());
                auxP.desapilar();
            }
            for (int i = 1; i <= auxL.longitud(); i++) {
                res.poner(auxL.recuperar(i));
            }
            if (!aux.esVacia() && aux.obtenerFrente().equals('#')) {
                res.poner(aux.obtenerFrente());
                aux.sacar();
            }
        }
        return res;

    }

    public static int contar(Lista l1, Object e) {
        int res = aux(1, e, l1, l1.longitud());
        return res;
    }

    private static int aux(int i, Object e, Lista t, int l) {
        int res = 0;
        if (i <= l) {
            if (t.recuperar(i).equals(e)) {
                res = aux(i + 1, e, t, l) + 1;
            } else {
                res = aux(i + 1, e, t, l);
            }
        }
        return res;
    }

    public static Lista colatolista(int t, Cola c1) {
        Lista res = new Lista();
        Cola cola = c1.clone();
        while (!cola.esVacia()) {
            Pila pila = new Pila();
            Cola aux = new Cola();
            int i = 1;
            while (!cola.esVacia() && i <= t) {
                res.insertar(cola.obtenerFrente(), res.longitud() + 1);
                pila.apilar(cola.obtenerFrente());
                aux.poner(cola.obtenerFrente());
                cola.sacar();
                i++;
            }
            while (!pila.esVacia()) {
                res.insertar(pila.obtenerTope(), res.longitud() + 1);
                pila.desapilar();
            }
            i = 1;
            while (!aux.esVacia()) {
                res.insertar(aux.obtenerFrente(), res.longitud() + 1);
                aux.sacar();
                i++;
            }
            if (!cola.esVacia()) {
                res.insertar('$', res.longitud() + 1);
            }
        }
        return res;
    }

    public static boolean verificarBalanceo(Cola q) {
        Cola clon = q.clone();
        Pila pila = new Pila();
        String elemento;
        Object tope;
        boolean hayBalance = true;
        while (!clon.esVacia() && hayBalance) {
            elemento = Character.toString((char) clon.obtenerFrente());
            if ("([{".contains(elemento)) {
                if (!pila.esVacia()) {
                    if (pila.obtenerTope().equals("(") && elemento.equals("(")) {// Si esta guardado un ( en el tope la pila, solo inserto si viene otra (
                        pila.apilar(elemento);
                    }
                    if (pila.obtenerTope().equals("{")) { // Si esta guardado una { en el tope, guardo lo que venga
                        pila.apilar(elemento);
                    }
                    if (pila.obtenerTope().equals("[") && !elemento.equals("{")) { // Si es un [ solo guardo si es [ o (
                        pila.apilar(elemento);
                    }

                } else { // Si está vacía guardo cualquiera
                    pila.apilar(elemento);
                }
            } else if (!pila.esVacia() && ")]}".contains(elemento)) {
                tope = pila.obtenerTope();
                if (elemento.equals(")")) {
                    hayBalance = tope.equals("(");
                }
                if (elemento.equals("]")) {
                    hayBalance = tope.equals("[");
                }
                if (elemento.equals("}")) {
                    hayBalance = tope.equals("{");
                }
                pila.desapilar();
            } else {
                if (pila.esVacia() && ")]}".contains(elemento)) {
                    hayBalance = false;
                }

            }
            clon.sacar();

        }
        hayBalance = pila.esVacia();
        return hayBalance;
    }


    /*Cola cola= c.clone();
        char elem;
        char tope;
        Pila pila= new Pila();
        boolean res=true;
        while(!cola.esVacia() && res){
            elem= (char) cola.obtenerFrente();
            if( elem == '[' || elem == '{' || elem == '('){
                pila.apilar(elem);
            }else{
                if(!pila.esVacia()|| elem == ']' || elem == '}' || elem== ')'){
                    tope= (char) pila.obtenerTope();
                    res= (tope == '}' && elem== '{') || (elem=='(' && tope==')') || (elem== '[' && tope== ']');
                }
                pila.desapilar();
            }
            cola.sacar();
        }
        return res;*/
    public static Cola generarOtraCola(Cola c1) {
        Cola nueva = new Cola();
        Cola auxCola = c1.clone();
        Pila auxPila = new Pila();
        while (auxCola.esVacia() == false) {
            invertido(auxCola, auxPila, nueva);
        }

        return nueva;
    }

    private static void invertido(Cola auxCola, Pila auxPila, Cola nueva) {

        while (auxCola.esVacia() == false && (char) auxCola.obtenerFrente() != '#') {
            auxPila.apilar(auxCola.obtenerFrente());
            nueva.poner(auxCola.obtenerFrente());
            auxCola.sacar();
        }
        while (auxPila.obtenerTope() != null) {
            nueva.poner(auxPila.obtenerTope());
            auxPila.desapilar();
        }
        if (!auxCola.esVacia()) {
            nueva.poner(auxCola.obtenerFrente());
            auxCola.sacar();
        }

    }

}
