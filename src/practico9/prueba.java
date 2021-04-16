/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;

import static practico9.punto10.distancia;
import static practico9.punto10.isoceles;

/**
 *
 * @author Faustino
 */
public class prueba {
    public static void main (String []args){
    int acumI=0;   
    double lado1 = 3, lado2= 3, lado3 = 2; 
    
        
         if (isoceles(lado1,lado2,lado3)){
             System.out.println("el triangulo es isoceles");
             acumI= acumI++;}
         else System.out.println("no lo es");
         System.out.println(acumI);
    }
}
