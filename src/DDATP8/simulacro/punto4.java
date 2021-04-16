
package DDATP8.simulacro;

import static DDATP7.punto2.cargarArreglo;
import java.util.Scanner;

        
public class punto4 {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
    int []a=new int[6];
    cargarArreglo(a);
    int ceros= cero(a,a.length-1);
        System.out.println(ceros);
        System.out.println("ingrese texto");
        String text= teclado.nextLine();
        int b;
        b= text.length()-1;
        int ceros2= ceroString(text,b);
        System.out.println(ceros2);
    }
    
    public static int cero(int[]a,int pos){
        int res=0;
        if(pos!=-1){
        if (a[pos]==0){
            res= cero(a,pos-1)+1;
        }else{
            res= cero(a,pos-1);
        }
            
    }
        return res;
}
    public static int ceroString(String text,int pos){
        int res=0;
        if(pos!=-1){
        if (text.charAt(pos)=='0'){
            res= ceroString(text,pos-1)+1;
        }else{
            res= ceroString(text,pos-1);
        }
            
    }
        return res;
}
}