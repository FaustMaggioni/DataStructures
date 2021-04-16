
package practio10;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class MOD {
  public static void main (String []args){
      int numero;
      System.out.println("ingrese numero");
      numero= TecladoIn.readLineInt();
      int cantidad=  cantidad(numero);
      System.out.println(cantidad);
      int invertido= invertido(numero);
      System.out.println(invertido);
      String hola;
      hola= "00";
      boolean pedo= cincuenta(hola);
      if(pedo){
          System.out.println("de ruta");
      }
      else{
          System.out.println("no llega");
      }
      int prod= productoria(hola);
      System.out.print(prod);
}
  public static int cantidad(int numero){
    int cant=0,i=0;
    boolean nro=true;
    while(nro){
        if(numero>Math.pow(10, i)){
            cant++;
            i++;
            
        }
        else{
            nro= false;
        }
    }
    return cant;
  }
  public static int invertido (int numero){
    int cifra, inverso = 0;
        while(numero!=0){
            cifra = numero%10;
            inverso = (inverso * 10) + cifra;
            numero=numero/10;
      
      
  }
return inverso;
  }
public static boolean cincuenta (String numeros){
    int i=0,sum=0;
   
    while((sum<50)&&(i<numeros.length()-1)){
        char j= numeros.charAt(i);
        switch (j){
            case '1':
                sum= sum+1;
                break;
                case '2':
                sum= sum+2;
                break;
                case '3':
                sum= sum+3;
                break;
                case '4':
                sum= sum+4;
                break;
                case '5':
                sum= sum+5;
                break;
                case '6':
                sum= sum+6;
                break;
                case '7':
                sum= sum+7;
                break;
                case '8':
                sum= sum+8;
                break;
                case '9':
                sum= sum+9;
                break;
                case '0':
                sum= sum+0;
                break;
                
            
                
                
        }
    }
    System.out.println(sum);
           
    return sum==50;
}
public static int productoria (String cadena){
    int pro=1,i=0;
    char j;
    boolean seguir=true;
    while((seguir)&&(i<cadena.length()-1)){
     j= cadena.charAt(i);
     switch(j){
         case '1':
             pro=pro*1;
             break;
         case '2':
             pro=pro*2;
             break;
         case '3':
             pro=pro*3;
             break;
         case '4':
             pro=pro*4;
             break;
         case '5':
             pro= pro*5;
             break;
         case '6':
             pro= pro*6;
             break;
         case '7':
             pro= pro*7;
             break;
         case '8':
             pro= pro*8;
             break;
         case '9':
             pro=pro*9;
             break;
             case'0':
                 pro=pro*0;
                 seguir=false;
                 break;
             default:
                 System.out.println("error");
                 seguir= false;
                 break;
                 
                        
                 
     }
}
return pro;
}}