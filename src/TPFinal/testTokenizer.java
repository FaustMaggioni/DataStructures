
package TPFinal;
import java.util.StringTokenizer;
public class testTokenizer {
    public static void main(String []args){
        String nombre= "Faus, Car, mar, tes, pedo.";
        StringTokenizer tokens= new StringTokenizer(nombre,",");
        System.out.println(nombre.indexOf(','));
        System.out.println(nombre.substring(2, 5));
    }
}
