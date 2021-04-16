/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;
import TPFinalEDAT.TecladoIn;
/**
 *
 * @author Faustino
 */
public class punto3 {

 public static void main (String []args){
     int numero,intentos;
     
     for (intentos=1; intentos < 5; intentos ++){
         System.out.println("ingresar numero");
     numero= TecladoIn.readLineInt();
             
             if (numero==690105){
                 
                 System.out.println("alarma desactivada");}
             else
                 
             System.out.println("clave incorrecta");
     }
     
 }      
}            
     
              
 
     
         
 
   

