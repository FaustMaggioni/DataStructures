package EDD.jerarquicas;

import TPFinalEDAT.Cola;
import TPFinalEDAT.Lista;

public class ArbolGen {
    private NodoGen raiz;
    
    //Constructor
    public ArbolGen(){
        this.raiz=null;
    }
   
    public boolean insertar(Object nuevo, Object padre){
          boolean res= true;
        if(this.raiz==null){
            this.raiz= new NodoGen(nuevo,null,null);
        }
        else{
            NodoGen nodoPadre= obtenerNodo(this.raiz,padre);
            NodoGen aux= nodoPadre;
            if(aux!=null){
                if(aux.getHijoIzq()==null){
                    nodoPadre.setHijoIzq(new NodoGen(nuevo,null,null));
                }else{
                    aux=aux.getHijoIzq();
                    boolean var=true;
                    while(aux!=null && var){
                        if(aux.getHermanoDer()==null){
                            aux.setHermanoDerecho(new NodoGen(nuevo,null,null));
                            var=false;
                        }else{
                            aux= aux.getHermanoDer();
                        }
                    }
                }
            }else{
            res= false;}
        }
        return res;
        
    }
    private NodoGen obtenerNodo(NodoGen n, Object buscado){
        NodoGen res= null;
        if(n!=null){
            if(n.getElem().equals(buscado)){
                res= n;
            }
            else{
                res= obtenerNodo(n.getHijoIzq(),buscado);
                if(res== null){
                    res= obtenerNodo(n.getHermanoDer(),buscado);
                }
            }
        }
        return res;
    }
    
    public boolean pertenece(Object elem){
        NodoGen x= obtenerNodo(this.raiz,elem);
        return x != null;
    }
    
    public Lista ancentros(Object elem){ 
        Lista res= new Lista();
        if(this.raiz!=null&& !elem.equals(this.raiz.getElem())){
            ancestrosAux(this.raiz,elem,res);
            res.eliminar(1);
        }
        return res;
        
    }
    private void ancestrosAux(NodoGen n,Object e,Lista lista){ 
            if(n!=null){
            
            if(n.getElem().equals(e)){
                 lista.insertar(n.getElem(),lista.longitud()+1);
             }else{
                 if(n.getHijoIzq()!=null){
                     
                     NodoGen aux= n.getHijoIzq();
                     boolean var=true;
                     while(aux!=null&&var){
                         ancestrosAux(aux,e,lista);
                         if(!lista.esVacia()){
                             var=false;
                         }else{
                             aux=aux.getHermanoDer();
                     }}
                     if(!lista.esVacia()){
                         lista.insertar(n.getElem(),lista.longitud()+1);
                     }
                 }
                 
             
             
            }
    
    }}
    public boolean esVacio(){
        return this.raiz==null;
    }
    
    public Object padre(Object hijo){
        Object res= null;
        if(this.raiz!=null && !hijo.equals(this.raiz.getElem())){
        res= padreAux(hijo,this.raiz);}
        return res;
        
    }
    
    private Object padreAux(Object e, NodoGen n){
        Object res= null;
        if(n!=null){
                    if(n.getHijoIzq()!=null){
                        NodoGen aux= n.getHijoIzq();
                        while(aux!=null && res==null){
                            if(aux.getElem().equals(e)){
                                res= n.getElem();
                            }else{
                                res= padreAux(e,aux);
                                aux=aux.getHermanoDer();
                            }
                        }
                    }
        }
        return res;
    }
    
    
    public int altura(){
        int res=-1;
        if(this.raiz!=null){
            res= alturaAux(this.raiz,0);
        }
        return res;
    }
    private int alturaAux(NodoGen n, int i){
        if(n!=null){
            
            int izq=i;
            if(n.getHijoIzq()!=null){
                i++;
                izq= alturaAux(n.getHijoIzq(),i);
                NodoGen aux= n.getHijoIzq();
                int max=0;
                int comp=0;
                while(aux!=null){
                    aux=aux.getHermanoDer();
                    comp= alturaAux(aux,i);
                    if(comp>max){
                        max= comp;
                    }
                }
                i= Math.max(max, izq);
            }
        }
        return i;
    }
    
    public int nivel(Object e){
        int res= -1;
        if(this.raiz!=null){
            res= nivelAux(this.raiz,e,0);
        }
        return res;
    }
    
    private int nivelAux(NodoGen n, Object e,int i){
        int res= -1;
        if(n!=null){
            if(n.getElem().equals(e)){
                res=i;
            }else{
                i++;
                res= nivelAux(n.getHijoIzq(),e,i);
                if(res==-1){
                    NodoGen aux= n.getHijoIzq();
                    boolean var= true;
                    while(aux!=null && var){
                        aux=aux.getHermanoDer();
                        res= nivelAux(aux,e,i);
                        if(res!=-1){
                            var=false;
                        }
                    }
                }
            }
        
    }
        return res;
    }
    
    public void vaciar(){
        this.raiz=null;
    }
    
    public ArbolGen clone(){
        ArbolGen clone= new ArbolGen();
        if(this.raiz!=null){
            clone.raiz= clonar(this.raiz);
        }
        return clone;
    }
    private NodoGen clonar(NodoGen n){
     NodoGen hijo=  null;
     if(n!=null){
         hijo= new NodoGen(n.getElem(),clonar(n.getHijoIzq()),clonar(n.getHermanoDer()));
         }
     return hijo;
    }
    /*    public ArbolBin clone() {
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
*/
    
    public Lista listarPreorden(){
        Lista po= new Lista();
        if(this.raiz!=null){
            preordenAux(po,this.raiz);
        }
        return po;
    }
    
    private void preordenAux(Lista x,NodoGen n){
        if(n!=null){
            x.insertar(n.getElem(),x.longitud()+1);
            preordenAux(x,n.getHijoIzq());
            NodoGen aux= n.getHijoIzq();
            while(aux!=null){
                aux= aux.getHermanoDer();
                if(aux!=null)
                preordenAux(x,aux);
           
            }
        }
    }
    public Lista listarInorden(){
        Lista salida= new Lista();
        listarInordenAux(this.raiz,salida);
        return salida;

    }
    
    private void listarInordenAux(NodoGen n, Lista ls){
        if(n!=null){
            if(n.getHijoIzq()!=null){
                listarInordenAux(n.getHijoIzq(),ls);
            }
            ls.insertar(n.getElem(), ls.longitud()+1);
            if(n.getHijoIzq()!=null){
                NodoGen hijo = n.getHijoIzq().getHermanoDer();
                while(hijo!=null){
                    listarInordenAux(hijo,ls);
                    hijo= hijo.getHermanoDer();
                }
            }
        }
    }
    
    public Lista listarPosorden(){
        Lista res= new Lista();
        if(this.raiz!=null){
            posordenaux(this.raiz,res);
        }
        return res;
        
    }
    
    private void posordenaux(NodoGen n, Lista x){
        if(n!=null){
            NodoGen aux= n.getHijoIzq();
            while(aux!=null){
                posordenaux(aux,x);
                aux= aux.getHermanoDer();
            }
            x.insertar(n.getElem(),x.longitud()+1);
        }
    }
    
    public Lista porNivel(){
        Lista res= new Lista();
        Cola q= new Cola();
        q.poner(this.raiz);
        int i=1;
        while(!q.esVacia()){
            NodoGen aux= (NodoGen)q.obtenerFrente();
            q.sacar();
            res.insertar(aux.getElem(), i);
            i++;
            aux= aux.getHijoIzq();
            while(aux!=null){
                q.poner(aux);
                aux= aux.getHermanoDer();
            }
        }
        return res;
    }
    
    public String toString(){
        return "\n"+toStringAux(this.raiz);
    }
    
    private String toStringAux(NodoGen n){
        String s="";
        if(n!=null){
            s+=n.getElem()+" -> ";
            NodoGen hijo = n.getHijoIzq();
            while(hijo!=null){
                s += hijo.getElem().toString()+", ";
                hijo= hijo.getHermanoDer();
            }
            
            hijo= n.getHijoIzq();
            while(hijo != null){
                s+= "\n"+ toStringAux(hijo)+",";
                hijo= hijo.getHermanoDer();
            }
        }
        return s;
    }
    
    public boolean verificarPatron(Lista lis){
    Lista aux= lis.clone();
    boolean res= verifAux(aux,this.raiz,false);
    return res;
}

private boolean verifAux(Lista l, NodoGen n, boolean res){
        if(n!=null){
            if(n.getElem().equals(l.recuperar(1))){
                l.eliminar(1);
                if(n.getHijoIzq()==null && l.esVacia()){
                    res=true;
                }else{
                    NodoGen aux= n.getHijoIzq();
                    while(aux!=null&& res==false){
                        res= verifAux(l,aux,res);
                        aux=aux.getHermanoDer();
                    }
                    
                }
        }
    }
    return res;}

public Lista frontera(){
    Lista frontera= new Lista();
    frontAux(frontera,this.raiz);
    return frontera;
}

private void frontAux(Lista f, NodoGen n){
    if(n!=null){
        if(n.getHijoIzq()==null){
            f.insertar(n.getElem(),f.longitud()+1);
        }else{
            NodoGen aux= n.getHijoIzq();
            while(aux!=null){
                frontAux(f,aux);
                aux=aux.getHermanoDer();
            }
        }
    }
}

public Lista listaQueJustificaLaAltura(){
    Lista res= new Lista();
    Lista actual= new Lista();
    if(this.raiz!=null){
    res= caminoLargo(this.raiz,actual,res);} 
    return res;
}

 private Lista caminoLargo(NodoGen n, Lista actual, Lista res) {
     
     if(n!=null){
         actual.insertar(n.getElem(),actual.longitud()+1);
         if(n.getHijoIzq() == null){
             if(actual.longitud()>res.longitud()){
                 res= actual.clone();
             }
         }else{
             NodoGen aux= n.getHijoIzq();
             while(aux!=null){
                 res= caminoLargo(aux,actual,res);
                 aux= aux.getHermanoDer();
                 actual.eliminar(actual.longitud());
             }
             
         
     }}
     return res;
    
    
   


}
    
    }

