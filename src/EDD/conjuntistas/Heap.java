package EDD.conjuntistas;

public class Heap {

    private static int TAMAÑO = 20;
    private int ultimo;
    private Comparable[] heap;

    //Constructor
    public Heap() {
        this.ultimo = 0;
        this.heap = new Comparable[TAMAÑO];
    }
    //Otros
    /*public boolean insertar(Comparable elemento) {
        boolean flag = ultimo < this.TAMAÑO - 1;
        if (flag) {
            this.ultimo++;
            heap[ultimo] = elemento;
            if (this.ultimo != 1) {
                int posactual= ultimo;
                
                while (posactual>=1 && (this.heap[posactual].compareTo(this.heap[(int)posactual/2])<0)){
                    Comparable aux=this.heap[posactual];
                    this.heap[posactual]=this.heap[(int)posactual/2];
                    this.heap[(int)posactual/2]=aux;
                    posactual=(int) posactual/2;
                }

            }

        }
        return flag;
    }*/
    public boolean insertar(Comparable e){
       
        boolean exito=this.ultimo<this.TAMAÑO-1;
        if(exito){
            this.heap[ultimo+1]=e;
            this.ultimo++; 
            if(ultimo!=1){
                int posActual=ultimo;
                while(posActual>1 && (this.heap[posActual].compareTo(this.heap[(int)posActual/2])>0)){
                    Comparable aux=this.heap[posActual];
                    this.heap[posActual]=this.heap[(int)posActual/2];
                    this.heap[(int)posActual/2]=aux;
                    posActual=(int)posActual/2;
                }
            }
        }
        return exito;
    }

    public Heap clone() {
        Heap clon = new Heap();
        clon.ultimo = 0;
        for (int i = 1; i <= this.ultimo; i++) {
            clon.heap[i] = this.heap[i];
            clon.ultimo++;
        }
        return clon;
    }

    public Comparable recuperarCima() {
        Comparable res = null;
        
        if (this.heap[1] != null) {
            res = this.heap[1];
        }
        return res;
    }

    public boolean esVacio() {
        return this.heap[1] == null;
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                if (posH < this.ultimo) {
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) > 0) {
                        posH++;
                    }
                }

                if (this.heap[posH].compareTo(temp) > 0) {
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;

                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    public String toString() {
        String s = "Vacio";
        if (this.heap[1] != null) {
            s = "";
            for (int i = 1; i <= ultimo; i++) {
                s = s + "Nodo => " + this.heap[i] + ". ";
                if (2*i <=this.ultimo){
                    s = s + "Hijo izquierdo => " + this.heap[2 * i] + ". ";
                } else {
                    s = s + "Hijo Izquierdo => " + "- ";
                }
                if (2 * i + 1 <=this.ultimo){
                    s = s + "Hijo derecho => " + this.heap[2 * i + 1] + ". \n";
                } else {
                    s = s + "Hijo Derecho => " + "- " + "\n";
                }
            }

        }
        return s;

    }
    
    
}
