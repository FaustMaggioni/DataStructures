
package Simulacros;

import static DDATP3.TP2Punto5.cargarArreglo;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

     
public class invertirpalabra {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        System.out.println("escribirr");
        String h= teclado.nextLine();
        int p= h.length()-1;
        String k=invertir(h,p);
        System.out.println(h);
        System.out.println(k);
        String []a= new String [4];
        cargarArreglo(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.println("------------------");
        invertirArreglo(a,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
    
}
    public static String invertir(String s,int pos){
        String r="";
        
        if(pos!=-1){
            char a= s.charAt(pos);
            r= a+invertir(s,pos-1);
        }
        return r;
    }
    public static void invertirArreglo(String []a,int x){
        String n;
        if(x!=-1){
        n=invertir(a[x],a[x].length()-1);
        a[x]=n;
        invertirArreglo(a,x-1);
    }
}}
