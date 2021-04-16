package EDD.jerarquicas;
class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    // Constructor 
    
    public NodoArbol (Object e){
    this.elem= e;
    this.izquierdo= null;
    this.derecho= null;
    
    }
    public NodoArbol(Object e, NodoArbol iz, NodoArbol der){
        this.elem=e;
        this.izquierdo=iz;
        this.derecho=der;
    }
    
    // Visualizadores 
    
    public Object getElemento(){
        return this.elem;
    }
    
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    // Modificadores 
    
    public void setElem(Object e){
        this.elem= e;
    }
    
    public void setIzquierdo(NodoArbol nuevo){
        this.izquierdo= nuevo;
    }
    
    public void setDerecho (NodoArbol nuevo){
        this.derecho= nuevo;
    }
}
