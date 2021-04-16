package DDATP7;
import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.insercion;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto4 {
     public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        int[]a= new int[3], b= new int[5];
        cargarArreglo(a);
        cargarArreglo(b);
        int []c= nuevoArreglo(a,b);
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
     
     }
public static int [] nuevoArreglo(int[]a,int[]b){
    
    int [] c= new int[a.length+b.length];
    for(int i=0;i<a.length;i++){
        c[i]=a[i];
    }
    for(int j=a.length,aux=0;j<c.length;j++){
        c[j]=b[aux];
        aux++;
    }
    insercion(c);
    
    return c;
}}