package DDATP8;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto3b{
     public static void main (String []args){
         System.out.println("ingrese un numero");
         int numero= TecladoIn.readLineInt();
         System.out.println("ahora ingrese un digito para contar sus incidencias en el numero anterior");
         int digito= TecladoIn.readLineInt();
         System.out.println(contarVeces(numero,digito));
     
     
     }
public static int contarVeces(int n,int d){
    int res;
    if(n==d){
        res= 1;
    }else{
        if(n<10){
            res=0;}
        else{
            if(n%10==d){
                res= contarVeces(n/10,d)+1;
            }
            else{
                res= contarVeces(n/10,d);
            }
        }}
    
      
           
    return res;
}}