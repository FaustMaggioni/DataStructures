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
public class punto9 {
    public static int factorial (int numero){
        int factorial = 1,n,acum;
        n= 1;
        while (numero>0){
            factorial= factorial*numero;
            numero--;
            
            
        }
        return factorial;
    }
    public static void main (String []args ){
        int factorial,n, conjunto=0;
        char pregunta;
        System.out.println("quiere ingresar algun numero? s=Si, n=No");
        pregunta= TecladoIn.readLineNonwhiteChar();
        while (pregunta=='s'){
            System.out.println("ingrese un numero");
            n= TecladoIn.readLineInt();
            factorial= factorial(n);
            conjunto= factorial+conjunto;
            System.out.println("desea ingresar otro numero? s= Si, n= No");
            pregunta= TecladoIn.readNonwhiteChar();
        }
        System.out.println("la suma de los factoriales de esos numeros es " +conjunto);
    }
        
            
        
        
        
    

