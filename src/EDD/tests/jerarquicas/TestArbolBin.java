
package EDD.tests.jerarquicas;
import EDD.jerarquicas.ArbolBin;
import TPFinalEDAT.Lista;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class TestArbolBin {
    public static void main(String [] args){
        ArbolBin arbol= new ArbolBin();
        arbol.insertar(2,null,'I');
        arbol.insertar(3,2,'I');
        arbol.insertar(5,3,'D');
        arbol.insertar(1,2,'D');
        arbol.insertar(4,1,'D');
        /*Lista preorden= arbol.preOrden();
        Lista inorden= arbol.inoen();
        Lista posorden= arbol.posorden();
        System.out.println("Lista PosOrden: "+posorden.toString());
        System.out.println("Lista InOrden: "+inorden.toString());
        System.out.println("Lista PreOrden: "+preorden.toString());*/
        boolean x= arbol.insertar(2,1,'D');
        System.out.println("Boolean: "+x);
        System.out.println(arbol.toString());
        ArbolBin copia= arbol.invertir();
        System.out.println("Invertido: "+copia);
        System.out.println("Es vacio? "+arbol.esVacio());
        int padre= (int)arbol.padre(5);
        System.out.println("Padre de 5, sería 3: "+padre);
        int altura= arbol.altura();
        System.out.println("Altura: "+altura);
        int nivel= arbol.nivel(9);
        System.out.println("Nivel del 9: "+nivel);
        arbol.vaciar();
        System.out.println("Es vacia? "+arbol.esVacio());
        arbol.insertar(4,null,'I');
        arbol.insertar(8,4,'I');
        arbol.insertar(5,4,'D');
        //arbol.insertar(1,8,'D');
        arbol.insertar(3,8,'I');
        arbol.insertar(89, 3, 'I');
        arbol.insertar(6,5,'I');
        arbol.insertar(7,5,'D');
        arbol.insertar(67,7,'D');
        arbol.insertar(12,1,'I');
        arbol.insertar(18,1,'D');
        arbol.insertar(20,18,'D');
        arbol.insertar(9,12,'D');
        arbol.insertar(13,9,'D');
        //arbol.insertar(91,9,'I');
        //arbol.insertar(88,91,'D');
       /* System.out.println("Arbol original: "+arbol.toString());
        altura= arbol.altura();
        System.out.println("Altura: "+altura);
        preorden= arbol.preorden();
        System.out.println("Lista PreOrden: "+preorden.toString());
        inorden= arbol.inorden();
        System.out.println("Lista InOrden: "+inorden.toString());
        posorden= arbol.posorden();
        System.out.println("Lista PosOrden: "+posorden.toString());
        Lista niveles= arbol.listarNiveles();
        System.out.println("Lista Niveles: "+niveles.toString());
        ArbolBin clone= arbol.clone();
        arbol.vaciar();
        System.out.println("Arbol clone: "+clone.toString());
        System.out.println("Arbol original: "+arbol.toString());*/
        Lista ls= new Lista();
        ls.insertar(4, 1);
        ls.insertar(5, 2);
        ls.insertar(6, 3);
        /*ls.insertar(1, 3);
        ls.insertar(12, 4);
        ls.insertar(9, 5);
        ls.insertar(13, 6);
        ls.insertar(00, 7);*/
        boolean listado= arbol.verificarPatron(ls);
        System.out.println("Listado "+listado);
        Lista front= arbol.frontera();
        System.out.println("Frontera: "+front.toString());
        Lista maslarga= arbol.listaQueJustificaLaAltura();
        System.out.println("Mas larga: "+maslarga.toString());
    }
}
