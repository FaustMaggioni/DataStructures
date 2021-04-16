package EDD.conjuntistas;

class NodoAVL {

    private Comparable elem;
    private int altura;
    private NodoAVL izq;
    private NodoAVL der;

    //Constructor
    public NodoAVL(Comparable e, NodoAVL izq, NodoAVL der) {
        this.elem = e;
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
    }

    public NodoAVL(Comparable e) {
        this.elem = e;
        this.altura = 0;
        this.der = null;
        this.izq = null;
    }

    public NodoAVL() {
        this.elem = null;
        this.altura = -1;
        this.der = null;
        this.izq = null;
    }

    //Otros 
    public Comparable getElem() {
        return this.elem;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVL getIzq() {
        return this.izq;
    }

    public NodoAVL getDer() {
        return this.der;
    }

    public void setElem(Comparable e) {
        this.elem = e;
    }

    public void setIzq(NodoAVL i) {
        this.izq = i;
    }

    public void setDer(NodoAVL d) {
        this.der = d;
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
