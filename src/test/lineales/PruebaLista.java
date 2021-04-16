package test.lineales;
import TPFinalEDAT.Cola;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
import TPFinalEDAT.Lista;
import TPFinalEDAT.Pila;
public class PruebaLista {
    public static void main(String []args){
         Scanner teclado=new Scanner(System.in);
         Lista L1 = new Lista();
         Lista L2 = new Lista();
         System.out.println("Elija algun de las siguientes opciones: \n a) concatenar dos listas.\n  b) comprobar \n c) : recibe una lista L y devuelve una lista nueva con los elementos de L invertidos. \n d) intercalar. \n e) contar. \n f) esCapicua");
         char opcion= TecladoIn.readLineNonwhiteChar();
            switch(opcion){
                case 'a':
                    boolean 
                    x= L1.insertar(2,1);
                    x= L1.insertar(4,2);
                    x= L1.insertar(6,3);
                    x= L2.insertar(5,1);
                    x= L2.insertar(1,2);
                    x= L2.insertar(6,3);
                    x= L2.insertar(7,4);
                    System.out.println("Lista 1: "+L1.toString());
                    System.out.println("Lista 2: "+L2.toString());
                    Lista L3= concatenar(L1,L2);
                    System.out.println("Lista 3:"+L3.toString());
                    break;
                case 'b':
                    x= L1.insertar(2,1);
                    x= L1.insertar(4,2);
                    x= L1.insertar(6,3);
                    x= L1.insertar(0,4);
                    x= L1.insertar(2,5);
                    x= L1.insertar(4,6);
                    x= L1.insertar(6,7);
                    x= L1.insertar(0,8);
                    x= L1.insertar(6,9);
                    x= L1.insertar(4,10);
                    x= L1.insertar(2,11);
                    x= L1.insertar(8,12);
                    boolean tresbe= comprobar(L1);
                    System.out.println("3B, espera true: "+tresbe);
                    break;
                case 'c':
                    x= L1.insertar(2,1);
                    x= L1.insertar(4,2);
                    x= L1.insertar(2,3);
                    x= L1.insertar(0,4);
                    Lista y= new Lista();
                    y= L1.invertir();
                    
                    System.out.println("Inversa: "+y.toString());
                    /*x= L1.insertar(2,1);
                    x= L1.insertar(4,2);
                    x= L1.insertar(2,3);
                    x= L1.insertar(0,4);
                    x= L1.insertar(2,5);
                    x= L1.insertar(4,6);
                    x= L1.insertar(2,7);
                    x= L1.insertar(0,8);
                    L1.eliminarApariciones(2);
                    System.out.println("L1 con eliminados: "+L1.toString());*/
                    break;
                case 'd':
                    x= L1.insertar(2,1);
                    x= L1.insertar(4,2);
                    x= L1.insertar(6,3);
                    x= L2.insertar(5,1);
                    x= L2.insertar(1,2);
                    x= L2.insertar(6,3);
                    x= L2.insertar(7,4);
                    x=L2.insertar(10,5);
                    Lista L5= intercalar(L1,L2);
                    System.out.println("L5, intercala, espera: 2,5,4,1,6,6,7 "+L5.toString());
                    break;
                case 'e':
                    x= L2.insertar(5,1);
                    x= L2.insertar(7,2);
                    x= L2.insertar(7,3);
                    x= L2.insertar(7,4);
                    x=L2.insertar(10,5);
                    int cant= contarIte(L2,7);
                    int cant2= contarRec(L2, 7);
                    System.out.println("Cant: "+cant+", Cant 2: "+cant2);
                    break;
                case 'f':
                    x= L2.insertar(5,1);
                    x= L2.insertar(7,2);
                    x= L2.insertar(7,3);
                    x= L2.insertar(5,4);
                   
                    boolean rey= esCapicua(L2);
                    System.out.println("Capicua: "+rey);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
         }
    
    
    
    }
    public static boolean esCapicua(Lista x){
        Lista t= invertir(x);
        int i=1;
        boolean var=true;
        while(i<=x.getLongitud()&& var){
            var= x.recuperar(i)==t.recuperar(i); // O Equals, no estoy seguro
            i++;
        }
        return var;
    }


    public static int contarIte(Lista x, Object e){
    int cont=0;
    for(int i=1;i<= x.longitud();i++){
        if(x.recuperar(i).equals(e)){
            cont++;
        }
    }
    return cont;
    
    }
    public static int contarRec(Lista x, Object e){
        int i=1,cont=0;
        
        i= recuento(x,e,i,cont);
        return i;
    }
    private static int recuento(Lista x,Object e,int i,int res){
        if(i!=x.longitud()){
            if(x.recuperar(i).equals(e)){
                res= recuento(x,e,i+1,res+1);
            }else{
                res= recuento(x,e,i+1,res);
            }
        }
        return res;
    }
    public static Lista concatenar(Lista x, Lista y){
        Lista res= new Lista();
        for(int i=1; i<=x.longitud();i++){
            res.insertar(x.recuperar(i), res.longitud()+1);
        }
        for(int j= x.longitud()+1; j<= x.longitud()+y.longitud();j++){
            res.insertar(y.recuperar(j-x.longitud()), res.longitud()+1);
        }
        return res;
    }
    public static boolean comprobar(Lista l){
        int largo=0;
        boolean res= true;
        Lista aux= l.clone();
        Pila pila= new Pila();
        Cola cola= new Cola();
        while(!aux.esVacia() && !aux.recuperar(1).equals(0)){
            largo ++;
            pila.apilar(aux.recuperar(1));
            cola.poner(aux.recuperar(1));
            aux.eliminar(1);
        }
        if(largo*3+2!=l.longitud()|| largo==l.longitud()){
            res= false;
        }
        aux.eliminar(1);
        int i=1;
        while(res&& i<=largo){
            res= aux.recuperar(1).equals(cola.obtenerFrente());
            cola.sacar();
            aux.eliminar(1);
            i++;
        }
        aux.eliminar(1);
        if(res){
            i=1;
            while(res&&i<=largo){
                res= aux.recuperar(1).equals(pila.obtenerTope());
                pila.desapilar();
                aux.eliminar(1);
                i++;
            }
        }
        return res;
    }
public static Lista invertir(Lista x){
    Lista invertida= new Lista();
    int longitud= x.longitud();
    int j=1;
    for(int i=longitud; i>=1; i-- ){
       boolean t= invertida.insertar((int)x.recuperar(i), j);
       j++;
    
}
    return invertida;
}
public static Lista intercalar(Lista x, Lista y){
    int i= 1;
    int j=1;
    int h=1;
    Lista z= new Lista();
    while(i<=x.longitud()+y.longitud()){
        if(j<=x.longitud()&& h<=y.longitud()){
        if((i%2)!=0){
            z.insertar(x.recuperar(j), i);
            j++;
        }else{
            
            z.insertar(y.recuperar(h), i);
            h++;
        }} else{
            if(j>x.longitud()){
                z.insertar(y.recuperar(h), i);
                h++;
            }else{
                z.insertar(x.recuperar(j), i);
                j++;
            }
            
        }
        i++;
   }
    return z;
    
    
    
}}