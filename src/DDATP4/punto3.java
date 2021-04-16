package DDATP4;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import static DDATP4.punto2.cuadrada;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto3 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int [][] matriz1, matriz2;
         System.out.println("ingrese numero de filas de la matriz 1");
         int filas1= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas de la matriz 1");
         int col1= TecladoIn.readLineInt();
          System.out.println("ingrese numero de filas de la matriz 2");
         int filas2= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas de la matriz 2");
         int col2= TecladoIn.readLineInt();
         matriz2= new int[filas2][col2];
         matriz1= new int[filas1][col1];
         System.out.println("ahora dele valores a la matriz 1");
         cargarmatriz(matriz1);
         System.out.println("y ahora a las 2");
         cargarmatriz(matriz2);
         boolean seguir=true;
         while(seguir){
             
         System.out.println("elija una opcion 1 o 2");
         int opcion= TecladoIn.readLineInt();
         switch(opcion){
             
             case 1:
         int [][] matrizSuma= suma(matriz1,matriz2); 
         System.out.println("la suma de las dos matrices es:");
         mostrarMatriz(matrizSuma);
            break;
             case 2:
                  int [][] matrizProducto= multiplicacion(matriz1,matriz2); 
         System.out.println("la suma de las dos matrices es:");
         mostrarMatriz(matrizProducto);
         break;
      }
             System.out.println("desea seguir?");
         String elegir= teclado.nextLine();
         seguir= (elegir.equalsIgnoreCase("si"));
     }

    }
    public static int [][] suma(int [][] matriz1,int [][] matriz2){
         int [][] matrizSuma = null;
         int fila= matriz1.length,col=matriz1[0].length;
         if(cuadrada(matriz1)&&(cuadrada(matriz2))){
         matrizSuma= new int [fila][col];
         for(int i=0;i<fila;i++){
             for(int j=0; j<col;j++){
                 matrizSuma[i][j]= matriz1[i][j]+matriz2[i][j];
             }
         }
             
         }
         return matrizSuma;
     }
     public static int [][] multiplicacion(int[][]matriz1, int [][] matriz2){
         int [][] matrizProducto;
         
         int fila= matriz1.length-1,col=matriz1[0].length-1,col2=matriz2[0].length-1,k,suma=0, fila2=matriz2.length-1;
         matrizProducto= new int [fila][col2];
         if(matriz1[0].length==matriz2.length){
             for(int i=0;i<=fila;i++){
                 for(int j=0; j<=col2;j++){
                     for( k=0;k<=col;k++){
                         suma= suma + matriz1[i][k]*matriz2[k][j];
                     }
                     matrizProducto[i][j]= suma;
                 }
             }
         }
         return matrizProducto;
     }
}
