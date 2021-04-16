
package test.lineales;

import TPFinalEDAT.Pila;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class TestPila {
    public static void main(String []args){
         Scanner teclado=new Scanner(System.in);
        Pila p= new Pila();
            apilando(p);
            desapilando(p);
            vaciador(p);
            top(p);
       
        System.out.println(p.toString());
        Pila x= p.clone();
        System.out.println(x.toString());
        boolean e= p.equals(x);
        System.out.println("Equals: "+ e);
        boolean capicua= capicua(p);
        if(capicua){
            System.out.println("es capicua");
        }
        else{
            System.out.println("no");
        }
    }
    public static boolean capicua(Pila p){
        boolean cap;
        Pila aux= new Pila();
        Pila clone= p.clone();
        boolean seguir=false;
        boolean seguir1=false;
        Object e;
        do{seguir=false;
        seguir1=false;
       if(!p.esVacia()){
            e= p.obtenerTope();
            seguir= aux.apilar(e);
            seguir1= p.desapilar();}
        }while((seguir)&&(seguir1));
        cap = aux.equals(clone);
        return cap;
    }
public static void top(Pila p){
    if(p.esVacia()==false){
        Object tope= p.obtenerTope();
        System.out.println("Tope:"+tope);
        System.out.println("------------");}
    else{
        System.out.println("No tiene tope, está vacía.");
    }
}
public static void apilando(Pila p){
         Scanner teclado=new Scanner(System.in);
        boolean seguir=true;
        boolean continuar=true;
        System.out.println("Si quiere apilar un elemento responda si");
            boolean apilar= teclado.nextLine().equalsIgnoreCase("si");
            if(apilar){
                System.out.println("Que tipo de elemento va a apilar? int, String, char, boolean o double.");
                String op= teclado.nextLine();
                System.out.println("Ingrese");
                Object elem= teclado;
                switch(op){
                    case "String":
                        apilarString(p);
                        break;
                    case"int":
                        apilarInt(p);
                        break;
                    case "char":
                        apilarChar(p);
                        break;
                    case "double":
                        apilarDouble(p);
                        break;
                    case "boolean":
                        apilarBool(p);
                        break;
                    default:
                        System.out.println("No ingreso una opcion valida");
                        break;
                        
                }
          
}}
public static void apilarInt(Pila p){
        
    Scanner teclado=new Scanner(System.in);
    boolean seguir;
        do{     
                System.out.println("Ingrese elemento");
                int elem= TecladoIn.readLineInt();
                
            if(p.apilar(elem)){
                System.out.println("Se apiló su elemento, si quiere agregar responda si");
                seguir= teclado.nextLine().equalsIgnoreCase("si");
            }else{
                System.out.println("La pila está llena, disculpe");
                seguir=false;
            }
        }while(seguir);}
public static void apilarString(Pila p){
        
    Scanner teclado=new Scanner(System.in);
    boolean seguir;
        do{     
                System.out.println("Ingrese elemento");
                String elem= teclado.nextLine();
                
            if(p.apilar(elem)){
                System.out.println("Se apiló su elemento, si quiere agregar responda si");
                seguir= teclado.nextLine().equalsIgnoreCase("si");
            }else{
                System.out.println("La pila está llena, disculpe");
                seguir=false;
            }
        }while(seguir);}
public static void apilarChar(Pila p){
        
    Scanner teclado=new Scanner(System.in);
    boolean seguir;
        do{     
                System.out.println("Ingrese elemento");
                char elem= TecladoIn.readLineNonwhiteChar();
                
            if(p.apilar(elem)){
                System.out.println("Se apiló su elemento, si quiere agregar responda si");
                seguir= teclado.nextLine().equalsIgnoreCase("si");
            }else{
                System.out.println("La pila está llena, disculpe");
                seguir=false;
            }
        }while(seguir);}
public static void apilarDouble(Pila p){
        
    Scanner teclado=new Scanner(System.in);
    boolean seguir;
        do{     
                System.out.println("Ingrese elemento");
                double elem= TecladoIn.readLineDouble();
                
            if(p.apilar(elem)){
                System.out.println("Se apiló su elemento, si quiere agregar responda si");
                seguir= teclado.nextLine().equalsIgnoreCase("si");
            }else{
                System.out.println("La pila está llena, disculpe");
                seguir=false;
            }
        }while(seguir);}
public static void apilarBool(Pila p){
        
    Scanner teclado=new Scanner(System.in);
    boolean seguir;
        do{     
                System.out.println("Ingrese elemento");
                boolean elem= TecladoIn.readLineBoolean();
                
            if(p.apilar(elem)){
                System.out.println("Se apiló su elemento, si quiere agregar responda si");
                seguir= teclado.nextLine().equalsIgnoreCase("si");
            }else{
                System.out.println("La pila está llena, disculpe");
                seguir=false;
            }
        }while(seguir);}
public static void desapilando(Pila p){
    Scanner teclado=new Scanner(System.in);
    boolean continuar;
    
    System.out.println("Si quiere desapilar un elemento responda si");
            boolean desapilar= teclado.nextLine().equalsIgnoreCase("si");
            if(desapilar){
        do{
            
                if(p.desapilar()){
                    System.out.println("se desapiló un elemento");
                    System.out.println("Quiere desapilar otro? responda si");
            continuar= teclado.nextLine().equalsIgnoreCase("si");
                }
                else{
                    System.out.println("Ya no quedan elementos");
                    continuar=false;
                }
            
            
        } while(continuar);}
}
public static void vaciador(Pila p){
    Scanner teclado=new Scanner(System.in);
    System.out.println("Si quiere vaciar responda si");
       boolean vaciar= teclado.nextLine().equalsIgnoreCase("si");
        if(vaciar){
            p.vaciar();
        }
}
}
