package EDD.conjuntistas;
public class TestHeap {
    public static void main (String[]args){
        Heap heap= new Heap();
        heap.insertar(1);
        heap.insertar(12);
        heap.insertar(2);
        heap.insertar(8);
        heap.insertar(20);
        heap.insertar(10);
        heap.insertar(4);
        System.out.println("Heap: "+heap.toString());
        
        
        
        
    }
}
