package EDD.jerarquicas;
class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    //Constructor 
    public NodoGen(Object e, NodoGen i, NodoGen h){
        this.elem=e;
        this.hermanoDerecho=h;
        this.hijoIzquierdo=i;
    }
    public NodoGen(Object e){
        this.elem=e;
        this.hermanoDerecho=null;
        this.hijoIzquierdo=null;
    }
    
    //Visualizadores
    public Object getElem(){
        return this.elem;
    }
    
    public NodoGen getHijoIzq(){
        return this.hijoIzquierdo;
    }
    
    public NodoGen getHermanoDer(){
        return this.hermanoDerecho;
    }
    
    //Modificadores
    public void setElem(Object e){
        this.elem=e;
    }
    
    public void setHijoIzq(NodoGen n){
        this.hijoIzquierdo=n;
    }
    
    public void setHermanoDerecho(NodoGen n){
        this.hermanoDerecho=n;
    }
}
