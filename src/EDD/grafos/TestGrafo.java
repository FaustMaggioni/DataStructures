package EDD.grafos;

import TPFinalEDAT.Lista;

public class TestGrafo {
    public static void main (String[] args){
        Grafo g= new Grafo();
        for(int i=0; i<= 7;i++){
            g.insertarVertice(i);
        }
        g.insertarArco(6, 5, 333);
        g.insertarArco(6, 2, 657);
        g.insertarArco(6, 1, 800);
        g.insertarArco(3, 6, 0);
        g.insertarArco(4, 0, 221);
        g.insertarArco(4, 5, 1992);
        g.insertarArco(1, 3, 211);
        g.insertarArco(2, 0, 55);
        g.insertarArco(2, 1, 100);
        System.out.println(g.toString());
        System.out.println("Existe camino del 6 al 2? "+g.existeCamino(6, 1));
        System.out.println("Corto 6-5: "+g.caminoMasCorto(3, 4));
        System.out.println("Lista en prof: "+g.enProfundidad()+", en anchura: "+g.enAnchura());
        //g.eliminarArco(6, 3);
        System.out.println("G: "+g.toString());
        //g.eliminarVertice(6);
        System.out.println("G: "+g.toString());
        System.out.println("Existe 3? "+g.existeVertice(3));
        Lista liviana= g.liviano(4, 5);
        System.out.println("Liviana: "+liviana);
    }
}
