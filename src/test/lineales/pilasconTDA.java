
package test.lineales;
import TPFinalEDAT.Pila;
import EstructurasDeDatos.Alumno;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

import static test.lineales.TestPila.capicua;
import static test.lineales.TestPila.desapilando;
import static test.lineales.TestPila.top;
import static test.lineales.TestPila.vaciador;

public class pilasconTDA {
    public static void main(String []args){
         Scanner teclado=new Scanner(System.in);
    Pila p= new Pila();
            apilarAlumno(p);
            desapilando(p);
            vaciador(p);
            top(p);
       
        System.out.println(p.toString());
        Pila x= p.clone();
        System.out.println(x.toString());
        boolean capicua= capicua(p);
        if(capicua){
            System.out.println("es capicua");
        }
        else{
            System.out.println("no");
        }
    }
    public static void apilarAlumno(Pila p){
        Scanner teclado=new Scanner(System.in);
        boolean api= true;
        
        
        while(api){
            System.out.println("Ingrese legajo,nombre,apellido,tipodoc,dni,ciudad,calle,nro,tel,usuario siu,clave siu");
            int legajo=TecladoIn.readLineInt();
            String nombre=teclado.nextLine();
            String apellido=teclado.nextLine();
            String tipodoc=teclado.nextLine();
            int dni= TecladoIn.readLineInt();
            String ciudad= teclado.nextLine();
            String calle= teclado.nextLine();
            int nro= TecladoIn.readLineInt();
            int tel= TecladoIn.readLineInt();
            String usu= teclado.nextLine();
            String clave= teclado.nextLine();
       Alumno a= new Alumno(legajo,nombre,apellido, tipodoc,dni,ciudad,calle,nro,tel,usu,clave);
       p.apilar(a);
    }
    }
    
    
    }
