package EDD.Mapeos;



public class NodoHashMapeo {
    private Object dominio;
    private Object rango;
    private NodoHashMapeo enlace;
    
    public NodoHashMapeo(Object d, Object r, NodoHashMapeo e){
        this.dominio=d;
        this.rango=r;
        this.enlace=e;
    }
    public void setEnlace(NodoHashMapeo n){
        this.enlace=n;
    }
    public Object getDominio(){
        return this.dominio;
    }
    public Object getRango(){
        return this.rango;
    }
    public NodoHashMapeo getEnlace(){
        return this.enlace;
    }
}
