
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto6 {
    public static void main(String [] args){
        Scanner teclado=new Scanner(System.in);
        int x;
        String dia;
        System.out.println("elija un numero");
        x= teclado.nextInt();
        dia= dias(x);
        System.out.println("el dia es |"+dia+"|");
        
    }
    public static String dias(int x){
        Scanner teclado=new Scanner(System.in);
        String diasemana="";
            switch (x){
                case 1:
                    diasemana= "lunes";
                    break;
                case 2:
                    diasemana= "martes";
                    break;
                case 3:
                    diasemana= "miercoles";
                    break;
                case 4:
                    diasemana= "jueves";
                    break;
                case 5:
                    diasemana= "viernes";
                    
                    break;
                case 6:
                    diasemana= "sabado";
                    break;
                case 7:
                    diasemana= "domingo";
                    break;
                default:
                    diasemana= "error";
                    break;
                
        }
       return diasemana;
    }
    
}
