package DDATP8;
import static DDATP7.punto2.cargarArreglo;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto5a{
     public static void main (String []args){
     int n;
         System.out.println("ingrese n");
     n= TecladoIn.readLineInt();
        int cant_enteros_multiplos_de_4= contar(n);
         System.out.println(cant_enteros_multiplos_de_4);
     int []a= new int [7];
     cargarArreglo(a);
     int p=0;
             int cant= contarArreglo(a,p);
             System.out.println(cant);
             }
  public static int contar(int n){
      int cant;
      int j;
      if(n==0){
          cant=0;
      }else{
          j= n%10;
          if(j%4==0){
              cant= contar(n/10)+1;
          }else{
              cant= contar(n/10);
          }
      }
     return cant;
  }   
public static int contarArreglo (int []n,int p){
    int cant=0;
    if(p==n.length){
        cant=0;
    
    if(n[p]==0){
        cant= 0;
       }
    else{
        if(n[p]%4==0){
            cant= contarArreglo(n,p++)+1;
        }else{
            cant= contarArreglo(n,p++);
        }
    }
}
return cant;}

}