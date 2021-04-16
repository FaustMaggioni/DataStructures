package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto4 {
    public static void main(String[]args){
        Scanner teclado=new Scanner(System.in);
        String palabra;
        char vocal;
        int cantidad;
        System.out.println("ingrese palabra");
        palabra= teclado.nextLine();
        System.out.println("escriba una vocal para contar");
        vocal= TecladoIn.readLineNonwhiteChar();
        cantidad= verificarRepe(palabra,vocal);
        System.out.println("la vocal "+vocal+" se repite "+cantidad+" veces");
       
             
        }
        
   
    public static int verificarRepe(String palabra, char vocal){
        
        int i=0, cont=0;
        
        for (i=0;i<palabra.length();i++){
          if (palabra.charAt(i)==vocal){
              cont++;
          }
        
    }
        return cont;
}
}