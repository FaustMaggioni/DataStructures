
package EDD.conjuntistas;
import EDD.conjuntistas.CeldaHash;
import TPFinalEDAT.Lista;

public class TestHashCerrado {
    public static void main(String []args){
        HashCerrado hc= new HashCerrado();
        CeldaHash ch= new CeldaHash(7);
        System.out.println("ch estado: "+ch.getEstado());
        for(int i=1;i <= 35;i++){
            int a= (int)(Math.random()*80);
            hc.insertar(a);
        }
        hc.insertar(8);
        hc.insertar(8);
        Lista x= hc.listar();
        System.out.println("Lista: "+x);
        hc.eliminar(8);
        System.out.println("Lista sin 8: "+hc.listar());
        hc.eliminar(8);
        System.out.println("Lista sin 8: "+hc.listar());
    }
}
