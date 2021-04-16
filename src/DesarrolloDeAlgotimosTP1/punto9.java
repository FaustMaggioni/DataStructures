
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto9 {
    public static void main (String[]args){
         Scanner teclado=new Scanner(System.in);
         String color,patente,marcaMas=" ";
         int contRojo=0,año,capacidad,autos=0,contCapacidad=0,marca1=0,marca2=0,marca3=0,marca,marcaFinal=0;
         double promedio;
         char seguir ='s';
         while (seguir=='s'){
             System.out.println("que marca es el vehiculo? 1:Ford 2:Mercedes 3:Ferrari");
             marca= TecladoIn.readLineInt();
             switch (marca){
                 case 1:
                     
                     marca1++;
                     if (marca1>marcaFinal){
                         
                         marcaFinal=marca1;
                         marcaMas= "Ford";
                         
                     }
                     break;
                 case 2:
                     marca2++;
                     if((marca2>marcaFinal)){
                         
                         marcaFinal=marca2;
                         marcaMas= "Mercedes";
                         
                     }
                     break;
                 case 3:
                     marca3++;
                     if(marca3>marcaFinal){
                        
                         marcaFinal=marca3;
                         marcaMas= "Ferrari";
                     }
                     break;
             }
             System.out.println("que color es el auto?");
             color= teclado.nextLine();
             if(color.equalsIgnoreCase("rojo")){
                 contRojo++;
             }
             System.out.println("cual es la capacidad del vehiculo?");
             capacidad= TecladoIn.readLineInt();
             contCapacidad=contCapacidad+capacidad;
             autos++;
             System.out.println("desea continuar?s=si");
             seguir= TecladoIn.readLineNonwhiteChar();
             
         }
         promedio=((double)(contCapacidad/autos));
         System.out.println("la capacidad promedio de autos es "+promedio);
         System.out.println("la marca de autos mas expuesta es "+marcaMas);
         System.out.println("la cantidad de autos rojos es "+contRojo);
    }}