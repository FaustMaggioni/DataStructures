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
public class punto1 {
        public static void main(String []args){
            // Este algoritmo resuelve la siguiente cuenta//
            int x,y,c,d;
            char pregunta='s';
            while(pregunta=='s'){
            System.out.println("ingrese x e y");
            x= TecladoIn.readLineInt();
            y= TecladoIn.readLineInt();
            c= x-y;
            d= x+y;
            x= d-c;
            System.out.println("el valor de x es "+x+"y el de y es "+y);
                System.out.println("va a hacerlo de vuelta? s= si");
                pregunta= TecladoIn.readLineNonwhiteChar();
            
        }
    
}
