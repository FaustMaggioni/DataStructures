
package DDATP3;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto3 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        String mas ="si";
        while(mas.equalsIgnoreCase("Si")){
         System.out.println("cuantas palabras va a ingresar?");
         int cantidad= TecladoIn.readLineInt();
         String []palabras= new String [cantidad];
         for(int i=0;i<palabras.length;i++){
             System.out.println("ingrese una palabra");
             palabras[i]= teclado.nextLine();
         }
         System.out.println("diganos una posicion y le mostraremos la palabra alacenada en ella");
         int pos= TecladoIn.readLineInt();
         if(pos<palabras.length){
         System.out.println("la palabraa en la posicion "+pos+" es "+palabras[pos]);
            
         }else{
                    System.out.println("posicion invalida");
                    }
         System.out.println("va a ingresar mas palabras? si es asi responda con un Si");
            mas= teclado.nextLine();
}
}}