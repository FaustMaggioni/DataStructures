package EDD.conjuntistas;
public class CeldaHash {
    private Object elem;
    private int estado=0;
    
    public CeldaHash(Object e){
        this.elem=e;
        this.estado=1;
    }
    public CeldaHash(){
        this.elem=null;
        this.estado=0;
    }
    
    public void setElem(Object e){
        this.elem=e;  
    }
    public void setEstado(int s){
        this.estado=s;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public Object getElem(){
        return this.elem;
    }
}
