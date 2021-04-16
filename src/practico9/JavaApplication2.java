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
public class JavaApplication2 {
    public static int cuentaRegresiva(int x){
        int numC, i;
        System.out.println("ingrese i");
        i= TecladoIn.readLineInt ();
        if (x==i){
        for (x=1;x <= i; x ++){
            System.out.println (Math.abs(x));
            
                    }
        }
      return x;       
        }
    public static void main(String[] args) {
        int numC,x;
        System.out.println("ingrese x");
        x= TecladoIn.readLineInt();
        numC = cuentaRegresiva (x);
    }
}