
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
public class punto7 {
    public static void main(String []args){
        double a,b,c, x1, x2;
        System.out.println("ingrese 3 numeros ");
        a=TecladoIn.readLineDouble();
        b= TecladoIn.readLineDouble();
        c= TecladoIn.readLineDouble();
        System.out.println("sus raices son "+baskaraPositivo(a,b,c)+" y "+baskaraNegativo(a,b,c));
       
    }
    public static double baskaraPositivo (double a, double b, double c){
        
        double x1 = (-b+(Math.sqrt(Math.pow(b,2)-4*a*c)))/2*a;
        System.out.println("Da raiz negativa y pasamos al campo de los imaginarios por eso da error");
        return x1;
        
    }
    public static double baskaraNegativo (double a, double b, double c){
        double x2 = (-b-(Math.sqrt(Math.pow(b,2)-4*a*c)))/2*a;
        if (((Math.pow(b,2))-4*a*c)<0){
            System.out.println("Da raiz negativa y pasamos al campo de los imaginarios por eso da error");
        }
        return x2;
    }
}
