package EDD.conjuntistas;
class NodoArbol {
    private Comparable elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    // Constructor 
    
    public NodoArbol (Comparable e){
    this.elem= e;
    this.izquierdo= null;
    this.derecho= null;
    
    }
    public NodoArbol(Comparable e, NodoArbol iz, NodoArbol der){
        this.elem=e;
        this.izquierdo=iz;
        this.derecho=der;
    }
    
    // Visualizadores 
    
    public Comparable getElemento(){
        return this.elem;
    }
    
    public boolean esHoja(){
        return this.getIzquierdo()==null && this.getDerecho()==null;
    }
    
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    // Modificadores 
    
    public void setElem(Comparable e){
        this.elem= e;
    }
    
    public void setIzquierdo(NodoArbol nuevo){
        this.izquierdo= nuevo;
    }
    
    public void setDerecho (NodoArbol nuevo){
        this.derecho= nuevo;
    }
}

