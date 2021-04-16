package EDD.conjuntistas;
import EDD.conjuntistas.funciones;
import TPFinalEDAT.Lista;

public class TestHashAbierto {
    public static void main (String []args){
        System.out.println("Funcion:"+funciones.funcioncadena(10));
        System.out.println("Funcion:"+funciones.funcioncadena(10));
        HashAbierto h= new HashAbierto();
        System.out.println("Vacio: "+h.esVacio());
        for(int i=1; i<=74; i++){
            int a= (int) (Math.random() * 101);
            h.insertar(a);
        }
        h.insertar(21);
        Lista r= h.listar();
        System.out.println("Lista: "+r.toString());
        boolean x= h.pertenece(33);
        System.out.println("33 "+x);
        x= h.pertenece(10);
        System.out.println("10"+ x);
        h.eliminar(21);
        h.eliminar(10);
        r=h.listar();
        System.out.println("Lista sin 21: "+r);
        
    }
}
