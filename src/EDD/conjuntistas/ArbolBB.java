package EDD.conjuntistas;

import TPFinalEDAT.Lista;

public class ArbolBB {

    private NodoArbol raiz;

    //Constructor
    public ArbolBB() {
        this.raiz = null;
    }

    //Otros
    public boolean insertar(Comparable e) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(e);
        } else {
            exito = insertarAux(this.raiz, e);
        }
        return exito;
    }

    public boolean eliminarMinimo() {
        boolean res = false;
        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() != null) {
                res = eliminarMinAux(this.raiz.getIzquierdo(), this.raiz);
            } else {
                res = true;
                this.raiz = this.raiz.getDerecho();
            }
        }
        return res;

    }

    private boolean eliminarMinAux(NodoArbol n, NodoArbol padre) {
        boolean res = false;
        if (n != null) {
            if (n.getIzquierdo() == null) {
                if (n.getDerecho() == null) {
                    padre.setIzquierdo(null);
                } else {
                    padre.setIzquierdo(n.getDerecho());
                }
                res = true;
            } else {
                res = eliminarMinAux(n.getIzquierdo(), padre.getIzquierdo());
            }
        }
        return res;
    }

    public boolean eliminarMaximo() {
        boolean res = false;
        if (this.raiz != null) {
            if (this.raiz.getDerecho() != null) {
                res = eliminarMaxAux(this.raiz.getDerecho(), this.raiz);
            } else {
                this.raiz = this.raiz.getIzquierdo();
                res = true;
            }
        }
        return res;

    }

    private boolean eliminarMaxAux(NodoArbol n, NodoArbol padre) {
        boolean res = false;
        if (n != null) {
            if (n.getDerecho() == null) {
                res = true;
                if (n.getIzquierdo() == null) {
                    padre.setDerecho(null);
                } else {
                    padre.setDerecho(n.getIzquierdo());
                }

            } else {
                res = eliminarMaxAux(n.getDerecho(), padre.getDerecho());
            }
        }
        return res;
    }

    private boolean insertarAux(NodoArbol n, Comparable e) {
        boolean exito = false;
        if (n != null) {
            exito = true;
            if (e.compareTo(n.getElemento()) == 0) {
                exito = false;
            } else {
                if (e.compareTo(n.getElemento()) < 0) {
                    if (n.getIzquierdo() != null) {
                        exito = insertarAux(n.getIzquierdo(), e);
                    } else {
                        n.setIzquierdo(new NodoArbol(e));
                    }
                } else {
                    if (n.getDerecho() != null) {
                        exito = insertarAux(n.getDerecho(), e);
                    } else {
                        n.setDerecho(new NodoArbol(e));
                    }
                }
            }
        }
        return exito;

    }

    public int amplitudSubArbol(Comparable e) {
        int dif = -1;
        NodoArbol aux = this.raiz;
        while (aux != null && aux.getElemento().compareTo(e) != 0) {
            if (aux.getElemento().compareTo(e) < 0) {
                aux = aux.getDerecho();
            } else {
                aux = aux.getIzquierdo();
            }
        }
        if (aux != null) {
            if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
                dif = 0;
            } else {
                if (aux.getIzquierdo() == null && aux.getDerecho() != null) {
                    dif = (int) max(aux.getDerecho()).getElemento() - (int) e;
                } else {
                    if (aux.getIzquierdo() != null && aux.getDerecho() == null) {
                        dif = (int) minimo(aux.getIzquierdo()).getElemento() - (int) e;
                    } else {
                        dif = (int) max(aux.getDerecho()).getElemento() - (int) minimo(aux.getIzquierdo()).getElemento();
                    }
                }
                dif= Math.abs(dif);
            }
        }
        return dif;
    }

    private NodoArbol minimo(NodoArbol n) {
        NodoArbol min;
        System.out.println("n: "+n.getElemento());
            if (n.getIzquierdo() != null) {
                min = minimo(n.getIzquierdo());
            } else {
                min = n;
            }
        
        return min;
    }

    private NodoArbol max(NodoArbol n) {
        NodoArbol max;
        System.out.println("n max: ");
            if (n.getDerecho() != null) {
                max = max(n.getDerecho());
            } else {
                max = n;
            }
        
        return max;
    }

    private NodoArbol buscarSubRaiz(NodoArbol aux, Object e) {
        NodoArbol n = null;
        while (aux != null && aux.getElemento().compareTo(e) != 0) {
            if (aux.getElemento().compareTo(e) < 0) {
                aux = aux.getDerecho();
            } else {
                aux = aux.getIzquierdo();
            }
        }
        n = aux;
        return n;
    }

    public Lista listarInv() {
        Lista res = new Lista();
        listarInvAux(this.raiz, res);
        return res;
    }

    private void listarInvAux(NodoArbol n, Lista res) {
        if (n != null) {
            listarInvAux(n.getDerecho(), res);
            res.insertar(n.getElemento(), res.longitud() + 1);
            listarInvAux(n.getIzquierdo(), res);
        }
    }

    public Lista ancestros(Object e) {
        Lista x = new Lista();
        ancestrosAux(this.raiz, x, e);
        return x;
    }

    private void ancestrosAux(NodoArbol n, Lista res, Object e) {
        if (n != null) {
            res.insertar(n.getElemento(), 1);
            if (n.getElemento().compareTo(e) < 0) {
                ancestrosAux(n.getDerecho(), res, e);
            } else {
                ancestrosAux(n.getIzquierdo(), res, e);
            }
        }
    }

    public ArbolBB ancestrosArbol(Object e) {
        ArbolBB n = new ArbolBB();
        n.raiz = ancAux(this.raiz, e);
        return n;
    }

    private NodoArbol ancAux(NodoArbol n, Object e) {
        NodoArbol hijo = null;
        if (n != null) {
            hijo = new NodoArbol(n.getElemento());
            if (n.getElemento().compareTo(e) < 0) {
                hijo.setDerecho(ancAux(n.getDerecho(), e));
            } else {
                hijo.setIzquierdo(ancAux(n.getIzquierdo(), e));
            }
        }
        return hijo;
    }

    public boolean pertenece(Comparable e) {
        boolean res = perteneceAux(e, this.raiz);
        return res;
    }

    private boolean perteneceAux(Comparable e, NodoArbol n) {
        boolean res = false;
        if (n != null) {
            if (e.compareTo(n.getElemento()) == 0) {
                res = true;
            } else {
                if (e.compareTo(n.getElemento()) < 0) {
                    res = perteneceAux(e, n.getIzquierdo());
                } else {
                    res = perteneceAux(e, n.getDerecho());
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

    public void vaciar() {
        this.raiz = null;
    }

    private void inordenAux(NodoArbol n, Lista l) {
        if (n != null) {
            inordenAux(n.getIzquierdo(), l);
            l.insertar(n.getElemento(), l.longitud() + 1);
            inordenAux(n.getDerecho(), l);
        }
    }

    public Comparable minimoElemento() {
        NodoArbol n = this.raiz;
        Comparable res = null;
        while (n != null) {
            res = n.getElemento();
            n = n.getIzquierdo();
        }
        return res;
    }

    public Comparable maximoElemento() {
        NodoArbol n = this.raiz;
        Comparable res = null;
        while (n != null) {
            res = n.getElemento();
            n = n.getDerecho();
        }
        return res;
    }

    public boolean esVacío() {
        return this.raiz == null;
    }

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
            s = s + " HI de " + n.getElemento().toString() + "-> " + toStringAux(n.getIzquierdo(), s) + "\n";
            s = s + " HD de " + n.getElemento().toString() + "-> " + toStringAux(n.getDerecho(), s) + "\n ";
        } else {
            s = " No tiene";
        }
        return s;
    }

    public ArbolBB clone() {
        ArbolBB nuevo = new ArbolBB();
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

    public Lista listarMayoresQue(Comparable valor, Comparable elem) {
        Lista res = new Lista();
        NodoArbol aux = this.raiz;
        while (aux != null && aux.getElemento().compareTo(elem) != 0) {
            if (aux.getElemento().compareTo(elem) < 0) {
                aux = aux.getDerecho();
            } else {
                aux = aux.getIzquierdo();
            }
        }
        if (aux != null) {
            listarMayAux(aux, valor, res);
        }
        return res;
    }

    private void listarMayAux(NodoArbol n, Comparable valor, Lista res) {
        if (n != null) {
            if (n.getIzquierdo() != null && n.getElemento().compareTo(valor) > 0) {
                listarMayAux(n.getIzquierdo(), valor, res);
            }
            if (n.getElemento().compareTo(valor) > 0) {
                res.insertar(n.getElemento(), res.longitud() + 1);
            }
            if (n.getDerecho() != null) {
                listarMayAux(n.getDerecho(), valor, res);
            }
        }

    }

    public ArbolBB clonarParteInvertida(Object e) {
        NodoArbol aux = this.raiz;

        buscarSubRaiz(aux, e);

        ArbolBB nuevo = new ArbolBB();
        if (aux != null) {
            nuevo.raiz = clonarInvAux(aux);
        }
        return nuevo;
    }

    private NodoArbol clonarInvAux(NodoArbol aux) {
        NodoArbol hijo = null;
        if (aux != null) {
            System.out.println("aux elem: " + aux.getElemento());
            hijo = new NodoArbol(aux.getElemento(), clonarInvAux(aux.getDerecho()), clonarInvAux(aux.getIzquierdo()));
        }
        return hijo;
    }

    public boolean verifSimetria(Object e) {
        boolean res = false;
        NodoArbol aux = this.raiz;
        buscarSubRaiz(aux, e);
        if (aux != null) {
            if (aux.getDerecho() == null && aux.getIzquierdo() == null) {
                res = true;
            } else {
                if (aux.getDerecho() != null && aux.getIzquierdo() != null) {
                    res = verifSimAux(aux.getIzquierdo(), aux.getDerecho());
                }
            }
        }
        return res;
    }

    private boolean verifSimAux(NodoArbol izq, NodoArbol der) {
        boolean res = false;
        if (izq.esHoja() && der.esHoja()) {
            res = true;
        } else {
            if (izq.getIzquierdo() != null && izq.getDerecho() != null && der.getIzquierdo() != null && der.getDerecho() != null) {
                res = verifSimAux(izq.getIzquierdo(), der.getDerecho()) && verifSimAux(izq.getDerecho(), der.getIzquierdo());
            } else {
                if (izq.getIzquierdo() != null && izq.getDerecho() == null && der.getIzquierdo() == null && der.getDerecho() != null) {
                    res = verifSimAux(izq.getIzquierdo(), der.getDerecho());
                } else {
                    if (izq.getIzquierdo() == null && izq.getDerecho() != null && der.getIzquierdo() != null && der.getDerecho() == null) {
                        res = verifSimAux(izq.getDerecho(), der.getIzquierdo());

                    }
                }
            }
        }
        return res;
    }

    public int masNodosEnRango(int min, int max) {
        int izq = contador(min, max, this.raiz.getIzquierdo());
        int der = contador(min, max, this.raiz.getDerecho());
        return Math.max(izq, der);
    }

    private int contador(int min, int max, NodoArbol n) {
        int res = 0;
        if (n != null) {
            if (n.getElemento().compareTo(min) >= 0 && n.getElemento().compareTo(max) <= 0) {
                res = 1;
            }
            if (n.getIzquierdo() != null
                    && n.getElemento().compareTo(min) >= 0) {
                res = contador(min, max, n.getIzquierdo()) + res;
            }

            if (n.getDerecho() != null
                    && n.getElemento().compareTo(max) <= 0) {
                res = contador(min, max, n.getDerecho()) + res;
            }
        }

        return res;
    }

    public Lista listarMayorIgual(Object e) {
        Lista res = new Lista();
        listarMIAux(e, this.raiz, res);
        return res;
    }

    private void listarMIAux(Object e, NodoArbol n, Lista res) {
        if (n != null) {
            if (n.getElemento().compareTo(e) >= 0) {
                res.insertar(n.getElemento(), res.longitud() + 1);
            }
            if (n.getElemento().compareTo(e) > 0) {
                listarMIAux(e, n.getIzquierdo(), res);
            }
            listarMIAux(e, n.getDerecho(), res);
        }
    }

    public Lista listarRango(Comparable x, Comparable y) {
        NodoArbol n = this.raiz;
        Lista res = new Lista();
        if (x.compareTo(y) <= 0) {
            rangoAux(x, y, n, res);
        }
        return res;
    }

    private void rangoAux(Comparable min, Comparable max, NodoArbol n, Lista l) {
        if (n != null) {
            if (n.getElemento().compareTo(min) > 0) {
                rangoAux(min, max, n.getIzquierdo(), l);
            }
            if (n.getElemento().compareTo(min) >= 0 && n.getElemento().compareTo(max) <= 0) {

                l.insertar(n.getElemento(), l.longitud() + 1);
            }
            if (n.getElemento().compareTo(max) < 0) {
                rangoAux(min, max, n.getDerecho(), l);
            }
        }
    }

    private void caso1(NodoArbol n, NodoArbol padre) {
        if (n != null) {
            if (padre != null) {
                if (n.getElemento().compareTo(padre.getElemento()) < 0) {
                    padre.setIzquierdo(null);
                } else {
                    padre.setDerecho(null);
                }
            } else {
                this.raiz = null;
            }
        }
    }

    private void caso2(NodoArbol n, NodoArbol padre) {
        if (n != null) {
            if (padre == null) {
                if (n.getIzquierdo() != null) {
                    this.raiz = n.getIzquierdo();
                } else {
                    this.raiz = n.getDerecho();
                }
            } else {
                if (n.getElemento().compareTo(padre.getElemento()) < 0) {
                    if (n.getIzquierdo() != null) {
                        padre.setIzquierdo(n.getIzquierdo());
                    } else {
                        padre.setIzquierdo(n.getDerecho());
                    }
                } else {
                    if (n.getIzquierdo() != null) {
                        padre.setDerecho(n.getIzquierdo());
                    } else {
                        padre.setDerecho(n.getDerecho());
                    }
                }
            }
        }
    }

    private void caso3(NodoArbol n) {
        NodoArbol padreaux = candidatoA(n), aux;
        Comparable tmp;
        if (padreaux.getElemento().compareTo(n.getElemento()) == 0) {
            aux = padreaux.getIzquierdo();
            tmp = aux.getElemento();
            n.setIzquierdo(aux.getIzquierdo());

        } else {
            aux = padreaux.getDerecho();
            tmp = aux.getElemento();
            if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
                caso1(aux, padreaux);
            } else {
                if (aux.getIzquierdo() == null || aux.getDerecho() == null) {
                    caso2(aux, padreaux);
                }

            }
        }
        n.setElem(tmp);

    }

    private NodoArbol candidatoA(NodoArbol n) {
        NodoArbol padre;
        if (n.getIzquierdo().getDerecho() == null) {
            padre = n;
        } else {
            padre = n.getIzquierdo();
            while (padre.getDerecho().getDerecho() != null) {
                padre = padre.getDerecho();
            }
        }
        return padre;
    }

    public boolean eliminar(Comparable e) {
        boolean res = false;
        if (this.raiz != null) {
            res = eliminarAux(this.raiz, null, e);
        }
        return res;
    }

    private boolean eliminarAux(NodoArbol n, NodoArbol padre, Comparable e) {
        boolean res = false;
        if (n != null) {
            res = true;
            if (n.getElemento().compareTo(e) == 0) {
                if (n.getIzquierdo() == null && n.getDerecho() == null) {
                    caso1(n, padre);
                } else {
                    if (n.getIzquierdo() == null || n.getDerecho() == null) {
                        caso2(n, padre);
                    } else {
                        caso3(n);
                    }
                }
            } else {
                if (e.compareTo(n.getElemento()) < 0) {
                    eliminarAux(n.getIzquierdo(), n, e);
                } else {
                    eliminarAux(n.getDerecho(), n, e);
                }
            }
        }
        return res;

    }
}
