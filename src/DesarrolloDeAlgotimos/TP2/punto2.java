package DesarrolloDeAlgotimos.TP2;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto2 {
    public static void main(String []args){
        Scanner teclado= new Scanner (System.in);
        String palabra, frase;
        int cantidad=0;
        System.out.println("ingrese un texto");
        frase= teclado.nextLine();
        System.out.println("elija una palabra paara ver cuantas veces aparece en el tetxo que nos dió");
        palabra= teclado.nextLine();
        int pos;
        String subpalabra;
        for(pos=0;pos<frase.length();pos++){
            pos= frase.indexOf(" ");
            
            
            if(frase.substring(0, pos).equalsIgnoreCase(palabra)){
                cantidad++;
            }
            frase= frase.substring(pos);
                    
            
        }
        System.out.println(cantidad);
        
    }
}
