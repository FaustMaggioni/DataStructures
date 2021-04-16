package DDATP4;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import static DDATP4.punto2.cuadrada;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto4{
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int [][] matriz1;
        
         System.out.println("ingrese numero de filas de la matriz ");
         int filas1= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas de la matriz ");
         int col1= TecladoIn.readLineInt();
         matriz1= new int [filas1][col1];
         System.out.println("ahora dele valores a la matriz 1");
         cargarmatriz(matriz1);
         paresimpares(matriz1);
         
     }
public static void paresimpares(int [][]matriz1){
    int i,j,filas=matriz1.length,columnas=matriz1[0].length;
    for(i=0;i<filas;i++){
        if(i%2==0){
        for(j=0;j<columnas;j++){
            System.out.print(matriz1[i][j]);
        }
            
        }
        else{
            for(j=columnas-1;j>=0;j--){
                System.out.print(matriz1[i][j]);
            }
        }
        System.out.println(" ");
    }
}
}