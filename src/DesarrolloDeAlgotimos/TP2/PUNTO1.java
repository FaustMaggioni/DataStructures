/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimos.TP2;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class PUNTO1 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        char vocal;
        int  cantVocal;
        String text;
        System.out.println("escriba texto");
        text= teclado.nextLine();
        System.out.println("que vocal va a querer contar sus ocurrencias en el texto?");
        vocal= TecladoIn.readLineNonwhiteChar();
        cantVocal= contVocales(text,vocal);
        System.out.println(cantVocal);
        
    }
    public static int contVocales (String text, char vocal){
        int pos=0,cantVocal=0;
        char digito;
        while (pos<text.length()){
            digito= text.charAt(pos);
            if(digito==vocal);{
            cantVocal= cantVocal+1;
            }
           
            pos++;
        }
        return cantVocal;
    }
}
