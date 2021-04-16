package DDATP4;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto6 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
   
         System.out.println("ingrese nro de filas");
         int filas= TecladoIn.readLineInt();
         int col= filas;
         int matriz[][]= new int[filas][col];
         cargarmatriz(matriz);
         espiral(matriz);
         mostrarMatriz(matriz);
            

}
public static void espiral(int[][] m){
    int minfila=0,mincol=0,maxcol=m[0].length-1,maxfila=m.length-1,i,j;
    while((minfila<=maxfila)||(mincol<=maxcol)){
    for(j=mincol;j<=maxcol;j++){
        System.out.print(m[minfila][j]);
        minfila++;
    }
    for(i=minfila;i<=maxfila;i++){
        System.out.print(m[i][maxcol]);
        maxcol--;
    }
    for(j=maxcol;j>=mincol;j--){
        System.out.print(m[maxfila][j]);
        maxfila--;
    }
    for(i=maxfila;i>=minfila;i--){
        System.out.print(m[i][mincol]);
        mincol++;
    }
}
}}