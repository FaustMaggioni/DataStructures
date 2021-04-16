
package EDD.Mapeos;
import EDD.conjuntistas.funciones;
public class Mapeo {
    private static int TAM=100;
    private NodoHashMapeo[] tabla;
    private int cant;
    
    public Mapeo(){
        this.cant=0;
        this.tabla= new NodoHashMapeo[TAM];
    }
    public boolean asociar(Object dom, Object ran) {
        boolean res = false;

        int pos = funciones.funcioncadena(dom) % this.TAM;
        if (pos >= 0) {
            res = true;
            this.cant++;
            if (this.tabla[pos] == null) {
                this.tabla[pos] = new NodoHashMapeo(dom,ran,null);
            } else {
                if(this.tabla[pos].getDominio().equals(dom)){
                NodoHashMapeo aux = this.tabla[pos];
                while (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(new NodoHashMapeo(dom,ran,null));
            }else{
                    while(!res){
                        pos = (pos + i * incremento) % this.TAMAÑO;
                i++;
                    }
                }
        }}
        return res;
    }
    
    
}
