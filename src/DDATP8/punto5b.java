package DDATP8;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto5b{
     public static void main (String []args){
    int max=0;
    int mayor= mayor(max);
    System.out.println(mayor);
}
public static int mayor(int max){
    System.out.println("ingrese entero, cuando quiera terminar ingrese 0");
    int nro= TecladoIn.readLineInt();
    if(nro!=0){
     if(nro>max){
        max= mayor(nro);
   }else{
          max= mayor(max);
    }}
     return max;
}}