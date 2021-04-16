
package test.lineales;
import TPFinalEDAT.Cola;
import TPFinalEDAT.TecladoIn;

import java.util.Scanner;

public class testCola {
    public static void main(String []args){
         Scanner teclado=new Scanner(System.in);
        Cola c= new Cola();
        encolar(c);
        System.out.println("boolean:"+c.esVacia());
        System.out.println(c.toString());
        System.out.println("boolean:"+c.esVacia());
        System.out.println("-------------");
        descolar(c);
        System.out.println(c.toString());
        System.out.println("-------------");
        c.vaciar();
        System.out.println("Es vacia, espera true: "+c.esVacia());
        System.out.println("-------------");
        encolar(c);
        descolar(c);
        Cola clone= c.clone();
        /*boolean igualdad= c.equals(clone);
        System.out.println("True o False:"+igualdad);*/
        System.out.println("Clone:"+clone.toString()+"Original:"+c.toString());
        Object frente= c.obtenerFrente();
        System.out.println("frente: "+frente);
        
               
}
public static void encolar(Cola c){
     Scanner teclado=new Scanner(System.in);
    boolean seguir=true, var;
    while(seguir){
        System.out.print("Ingrese elemento: ");
        int e= TecladoIn.readLineInt();
        var= c.poner(e);
        System.out.println("va a ingresar mas elementos?");
        seguir= teclado.nextLine().equalsIgnoreCase("si");
    }
}
public static void descolar(Cola c){
    Scanner teclado=new Scanner(System.in);
    boolean seguir=true, var=true;
    while((seguir)&&(var)){
        System.out.println("Va a seguir sacando?");
        seguir= teclado.nextLine().equalsIgnoreCase("si");
        System.out.println("Si si espera true, si no espera false:"+seguir);
        var= c.sacar();
        System.out.println("var: "+var);
        System.out.println("Cola, espera uno menos:"+c.toString());
        
    }
}}