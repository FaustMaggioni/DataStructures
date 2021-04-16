package DDATP8;

import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto4b {

    public static void main(String[] args) {
        int[] n = {14, 7, 10, 21, 38, 110};
        int p = n.length-1;
        if (crece(n, p)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public static boolean crece(int[] a, int p) {
        boolean res;
        if (p == 0) {
            res = true;
        } else {
            if (a[p] >= a[p - 1]) {
                res = crece(a, p - 1);
            } else {
                res = false;
            }
        }
        return res;
    }
}
