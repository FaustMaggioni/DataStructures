package DesarrolloDeAlgotimos.TP2;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto3 {
    public static void main(String []args){
        Scanner teclado=new Scanner(System.in);
        String salida="",texto;
        int cuenta;
        System.out.println("ingrese texto");
        texto= teclado.nextLine();
        for(cuenta=texto.length()-1;cuenta>=0;cuenta--){
            salida=salida+texto.charAt(cuenta);
        }
        System.out.println(salida);
        
        
    }
    
}
