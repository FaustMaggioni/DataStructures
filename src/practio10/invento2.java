/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class invento2 {
    public static void main (String []args){
    int talle,talleM=0;
    String zapatillas="Si";
    while (zapatillas=="Si"){
        System.out.println("Cuanto calzas?");
        talle= TecladoIn.readLineInt();
        if (talle>talleM){
            talleM= talle;
        }
        Scanner teclado=new Scanner(System.in);
        System.out.println("hay mas zapatillas?");
        zapatillas= TecladoIn.readLineWord();
    }
        
        
        System.out.println("la zapatiilas mas grande es de talle "+talleM);
        
}
}