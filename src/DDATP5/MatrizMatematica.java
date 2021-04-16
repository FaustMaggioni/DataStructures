
package DDATP5;

public class MatrizMatematica {
    //Atributo
    private int fila;
    private int col;
    private double [][] dim;
    
    //Constructores
    public MatrizMatematica(){
        }
    public MatrizMatematica(int fila,int col){
        this.col=col;
        this.fila=fila;
        this.dim= new double[this.fila][this.col];
        
    }
    
    //Modificadores
    public void setFila(int otraFila){
        this.fila=otraFila;
        
    }
    public void setCol(int otraCol){
        this.col=otraCol;
    }
    
    //Observadores
    public boolean igualA(MatrizMatematica otra){
        return ((this.col==otra.col)&&(this.fila==otra.fila));
    }
    public String aString(){
        String re= "Tiene una dimensión de: "+this.fila+"x"+this.col;
        return re;
    }
    public int getFila(){
        return this.fila;
    }
    public int getCol(){
        return this.col;
    }
    public double[][] getDim(){
        return this.dim;
    }
    
    //Observadores
    public MatrizMatematica suma(MatrizMatematica otra){
        MatrizMatematica suma= new MatrizMatematica(fila,col);
        for(int i=0; i<suma.fila;i++){
            for(int j=0; j<suma.col;j++){
                suma.dim[i][j]=this.dim[i][j]+otra.dim[i][j];
            }
        }
        return suma;
    }
     public MatrizMatematica resta(MatrizMatematica otra){
        MatrizMatematica resta= new MatrizMatematica(fila,col);
        for(int i=0; i<resta.fila;i++){
            for(int j=0; j<resta.col;j++){
                resta.dim[i][j]=this.dim[i][j]-otra.dim[i][j];
            }
        }
        return resta;
    }
     public MatrizMatematica traspuesta(){
         MatrizMatematica traspuesta= new MatrizMatematica(this.col,this.fila);
         for(int i=0;i<this.fila;i++){
             for(int j=0; j<this.col;j++){
                 traspuesta.dim[j][i]=this.dim[i][j];
             }
         }
         return traspuesta;
     }
     public MatrizMatematica producto(MatrizMatematica otra){
         MatrizMatematica pro= new MatrizMatematica(this.fila,otra.col);
         double suma=0;
         for(int i=0;i<this.dim.length;i++){
             for(int j=0; j<otra.dim[0].length;j++){
                 for(int k=0; k<this.col;k++){
                     suma= suma+this.dim[i][k]*otra.dim[k][j];
                 }
                 pro.dim[i][j]=suma;
             }
         }
         return pro;
         
     }
     public MatrizMatematica productoEscalar(double nro){
         MatrizMatematica nueva= new MatrizMatematica(this.fila,this.col);
         for(int i=0; i<this.fila;i++){
             for(int j=0; j<this.col;j++){
                 nueva.dim[i][j]= (nro*this.dim[i][j]);
             }
         }
         return nueva;
     }
}
