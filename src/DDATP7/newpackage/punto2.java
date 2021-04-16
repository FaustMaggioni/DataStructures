
package DDATP7.newpackage;

public class punto2 {
    

public static boolean busqbinaria(int []a,int x){
    int medio,inicio=0,fin=a.length-1;
    boolean esta=false;
    medio= (int) Math.floor((inicio+fin/2));
    while((esta==false)&&(inicio<=fin)){
    if(a[medio]==x){
        esta= true;
    }else{
        if(a[medio]>x){
            fin= medio-1;
        }else
            inicio= medio+1;
    }
}
    return esta;
}}