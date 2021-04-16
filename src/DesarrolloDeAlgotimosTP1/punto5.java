package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto5 {
   public static void main(String []args){
       Scanner teclado=new Scanner(System.in);
        String frase, Palabra, Larga=" ";
        int p;
        System.out.println("escriba su frase");
        frase= teclado.nextLine();
        frase= frase+ " ";
        while(!frase.equals("     ")){
            p= frase.indexOf(' ');
            Palabra= frase.substring(0,p);
            frase= frase.substring(p+1);
            if(Palabra.length()>Larga.length()){
                Larga= Palabra;
            }
            System.out.println("la palabra mas larga es "+Larga);
        }
        System.out.println("la palabra mas larga es "+Larga);
   }}