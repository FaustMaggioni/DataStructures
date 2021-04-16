/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;
import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class punto5 {
    public static void main (String[]args){
        int mayor= 0,N,numero, ingreso;
        System.out.println("ingrese N");
        N= TecladoIn.readLineInt();
        
        for (ingreso=1; ingreso <= N;ingreso++){
            System.out.println("ingrese numero");
            numero= TecladoIn.readLineInt();
            if (numero>mayor)
                mayor= numero;
                
                
            }
        System.out.println("el mayor numero es "+ mayor);
        }
    }
    
