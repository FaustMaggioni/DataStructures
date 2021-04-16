
package DDATP8.simulacro;

public class punto1 {
    

public static void insercion (int []a){
    int i,j,temp;
    for(i=0;i<=a.length-1;i++){
        j=i;
        temp= a[i];
        while((a[j]>0)&&(a[j-1]>temp)){
            a[j]=a[j-1];
            j--;
        }
        
    }
}
        }