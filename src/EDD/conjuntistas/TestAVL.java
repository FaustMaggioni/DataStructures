package EDD.conjuntistas;
public class TestAVL {
    public static void main(String []args){
        ArbolAVL av= new ArbolAVL();
        av.insertar(6);
        av.insertar(36);
        av.insertar(16);
        av.insertar(68);
        av.insertar(60);
        av.insertar(70);
        av.insertar(75);
        av.insertar(5);
        av.insertar(91);
        
        System.out.println("AVL: "+av.toString());
        
        av.eliminar(68);
        av.eliminar(16);
        av.eliminar(60);
        av.eliminar(6);
        av.eliminar(5);
        System.out.println("AVL: "+av.toString());
        
    }
}
