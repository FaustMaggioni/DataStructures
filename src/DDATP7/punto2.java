
package DDATP7;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto2 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
         System.out.println("ingrese la cantidad de elementos del arreglo");
         int a []= new int [TecladoIn.readLineInt()];
         cargarArreglo(a);
         burbuja(a);
         System.out.println("denos un elemento para verificar si está en el arreglo");
         int n= TecladoIn.readLineInt();
         if(busquedaSecuencial(a,n)){
             System.out.println("está");
         }
         else{
             System.out.println("no está");
         }
         if(busquedaBinaria(a,n)){
             System.out.println("true");
         }
         else{
             System.out.println("false");
         }
             
     }
public static void cargarArreglo(int []a){
    int p= a.length;
    for(int i=0;i<p;i++){
        System.out.println("ingrese elemento");
        a[i]=TecladoIn.readLineInt();
    }
    
}
public static boolean busquedaSecuencial(int []a,int n){
    boolean listo=false;
    int i=0;
    int p= a.length-1;
    while((listo==false)&&(i<=p)){
        if(a[i]==n){
            listo= true;
        }
        else{i++;}
}
    return listo;
}
public static boolean busquedaBinaria(int []a,int n){
    int inicio=0,fin=a.length-1;
    boolean listo=false;
    while((listo==false)&&(inicio<=fin)){
        int medio= (int) Math.floor(inicio+fin/2);
        if(a[medio]==n){
            listo= true;
        }
        else{
            if(n<a[medio]){
                fin= medio-1;
            }
            else{
                inicio= medio+1;
            }
        }
    }
    return listo;
}}