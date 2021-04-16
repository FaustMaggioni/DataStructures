package MaggioniFaustino;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;


public class TestInmobiliaria {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        boolean seguir=true;
        while(seguir){
            System.out.println("Ahora cargue por favor todos los datos de la propiedad que quiera");
            Propiedad p= crear();
               
        System.out.println("si quiere ingresar otra propiedad ingrese Si");
        String otra= teclado.nextLine();
        seguir= otra.equalsIgnoreCase("Si");}
}
public static Propiedad crear(){
    Scanner teclado=new Scanner(System.in);
                 System.out.println("Ingrese el código de la propiedad");
                int codigo= TecladoIn.readLineInt();
                System.out.println("Ingrese el tipo; c:casa, d: departamento, x: duplex");
                char tipo= TecladoIn.readLineNonwhiteChar();
                System.out.println("Ingrese la dirección");
                String direccion= teclado.nextLine();
                System.out.println("Ingrese la cantidad de ambientes");
                int ambientes= TecladoIn.readLineInt();
                System.out.println("Ingrese el tipo de operacion; v: venta, a: alquiler, t: alquiler temporario");
                char op= TecladoIn.readLineNonwhiteChar();
                System.out.println("Ingrese los metros cuadrados");
                int sup= TecladoIn.readLineInt();
                System.out.println("¿Está disponible la propiedad?");
                String logico= teclado.nextLine();
                boolean disp= logico.equalsIgnoreCase("si");
                System.out.println("Ingrese el precio en pesos");
                int precio= TecladoIn.readLineInt();
                Propiedad p= new Propiedad(codigo,tipo,direccion,ambientes,op,sup,disp,precio);
                return p;
    
}
public static void menú(Propiedad p){
     Scanner teclado=new Scanner(System.in);
    boolean opciones= true;
               while(opciones){
        System.out.println("Elija una de las siguientes opcione: 2, Listar Datos; 3, Verificar Casa; 4,Verificar Departamento.");
        int opcion= TecladoIn.readLineInt();
        
        
        
    switch(opcion){
            case 2:
                
                System.out.println(p.toString());
                
                break;
            case 3:
                if((p.getSuperficie()>100)&&(p.getDisponibilidad())&&(p.getOperacion()=='v')&&(p.getTipo()=='c')){
                    System.out.println(p.toString());}
                else{System.out.println("La propiedad no tiene una superficie mayor a 100m2, ni tiene una operacion de venta, ni es una casa y/o no está disponible");
                }
                break;
            case 4:
                if((p.getTipo()=='d')&&(p.getOperacion()=='a')&&(p.getAmbientes()==1)&&(p.getPrecio()<20000)){
                    System.out.println(p.toString());}
                else{
                    System.out.println("La propiedad no es un departamento, ni su alquiler es menor a $20000 por mes, y/o no es un monoambiente");
                }
                break;  
            default:
                System.out.println("Ese numero no es una opción");
        break;}
    System.out.println("si quiere elegir otra opcion para la misma propiedad conteste Si");
        String si= teclado.nextLine();
        opciones= si.equalsIgnoreCase("si");}
}
    
}