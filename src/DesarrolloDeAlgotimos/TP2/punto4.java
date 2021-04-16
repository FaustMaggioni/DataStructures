
package DesarrolloDeAlgotimos.TP2;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;


public class punto4 {
    public static void main(String[]args){
        Scanner teclado=new Scanner(System.in);
        String texto, palabraConMasVocal;
        char vocal;
        System.out.println("texto");
        texto= teclado.nextLine();
        System.out.println("char");
        vocal= TecladoIn.readLineNonwhiteChar();
        palabraConMasVocal= vocalenpalabra(texto,vocal);
        System.out.println(palabraConMasVocal);
    }
    public static String vocalenpalabra(String texto,char vocal){
        int contVocal=0,i=0,pos,contVocalIndividual=0,n;
        String ganadora=" ",palabra;
        while(i<texto.length()){
            pos= texto.indexOf(" ");
            palabra= texto.substring(0,pos);
            texto= texto.substring(pos);
            for(n=0;n<palabra.length();n++){
                if(palabra.charAt(n)=='a'){
                    contVocalIndividual++;
                }
                if(contVocalIndividual>=contVocal){
                    contVocal=contVocalIndividual;
                    ganadora=palabra;}
                }
            i++;
            }
        return ganadora;
        }
    }

