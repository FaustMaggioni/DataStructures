/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaDeBusqueda;

import TPFinalEDAT.Lista;
import TPFinal.ClaveVuelo;

public class TablaDeBusqueda {
    private NodoAVLDicc raiz;
    
    public TablaDeBusqueda(){
        this.raiz=null;
    }
     public String toString() {
        String s = "Arbol vacio";
        if (this.raiz != null) {

            s = "\n Raiz: " + toStringAux(this.raiz, "");
        }
        return s;
    }

    private String toStringAux(NodoAVLDicc n, String s) {
        if (n != null) {
            s = n.getDato().toString();
            s = s + " HI de " + n.getDato().toString() + "-> " + toStringAux(n.getIzq(), s) + "\n";
            s = s + " HD de " + n.getDato().toString() + "-> " + toStringAux(n.getDer(), s) + "\n ";
        } else {
            s = "-";
        }
        return s;
    }
    
    public Object getClave(Object n){
        boolean seguir=false;
        NodoAVLDicc aux= this.raiz;
        while(aux!=null && !seguir){
            Comparable cv= aux.getElem();
            seguir= cv.compareTo(n)==0;
            if(!seguir){
                if(cv.compareTo(n)<0){
                    aux=aux.getDer();
                }else{
                    aux=aux.getIzq();
                }
            }
        }
        Object res=null;
        if(aux!=null){
            res= aux.getElem();
        }
        return res;
    }
    private NodoAVLDicc rotarIzquierda(NodoAVLDicc r) {
        NodoAVLDicc h = r.getDer();
        NodoAVLDicc tmp = new NodoAVLDicc();
        if (h != null) {
            tmp = h.getIzq();
            h.setIzq(r);
        }
        r.setDer(tmp);
        return h;
    }

    private NodoAVLDicc rotarDerecha(NodoAVLDicc r) {
        NodoAVLDicc h = r.getIzq();
        NodoAVLDicc tmp = h.getDer();
        h.setDer(r);
        r.setIzq(tmp);
        return h;
    }

    private NodoAVLDicc derIzq(NodoAVLDicc n) { // Preguntar sobre si es void o que carajo
        n.setDer(rotarDerecha(n.getDer()));
        NodoAVLDicc a = rotarIzquierda(n);
        return a;
    }

    private NodoAVLDicc izqDer(NodoAVLDicc n) {
        NodoAVLDicc t = rotarIzquierda(n.getIzq());
        n.setIzq(t);
        NodoAVLDicc a = rotarDerecha(n);
        return a;
    }
    public boolean insertar(Comparable e,Object dato) {
        boolean res = false;
        if (this.raiz != null) {
            res= insertarAux(this.raiz,null,e,dato);
        } else {
            this.raiz = new NodoAVLDicc(e,dato);
        }
        return res;

    }

    public boolean insertarAux(NodoAVLDicc n,NodoAVLDicc padre, Comparable e,Object dato) {
        NodoAVLDicc aux = null;
        boolean exito = false;
        if (n != null && e.compareTo(n.getElem()) != 0) {
            if (e.compareTo(n.getElem()) < 0) {
                if (n.getIzq() != null) {
                    exito = insertarAux(n.getIzq(),n, e,dato);
                } else {
                    exito = true;
                    aux = new NodoAVLDicc(e,dato);
                    n.setIzq(aux);
                }
            } else {
                if (n.getDer() != null) {
                    exito = insertarAux(n.getDer(),n, e,dato);
                } else {
                    aux = new NodoAVLDicc(e,dato);
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
    private void rotar(int balanceN, NodoAVLDicc n, NodoAVLDicc padre){
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

    private NodoAVLDicc balancear(NodoAVLDicc N, int balanceN) {
        NodoAVLDicc retorno = null;
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

    private boolean eliminarAux(NodoAVLDicc n, NodoAVLDicc padre, Comparable e) {
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
    private void caso1(NodoAVLDicc n, NodoAVLDicc padre) {
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

    private void caso2(NodoAVLDicc n, NodoAVLDicc padre) {
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

    private void caso3(NodoAVLDicc n) {
        NodoAVLDicc padreaux = candidatoA(n), aux;
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

    private NodoAVLDicc candidatoA(NodoAVLDicc n) {
        NodoAVLDicc padre;
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
    public boolean existeClave(Comparable e) {
        boolean res = perteneceAux(e, this.raiz);
        return res;
    }
    public Lista listarRango(Comparable e, Comparable e2){
        Lista res= new Lista();
        rangoAux(e,e2,res,this.raiz);
        return res;
    }
    private void rangoAux(Comparable e1, Comparable e2, Lista res, NodoAVLDicc n){
        if(n!=null){
            if(n.getElem().compareTo(e1)>0){
                rangoAux(e1,e2,res,n.getIzq());
            }
            if(((Comparable)n.getElem()).compareTo(e1)>=0 && ((Comparable)n.getElem()).compareTo(e2)<=0){
                res.insertar(n.getElem(), res.longitud()+1);
            }
            if(((Comparable)n.getElem()).compareTo(e2)<0){
                rangoAux(e1,e2,res,n.getDer());
            }
        }
    }

    private boolean perteneceAux(Comparable e, NodoAVLDicc n) {
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
    
    public Object obtenerInformacion(Comparable clave){
        Object res= obtenerAux(clave,this.raiz);
        if(res==null){
            res= "No existe";
        }
        return res;
    }
    private Object obtenerAux(Comparable e,NodoAVLDicc n){
        Object res = null;
        if (n != null) {
            if (e.compareTo(n.getElem()) == 0) {
                res = n.getDato();
            } else {
                if (e.compareTo(n.getElem()) < 0) {
                    res = obtenerAux(e, n.getIzq());
                } else {
                    res = obtenerAux(e, n.getDer());
                }
            }
           
        }
        return res;
    }
    
     public Lista listarClaves() {
        Lista l = new Lista();
        if (this.raiz != null) {
            inordenAux(this.raiz, l);
        }
        return l;

    }

    private void inordenAux(NodoAVLDicc n, Lista l) {
        if (n != null) {
            inordenAux(n.getIzq(), l);
            l.insertar(n.getElem(), l.longitud() + 1);
            inordenAux(n.getDer(), l);
        }
    }
    
    public Lista listarDatos(){
        Lista l= new Lista();
        if(this.raiz!=null)
            datosAux(this.raiz,l);
        return l;
    }
    
    private void datosAux(NodoAVLDicc n,Lista l){
         if (n != null) {
            datosAux(n.getIzq(), l);
            l.insertar(n.getDato(), l.longitud() + 1);
            datosAux(n.getDer(), l);
        }
    }
    
    public boolean esVacio(){
        return this.raiz==null;
    }
    
    }
    

