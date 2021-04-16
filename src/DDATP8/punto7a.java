package DDATP8;

import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto7a {

    public static void main(String[] args) {
        int[] a = new int[5];
        cargarArreglo(a);
        burbuja(a);
        System.out.println("ingrese elemento para buscar en el arreglo");
        int k = TecladoIn.readLineInt();
        int posicion = busqBinariaRec(a, 0, a.length, k);
        System.out.println("posicion= " + posicion);

    }

    public static int busqBinariaRec(int[] a, int inicio, int fin, int k) {
        int res = -1;
        int medio = (int) Math.floor(inicio + fin / 2);
        if (inicio > fin) {
            res = -1;
        } else {
            if (a[medio] == k) {
                res = medio;
            } else {
                if (k < a[medio]) {
                    res = busqBinariaRec(a, inicio, medio - 1, k);
                } else {
                    res = busqBinariaRec(a, medio + 1, fin, k);
                }
            }
        }

        return res;
    }
}
