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
public class punto7 {
    public static int cantCifras (int numero){
        int cifras=0;
        while (numero>0){
        numero= numero/10;
        cifras++;
            
            
        }
        return cifras;
    }
    public static int primerCifra (int numero){
        int primera, cifra;
        cifra= cantCifras (numero);
        primera= 0;
         primera= (int)(numero/(Math.pow(10, cifra-1)));
        return primera;
    }
    public static int ultimaCifra (int numero){
        int ultima=0, cifra;
        cifra= cantCifras (numero);
        ultima= (int)(numero%10);
        return ultima;
    }
        
       
        
            
        
    
    public static void main (String[]args){
        int numero, ultima, cifras, primera;
        System.out.println("ingrese numero");
        numero= TecladoIn.readLineInt();
        ultima= ultimaCifra(numero);
        primera= primerCifra(numero);
        cifras= cantCifras(numero);
        
            if (ultima==primera){
                
            
                System.out.println("el numero es capicua");}
            
                
            
        
           
            
            
        
        
       
        
        
    

    
    
}
