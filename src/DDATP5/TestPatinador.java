
package DDATP5;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class TestPatinador {
    public static void main (String []args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuantos patinadores hay?");
        int cant= TecladoIn.readLineInt();
        Patinador [] evento = new Patinador[cant];
        cargar(evento);
        boolean elegir=true;
        while(elegir){
            menu(evento);
            System.out.println("si va a elegir otra opcion escriba Si");
            elegir= teclado.nextLine().equalsIgnoreCase("Si");
        }
    }
    public static void menu(Patinador[]evento){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("elija una de las 2 opciones,2 mostrar por categoria, 3 cambiar categoria");
        int opcion= TecladoIn.readLineInt();
        switch(opcion){
            
            
            case 2:
                System.out.println("denos una categoria para mostrarle los patinadores de ella");
                char categoria= TecladoIn.readLineNonwhiteChar();
                mostrarCat(evento,categoria);
                break;
            case 3:
                System.out.println("denos un dni");
                String d= teclado.nextLine();
                dni(evento,d); 
                break;
        }
    }
    public static void cargar(Patinador [] evento){
        Scanner teclado = new Scanner(System.in);
        for(int i=0; i<evento.length;i++){
            System.out.println("ingrese apellido");
            String apellido= teclado.nextLine();
            System.out.println("ingrese nombre");
            String nombre= teclado.nextLine();
            System.out.println("ingrese dni");
            String dni= teclado.nextLine();
            System.out.println("ingrese edad");
            int edad= TecladoIn.readLineInt();
            System.out.println("ingrese categoria");
            char cat= TecladoIn.readLineNonwhiteChar();
            Patinador j= new Patinador(apellido,nombre,dni,edad,cat);
            evento[i]= j;
        }
    }
    public static void mostrarCat(Patinador []evento,char cat){
        for(int i=0; i<evento.length;i++){
        if(evento[i].getCat()==cat){
            System.out.println(evento[i]);
        }
    }
}
    public static void dni(Patinador []evento,String dni){
        int i=0;
        boolean seguir=true;
        while((seguir)&&(i<evento.length)){
            if(evento[i].getDoc().equals(dni)){
                evento[i].asciende();
                seguir= false;
            }
            else{
                i++;
            }
        }
        if(seguir){
            System.out.println("No hay patinador con ese documento");
        }
    }


}
