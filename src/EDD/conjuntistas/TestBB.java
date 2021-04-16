package EDD.conjuntistas;

import TPFinalEDAT.Lista;

public class TestBB {

    public static void main(String args[]) {
        System.out.println("TEST ÁRBOL BINARIO DE BÚSQUEDA");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ArbolBB a = new ArbolBB();
        System.out.println("Elimina minimo en arbol vacio, espera false: " + a.eliminarMinimo());
        System.out.println("Elimina maximo en arbol vacio, espera false: " + a.eliminarMaximo());
        System.out.println("Arbol sin elementos: " + a);
        a.insertar(42);
        System.out.println("Inserta repetido, espera false: " + a.insertar(42));
        System.out.println("Elimino unico elemento, raiz. Espero true: " + a.eliminarMaximo());
        System.out.println("arbol A, espero vacio: " + a);
        System.out.println("Lo inserto de vuelta");
        a.insertar(42);
        System.out.println("Inserto elementos");

        a.insertar(22);
        a.insertar(52);
        a.insertar(13);
        a.insertar(45);
        a.insertar(72);
        a.insertar(33);
        a.insertar(70);
        a.insertar(71);
        a.insertar(92);
        System.out.println("Preorden: "+a.listar());
        //a.insertar(7);
        //a.insertar(97);
        System.out.println("Diferencia: "+a.amplitudSubArbol(42));
        System.out.println("Arbol anc: \n"+ a.ancestrosArbol(45));
        System.out.println("Lista ancestros: "+a.ancestros(45));
        System.out.println("Lista reves: "+a.listarInv());
        System.out.println("Simetria: "+a.verifSimetria(42));
        ArbolBB i= a.clonarParteInvertida(42);
        int res= a.masNodosEnRango(12, 52);
        System.out.println("Lista mayor igual a 92: "+a.listarMayorIgual(92));
        System.out.println("res: "+res);
        System.out.println("i: "+i);
        Lista r= a.listarMayoresQue(15,52);
        System.out.println("Lista: "+r);
        System.out.println("Arbol a, debe dar: \n Raiz: 42, HI: 22, HD: 52. \n Nodo: 22, HI: 13, HD: 33, \n Nodo: 13, HI: 7, HD: no tiene "
                + "\n Nodo: 7, HI: no tiene, HD: no tiene \n Nodo: 33, HI: no tiene, HD: no tiene"
                + "\n Nodo: 52, HI: 45, HD: 72 \n Nodo: 45, HI: no tiene, HD: no tiene \n Nodo: 72, HI: no tiene, HD: 92 \n "
                + "Nodo: 92, HI: 88, HD: no tiene \n Nodo: 88, HI: no tiene, HD: no tiene. \n" + a);

        ArbolBB b = a.clone();
        System.out.println("Elimino maximo y minimo de b");
        System.out.println("Eliminar maximo espera true: " + b.eliminarMaximo()); //Elimina 92
        System.out.println("Eliminar minimo espera true: " + b.eliminarMinimo()); // Elimina 7
        System.out.println("Comparo arbol b con arbol a");
        System.out.println("Arbol a, debe seguir igual que antes: \n" + a);
        System.out.println("Arbol b, debe dar: \n \n Raiz: 42, HI: 22, HD: 52. \n Nodo: 22, HI: 13, HD: 33, \n Nodo: 13, HI: no tiene, HD: no tiene "
                + "\n Nodo: 33, HI: no tiene, HD: no tiene"
                + "\n Nodo: 52, HI: 45, HD: 72 \n Nodo: 45, HI: no tiene, HD: no tiene \n Nodo: 72, HI: no tiene, HD: 88 \n "
                + "Nodo: 88, HI: no tiene, HD: no tiene \n" + b);
        Lista rango = a.listarRango(13, 72);
        System.out.println("Rango desde 13 a 72: " + rango);
        System.out.println("Maximo de a: " + a.maximoElemento());
        System.out.println("Elimino maximo, espero true: " + a.eliminarMaximo());
        System.out.println("Nuevo maximo de a: " + a.maximoElemento());
        System.out.println("Es vacio b? Espera false: " + b.esVacío());
        System.out.println("Vacío b");
        b.vaciar();
        System.out.println("Pregunto si b es vacio después de vaciar, espera true: " + b.esVacío());
        Lista rangoB = b.listarRango(0, 12);
        System.out.println("Listo un rango inexistente espero lista vacia");
        System.out.println("Rango B: " + rangoB);
        
        Object maxB = b.maximoElemento(); //Aclaración: pongo Object porque justamente está vacío el arbol y así devuelve null
        System.out.println("Max B, (arbol vacio, espero null): " + maxB);
        rango = a.listarRango(0, 100);
        Lista todoarbola = a.listar();
        System.out.println("Comparo listar en un rango que abarca todo el arbol a, con el metodo listar()");
        System.out.println("Lista Rango: " + rango + "; Lista de listar(): " + todoarbola);
        System.out.println("Son iguales?: " + rango.equals(todoarbola));
        b.insertar(5);
        b.insertar(1);
        b.insertar(100);
        b.insertar(-4);
        b.insertar(50);
        b.insertar(-20);
        System.out.println("B: " + b);
        System.out.println("Vacio el arbol b usando eliminarMaximo()");
        for (int i = 0; i <= 6; i++) {
            if (!b.esVacío()) {
                System.out.println("Elimino maximo de b, espero true: " + b.eliminarMaximo());
            } else {
                System.out.println("Elimino maximo en arbol vacio, espero false: " + b.eliminarMaximo());
            }
        }
        System.out.println("B, espero vacio: " + b);
        ArbolBB c = new ArbolBB();
        System.out.println("Inserto numeros descendentes para que la raiz sea el maximo");
        for (int i = 10; i >= 1; i--) {
            c.insertar(i);
        }
        System.out.println("C antes de eliminar maximo/raiz, espera raíz y solamente hijos izquierdos: " + c);
        System.out.println("Elimino maximo de c, espero true: " + c.eliminarMaximo());
        System.out.println("C sin raiz: " + c);
        System.out.println("Vacío b, y hago algo similar a lo anterior pero con la raíz como mínimo");
        b.vaciar();;
        for (int i = 1; i <= 20; i = i + 2) {
            b.insertar(i);
        }
        System.out.println("Muestro b, espera Raiz y solamente hijos derechos: " + b);
        System.out.println("Elimino minimo, o sea la raíz: ");
        b.eliminarMinimo();
        System.out.println("B sin raiz: " + b);
        System.out.println("--------------");
        System.out.println("Recupero minimo y maximo de arbol a, y luego listo rango desde maximo a minimo, espera lista vacia");
        int min = (int) a.minimoElemento();
        System.out.println("Minimo de a: " + min);
        int max = (int) a.maximoElemento();
        System.out.println("Maximo de a: " + max);
        rango = a.listarRango(max, min);
        System.out.println("Lista Rango [max,min]: " + rango);
        System.out.println("Listo rango un solo elemento, [max,max]: " + a.listarRango(max, max));
        
    }

}
