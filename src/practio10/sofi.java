/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;
/**
 *
 * @author Faustino
 */
public class sofi {
    public static void main (String []args){
        char pool='s', ganador;
        int faus, sofi;
        while (pool=='s'){
            System.out.println("cuantas bolas metio faus?");
            faus=TecladoIn.readLineNonwhiteChar();
            if (faus==8){
                System.out.println("faus gano");
            }
            else {System.out.println("cuantas metio sofi?");
            sofi= TecladoIn.readLineNonwhiteChar();
            if (sofi==8){
                System.out.println("sofi gano");}}
            System.out.println("jugamos otro? s=si");
            
           
        
              
        
        }
        
        
    }
    
}
