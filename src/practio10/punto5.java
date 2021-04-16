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
public class punto5 {
    public static void main(String[]args){
        double temp1, temp2, temp3, temp4, dia=1,mayor=0,mayorF=0;
        String diasemana="";
        
     for (dia=1; dia<=7; dia ++) {
         System.out.println("ingrese las 4 temperaturas registradas en el dia");
        temp1=TecladoIn.readLineDouble();
        temp2=TecladoIn.readLineDouble();
        temp3=TecladoIn.readLineDouble();
        temp4=TecladoIn.readLineDouble();
                
    if ((temp1>temp2)&&(temp1>temp3)&&(temp1>temp4)){
        System.out.println("la temperatura a las 6hs fue la maxima del dia, "+temp1);
        mayor= temp1;
            }
    else
        if ((temp2>temp3)&&(temp2>temp4)){
            System.out.println("la temperatura a las 12hs  fue la maxima del dia, "+temp2);
        mayor= temp2;
        }
    else
            if ((temp3>temp4)){
                System.out.println("la temperatura a las 18hs fue la maxima del dia, "+temp3);
            mayor= temp3;
                    }
            else{
                System.out.println("la temperatura a las 24hs fue la maxima del dia, "+temp4);
                mayor= temp4;}
        if (mayor>mayorF){
        mayorF= mayor;
        diasemana= dias((int)dia);
        
    }
        System.out.println("la mayor temperatura registrada fue "+ mayorF +" y fue el dia "+diasemana);
        
    
    }
}
    public static String dias(int d){
        String diasemana="";
        switch(d){
            case 1:
                diasemana= "Lunes";
                break;
            case 2:
                diasemana= "Martes";
                break;
            case 3: 
                diasemana= "Miercoles";
                break;
            case 4:
                diasemana= "Jueves";
                break;
            case 5:
                diasemana= "Viernes";
                break;
            case 6:
                diasemana= "Sabado";
                break;
            case 7:
                diasemana= "Domingo";
                break;
        }
        return diasemana;
    }
}