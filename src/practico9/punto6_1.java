/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico9;

import TPFinalEDAT.TecladoIn;

/**
 *
 * @author faustino.maggioni
 */
public class punto6_1 {

    public static int calificacionE(int correctas, int incorrectas) {
        int calificacion1;
        calificacion1 = ((correctas * 2) - incorrectas);
        return calificacion1;
    }

    public static void main(String[] args) {
        int correctas, acumCalificacion = 0, examenes, incorrectas;
        double promedio;
        char masExamenes = 'S';

        examenes = 0;

        while (masExamenes == 'S') {
            System.out.println("ingrese respuestas correctas");
            correctas = TecladoIn.readLineInt();
            incorrectas = (5 - correctas);
            acumCalificacion = (calificacionE(correctas, incorrectas) + acumCalificacion);
            examenes++;
            System.out.println("hay mas examenes? S=Si; N=No");
            masExamenes = TecladoIn.readLineNonwhiteChar();
        }

        promedio = ((double) acumCalificacion / examenes);
        System.out.println("la cantidad de examenes es " + examenes);
        System.out.println("el promedio es " + promedio);
    }

}
