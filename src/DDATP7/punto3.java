
package DDATP7;
import static DDATP7.punto2.cargarArreglo;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto3 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int a []= new int [5];
        cargarArreglo(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ,");
        }
         System.out.println("");
        
         burbujaMejorado(a);
         System.out.println("------------");
          for(int j=0;j<a.length;j++){
            System.out.print(a[j]+" ,");
        }
    
}
     public static void intercambiar ( int j, int i,int[]a){
         int temp;
         temp= a[i];
         a[i]=a[j];
         a[j]=temp;
         
     }
     public static void burbuja (int []a){
         int l= a.length-2,q=a.length;
         int i=0;
         int j=0;
         
         for(i=0;i<=l;i++){
             for(j=0;j<=l-i;j++){
                 if(a[j+1]<a[j]){
                     intercambiar(j,j+1,a);
                 }
             }
         }
     }
     
     public static void burbujaMejorado(int []a){
           int l= a.length-2;
         int i=0;
         int j,temp;
         int vueltas=0;
         int listo=0;
         while((i<=l)&&(listo==0)){
             listo= 1;
             for(j=0;j<=l-i;j++){
                 
                 if(a[j+1]<a[j]){
                     temp= a[j];
                     a[j]=a[j+1];
                     a[j+1]=temp;
                     listo= 0;
                 }
         }
             
             
             i++;
     }
         
         System.out.println("vueltas="+i);}
     public static void insercion(int []a){
         int largo= a.length-1;
         for(int p=1;p<=largo;p++){
             int temp= a[p];
             int j=p;
             while((j>0)&&(temp<a[j-1])){
                 a[j]=a[j-1];
                 j--;
             }
             a[j]=temp;
         }
     }
     public static boolean comparar(int []a,int []n){
         boolean res=false;
         int i=0;
         while((res=false)&&(i<a.length)){
             if(a[i]==n[i]){
                 res=true;
             }
         }
         return res;
     }
}