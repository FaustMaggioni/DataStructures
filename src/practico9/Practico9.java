/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;
import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class Practico9 {
    public static double costoEnvio(double peso){
        double costo;
        costo= ((50*peso)+30);
        return costo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double peso, montoEnvio= 0,montoTotal= 0;
        int envios =0;        
        System.out.println("ingrese peso");
        peso= TecladoIn.readLineInt();
        while (peso !=0)
        {
            montoEnvio=costoEnvio (peso);
            System.out.println("el costo del envio"+ montoEnvio);
            envios++;
            montoTotal= montoEnvio+montoTotal;
            System.out.println("ingrese peso");
            peso= TecladoIn.readLineInt();
            
        }
        
        
        System.out.println("envios es "+ envios);
        System.out.println("monto total es "+montoTotal);
        
                
        // TODO code application logic here
    }
    
}
