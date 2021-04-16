package DDATP8;
import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto5{
     public static void main (String []args){
     int cant= contar4();
         System.out.println(cant);
     
     
     
     }
public static int contar4(){
    int nro, cant=0;
    System.out.println("ingrese numero. cuando quiera terminaar ingrese 0");
    nro= TecladoIn.readLineInt();
    if(nro!=0){
        if(nro%4==0){
            cant= contar4()+1;
        }
        else{
            cant= contar4();
        }
    }
   return cant;
}

}