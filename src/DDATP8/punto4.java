package DDATP8;
import static DDATP7.punto3.burbuja;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
public class punto4{
     public static void main (String []args){
     int [] n= {12,7,0,-1,8,10};
     int a=12;
     int posicion=n.length-1;
     boolean e= está(n,a,posicion);
     if(e){
         System.out.println("true");
     }else{
         System.out.println("false");
     }
     }
     public static boolean está(int[]n,int a,int p){
         
         boolean res=false;
         
         if(n[p]==a){
             res= true;
             
         }
         else{if(p>=0){
            res= está(n,a,p-1);}}
         return res;
     
}}