/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDATP8.resumen;

/**
 *
 * @author Faustino
 */
public class insercion {
    public static void insercion(int []a){
        int i,j,temp;
        for(i=0;i<a.length;i++){
            temp= a[i];
            j=i;
            while((j>0)&&(temp<a[j-1])){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
            
        }
    }
}
