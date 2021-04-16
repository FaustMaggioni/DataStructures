package DDATP5;
import java.util.Scanner;
public class testAuto {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        
        String patente,modelo,patente2,modelo2;
        int cuentaKm,cuentaKm2;
        boolean disponible=true,disponible2=false;
        System.out.println("ingrese patente, modelo,cuentaKm");
        patente= teclado.nextLine();
        modelo= teclado.nextLine();
        cuentaKm= teclado.nextInt();
        patente2= teclado.nextLine();
        modelo2= teclado.nextLine();
        cuentaKm2= teclado.nextInt();
        Auto a1= new Auto(patente), a2= new Auto(patente2);
        a1.setCuentaKM(cuentaKm);
        a2.setCuentaKM(cuentaKm2);
        a1.setDisponible(disponible);
        a2.setDisponible( disponible2);
        a1.setModelo(modelo);
        a2.setModelo(modelo2);
        if(a1.igualA(a2)){
            System.out.println("los dos objetos son iguales");
        }
        else{
            System.out.println("son objetos distintos");
        }
        
        
        
    
    }
}