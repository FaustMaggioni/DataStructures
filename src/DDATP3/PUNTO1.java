/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDATP3;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

/**
 *
 * @author Faustino
 */
public class PUNTO1 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        char [] letras;
        int cantidad;
        int i=0,x=0;
        
        boolean numero=true;
        System.out.println("cuantas letras va a ingresar?");
        cantidad= TecladoIn.readLineInt();
        letras= new char [cantidad];
        for(x=0;x<cantidad;x++){
            System.out.println("ingrese letra");
            letras[x]= TecladoIn.readLineNonwhiteChar();
        }
        
        while((numero)&&(i>=letras.length-1)){
           if(Character.isLetter(letras[i])){
               numero=true;
           }
           else{
               System.out.println("no ha ingresado solo numeros");
               numero=false;
           }
           i++;
        }
        if(numero){
            pares(char[])
            
        }
        
        
       
    
}
    public static void pares(char[]letras){
        int j;
       
        for (j=0;j<letras.length;j++){
            if(j%2==0){
                System.out.print(letras[j]);
            }
        }
    }
}