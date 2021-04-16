
package DesarrolloDeAlgotimosTP1;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto8 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        String personas="si",nombre_y_apellido,estadoC,punteroMasPaises=" ",sorteoViaje;
        int edad,cantPaises,MayorcantPaises=0,acumEdad=0,Cantpersonas=0;
        double promedio;
        while (personas.equalsIgnoreCase("si")){
            System.out.println("¿Como te llamas?");
            nombre_y_apellido= teclado.nextLine();
            
            System.out.println("¿Cuantos años tenes?");
            edad= TecladoIn.readLineInt();
            acumEdad= acumEdad+edad;
            System.out.println("¿Cuantos paises visitaste?");
            cantPaises= TecladoIn.readLineInt();
            if(cantPaises>MayorcantPaises){
                MayorcantPaises= cantPaises;
                punteroMasPaises= nombre_y_apellido;
            }
            System.out.println("¿Sos solterx o casadx?");
            estadoC= teclado.nextLine();
            Cantpersonas++;
            sorteoViaje= sorteo(estadoC,edad);
            System.out.println(sorteoViaje);
            System.out.println("¿hay mas personas?");
            personas= teclado.nextLine();
            
        }
        promedio= promedio(acumEdad,Cantpersonas);
        System.out.println("el promedio de edad de estas personas es "+(double)acumEdad/Cantpersonas);
        System.out.println("la persona que mas paises visitó es "+punteroMasPaises);
        
    }
    public static double promedio(int acumEdad, int Cantpersonas){
        double promedioEdad;
        promedioEdad= ((double)acumEdad)/((double)Cantpersonas);
        return promedioEdad;
    }
    public static String sorteo(String estadoC,int edad){
        String sorteoSioNo;
        if((estadoC.equals("soltero"))&&(edad>=45)&&(edad<=62)){
            sorteoSioNo= "puede participar en el sorteo";
            
        }
        else{
            sorteoSioNo= "usted no puede participar en el sorteo";}
        return sorteoSioNo;
        
        
    }
    
    
    
}
