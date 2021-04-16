/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;

import TPFinalEDAT.TecladoIn;
import static practio10.PiramideVocal.letra;
/**
 *
 * @author Faustino
 */
public class invertida {
    public static void main (String []args){
        int n, fila, columna=1;
        n=TecladoIn.readLineInt();
        System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
        for (fila=1;fila<=n;fila++){
            System.out.print("<");
            for (columna=n; columna>=fila; columna--){
                System.out.print(letra(columna));
                
            }
            System.out.println(">");
       
        }
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Aguante Faustin Records");
    }
}
