
package DDATP7;

import TPFinalEDAT.TecladoIn;

public class punto1 {
    public static void main (String []args){
    int arreglo []= new int [5];
    for(int i=0; i<arreglo.length;i++){
        System.out.println("ingrese nro");
        arreglo[i]=TecladoIn.readLineInt();}
        boolean creciente= creciente(arreglo);
        if(creciente){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    
        
    
    public static boolean creciente(int []a){
        boolean seguir= true;
       int i=0;
       while((i<a.length-1)&&(seguir)){
           if(a[i]<=a[i+1]){
               seguir=true;
               i++;
           }
           else{
               seguir=false;
           }
        }
       return seguir;
    }
}
