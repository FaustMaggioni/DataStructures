/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
/**
 *
 * @author Faustino
 */
public class seba {
    public static void main(String []args){
         int dia;
        Scanner teclado=new Scanner(System.in);
        System.out.println(" ingrese el numero de dia que quiere saber");
        dia=TecladoIn.readLineInt();
        diaSemana (y);
        
    }
    
    public static void dia (int y ){
        String diaSemana;
        switch (y){
            case 1 :
                 diaSemana="lunes" ;
                         break;
            case 2 :
                diaSemana="martes";
                break;
            case 3 :
                diaSemana="miercoles";
                break;
            case 4 :
                diaSemana="jueves";
                break;
            case 5 : 
                diaSemana = "viernes ";
                break;
            case 6 :
                diaSemana = "sabado";
                break;
            case 7 :
                diaSemana = "domingo";
                break;
            default:
                diaSemana= "error";
                break;
                     
               
    }
        
}
}