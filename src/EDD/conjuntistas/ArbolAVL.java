package EDD.conjuntistas;

import TPFinalEDAT.Lista;

public class ArbolAVL {

    private NodoAVL raiz;

    //Constructor
    public ArbolAVL() {
        this.raiz = null;
    }

    //Otros
    public boolean pertenece(Comparable e) {
        boolean res = perteneceAux(e, this.raiz);
        return res;
    }

    private boolean perteneceAux(Comparable e, NodoAVL n) {
        boolean res = false;
        if (n != null) {
            if (e.compareTo(n.getElem()) == 0) {
                res = true;
            } else {
                if (e.compareTo(n.getElem()) < 0) {
                    res = perteneceAux(e, n.getIzq());
                } else {
                    res = perteneceAux(e, n.getDer());
                }
            }
        }
        return res;
    }

    public Lista listar() {
        Lista l = new Lista();
        if (this.raiz != null) {
            inordenAux(this.raiz, l);
        }
        return l;

    }

    private void inordenAux(NodoAVL n, Lista l) {
        if (n != null) {
            inordenAux(n.getIzq(), l);
            l.insertar(n.getElem(), l.longitud() + 1);
            inordenAux(n.getDer(), l);
        }
    }

    public Comparable minimoElemento() {
        NodoAVL n = this.raiz;
        Comparable res = null;
        while (n != null) {
            res = n.getElem();
            n = n.getIzq();
        }
        return res;
    }

    public Comparable maximoElemento() {
        NodoAVL n = this.raiz;
        Comparable res = null;
        while (n != null) {
            res = n.getElem();
            n = n.getDer();
        }
        return res;
    }

    public boolean esVacío() {
        return this.raiz == null;
    }

    @Override
    public String toString() {
        String s = "Arbol vacio";
        if (this.raiz != null) {

            s = "\n Raiz: " + toStringAux(this.raiz, "");
        }
        return s;
    }

    private String toStringAux(NodoAVL n, String s) {
        if (n != null) {
            s = n.getElem().toString();
            s = s + " HI de " + n.getElem().toString() + "-> " + toStringAux(n.getIzq(), s) + "\n";
            s = s + " HD de " + n.getElem().toString() + "-> " + toStringAux(n.getDer(), s) + "\n ";
        } else {
            s = " No tiene";
        }
        return s;
    }

    public ArbolAVL clone() {
        ArbolAVL nuevo = new ArbolAVL();
        nuevo.raiz = clonarAux(this.raiz);
        return nuevo;
    }

    private NodoAVL clonarAux(NodoAVL aux) {
        NodoAVL hijo = null;
        if (aux != null) {
            hijo = new NodoAVL(aux.getElem(), clonarAux(aux.getIzq()), clonarAux(aux.getDer()));
        }
        return hijo;
    }

    public Lista listarRango(Comparable x, Comparable y) {
        NodoAVL n = this.raiz;
        Lista res = new Lista();
        rangoAux(x, y, n, res);
        return res;
    }

    private void rangoAux(Comparable min, Comparable max, NodoAVL n, Lista l) {
        if (n != null) {
            if (n.getElem().compareTo(min) > 0) {
                rangoAux(min, max, n.getIzq(), l);
            }
            if (n.getElem().compareTo(min) >= 0 && n.getElem().compareTo(max) <= 0) {

                l.insertar(n.getElem(), l.longitud() + 1);
            }
            if (n.getElem().compareTo(max) < 0) {
                rangoAux(min, max, n.getDer(), l);
            }
        }
    }

    /* private int balance(NodoAVL n) {
        int bal = -1;
        int aizq = 0, ader = 0;
        if (n != null) {
            n.getIzq().recalcularAltura();
            n.getDer().recalcularAltura();
            n.recalcularAltura();
            if (n.getIzq() != null) {
                
                aizq = n.getIzq().getAltura();
            }
            if (n.getDer() != null) {
                ader = n.getDer().getAltura();
            }
            bal = aizq - ader;
        }
        return bal;
    }*/
    private NodoAVL rotarIzquierda(NodoAVL r) {
        NodoAVL h = r.getDer();
        NodoAVL tmp = new NodoAVL();
        if (h != null) {
            tmp = h.getIzq();
            h.setIzq(r);
        }
        r.setDer(tmp);
        return h;
    }

    private NodoAVL rotarDerecha(NodoAVL r) {
        NodoAVL h = r.getIzq();
        NodoAVL tmp = h.getDer();
        h.setDer(r);
        r.setIzq(tmp);
        return h;
    }

    private NodoAVL derIzq(NodoAVL n) { // Preguntar sobre si es void o que carajo
        n.setDer(rotarDerecha(n.getDer()));
        NodoAVL a = rotarIzquierda(n);
        return a;
    }

    private NodoAVL izqDer(NodoAVL n) {
        NodoAVL t = rotarIzquierda(n.getIzq());
        n.setIzq(t);
        NodoAVL a = rotarDerecha(n);
        return a;
    }

    public boolean insertar(Comparable e) {
        boolean res = false;
        if (this.raiz != null) {
            res= insertarAux(this.raiz,null,e);
        } else {
            this.raiz = new NodoAVL(e);
        }
        return res;

    }

    public boolean insertarAux(NodoAVL n,NodoAVL padre, Comparable e) {
        NodoAVL aux = null;
        boolean exito = false;
        if (n != null && e.compareTo(n.getElem()) != 0) {
            if (e.compareTo(n.getElem()) < 0) {
                if (n.getIzq() != null) {
                    exito = insertarAux(n.getIzq(),n, e);
                } else {
                    exito = true;
                    aux = new NodoAVL(e);
                    n.setIzq(aux);
                }
            } else {
                if (n.getDer() != null) {
                    exito = insertarAux(n.getDer(),n, e);
                } else {
                    aux = new NodoAVL(e);
                    exito = true;
                    n.setDer(aux);
                }
            }
        }
        n.recalcularAltura();
        int balanceN = n.balance();//balance del nodoActual n
        if ((Math.abs(balanceN)) > 1) {
            rotar(balanceN,n,padre);
        }
        return exito;
   }
    private void rotar(int balanceN, NodoAVL n, NodoAVL padre){
        if (padre != null) {
                if (n.getElem().compareTo(padre.getElem()) > 0) {//estamos en el hijo derecho de padre
                    padre.setDer(balancear(n, balanceN));
                } else {//estamos en el hijo izquierdo de padre
                    padre.setIzq(balancear(n, balanceN));
                }
            } else {//caso en que n sea la raiz
                this.raiz = balancear(n, balanceN);
            }
    }

    private NodoAVL balancear(NodoAVL N, int balanceN) {
        NodoAVL retorno = null;
        if (balanceN > 0 && (N.getIzq()).balance() >= 0) {//simple a derecha
            retorno = rotarDerecha(N);
        } else if (balanceN > 0 && (N.getIzq()).balance() < 0) {//doble izq-der
            retorno= izqDer(N);
        } else if (balanceN < 0 &&(N.getDer()).balance() <= 0) {//simple a izquierda
            retorno = rotarIzquierda(N);
        } else if (balanceN < 0 && (N.getDer()).balance() > 0) {//doble der-izq
            retorno= derIzq(N);
        }
        N.recalcularAltura();
        return retorno;
    }
    public boolean eliminar(Comparable e) {
        boolean res = false;
        if (this.raiz != null) {
            res = eliminarAux(this.raiz, null, e);
        }
        return res;
    }

    private boolean eliminarAux(NodoAVL n, NodoAVL padre, Comparable e) {
        boolean res = false;
        if (n != null) {
            res = true;
            if (n.getElem().compareTo(e) == 0) {
                if (n.getIzq() == null && n.getDer() == null) {
                    caso1(n, padre);
                } else {
                    if (n.getIzq() == null || n.getDer() == null) {
                        caso2(n, padre);
                    } else {
                        caso3(n);
                    }
                }
            } else {
                if (e.compareTo(n.getElem()) < 0) {
                    eliminarAux(n.getIzq(), n, e);
                } else {
                    eliminarAux(n.getDer(), n, e);
                }
            }
        }
        n.recalcularAltura();
        int balanceN = n.balance();//balance del nodoActual n
        if ((Math.abs(balanceN)) > 1) {
            rotar(balanceN,n,padre);
        }
        
        
        return res;

    }
    private void caso1(NodoAVL n, NodoAVL padre) {
        if (n != null) {
            if (padre != null) {
                if (n.getElem().compareTo(padre.getElem()) < 0) {
                    padre.setIzq(null);
                } else {
                    padre.setDer(null);
                }
            } else {
                this.raiz = null;
            }
        }
    }

    private void caso2(NodoAVL n, NodoAVL padre) {
        if (n != null) {
            if (padre == null) {
                if (n.getIzq() != null) {
                    this.raiz = n.getIzq();
                } else {
                    this.raiz = n.getDer();
                }
            } else {
                if (n.getElem().compareTo(padre.getElem()) < 0) {
                    if (n.getIzq() != null) {
                        padre.setIzq(n.getIzq());
                    } else {
                        padre.setIzq(n.getDer());
                    }
                } else {
                    if (n.getIzq() != null) {
                        padre.setDer(n.getIzq());
                    } else {
                        padre.setDer(n.getDer());
                    }
                }
            }
        }
    }

    private void caso3(NodoAVL n) {
        NodoAVL padreaux = candidatoA(n), aux;
        Comparable tmp;
        if (padreaux.getElem().compareTo(n.getElem()) == 0) {
            aux = padreaux.getIzq();
            tmp = aux.getElem();
            n.setIzq(aux.getIzq());

        } else {
            aux = padreaux.getDer();
            tmp = aux.getElem();
            if (aux.getIzq() == null && aux.getDer() == null) {
                caso1(aux, padreaux);
            } else {
                if (aux.getIzq() == null || aux.getDer() == null) {
                    caso2(aux, padreaux);
                }

            }
        }
        n.setElem(tmp);

    }

    private NodoAVL candidatoA(NodoAVL n) {
        NodoAVL padre;
        if (n.getIzq().getDer() == null) {
            padre = n;
        } else {
            padre = n.getIzq();
            while (padre.getDer().getDer() != null) {
                padre = padre.getDer();
            }
        }
        return padre;
    }
}
