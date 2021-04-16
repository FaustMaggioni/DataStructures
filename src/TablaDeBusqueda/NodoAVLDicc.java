/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaDeBusqueda;

/**
 *
 * @author Faustino
 */
class NodoAVLDicc {
    private Comparable clave;
    private Object dato;
    private int altura;
    private NodoAVLDicc izq;
    private NodoAVLDicc der;
    
    public NodoAVLDicc(Comparable e, Object d, NodoAVLDicc i, NodoAVLDicc der){
        this.altura=0;
        this.clave = e;
        this.der = der;
        this.izq = izq;
        this.altura = 0;
        int altizq = -1, altder = -1;
        if (this.izq != null) {
            altizq = izq.getAltura();
        }
        if (this.der != null) {
            altder = der.getAltura();
        }
        this.altura = Math.max(altder, altizq) + 1;
        this.dato=d;
        
    }
    
     public NodoAVLDicc(Comparable e,Object d) {
        this.clave = e;
        this.altura = 0;
        this.dato=d;
        this.der = null;
        this.izq = null;
    }

    public NodoAVLDicc() {
        this.clave = null;
        this.dato=null;
        this.altura = -1;
        this.der = null;
        this.izq = null;
    }
    
    public Comparable getElem() {
        return this.clave;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVLDicc getIzq() {
        return this.izq;
    }

    public NodoAVLDicc getDer() {
        return this.der;
    }

    public void setElem(Comparable e) {
        this.clave = e;
    }

    public void setIzq(NodoAVLDicc i) {
        this.izq = i;
    }

    public void setDer(NodoAVLDicc d) {
        this.der = d;
    }
    
    public void setDato(Object dato){
        this.dato=dato;
    }
    
    public Object getDato(){
        return this.dato;
    }

    public void recalcularAltura() {
        int altizq = -1, altder = -1;
        if (this.izq != null) {
            altizq = izq.getAltura();
        }
        if (this.der != null) {
            altder = der.getAltura();
        }
        this.altura = Math.max(altder, altizq) + 1;

    }

    public int balance() {
        int izq = -1, der = -1;
        if (this.izq != null) {
            izq = this.izq.getAltura();
        }
        if (this.der != null) {
            der = this.der.getAltura();
        }
        int bal = izq-der;
        return bal;
    }

}
    

