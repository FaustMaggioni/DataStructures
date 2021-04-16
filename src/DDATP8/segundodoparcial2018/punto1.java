
package DDATP8.segundodoparcial2018;
import static DDATP7.punto2.cargarArreglo;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto1 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int []a= new int [5];
        cargarArreglo(a);
        
        boolean decre= arre(a,a.length-1);
        if(decre){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
       int n= 5678;
       int q= queHago2(n);
         System.out.println(q);
    
}
     public static boolean arre(int []a,int pos){
         boolean res=true;
         if(pos!=0){
             if(a[pos]<a[pos-1]){
                 res= arre(a,pos-1);
             }else{
                 res= false;
             }
         }
         return res;
     }
     static int queHago2(int n) {
         int aux;       
         if (n == 0){ 
             aux= n;}
               else {
             aux= (n % 10) + queHago2(n / 10) * 10;
         }        return aux;    }
}