/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimosTP1;

import TPFinalEDAT.TecladoIn;

/**
 *
 * @author Faustino
 */
public class punto3 {
    public static void main(String []args){
        int acumN=0,numero=0, n=0;
        double promedio;
        char pedo= 's';
        System.out.println("Hay numeros? s= si");
        pedo= TecladoIn.readLineNonwhiteChar();
        while(pedo=='s'){
            System.out.println("ingrese un numero entero");
            numero=TecladoIn.readLineInt();
            acumN=acumN+numero;
            n++;
            System.out.println("hay mas numeros? s=si");
            pedo=TecladoIn.readLineNonwhiteChar();
        }
        promedio= (double)acumN/n;
        System.out.println(promedio);
        
    }
}
