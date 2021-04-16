
package DDATP5;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class TestRacional {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
         racional rac= cargar();
         
         boolean elegir=true;
         while(elegir){
         System.out.println("elija una opcion");
         int opcion= TecladoIn.readLineInt();
         menu(opcion,rac);
             System.out.println("va a elegir otra opcion?");
             elegir= teclado.nextLine().equalsIgnoreCase("si");
         }
    
}
public static racional cargar(){
    System.out.println("ingrese numerador y denominador");
    int x= TecladoIn.readLineInt();
    int y= TecladoIn.readLineInt();
    racional nuevo= new racional(x,y);
    return nuevo;
}
public static void menu(int opcion, racional rac){
    switch(opcion){
             case 1: System.out.println(rac.getNumerador());
             break;
             case 2: System.out.println(rac.getDenominador());
             break;
             case 3: double real= rac.aReal();
                 System.out.println(real);
                 break;
             case 4:
                 System.out.println(rac.aString());
                 break;
             case 5: 
             racional equal=cargar();
             if(rac.equals(equal)){
                 System.out.println("true");
             }else{
                 System.out.println("false");
             }
                 break;
             case 6:
                 System.out.println("ingrese un numero para cambiar el numerador del racional anterior");
                 int x= TecladoIn.readLineInt();
                 rac.setNum(x);
                 System.out.println(rac.toString());
                 break;
             case 7: System.out.println("ingrese un nro para cambiar el denominador");
             int y= TecladoIn.readLineInt();
             rac.setDen(y);
                 System.out.println(rac.aString());
                 break;
             case 8: racional otro= cargar();
             racional suma= rac.sumar(otro);
                 System.out.println(suma.aString());
                 break;
             case 9:
                 racional este= cargar();
                 racional resta= rac.restar(este);
                 System.out.println(resta.aString());
                 break;
             case 10:
                 racional uno= cargar();
                 racional producto= rac.multiplicar(uno);
                 System.out.println(producto.aString());
                 break;
             case 11:
                 racional divisor= cargar();
                 racional dividido= rac.dividir(divisor);
                 System.out.println(dividido.aString());
                 break;
             case 12:
                 rac.simplificar();
                 System.out.println(rac.aString());
                 
         }
}}
