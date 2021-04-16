/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

/**
 *
 * @author Faustino
 */
public class punto8 {
    public static void main (String []args){
        String equipo, equipoG="";
        double tiempoI, tiempoE=0, mayorT=9999, promedio;
        int participantes, equipos, n=1, i=1;
        System.out.println("ingrese cantidad de equipos");
        equipos= TecladoIn.readLineInt();
        System.out.println("cuantos integrantes tiene cada uno?");
        participantes= TecladoIn.readLineInt();
        for (n=1; n<=equipos;n++){
            Scanner teclado=new Scanner(System.in);
            System.out.println("ingrese nombre del equipo");
            
            equipo= teclado.next();
            for (i=1; i<=participantes; i++){
                System.out.println("ingrese su marca individual");
                tiempoI= TecladoIn.readLineDouble();
                tiempoE= tiempoE+tiempoI;}
                if (tiempoE<mayorT){
                mayorT= tiempoE;
                equipoG= equipo;}
            
            System.out.println("el tiempo total del equipo es "+tiempoE);
            promedio= tiempoE/participantes;
            System.out.println("el promedio de este equipo es "+promedio);
        }
            
                
            
            
         
        System.out.println("el mejor tiempo es "+mayorT+" y el equipo que lo logro fue "+equipoG);
        }
}
      
        
