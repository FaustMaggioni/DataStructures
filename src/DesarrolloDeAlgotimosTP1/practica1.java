/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesarrolloDeAlgotimosTP1;

/**
 *
 * @author Faustino
 */
public class practica1 {
    public static void main(String []args){
        
// ej 1
String s1 = "La frase!";
System.out.println(s1.length());

// ej 2
String s2 = "la frase!";
if (s2.equals(s1)) {
     System.out.println("Son iguales");
} else {
     System.out.println("No son iguales");
}

//ej 3
if (s2.equalsIgnoreCase(s1)) {
     System.out.println("Son iguales");
     } else {
     System.out.println("No son iguales");
}

//ej 4
String s3 = s1.toLowerCase();
System.out.println(s3);

// ej 5
String s4 = "Hola MundO";
String s5 = s4.toUpperCase();
System.out.println(s5);

// ej  6
String s6 = "  Hola MUNDO  ";
String s7 = s6.trim();
System.out.println(s7);

// ej 7
String s8 = "La frase!";
String salida = "";
for (int cuenta = s8.length() - 1; cuenta >= 0; cuenta--) 
{salida += s1.charAt(cuenta);}
System.out.println(salida);

// ej 8
String letras = "abcdefghijklmabcdefghijklm";
String salida1 = letras.substring(20);
System.out.println(salida1);

// ej 9
String salida2 = letras.substring(3, 6);
System.out.println(salida2);



// ej 10
letras = "abcdefghijklmabcdefghijklm";
int sale;
// probar indexOf 
sale = letras.indexOf('c');
sale += letras.indexOf('a', 1);
sale += letras.indexOf('$');
System.out.println(sale);

// ej 11 
// probar lastIndexOf
sale = letras.lastIndexOf('c');
sale += letras.lastIndexOf('a', 25);
sale += letras.lastIndexOf('$');
System.out.println(sale);

// ej 12
String x1 = new String("hola");
String x2 = "adiós";
System.out.println(" x1.compareTo( x2 ) es "+ x1.compareTo(x2));

    
}
}