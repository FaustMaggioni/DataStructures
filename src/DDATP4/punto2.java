
package DDATP4;
import static DDATP4.PUNTO1.cargarmatriz;
import static DDATP4.PUNTO1.mostrarMatriz;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto2 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int [][]matriz;
         System.out.println("ingrese numero de filas");
         int filas= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas");
         int col= TecladoIn.readLineInt();
         matriz= new int[filas][col];
         cargarmatriz(matriz);
         boolean seguir=true;
         while(seguir){
         System.out.println("elija una opcion,1,2,3,4,5,6,7");
         int opcion= TecladoIn.readLineInt();
         
         switch(opcion){
             case 1:
                 mostrarMatriz(matriz);
                 break;
             case 2:
                 superior(matriz);
                 if(superior(matriz)){
                     System.out.println("la matriz es triangular superior");}
                 else{
                     System.out.println("la matriz no es triangular superior");
                 }
                 
                 break;
             case 3:
                 diagonal(matriz);
                 if(diagonal(matriz)){
                     System.out.println("la matriz es diagonal");}
                 else{
                     System.out.println("la matriz no es diagonal");
                 }
                 break;
             case 4:
                 System.out.println("ingrese un escalar");
                 int escalar=TecladoIn.readLineInt();
                 producto(matriz,escalar);
                 mostrarMatriz(matriz);
                 break;
             case 5:
                 int [][]traspuesta;
                 traspuesta= trasponer(matriz);
                 mostrarMatriz(traspuesta);
                 break;
             case 6:
                 System.out.println("elija una fila para sumar sus elementos");
                 int eleccion= TecladoIn.readLineInt();
                 System.out.println("la suma es "+sumaFila(matriz,eleccion));
                 break;
             case 7:
                 System.out.println("elija una columna para sumar sus elementos");
                 int elegida= TecladoIn.readLineInt();
                 System.out.println("la suma es "+sumaColumna(matriz,elegida));
                 break;
         }
             System.out.println("va a elegir otra opcion?");
         String eleccion= teclado.nextLine();
         seguir= (eleccion.equalsIgnoreCase("si"));}}

     public static boolean cuadrada(int[][]matriz){
         return matriz.length==matriz[0].length;
     }
     public static boolean superior(int [][]matriz){
         boolean seguir=true;
         int fila=0,col,cantFilas=matriz.length,cantCol=matriz[0].length;
         if(!cuadrada(matriz)){
             seguir= false;}
         else{
             while((fila<cantFilas)&&(seguir)){
                 col=0;
                 while((col<cantCol)&&(seguir)){
                     if((fila>col)&&matriz[fila][col]!=0){
                         seguir= false;
                     }
                     col++;
                 }
                 fila++;
             }
         }
         return seguir;
     }
     public static boolean inferior(int [][]matriz){
         boolean seguir=true;
         int fila=0,col,cantFilas=matriz.length,cantCol=matriz[0].length;
         if(!cuadrada(matriz)){
             seguir= false;}
         else{
             while((fila<cantFilas)&&(seguir)){
                 col=0;
                 while((col<cantCol)&&(seguir)){
                     if((fila<col)&&matriz[fila][col]!=0){
                         seguir= false;
                     }
                     col++;
                 }
                 fila++;
             }
         }
         return seguir;
     }
     public static boolean diagonal(int [][]matriz){
         boolean diagonal=false;
         if (superior(matriz)&&inferior(matriz)){
             diagonal=true;
         }
         return diagonal;
     }
     public static void producto(int [][]matriz, int escalar){
         int i=0,j=0,filas=matriz.length,columnas=matriz[0].length;
         for(i=0;i<filas;i++){
             for(j=0;j<columnas;j++){
                 matriz[i][j]= escalar* matriz[i][j];
             }
             
         }
     }
     public static int[][] trasponer(int[][]matriz){
         int i=0,j=0,filas=matriz.length,columnas=matriz[0].length;
         int [][]traspuesta;
         traspuesta= new int [columnas][filas];
         for(i=0;i<filas;i++){
             for(j=0;j<columnas;j++){
                 traspuesta[j][i]=matriz[i][j];
             }
         }
         return traspuesta;
     }
     public static int sumaColumna (int[][]matriz,int eleccion){
         int suma=0,i=0,col=matriz[0].length;
         
         for(i=0;i<col;i++){
             suma= suma+matriz[i][eleccion];
         }
         return suma;
     }
      public static int sumaFila (int[][]matriz, int eleccion){
         int suma=0,i=0,fila=matriz.length;
         
         for(i=0;i<fila;i++){
             suma= suma+matriz[eleccion][i];
         }
         return suma;
     }
    
     
     
}