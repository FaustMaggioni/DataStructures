package DDATP3;

import Utiles.TecladoIn;
import java.util.Scanner;

public class TP2Punto5 {

    Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("cuantas palabras va a tener su oracion?");
        int longitud = TecladoIn.readLineInt();

        String oracion[] = new String[longitud];
        cargarArreglo(oracion,longitud);

        for (int i = 0; i < oracion.length; i++) {
            int x = i;
            while (x < longitud) {
                
                if (oracion[i].length()>oracion[x].length()) {
                    String aux = oracion[x];
                    oracion[x] = oracion[i];
                    oracion[i] = aux;

                }

                x++;
            }
            System.out.print(oracion[i] + " ");
        }

    }

    public static void cargarArreglo(String[] oracion, int longitud) {
        Scanner teclado = new Scanner(System.in);
        
        for (int j = 0; j < oracion.length; j++) {
            System.out.println("ingrese palabra");
            oracion[j] = teclado.next();
        }

    }
}