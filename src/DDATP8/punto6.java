package DDATP8;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto6{
     public static void main (String []args){
     String res="";
     char c= 'a';
     String otro= mostrarInv(c,res);
         System.out.println(otro);
     
     
     }
public static String mostrarInv(char t,String res){
    
    System.out.println("ingrese caaracter. para terminar ingrese '.'");
    char c= TecladoIn.readLineNonwhiteChar();
    if(c!='.'){
        if(c!=t){
        res= (mostrarInv(t,res))+c;
    }else{
        res= mostrarInv(t,res);
    }
    
}else{
        
    }
return res;

}}
