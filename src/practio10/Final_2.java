/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
/**
 *
 * @author faustino.maggioni
 */
public class Final_2 {
    public static void main(String[]args){
         Scanner teclado=new Scanner(System.in);
        int longitud, word;
        boolean verdad, correcta=false, menor;
        String texto = "", opcion="";
        
        System.out.println("Elegir primero la opcion 1 y luego elegir otra si se quiere");
        while (!opcion.equals("salir")){
            System.out.println("elija una opcion. 1: verificar si una cadena esta compuesta solo por letras y espacios en blanco,2: contar la cantidad de palabras de longitud menor a una longitud dada por usted,3: buscar la palabra mas larga,4: armar una nueva cadena compuesta solo por palabras en posiciones pares, y sino, al escribir salir, saldrá del menú");
            opcion= teclado.nextLine();
        switch (opcion) {
            case "1": 
                do{
                    System.out.println("ingrese texto");
                    texto= teclado.nextLine();
                    verdad= verif(texto);
                    System.out.println(verdad);
                    
                
                }while (!verdad);
                correcta=true;
                break;
            case "2":
                if (correcta=true){
                    System.out.println("elija una longitud para comparar con las palabras del texto");
                   
                    longitud= teclado.nextInt();
                    palabras(texto,longitud);
                    break;
                }
            case "3":
                if (correcta=true){
                    larga(texto);
                    break;
                }
            case "4":
                if(correcta=true){
                    pares(texto);
                }
            case "salir":
                default:
                    System.out.println("Hasta pronto");
                    break;
                
                
                
                
                
            
        }
    
}
    
}
    public static boolean verif (String texto){
        boolean res = true;
        
        int pos=0;
        while ((pos<=(texto.length()-1))&&(res==true)) {
           // System.out.println(texto.charAt(letra));
            
            if (Character.isLetter(texto.charAt(pos))){
                pos++;
             }
            else {
                System.out.println("tiene numeros");
                res= false;}
                
              
        }
        
         
        return res;
    }
   public static void palabras(String texto,int longitud){
       //cuenta la cantidad de palabras menores a la longitud que nos dio el usuario
       int acum = 0, i, menor=0;
       char ch;
       for (i=0; i < texto.length();i++){
           ch= texto.charAt(i);
           if (ch == ' '){
               if (acum < longitud){
                   menor++;
               }
               acum=0;
               
           } else {
               acum++;
               
           }
       }
       System.out.println("la cantidad de palabras mas cortas que la longitud dada es "+menor);
   
   }
   public static void larga(String texto){
       //busca la palabra mas larga dentro del texto
       String Larga = "", palabra = "";
        int pos, i ;
        texto = texto + " ";
        while (!texto.equals("")){
        pos = texto.indexOf(' ');
        palabra=texto.substring(0,pos);
        texto=texto.substring(pos+1);
        if (palabra.length() > Larga.length()){
            Larga = palabra;}
            
        }
         
        
           
       
       System.out.println("la palabra mayor es "+Larga);}
   
   public static void pares(String texto){
       String palabra="";
       int pos, i, NroPalabra=0;
       texto=texto+" ";
       while (!texto.equals("")){
           pos=texto.indexOf(' ');
           palabra=texto.substring(0,pos);
           texto=texto.substring(pos+1);
           NroPalabra++;
           if(NroPalabra%2==0){
               System.out.print(palabra+" ");
           }
       }
       
      
           
   
       System.out.println(" ");}

}