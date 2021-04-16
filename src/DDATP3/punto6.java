
package DDATP3;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
/**
 *
 * @author Faustino
 */
public class punto6 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int i;
        String []cap= {"San Juan","Neuquen","Rawson","Viedma","La Plata","Rio Gallegos","Posadas","Santa Rosa","Mendoza","La Rioja","San Luis","CABA","Corrientes","Paraná","Córdoba","Formosa","Resistencia","Jujuy","Salta","Catamarca","Stgo del Estero","SM de Tucuman","Rosario",};
        double []temperatura= new double [cap.length];
        for(i=0;i<=cap.length-1 ;i++){
            System.out.println("ingrese la temperatura minima en "+cap[i]);
            temperatura[i]=TecladoIn.readLineDouble();
            
        } 
        String seguir="si";
        while(seguir.equalsIgnoreCase("Si")){
        System.out.println("ahora con las temperaturas minimas cargadas, elija alguna de las opciones: 1,2,3,4");
        int opcion= TecladoIn.readLineInt();
        switch (opcion){
            case 1:
                String minima= menor(cap,temperatura);
                System.out.println("la temperatura minima en el pais fue en "+minima);
                break;
            case 2:
                
                System.out.println("el promedio de las temperaturas minimas en el pais fue "+promedio(temperatura));
                break;
            case 3:
                
                ceroGrados(cap,temperatura);
                break;
            case 4:
                sieteGrados(cap,temperatura);
                break;
        }
            System.out.println("si quiere seguir, escriba si");
            seguir= teclado.nextLine();
     }}
     public static String menor (String []cap, double []temperatura){
         String minima=" ";
         double TMinima=99999;
         for (int j=0;j<temperatura.length;j++){
             if(temperatura[j]<TMinima){
                 TMinima= temperatura[j];
                 minima= cap[j];
                 
             }
         }
         return minima;
         
     }
     public static double promedio (double []temperatura){
         double promedio;
         double total=0;
         for (int i=0; i<temperatura.length;i++){
             total=total+temperatura[i];
             System.out.println(total);
         }
         promedio= total/temperatura.length;
         return promedio;
     }
     public static void ceroGrados(String []cap,double []temperatura){
        System.out.println("las ciudades con temperaturas minima menores a 0 fueron:");
         for(int i=0;i<temperatura.length;i++){
            if(temperatura[i]<0){
                System.out.print(cap[i]+",");
            }
        }
         System.out.println("");
     }
     public static void sieteGrados(String []cap,double []temperatura){
        System.out.println("las ciudades con temperaturas minima mayores a 7 fueron:");
         for(int i=0;i<temperatura.length;i++){
            if(temperatura[i]>7){
                System.out.print(cap[i]+",");
            }
        }
         System.out.println("");
     
}