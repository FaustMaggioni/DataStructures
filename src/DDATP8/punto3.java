package DDATP8;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto3 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
         System.out.println("ingrese numero");
         int n= TecladoIn.readLineInt();
         int cant= contar(n);
         System.out.println(cant);
     
     }
public static int contar(int n){
    int cant=1;
    
    if((n>=0)&&(n<10)){
        cant=1;
    }else{
        if(n>=10){
        cant= contar(n/10)+1;
    }}
     return cant;   
}
}