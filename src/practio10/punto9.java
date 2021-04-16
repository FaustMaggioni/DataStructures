/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico10;

/**
 *
 * @author faustino.maggioni
 */
public class punto9 {
    public static void main(String[]args){
        int n=1, columna=1, fila=1;
        System.out.println("x|| 1| 2| 3| 4| 5| 6| 7| 8|9|");
        System.out.println("-----------------------------");
        
        for (fila=1  ; fila<=9; fila++){
            System.out.print(fila +"||");
        
            for (columna=1; columna<=9; columna++){
                
                imprimirDigito(columna*fila);
                
            }
            System.out.println("");
        }
        
}
public static void imprimirDigito (int numero){
    if (numero<10){  xz
        System.out.print(" ");}
    System.out.print(numero+"|");
        
    }
    
}
