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
public class PiramideVocal {
    public static String letra(int d){
        String letra="x";
        switch(d){
            case 1:
                letra= "locura";
                break;
            case 2:
                letra= "sin";
                break;
            case 3: 
                letra= "techo";
                break;
            case 4:
                letra= "seba";
                break;
            case 5:
                letra= "puto";
                break;
            case 6:
                letra= "gato";
                break;
            case 7:
                letra= "siome";
                break;
        }
       return letra;
    }
    
    
    public static void main(String []args){
        
        int n, fila=0, columna=0;
        
        System.out.println("ingrese n");
        n= TecladoIn.readLineInt();
        
        for (fila=n; fila>0; fila--){
            for (columna=1; columna <=fila; columna ++){
                System.out.print(columna);
            }
            System.out.println("");}}
    

}
