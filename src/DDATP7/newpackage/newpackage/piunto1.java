
package DDATP7.newpackage.newpackage;

public class piunto1 {
    public static void burbujaMejorado(int []a){
        int i,j,temp;
        boolean listo=false;
        for(i=0;i<=a.length-2;i++){
            while((listo=false)&&(j<=a.length-2-i)){
                listo=true;
                if(a[j]>a[j+1]){
                    listo=false;
                    temp= a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
