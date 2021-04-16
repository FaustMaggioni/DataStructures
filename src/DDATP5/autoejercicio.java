package DDATP5;

import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

     
public class autoejercicio {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        boolean seguir=true;
        
        System.out.println("ingrese la cantidad de autos que tiene la agencia");
        int cantidad= TecladoIn.readLineInt();
        Auto []a= new Auto[cantidad];
        autos(a);
        while(seguir){
        System.out.println("Elija una opcion: 2,3,4,5,6.");
        int opcion= TecladoIn.readLineInt();
        menuAutos(opcion,a);
        
        }
        
    }
public static void autos(Auto[]a){
    Scanner teclado=new Scanner(System.in);
    int i;
    for(i=0;i<a.length;i++){
            System.out.println("ingrese los datos del auto; patente, modelo, km y disp");
            String patente= teclado.nextLine();
            String modelo= teclado.nextLine();
            int km= TecladoIn.readLineInt();
            boolean disp= teclado.nextLine().equalsIgnoreCase("Si");
            Auto p= new Auto(patente,km,disp);
            p.setModelo(modelo);
            
            a[i]= p;
            }
            
}
public static void menuAutos(int opcion,Auto []a){
    Scanner teclado=new Scanner(System.in);
    int i=0;
    switch(opcion){
        case 2:
            System.out.println("denos una patente");
            String patente= teclado.nextLine();
            boolean pat=false;
            while((!pat)&&(i<a.length)){
                if(a[i].getPatente().equalsIgnoreCase(patente)){
                   System.out.println(a[i].aString());
                   pat= true;                }
                else{
                    i++;
                }
            }
            if(!pat){
                System.out.println("No tenemos ningun auto con esa patente disculpe");
            }
            break;
        case 3:
            System.out.println("denos una modelo");
            String modelo= teclado.nextLine();
            boolean mod=false;
            while((!mod)&&(i<a.length)){
                if(a[i].getModelo().equalsIgnoreCase(modelo)){
                    a[i].setDisponible(false);
                    mod= true;
                }
                else{
                    i++;
                }
            }
            if(!mod){
                System.out.println("No contamos con autos de ese modelo");
            }
            break;
        case 4:
            System.out.println("Cuantos km le sumó al auto?");
            int km= TecladoIn.readLineInt();
            System.out.println("y cual era la patente?");
            String patenteCase4= teclado.nextLine();
            boolean devolver= false;
            int j=0;
            while((!devolver)&&(j<a.length)){
                if(a[i].getPatente().equalsIgnoreCase(patenteCase4)){
                    a[i].setDisponible(true);
                    a[i].setCuentaKM(km+a[i].getCuentaKM());
                    devolver= true;
                }
                else{
                    i++;
                }
                }
            if(!devolver){
                System.out.println("agencia equivocada bro");
            }
            
            break;
        case 5:
            int k=0;
            for(k=0;k<a.length;k++){
                System.out.println(a[k].aString());
            }
            break;
        case 6:
            int f=0;
            for(f=0;f<a.length;f++){
                if(a[f].getDisp()==false){
                    System.out.println(a[f].aString());
                }
            }
    }
}}