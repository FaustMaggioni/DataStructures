/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimosTP1;

import java.util.Scanner;
import static practio10.Final_2.verif;

/**
 *
 * @author Faustino
 */
public class practica2 {
     public static void main(String[]args){
         Scanner teclado=new Scanner(System.in);
        int longitud, word;
        boolean verdad, correcta=false, menor;
        String texto = "", opcion="";
        
        System.out.println("Elegir primero la opcion 1 y luego elegir otra si se quiere");
         
        while (!opcion.equals("salir")){
            System.out.println("elija una opcion. 1: verificar si una cadena esta compuesta solo por letras y espacios en blanco,2: contar la cantidad de palabras de longitud menor a una longitud dada por usted,3: buscar la palabra mas larga,4: armar una nueva cadena compuesta solo por palabras en posiciones pares, y sino, al escribir salir, saldrá del menú");
            opcion= teclado.nextLine();
            switch(opcion){
                case "1": 
                do{
                    System.out.println("ingrese texto");
                    texto= teclado.nextLine();
                    verdad= verif(texto);
                    System.out.println(verdad);
                    
                
                }while (!verdad);
                correcta=true;
                break;
                case "2": System.out.println("ingrese una longitud para comparar");
                longitud= teclado.nextInt();
                
                    
            }
}
     }
     public static void dos (String texto, int longitud){
         int acum=0, i, menor=0;
         char ch;
         
    
    
}
}