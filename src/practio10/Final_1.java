/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico10;
import TPFinalEDAT.TecladoIn;
/**
 *
 * @author faustino.maggioni
 */
public class Final {
    public static void main(String[]args){
        int longitud;
        boolean pedo, correcta=false;
        String texto, opcion="";
        
        
        while (!opcion.equals("salir")){
            System.out.println("elija una opcion. 1: verificar si una cadena esta compuesta solo por letras y espacios en blanco,2: contar la cantidad de palabras de longitud menor a una longitud dada por usted,3: buscar la palabra mas larga,4: armar una nueva cadena compuesta solo por palabras en posiciones pares,5: salir");
            opcion= TecladoIn.readLine();
        switch (opcion) {
            case "1": 
                do{
                    System.out.println("ingrese texto");
                    texto= TecladoIn.readLine();
                    pedo= verif(texto);
                    System.out.println(pedo);
                    
                
                }while (!pedo);
                correcta=true;
                break;
            case "2":
                if (correcta=true){
                    System.out.println("elija una longitud para comparar con las palabras del texto");
                    longitud= TecladoIn.readLineInt();
                    
                }
            
        }
    
}
    
}
    public static boolean verif (String texto){
        boolean res = true;
        char letras;
        int pos=0;
        while ((pos<=(texto.length()-1))&&(res==true)) {
           // System.out.println(texto.charAt(letra));
            letras=texto.charAt(pos);
            if (((letras>=65) && (letras<=90) )|| ((letras>=97) && (letras<=122))|| (letras==32)){
                //System.out.println("es solo letras y espacios");
                //res= true;
                pos++;
             }
            else {
                System.out.println("tiene numeros");
                res= false;}
                
              
        }
        
         
        return res;
    }
    public static boolean palabra(String texto){
        int pos=0,espacio;
        
        char letra;
        String palabra;
        while ((pos<=(texto.length()-1))){
         espacio=texto.indexOf(32);
            System.out.println(espacio);
        
        letra= texto.charAt(pos);
        texto.substring(0,);
    }
}public static int cantidadMenor(String oracion, int cantL) {
        int acum = 0, i, menor = 0;
        char ch;
        for (i = 0; i < oracion.length(); i++) {
            ch = oracion.charAt(i);
            if (ch == ' ') {
                if (acum < cantL) {
                    menor++;
                }
                acum = 0;
            } else {
                acum++;
            }
        }

        return menor;
    }

    public static String palabraMasLarga(String texto) {
        String palLarga = "", palLar = "";
        int pos, i , longg = 0;
        texto = texto + " ";
        while (!texto.equals("")){
        pos = texto.indexOf(' ');
        palLar=texto.substring(0,pos);
        texto=texto.substring(pos+1);
        if (palLar.length() > palLarga.length()){
            palLarga = palLar;}
            
        }
         return palLarga;
        }

case 2://opcion 2
                    int longitud,
                     cantPalabrasMenores;
                    System.out.println("Ingrese la oracion: ");
                    oracion1 = TecladoIn.readLine();
                    System.out.println("Ingrese la longitud a verificar: ");
                    longitud = TecladoIn.readLineInt();
                    cantPalabrasMenores = cantidadMenor(oracion1, longitud);
                    System.out.println("la cantidad de lapabras de menor longitud es" + cantPalabrasMenores);
                    break;
                case 3://opcion 3
                    String palabraLarga;
                    System.out.println("Ingrese la oracion: ");
                    oracion1 = TecladoIn.readLine();
                    palabraLarga = palabraMasLarga(oracion1);
                    System.out.println("La palabra mas larga de la cadena es: " + palabraLarga);
                    break;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoob;

/**
 *
 * @author Liliana Murisi
 */
public class TrabajoOb {
   public static void palabrasPares(String texto) {
        String palLarga = "", palabra = "";
        int pos, i , palabraNro=0;
        texto = texto + " ";
        while (!texto.equals("")){
        pos = texto.indexOf(' ');
        palabra=texto.substring(0,pos);
        texto=texto.substring(pos+1);
        palabraNro++;
        if (palabraNro%2==0){
            System.out.print(palabra+" ");
        }
            
       
           
            
        }
         System.out.println(" ");
        }
     
    
    

    public static boolean soloLetra(String oracion) {
        boolean verif = true;
        char ch;
        int i = 0;
        while ((oracion.length() > i) && (verif == true)) {
            ch = oracion.charAt(i);
            verif = Character.isLetter(ch) || ch == ' ';
            i++;
        }
        return verif;

    }

    public static int cantidadMenor(String oracion, int cantL) {
        int acum = 0, i, menor = 0;
        char ch;
        for (i = 0; i < oracion.length(); i++) {
            ch = oracion.charAt(i);
            if (ch == ' ') {
                if (acum < cantL) {
                    menor++;
                }
                acum = 0;
            } else {
                acum++;
            }
        }

        return menor;
    }

    public static String palabraMasLarga(String texto) {
        
       
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        String seguir = "si", oracion1;
        while (seguir != "salir") {
            System.out.println("Bienvenido al menú de opciones, seleccione una de las opciones siguientes con su numero correspondiente: ");
            System.out.println("Opcion 1: Verificar si la cadena esta compuesta solo por letras y espacios.");
            System.out.println("Opcion 2: Contar la cantidad de palabras con menor longitud a la dada.");
            System.out.println("Opcion 3: Buscar la palabra mas larga de la cadena.");
            System.out.println("Opcion 4: Armar la nueva cadena con las palabras en posiciones pares.");
            opcion = TecladoIn.readLineInt();
            switch (opcion) {
                case 1://opcion 1
                    boolean verdad;
                    do{
                    System.out.println("Ingrese la cadena de caracteres: ");
                    oracion1 = TecladoIn.readLine();
                    verdad=soloLetra(oracion1);
                    if (verdad) {
                        System.out.println("Son solo letras y espacios.");
                    } else {
                        System.out.println("La oracion contiene números o símbolos.");
                    }
                    }while (!verdad);
                    break;
                case 2://opcion 2
                    int longitud,
                     cantPalabrasMenores;
                    System.out.println("Ingrese la oracion: ");
                    oracion1 = TecladoIn.readLine();
                    System.out.println("Ingrese la longitud a verificar: ");
                    longitud = TecladoIn.readLineInt();
                    cantPalabrasMenores = cantidadMenor(oracion1, longitud);
                    System.out.println("la cantidad de lapabras de menor longitud es" + cantPalabrasMenores);
                    break;
                case 3://opcion 3
                    String palabraLarga;
                    System.out.println("Ingrese la oracion: ");
                    oracion1 = TecladoIn.readLine();
                    palabraLarga = palabraMasLarga(oracion1);
                    System.out.println("La palabra mas larga de la cadena es: " + palabraLarga);
                    break;
                case 4://opcion
                    String palPar;
                    System.out.println("ingrese la oracion");
                    oracion1= TecladoIn.readLine();
                    palabrasPares(oracion1);
                    break;
            }
            System.out.println("Si desea salir ingrese 'salir'.");
            seguir = TecladoIn.readLineWord();
        }

    }
 
}
