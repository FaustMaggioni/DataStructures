/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico10;
import Utiles.TecladoIn;
/**
 *
 * @author faustino.maggioni
 */
public class punto2 {
    public static void main(String[]args){
    char eleccion, invitados= 's';
    int costo=0;
        
        while (invitados=='s'){
        System.out.println("va a comer el menu comun o el vegetariano? v= vegetariano c=comun");
        eleccion= TecladoIn.readLineNonwhiteChar();
    
        if (eleccion=='v'){
            costo= costo+150;
        }
        else {
            costo= costo+230;
        }
            System.out.println("hay mas invitados? s= si, n= no");
            invitados= TecladoIn.readLineNonwhiteChar();
    
    
    
    
}
        System.out.println("el costo total a pagar por los menus es "+costo);
}
    }