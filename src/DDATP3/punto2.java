
package DDATP3;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
/**
 *
 * @author Faustino
 */
public class punto2 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int[] enteros;
        int cantidad,i;
        System.out.println("cuantas posiciones  tendrá el arreglo?");
        cantidad= TecladoIn.readLineInt();
        enteros= new int[cantidad];
        for(i=0;i<enteros.length;i++){
            System.out.println("ingrese un entero");
            enteros[i]= TecladoIn.readLineInt();
            
        }
        System.out.println("el arreglo tiene "+cuantosPares());
        
        
        
    }
    public static int cuantosPares (int[]enteros){
        int pares=0;
        for(int j=0;j<enteros.length;j++){
            if(enteros[j]%2==0){
                pares++;
            }
        }
        return pares;
    }
}
