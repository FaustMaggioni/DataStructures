/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import static practio10.PiramideVocal.letra;
/**
 *
 * @author Faustino
 */
public class piramide {
    public static void main (String []args){
        int i, columna=0, fila=0;
        System.out.println("ingrese i");
        i=TecladoIn.readLineInt();
                
    for (fila=1; fila<=i; fila++){
            for (columna=1; columna<=fila; columna ++){
                System.out.print(letra(columna));
            }
            System.out.println(" ");}}

  
    }


