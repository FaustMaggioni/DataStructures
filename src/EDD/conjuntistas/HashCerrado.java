package EDD.conjuntistas;

import TPFinalEDAT.Lista;

public class HashCerrado {

    private static int TAMAÑO = 40;
    private CeldaHash[] tabla;
    private static int VACIO = 0;
    private static int OCUPADO = 1;
    private static int BORRADO = -1;
    private int cant;

    public HashCerrado() {
        this.tabla = new CeldaHash[TAMAÑO];
        for(int i=0; i<this.TAMAÑO; i++){
            this.tabla[i]= new CeldaHash();
        }
        this.cant = 0;
    }

    public boolean eliminar(Object e) {
        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        int incremento = funciones.h2(e) % this.TAMAÑO;
        boolean res = false;
        int i = 1;

        while (!res && i < this.TAMAÑO && this.tabla[pos].getEstado() != VACIO) {
            if (this.tabla[pos].getEstado() == OCUPADO) {
                res = this.tabla[pos].getElem() == e;
                if (res) {
                    this.tabla[pos].setEstado(BORRADO);
                    this.cant--;
                }
            }
            pos = (pos + i * incremento) % this.TAMAÑO;
            i++;
        }
        return res;
    }

    public boolean insertar(Object e) {
        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        int incremento = funciones.h2(e) % this.TAMAÑO;
        boolean res = false;
        int i = 1;
        if(this.cant!=this.TAMAÑO){
        while (!res && i < this.TAMAÑO && pos >=0 && pos < this.TAMAÑO) {
            if (this.tabla[pos].getEstado() != OCUPADO){
                res = true;
                this.tabla[pos].setElem(e);
                this.tabla[pos].setEstado(OCUPADO);
                this.cant++;
            } else {
                pos = (pos + i * incremento) % this.TAMAÑO;
                i++;
            }
        }}
        return res;
    }

    public boolean pertenece(Object e) {
        int pos = funciones.funcioncadena(e) % this.TAMAÑO;
        int incremento = funciones.h2(e) % this.TAMAÑO;
        boolean res = false;
        int i = 1;
        while (!res && i < this.TAMAÑO && this.tabla[pos].getEstado() != VACIO) {
            if(this.tabla[pos].getEstado() == OCUPADO && this.tabla[pos].equals(e)){
                res=true;
            }else{
                pos = (pos + i * incremento) % this.TAMAÑO;
                i++;
            }
        }
        return res;
    }
    
    public Lista listar(){
        Lista res= new Lista();
        int j=1;
        for (int i=0; i<= this.TAMAÑO-1; i++){
            if(this.tabla[i].getEstado()==OCUPADO){
                res.insertar(this.tabla[i].getElem(), j);
                j++;
            }
        }
        return res;
    }
    
    public boolean esVacio(){
        return this.cant==0;
    }
    
}
