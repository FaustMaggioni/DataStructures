package DDATP5;

import static DDATP4.PUNTO1.cargarmatriz;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class simulacro {

    Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ingrese orden de la matriz");
    int orden= TecladoIn.readLineInt();
        int [][]matriz = new int[orden][orden];
        cargarmatriz(matriz);
        if(secundaria(matriz)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
public static boolean secundaria(int [][] matriz){
    int i=0,j=matriz[0].length-1;
    int filas= 0, col=matriz[0].length;
    int evaluador= matriz[filas][col-1];
    boolean seguir=true;
    while((seguir)&&(i<matriz.length)){
        if(matriz[i][j]==evaluador){
            i++;
            j--;
        }
        else{
            seguir= false;
        }
    }
    return seguir;
}}