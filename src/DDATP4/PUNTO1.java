package DDATP4;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class PUNTO1 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int [][]matriz;
         System.out.println("ingrese numero de filas");
         int filas= TecladoIn.readLineInt();
         System.out.println("ingrese numero de columnas");
         int col= TecladoIn.readLineInt();
         matriz= new int[filas][col];
         boolean seguir=true;
         while(seguir){
         System.out.println("ahora vamos a darle unas opciones. 1,2,3,4");
         int eleccion= TecladoIn.readLineInt();
         
         
          switch(eleccion){
             case 1:
                 cargarfila(matriz);
             break;
             
             case 2:
                 cargarmatriz(matriz);
                 break;
             case 3:
                 mostrarColumna(matriz);
                 break;
             case 4:
                 mostrarMatriz(matriz);
                 break;
         }
             System.out.println("va a elegir otra opcion?");
             String opcion= teclado.nextLine();
         seguir= (opcion.equalsIgnoreCase("si"));}
        
    
}
     
        
     
     public static void cargarfila(int [][]matriz){
         
     Scanner teclado=new Scanner(System.in);
         int filas= matriz.length,col= matriz[0].length;
        
             System.out.println("elija una fila para cargar");
         int filita= TecladoIn.readLineInt();
         if (filita<filas){
         for (int i=0;i<col;i++){
             System.out.println("ponga un numero");
             int digito= TecladoIn.readLineInt();
             matriz[filita][i]=digito;
         }
         }}
     public static void cargarmatriz(int[][]matriz){
         int filas= matriz.length, col= matriz[0].length;
         
         for(int i=0;i<filas;i++){
              for(int j=0;j<col;j++){
             System.out.println("ponga un numero");
             int digito= TecladoIn.readLineInt();
             matriz[i][j]=digito;
             
            
         }
         }
                
     }
     public static void mostrarColumna(int matriz[][]){
         int columna;
         System.out.println("elija unacolumna");
         
         columna= TecladoIn.readLineInt();
         for(int i=0; i<matriz.length;i++){
             System.out.println(matriz[i][columna]+" ");
             
         }
         
     }
     public static void mostrarMatriz(int matriz [][]){
         int col= matriz[0].length, filas= matriz.length;
         for(int i=0; i<filas;i++){
              for(int j=0;j<col;j++){
          System.out.print(matriz[i][j]+" ");
     }
             System.out.println(" ");}
}}