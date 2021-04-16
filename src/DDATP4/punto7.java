package DDATP4;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import static DDATP4.punto2.sumaColumna;
import static DDATP4.punto2.sumaFila;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto7 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int [][]matriz;
         System.out.println("ingrese numero de filas");
         int filas= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas");
         int col= TecladoIn.readLineInt();
         matriz= new int[filas][col];
         
         cargarmatriz(matriz);
     boolean magica= magico(matriz);
     if(magica){
         System.out.println("la matriz es un cuadrado magico");
     }
     else{
         System.out.println("la matriz no es un cuadrado magico");
     }}
public static boolean magico (int[][] matriz){
    int i=1,j=0,fila=matriz.length,col=matriz[0].length, comparar;
    boolean magic=true;
    comparar= sumaFila(matriz,0);
    if(fila==col){
    while((magic)&&(i<fila)){
    
        int suma=sumaFila(matriz,i);
        if (suma==comparar){
            magic=true;
            i++;
        }
        else{
            magic= false;
        }}
        if (magic){
            while((magic)&&(j<col)){
            int sumaC= sumaColumna(matriz,j);
            if (sumaC==comparar){
                j++;
                magic=true;
            }
            else{
                magic= false;
            }
        }}
            if(comparar==sumaDiagonal(matriz)){
                magic= true;
            }
            else{
                magic= false;
            }
               }
    else{
        magic=false;
    }
    return magic; 
}
        
    
    



public static int sumaDiagonal(int [][]matriz){
    int suma=0,i,fila=matriz.length,col=matriz[0].length;
    for(i=0;i<fila;i++){ suma= suma+ matriz[i][i];
       }
    
    return suma;}

public static int diagonalInvertida(int [][]matriz){
    int suma=0,i,j,fila=matriz.length,col=matriz[0].length;
     for(i=0,j=col;j>=0;i++,j--){
         suma= suma+matriz[i][j];
        
        }
     return suma;
}

}