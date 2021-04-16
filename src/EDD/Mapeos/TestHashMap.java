/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD.Mapeos;

import TPFinalEDAT.Lista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Faustino
 */
public class TestHashMap {
    public static void main (String [] args){
       HashMap<String,Integer> mapeo= new HashMap<String,Integer>();
       mapeo.put("Tres", 3);
       mapeo.put("dos", 2);
       mapeo.put("Cuatro", 4);
       mapeo.put("Cinco", 5);
      Iterator it = mapeo.entrySet().iterator();
    while (it.hasNext()) {
        HashMap.Entry pair = (HashMap.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        
    }
}}
