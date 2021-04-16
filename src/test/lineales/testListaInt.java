
package test.lineales;
import TPFinalEDAT.Lista;
import TPFinalEDAT.TecladoIn;
public class testListaInt {
    public static void main(String []args){
    Lista lista= new Lista();
    boolean
    x= lista.insertar('N',1);
    x= lista.insertar('E',2);
    x= lista.insertar('U',3);
    x= lista.insertar('Q',4);
    x= lista.insertar('U',5);
    x= lista.insertar('E',6);
    x= lista.insertar('N',7);
    /*x= lista.insertar('T', 8);
    x= lista.insertar('*', 9);*/
    boolean cap= esCapicua(lista);
        System.out.println("Capicua? "+cap);
    Lista m= lista.multiplos(3);
        System.out.println("Multiplos: "+m.toString());
    System.out.println("Lista: "+lista.toString());
    lista.eliminarApariciones('U');
    lista.eliminarApariciones('E');
        System.out.println("Lista sin U ni E: "+lista.toString());
    Lista in= invertir(lista);
        System.out.println("Invertida: "+in.toString());
    Lista a= lista.generarOtraLista(lista);
        System.out.println("Lista a: "+a.toString());
    int longitud= lista.longitud();
    System.out.println("Longitud: "+longitud);
    x= lista.eliminar(5);
    System.out.println("Lista: "+lista.toString());
    x= lista.eliminar(1);
    System.out.println("Lista: "+lista.toString());
    int elemento= (int) lista.recuperar(4);
    System.out.println("Recuperó 6:"+elemento);
    int posicion= (int) lista.localizar(6);
    System.out.println("Posición, espera 4 creo:"+posicion);
    posicion= (int)lista.localizar(9);
    System.out.println("Posición:"+posicion);
    x= lista.eliminar(9);
    System.out.println("Boolean si eliminó en posición inválida:"+x);
    lista.vaciar();
    System.out.println("Lista: "+lista.toString());
    x= lista.insertar(2,1);
    x= lista.insertar(4,2);
    x= lista.insertar(2,3);
    x= lista.insertar(8,4);
    System.out.println("Longitud:"+lista.longitud());
    x= lista.insertar(10,7);
    x= lista.insertar(11,5);
    x= lista.insertar(6,6);
    Lista clone= lista.clone();
    System.out.println("Clone: "+clone.toString());
    System.out.println("Lista: "+lista.toString());
    x= lista.eliminar(2);
    System.out.println("Lista con uno menos: "+lista.toString());
    System.out.println("Verifico si afecta a la clone: "+clone.toString());
    }
    public static Lista invertir(Lista x){
        Lista res= new Lista();
        for(int i=1;i<= x.longitud();i++){
            res.insertar(x.recuperar(x.longitud()+1-i), i);
        }
        return res;
    }
    public static boolean esCapicua(Lista x){
        Lista aux= invertir(x);
        boolean res= aux.equals(x);
        System.out.println("Res de capicua: "+res);
        return res;
    }
}