package EDD.jerarquicas;

import TPFinalEDAT.Cola;
import TPFinalEDAT.Lista;

public class ArbolBin {

    private NodoArbol raiz;

    // Constructor
    public ArbolBin() {
        this.raiz = null;
    }

    //Modificador
    public ArbolBin clonarInvertido() {
        ArbolBin res = new ArbolBin();
        NodoArbol r = new NodoArbol(this.raiz.getElemento());
        res.raiz = r;
        NodoArbol aux= this.raiz;
        aux(aux, res.raiz);
        return res;
    }

    private void aux(NodoArbol n,NodoArbol x) {
        NodoArbol rep= n;
        NodoArbol equis= x;
        while (n != null) {
            x.setDerecho(new NodoArbol(n.getIzquierdo()));
            x.setIzquierdo(new NodoArbol(n.getDerecho()));
            n= n.getIzquierdo();
            x= x.getDerecho();
        }
        while(rep!=null){
            equis.setIzquierdo(new NodoArbol(rep.getDerecho()));
            equis.setDerecho(new NodoArbol(rep.getIzquierdo()));
            rep= rep.getDerecho();
            equis=equis.getIzquierdo();
        }

    }

    public boolean insertar(Object nuevo, Object padre, char lugar) {
        boolean res = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevo);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, padre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(nuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        nodoPadre.setDerecho(new NodoArbol(nuevo));
                    } else {
                        res = false;
                    }
                }
            } else {
                res = false;
            }

        }
        return res;

    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol res = null;
        if (n != null) {
            if (n.getElemento().equals(buscado)) {
                res = n;
            } else {
                res = obtenerNodo(n.getIzquierdo(), buscado);
                if (res == null) {
                    res = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return res;
    }
    // Visualizadores 

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Object padre(Object e) {
        Object res = (nodoPadre(e, this.raiz));
        return res;
    }

    private Object nodoPadre(Object e, NodoArbol r) {
        Object res = null;
        if (r != null) {
            if (e.equals(this.raiz.getElemento())) {
                res = null;
            } else {
                if (r.getIzquierdo() != null) {
                    if (r.getIzquierdo().getElemento().equals(e)) {
                        res = r.getElemento();
                    } else {
                        res = nodoPadre(e, r.getIzquierdo());
                    }
                }
                if (res == null) {
                    if (r.getDerecho() != null) {
                        if (r.getDerecho().getElemento().equals(e)) {
                            res = r.getElemento();
                        } else {
                            res = nodoPadre(e, r.getDerecho());
                        }
                    }
                }
            }
        }
        return res;
    }

    public int altura() {
        int res = -1;
        if (this.raiz != null) {
            res = buscaAltura(0, this.raiz);
        }
        return res;
    }

    private int buscaAltura(int h, NodoArbol r) {
        int res = -1;
        if (r != null) {
            if (r.getDerecho() == null && r.getIzquierdo() == null) {
                res = h;
            } else {
                res = Math.max(buscaAltura(h + 1, r.getIzquierdo()), buscaAltura(h + 1, r.getDerecho()));
            }
        }
        return res;

    }

    public int nivel(Object e) {
        int res = nivelRec(e, 0, this.raiz);
        return res;
    }

    private int nivelRec(Object e, int cont, NodoArbol n) {
        int res = -1;
        if (e.equals(n.getElemento())) {
            res = cont;
        } else {
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                res = -1;
            } else {
                cont++;
                if (n.getIzquierdo() != null) {
                    res = nivelRec(e, cont, n.getIzquierdo());
                }
                if (res == -1) {
                    if (n.getDerecho() != null) {
                        res = nivelRec(e, cont, n.getDerecho());
                    }
                }
            }
        }
        return res;
    }

    public Lista listarPreorden() {
        Lista l = new Lista();
        preordenAux(this.raiz, l, 1);
        return l;

    }

    private void preordenAux(NodoArbol n, Lista l, int i) {
        if (n != null) {
            l.insertar(n.getElemento(), i);
            preordenAux(n.getIzquierdo(), l, i + 1);
            preordenAux(n.getDerecho(), l, l.longitud() + 1);

        }
    }

    public Lista listarInorden() {
        Lista l = new Lista();
        if (this.raiz != null) {
            inordenAux(this.raiz, l, 1);
        }
        return l;

    }

    private void inordenAux(NodoArbol n, Lista l, int i) {
        if (n != null) {

            inordenAux(n.getIzquierdo(), l, i);
            i = l.longitud() + 1;
            l.insertar(n.getElemento(), i);

            inordenAux(n.getDerecho(), l, i);

        }
    }

    public Lista listarPosorden() {
        Lista l = new Lista();
        posordenAux(this.raiz, l, 1);
        return l;

    }

    private void posordenAux(NodoArbol n, Lista l, int i) {
        if (n != null) {
            i = l.longitud() + 1;
            posordenAux(n.getIzquierdo(), l, i);
            posordenAux(n.getDerecho(), l, l.longitud() + 1);
            l.insertar(n.getElemento(), l.longitud() + 1);

        }
    }

    public Lista listarNiveles() {
        Cola Q = new Cola();
        Lista res = new Lista();
        Q.poner(this.raiz);
        int i = 1;
        while (!Q.esVacia()) {
            NodoArbol actual = (NodoArbol) (Q.obtenerFrente());
            Q.sacar();
            res.insertar(actual.getElemento(), i);
            i++;
            if (actual.getIzquierdo() != null) {
                Q.poner(actual.getIzquierdo());
            }
            if (actual.getDerecho() != null) {
                Q.poner(actual.getDerecho());
            }

        }
        return res;
    }

    public ArbolBin clone() {
        ArbolBin nuevo = new ArbolBin();
        nuevo.raiz = clonarAux(this.raiz);
        return nuevo;
    }

    private NodoArbol clonarAux(NodoArbol aux) {
        NodoArbol hijo = null;
        if (aux != null) {
            hijo = new NodoArbol(aux.getElemento(), clonarAux(aux.getIzquierdo()), clonarAux(aux.getDerecho()));
        }
        return hijo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public String toString() {
        String s = "Arbol vacio";
        if (this.raiz != null) {

            s = "\n Raiz: " + toStringAux(this.raiz, ".");
        }
        return s;
    }

    private String toStringAux(NodoArbol n, String s) {
        if (n != null) {
            s = n.getElemento().toString();
            s = s + " HI de " + n.getElemento().toString() + "-> " + toStringAux(n.getIzquierdo(), s) + ". ";
            s = s + " HD de " + n.getElemento().toString() + "-> " + toStringAux(n.getDerecho(), s) + ". ";
            s = s + " \n";
        } else {
            s = " -";
        }
        return s;
    }

    public boolean verificarPatron(Lista lis) {
        Lista aux = lis.clone();
        boolean res = verifAux(aux, this.raiz);
        return res;
    }

    private boolean verifAux(Lista l, NodoArbol n) {
        boolean res = false;
        if (n != null) {
            if (n.getElemento().equals(l.recuperar(1))) {
                l.eliminar(1);
                if (l.esVacia() && ((n.getDerecho() == null) && (n.getIzquierdo() == null))) {
                    res = true;
                } else {
                    res = verifAux(l, n.getIzquierdo());
                    if (!res) {
                        res = verifAux(l, n.getDerecho());
                    }
                }
            } else {
                res = false;
            }
        }
        return res;
    }

    public Lista frontera() {
        Lista frontera = new Lista();
        frontAux(frontera, this.raiz);
        return frontera;
    }

    private void frontAux(Lista f, NodoArbol n) {
        if (n != null) {
            if (n.getDerecho() == null && n.getIzquierdo() == null) {
                f.insertar(n.getElemento(), f.longitud() + 1);
            } else {
                frontAux(f, n.getIzquierdo());
                frontAux(f, n.getDerecho());
            }
        }
    }

    public Lista listaQueJustificaLaAltura() {
        Lista res = new Lista();
        Lista actual = new Lista();
        if (this.raiz != null) {
            res = caminoLargo(this.raiz, actual, res);
        }
        return res;
    }

    private Lista caminoLargo(NodoArbol n, Lista actual, Lista res) {

        if (n != null) {
            actual.insertar(n.getElemento(), actual.longitud() + 1);
            if (n.getDerecho() == null && n.getIzquierdo() == null) {
                if (actual.longitud() > res.longitud()) {
                    res = actual.clone();
                }
            } else {
                res = caminoLargo(n.getIzquierdo(), actual, res);
                if (n.getIzquierdo() != null) {
                    actual.eliminar(actual.longitud());
                }
                res = caminoLargo(n.getDerecho(), actual, res);
                if (n.getDerecho() != null) {
                    actual.eliminar(actual.longitud());
                }

            }
        }
        return res;

    }
    public ArbolBin invertir() {
        ArbolBin nuevo = new ArbolBin();
        nuevo.raiz = invAux(this.raiz);
        return nuevo;
    }

    private NodoArbol invAux(NodoArbol aux) {
        NodoArbol hijo = null;
        if (aux != null) {
            hijo = new NodoArbol(aux.getElemento(),invAux(aux.getDerecho()) ,invAux(aux.getIzquierdo()) );
            }
        return hijo;
    }
}

/*private void ancestrosAux(NodoGen n,Object e,Lista lista){ 
            if(n!=null){
             if(n.getElem().equals(e)){
                 lista.insertar(n.getElem(),lista.longitud()+1);
             }else{
                 if(n.getHijoIzq()!=null){
                     ancestrosAux(n.getHijoIzq(),e,lista);
                     if(lista.esVacia()){
                     NodoGen aux= n.getHijoIzq();
                     boolean var=true;
                     while(aux!=null&&var){
                         aux=aux.getHermanoDer();
                         ancestrosAux(aux,e,lista);
                         if(!lista.esVacia()){
                             var=false;
                         }
                     }}
                     if(!lista.esVacia()){
                         lista.insertar(n.getElem(),lista.longitud()+1);
                     }
                 }
                 
             }
             
            }
    }*/
