
package DDATP3;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto4 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
         System.out.println("cuantas palabras va a ingresar?");
         int cantidad= TecladoIn.readLineInt();
         String []palabras= new String [cantidad];
         for(int i=0;i<palabras.length;i++){
             System.out.println("ingrese una palabra");
             palabras[i]= teclado.nextLine();
         }
         System.out.println("diganos una palabra y le diremos la posicion en la que esta");
         String palabra=  teclado.nextLine();
         int j=0;
         boolean listo= false;
         while((j<palabras.length)&&(!listo)){
             if(palabras[j].equalsIgnoreCase(palabra)){
                 System.out.println("la palabra está en la posicion "+j);
                 listo= true;
             }
             else{
                 j++;
             }
         }
         if(!listo){
             System.out.println("-1");
             
         }
}
}