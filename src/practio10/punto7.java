/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;
/**
 *
 * @author Faustino
 */
public class punto7 {
    public static void main (String []args ){
        double recS=0, recD=0, dinero,  recCaja;
        int d, caja;
        String dia;
        d=1;
        caja=1;
        for (d=1; d<=7; d++){
            for (caja=1; caja<=7 ; caja++){
                System.out.println("ingrese lo recaudado en la caja "+caja);
                recCaja= TecladoIn.readLineDouble();
                recD= recD+recCaja;}
            System.out.println("Lo recaudado del dia "+dias(d)+" fue "+recD);
            recS= recS+recD;}
        System.out.println("lo recaudado en la semana fue: "+recS);
        System.out.println("el promedio por dia es "+recS/7);}
        
    
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


