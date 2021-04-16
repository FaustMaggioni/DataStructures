package EDD.conjuntistas;

import EDD.conjuntistas.funciones;
import TPFinalEDAT.Lista;

public class HashAbierto {

    private static int TAMAÑO = 20;
    private Nodo[] tabla;
    private int cant;

    public HashAbierto() {
        this.tabla = new Nodo[TAMAÑO];
        this.cant = 0;
    }

    public boolean insertar(Object e) {
        boolean res = false;

        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        if (pos >= 0) {
            res = true;
            this.cant++;
            if (this.tabla[pos] == null) {
                this.tabla[pos] = new Nodo(e);
            } else {
                
                Nodo aux = this.tabla[pos];
                while (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(new Nodo(e));
            }
        }
        return res;
    }

    public boolean pertenece(Object e) {
        boolean res=false;

        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        if (pos >= 0) {
            if (this.tabla[pos] == null) {
                res= false;
            }  else{
                Nodo aux = this.tabla[pos];
                while (aux != null && !res) {
                    if(aux.getElem().equals(e)){
                        res=true;
                    } else
                    aux = aux.getEnlace();
                }
            }}
        
        return res;
    }

    public boolean eliminar(Object e) {
        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        boolean res = false;
        if (pos >= 0) {
            if (this.tabla[pos] != null) {
                if (this.tabla[pos].getElem().equals(e)) {
                    res=true;
                    this.tabla[pos] = this.tabla[pos].getEnlace();
                } else {
                    Nodo aux= this.tabla[pos];
                    Nodo aux2 = this.tabla[pos].getEnlace();
                    while (aux2 != null && !res) {
                        if (aux2.getElem().equals(e)) {
                            res = true;
                            aux.setEnlace(aux2.getEnlace());
                            this.cant--;
                        } else {
                            aux = aux.getEnlace();
                            aux2= aux2.getEnlace();
                        }
                    }
                }
            }
        }
        
        return res;

    }
    public boolean esVacio(){
        return this.cant==0;
    }
    
    public Lista listar(){
        Lista res= new Lista();
        int j= 1;
        for(int i=0; i<= this.TAMAÑO-1; i++){
            
            if(this.tabla[i]!=null){
                res.insertar(this.tabla[i].getElem(), j);
                j++;
                Nodo aux= this.tabla[i].getEnlace();
                while(aux!=null){
                    res.insertar(aux.getElem(), j);
                    j++;
                    aux=aux.getEnlace();
                }
            }
        }
        return res;
    }
    

    


}
