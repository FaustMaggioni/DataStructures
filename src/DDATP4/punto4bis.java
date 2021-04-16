package DDATP4;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto4bis {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
         System.out.println("ingrese orden de la matriz");
         int orden=TecladoIn.readLineInt();
         int [][]matriz= new int[orden][orden];
         cargarMatriz(matriz);
         mostrarM(matriz);
         parImpar(matriz);
     }
public static void cargarMatriz(int[][]matriz){
    int filas=matriz.length-1, col=matriz[0].length-1,i,j;
    for(i=0;i<=filas;i++){
        for(j=0;j<=col;j++){
            System.out.println("ingrese elemento");
            matriz[i][j]= TecladoIn.readLineInt();
        }
    }
}
public static void mostrarM(int[][]matriz){
    for(int i=0;i<matriz.length;i++){
        for(int j=0;j<matriz[0].length;j++){
            System.out.print((matriz[i][j]));
        }
        System.out.println(" ");
    }
}
public static void parImpar(int [][]matriz){
    int filas= matriz.length-1,col=matriz[0].length-1;

    for(int i=0;i<=filas;i++){
        if(i%2==0){
            for(int j=0;j<=col;j++){
                System.out.print(matriz[i][j]);
            }
        }
        else{
            for(int j=col;j>=0;j--){
                System.out.print(matriz[i][j]);
            }
        }
        System.out.println(" ");
}}}