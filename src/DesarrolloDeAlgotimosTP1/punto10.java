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
public class punto10 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        String formageo="Si";
        double perimetro, area, lado1,lado2,radio;
        int opcion;
        System.out.println("elija una figura geometrica. 1: cuadrado, 2:rectangulo, 3:triangulo,4: circulo");
        opcion= TecladoIn.readLineInt();
        while(formageo.equalsIgnoreCase("si")){
            switch(opcion){
            case (1):
                System.out.println("diganos un lado del cuadrado en centimetros y le calcularemos su perimetro y area");
                lado1= TecladoIn.readLineDouble();
                perimetro= perimCuadrado(lado1);
                area= areaRectangulo(lado1,lado1);
                System.out.println("el perimetro es "+perimetro+" cm, y el area "+area+" centimetros cuadrados");
                break;
                        
            case (2):
                System.out.println("diganos dos lados distintos del rectangulo y calcularemos su area y perimetro");
                lado1=TecladoIn.readLineDouble();
                lado2=TecladoIn.readLineDouble();
                area= areaRectangulo(lado1,lado2);
                perimetro= perimRectangulo(lado1,lado2);
                System.out.println("el perimetro es "+perimetro+" cm, y el area "+area+" centimetros cuadrados");
                break;
            case (3):
                System.out.println("diganos un lado de su triangulo y calcularemos su perimetro y area");
                lado1=TecladoIn.readLineDouble();
                area=
                perimetro= perimTriangulo(lado1);
                System.out.println("el perimetro es "+perimetro+" cm, y el area "+area+" centimetros cuadrados");
                break;
            case (4):
                System.out.println("");
        }
            
        
    }}
    public static double perimCuadrado(double lado){
        double perimetro;
        perimetro= (lado*4);
        return perimetro;
    }
    public static double areaRectangulo(double lado,double lado1){
        double area;
        area= (lado*lado1);
        return area;
    }
    public static double perimRectangulo(double lado1,double lado2){
        double perimetro;
        perimetro= ((lado1*2)+(lado2*2));
        return perimetro;
    }
    public static double perimTriangulo(double lado){
        double perimetro;
        perimetro= lado*3;
        return perimetro;
    }
    public static double areaTriangulo (double lado){
        double area, altura;
        altura= Math.sqrt((Math.pow(lado, 2))+(Math.pow(lado, 2)));
        area= (lado*altura)/2;
        return area;
    }
    
}
