
package DDATP5;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class testConjunto {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        Conjunto c1= new Conjunto();
        Conjunto c2= new Conjunto();
        //Modularizar el ingreso de elementos
        System.out.println("ingrese los elemento del conjunto 1");
        boolean ingresar= true;
       
        while (ingresar){
            System.out.println("elemento:");
            int elemento=TecladoIn.readLineInt();
            if(elemento<100){
            c1.insertar(elemento);
            }
            System.out.println("va a ingresar otro elemento?");
            ingresar= teclado.nextLine().equalsIgnoreCase("Si");
            
        }
         System.out.println("ingrese los elemento del conjunto 2");
        boolean meter= true;
        
        while (meter){
            System.out.println("elemento:");
            int elemento=TecladoIn.readLineInt();
            if(elemento<100){
            c2.insertar(elemento);}
           
            System.out.println("va a ingresar otro elemento?");
            meter= teclado.nextLine().equalsIgnoreCase("Si");
            
        }
        System.out.println(c1.toString());;
        c1.igualA(c2);
        c1.comprobarVacio();
        c1.comprobar(4);
       
        c1.vacio();
        c1.borrar(8);
        c1.insertar(5);
        c1.union(c2);
        c1.interseccion(c2);
        c1.resta(c2);
        c1.complemento();
}}
