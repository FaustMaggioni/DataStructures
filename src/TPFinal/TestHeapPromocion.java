/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinal;

/**
 *
 * @author Faustino
 */
public class TestHeapPromocion {
    public static void main(String[]args){
        HeapPromocion hp= new HeapPromocion();
        hp.insertar(23, "AAAAAA");
        hp.insertar(63, "papapapa");
        hp.insertar(93, "prrrrr");
        hp.insertar(123, "jjjjjjjA");
        hp.insertar(3, "BBB");
        System.out.println(hp.ordenado());
        
    }
}
