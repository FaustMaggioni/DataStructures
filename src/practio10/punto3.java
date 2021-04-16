/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico10;
import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class punto3 {
    public static void main(String[]args){
        int n, fila=1, columna =1;
        System.out.println("ingrese n");
        n= TecladoIn.readLineInt();
        System.out.println("----------");
        for(fila=1; fila<=n; fila++){
            for (columna=1; columna<= fila; columna ++){
                System.out.print("|"+fila);
            }
            System.out.println("|");
        }
    
    
}
}
