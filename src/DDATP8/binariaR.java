
package DDATP8;

import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.burbuja;
import static DDATP7.punto3.burbujaMejorado;

public class binariaR {
    public static void main(String []args){
    int n=6;
    int []a= new int [8];
    cargarArreglo(a);
    burbuja(a);
    for(int i=0;i<a.length;i++){
        System.out.print(a[i]+".");
    }
        System.out.println("");
    int pos= BBR(0,a.length-1,n,a);
        System.out.println(pos);
    
    
    }
    public static int BBR(int inicio,int fin,int n,int[]a){
     
     int res=-1;   
     int medio= (inicio+fin)/2;
     if(inicio>fin){
         res= -1;}
         else{
     if(a[medio]==n){
         res= medio;
     }else{
         if(a[medio]<n){
             res= BBR(medio+1,fin,n,a);
         }else{
             res= BBR(inicio,medio-1,n,a);
         }
     }
}return res;
    } }