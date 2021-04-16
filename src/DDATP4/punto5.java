package DDATP4;


import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class punto5{
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        char[] arreglo;
        arreglo= new char[150];
        cargarArregloChar(arreglo);
        diezporquince(arreglo);
        
     }
public static void cargarArregloChar(char[] arreglo){
    
     for (int j = 0; j < arreglo.length; j++) {
            System.out.println("ingrese caracter");
            arreglo[j] = TecladoIn.readLineNonwhiteChar();
        }

    }
public static void diezporquince(char arreglo[]){
    char [][] matriz;

        matriz= new char [10][15];
    int k=0;    
    for(int i=0;i<10;i++){
        for(int j=0;j<15;j++){
            
                matriz[i][j]=arreglo[k];
                k++;
        }
                   
        }
    mostrarMatrizCHAR(matriz);
   
        
    }
public static void mostrarMatrizCHAR(char matriz [][]){
         int col= matriz[0].length, filas= matriz.length;
         for(int i=0; i<filas;i++){
              for(int j=0;j<col;j++){
          System.out.print(matriz[i][j]+" ");
     }
             System.out.println(" ");}
}}

  
