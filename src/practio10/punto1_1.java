/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class punto1_1 {
    public static void main(String[]args){
        char ropa,accesorios,belleza,sexo,vidriera,persona= 'S';
        int acumHR=0, acumHA=0, acumHB=0, acumMR=0, acumMA=0, acumMB=0;
        
        while (persona== 'S'){
        System.out.println("sos hombre o mujer? H=hombre, M=mujer");
        sexo=TecladoIn.readLineNonwhiteChar();
        
        System.out.println("Que vidriera le gusta mas? ropa=R, accesorios=A, belleza=B");
        vidriera= TecladoIn.readLineNonwhiteChar();
        
        if (sexo=='H'){
            
        
        switch (vidriera){
            case 'R':
                 acumHR ++;
                break;
            case 'A':
                 acumHA ++;
                break;
            case 'B':
                 acumHB ++;
                break;
            default:
                
                break;
                
                
        }
        
        
        }else 
        if (sexo=='M'){
            
            switch (vidriera){
            case 'R':
                acumMR ++;
                break;
            case 'A':
                acumMA ++;
                break;
            case 'B':
                acumMB ++;
                break;
            default:
                
                break;
        }
            
}
            System.out.println("Hay mas personas? S= si, N= no");
            persona= TecladoIn.readLineNonwhiteChar();
}
        if ((acumHR>acumHA)&&(acumHR>acumHB)){
            System.out.println("los hombres prefieren vidrieras de ropa");}
            else 
            if ((acumHA>acumHB)){
                System.out.println("los hombres prefieren vidrieras de accesorios");}
            else 
                System.out.println("los hombres prefieren vidrieras de belleza");
        if ((acumMR>acumMA)&&(acumMR>acumMB)){
            System.out.println("las mujeres prefieren vidrieras de ropa");
        }
        else 
            if ((acumMA>acumHB)){
                System.out.println("las mujeres prefieren vidrieras de accesorios");
                
            }
            else System.out.println("las mujeres prefieren vidrieras de belleza");
                
            
        
    }
}
