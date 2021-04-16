/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferReaderTest {
    public static void main (String []args) throws FileNotFoundException, IOException{
      
      File f= new File("C:\\Users\\Faustino\\Documents\\datos2.txt");
      String line="";
      //File f1= new File("C:\\Users\\Faustino\\Documents\\datos2.txt");
      FileReader fi = new FileReader(f);
     // FileWriter fi1 = new FileWriter(f1);
      BufferedReader b = new BufferedReader(fi);
      //BufferedWriter b1= new BufferedWriter(fi1);
      line = b.readLine();  
      while(line!=null){
          System.out.println(line);
          line= b.readLine();
      }
      //*b1.write("Hola");
      /* b1.newLine();
      b1.write("Chau");
      b1.newLine();
      b1.write("Pedo");
      b1.flush();;*/
}
    }

