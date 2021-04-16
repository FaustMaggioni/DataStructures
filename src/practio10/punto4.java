/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practio10;
import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class punto4 {
    public static void main(String[]args){
        int estudiantes, aprobados=0, desapro=0, i=1, nota, inciso1,inciso2,inciso3,inciso4,inciso5;
        System.out.println("cuantos estudiantes hay");
        estudiantes= TecladoIn.readLineInt();
        for (i=1; i<=estudiantes; i++ ){
            System.out.println("ingrese las notas de los incisos 1,2,3,4 y 5");
            inciso1=TecladoIn.readLineInt();
            inciso2=TecladoIn.readLineInt();
            inciso3=TecladoIn.readLineInt();
            inciso4=TecladoIn.readLineInt();
            inciso5=TecladoIn.readLineInt();
            nota= Nota(inciso1,inciso2,inciso3,inciso4,inciso5);
            if (nota>=60){
                aprobados++;}
            else
                desapro++;}
        System.out.println("los aprobados son "+aprobados);
        System.out.println("los desaprobados son "+desapro);}
public static int Nota(int inciso1, int inciso2, int inciso3, int inciso4, int inciso5) {
int nota;
nota= (inciso1+inciso2+inciso3+inciso4+inciso5);
return nota;}}