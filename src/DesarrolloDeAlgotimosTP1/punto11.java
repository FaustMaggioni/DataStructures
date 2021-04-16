package DesarrolloDeAlgotimosTP1;

import TPFinalEDAT.TecladoIn;

public class punto11 {
    public static void main(String[]args){
    int fila, col,i,n;
        System.out.println("ingrese i");
        i= TecladoIn.readLineInt();
    for(fila=i;fila>0;fila--){
        for(n=i-fila;n>=0;n--){
            System.out.print("  ");
        }

        for(col=1;col<=fila*2;col++){

            if (col%2==0){
                System.out.print(" ");
            }
            else{

                System.out.print(" "+col+" ");
            }
        }
        System.out.println(" ");    
   
}
       
}}