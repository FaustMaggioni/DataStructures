/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;
import TPFinalEDAT.TecladoIn;
       

/**
 *
 * @author Faustino
 */
public class punto10 {
    public static double distancia(double x1, double y1,double x2, double y2){
        double distancia;
        distancia=(Math.abs(x1))-(Math.abs(x2)+(Math.abs(y1)-(Math.abs(y2))));
        return distancia;
    }
    public static boolean isoceles(double lado1, double lado2, double lado3){
        boolean isoceles=false;
        if ((lado1==lado2)||(lado1==lado3)||(lado2==lado3)){
            isoceles= true;
           
        }
        return isoceles;
   }
    public static void main (String []args){
        int acumI=0;
        double x1,y1,z1,x2,y2,z2,lado1,lado2,lado3;
        char triangulo='s';
        
        while(triangulo=='s'){
         System.out.println("ingrese las 6 coordenas, primero las dos del punto x, despues las dos del y y tercero las dos del punto z");
        x1= TecladoIn.readLineDouble();
        x2= TecladoIn.readLineDouble();
        y1= TecladoIn.readLineDouble();
        y2= TecladoIn.readLineDouble();
        z1= TecladoIn.readLineDouble();
        z2= TecladoIn.readLineDouble();
        lado1= distancia(x1,z1,x2,z2);
        lado2= distancia(x1,y1,x2,y2);
        lado3= distancia(z1,y1,z2,y2);
         if (isoceles(lado1,lado2,lado3)){
             System.out.println("el triangulo es isoceles");
             acumI= acumI++;
         }
            System.out.println("va a ingresar otro triangulo? s= Si ");
            triangulo= TecladoIn.readLineNonwhiteChar();
            
        }
        System.out.println("la cantidad de triangulos isoceles es "+acumI);
            
        
    }
    
}
