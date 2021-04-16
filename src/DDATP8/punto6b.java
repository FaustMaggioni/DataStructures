package DDATP8;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto6b{
     public static void main (String []args){
         Scanner teclado=new Scanner(System.in);
         System.out.println("ingrese un texto");
         String t= teclado.nextLine();
         System.out.println("elija un caracter para contar cuantas veces aparece en el texto");
         char c= TecladoIn.readLineNonwhiteChar();
         int pos= t.length()-1;
         int cant= cantidad(t,c,pos);
         System.out.println(cant);
     
     }
public static int cantidad(String t,char x,int pos){
    int cant=0;
    if(pos!=-1){
        if(t.charAt(pos)==x){
            cant= cantidad(t,x,pos-1)+1;
        }else{
            cant= cantidad(t,x,pos-1);
        }
    }
    return cant;
}}