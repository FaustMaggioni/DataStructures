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
public class punto8 {
    public static boolean verifVocal (char x){
        boolean res = false;
        if ((x=='a')||(x=='e')||(x=='i')||(x=='o')||(x=='u')){       
        res= true;}
        return res;
                
                        
        }
    public static void main(String []args){
        String texto;
        int i=0,acum=0;
        System.out.println("ingrese texto");
        texto= TecladoIn.readLine();
        for (i=0; i < texto.length(); i++){
            if (verifVocal(texto.charAt(i))){
                acum=acum+1;
            
        }
         
        }
        System.out.println("la cantidad de vocales del texto es "+acum);   }
   }        
        
                
       
        
        
        
        
        
    
    
    

