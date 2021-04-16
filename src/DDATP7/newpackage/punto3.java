
package DDATP7.newpackage;

import static DDATP7.punto1.creciente;
import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.intercambiar;



public class punto3 {
    public static void main(String []args){
    int []a= new int [5];
    cargarArreglo(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.println("---------");
  
   seleccion(a);
         for(int j=0;j<a.length;j++){
            System.out.print(a[j]+",");
        }
        System.out.println("--------");
    insercion(a);
         for(int k=0;k<a.length;k++){
            System.out.print(a[k]+",");
        }
        System.out.println("--------");
    
    
    
    }
    public static void seleccion(int []a){
        int i,j,min;
        for(i=0;i<a.length-1;i++){
            min=i;
            for(j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            intercambiar(i,min,a);
        }
    }
    public static void insercion(int []a){
        int i,j,min;
        for(i=1;i<=a.length-1;i++){
            min= a[i];
            j=i;
            while((j>0)&&(min<a[j-1])){
                a[j]=a[j-1];
                j--;
                
            }
            a[j]=min;
            
        }
    }
}
