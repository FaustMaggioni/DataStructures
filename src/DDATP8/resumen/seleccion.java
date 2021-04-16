
package DDATP8.resumen;

import static DDATP7.punto3.intercambiar;

public class seleccion {
    public static void main(String []args){
        
    }
    public static void seleccion(int[]a){
        
        int i,j,min;
        for(i=0;i<a.length-1;i++){
            min=i;
            for(j=i++;j<a.length;j++){
                if(a[j]<a[min]){
                    j=min;
                }
            }
            intercambiar(j,i,a);
        }
    }
    public static void burbuja(int []a){
        int i,j;
        for(i=0;i<=a.length-2;i++){
            for(j=0;j<=a.length-2-i;j++){
                if(a[j+1]<a[j]){
                    intercambiar(j,j+1,a);
                }
            }
        }
    }
    public static void insercion(int []a){
        int i, j,temp=0;
        for(i=1;i<a.length;i++)
            temp=a[i];
            j=i;
            while((a[j]>0)&&(temp<a[j-1])){
                    a[j]=a[j-1];
                    j--;
    }
            a[j]=temp;
        
    }
}
