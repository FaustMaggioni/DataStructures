
package DDATP5;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;
import static DDATP4.PUNTO1.cargarmatriz;
public class TestMatriz {
   public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
        MatrizMatematica m= crear();
        Cargar(m);
        boolean seguir=true;
        while(seguir){
         menu(m);
            System.out.println("desea continuar?");
        seguir= teclado.nextLine().equalsIgnoreCase("si");
        }
        
        
        
}
   public static void menu(MatrizMatematica m){
       System.out.println("elija una opcion");
        int op= TecladoIn.readLineInt();
       switch(op){
           case 1: cambiarFila(m);
           break;
           case 2: cambiarCol(m);
           break;
           case 3: MatrizMatematica n= crear();
           Cargar(n);
           if(m.igualA(n)){
               System.out.println("true");
           }else{
               System.out.println("false");
           }
           break;
           case 4: String cadena= m.aString();
           break;
           case 5: MatrizMatematica suma;
           suma= sumar(m);
           break;
           case 6:MatrizMatematica resta;
           resta= resta(m);
           break;
           case 7:MatrizMatematica t= m.traspuesta();
               System.out.println(t);
           break;
           case 8: MatrizMatematica producto= por(m);
           break;
           case 9: MatrizMatematica escalar= escalar(m);
               
       }
   }
public static MatrizMatematica crear(){
    System.out.println("ingrese filas y columnas");
    int fila= TecladoIn.readLineInt();
    int col= TecladoIn.readLineInt();
    MatrizMatematica m= new MatrizMatematica(fila,col);
    return m;
}
public static void Cargar(MatrizMatematica m){
    for(int i=0; i<m.getFila();i++){
        for(int j=0;j<m.getCol();j++){
            System.out.println("ingrese nro");
            m.getDim()[i][j]=TecladoIn.readLineInt();
        }
    }
}
public static void cambiarFila (MatrizMatematica m){
    System.out.println("ingrese numero");
    int nro= TecladoIn.readLineInt();
    m.setFila(nro);
   }
public static void cambiarCol(MatrizMatematica m){
    System.out.println("ingrese numero");
    int nro= TecladoIn.readLineInt();
    m.setCol(nro);
}
public static MatrizMatematica sumar (MatrizMatematica m){
    MatrizMatematica ñ= crear();
           Cargar(ñ);
           MatrizMatematica p= m.suma(ñ);
               System.out.println(p.aString());
               return p;
}
public static MatrizMatematica resta (MatrizMatematica m){
    MatrizMatematica ñ= crear();
           Cargar(ñ);
           MatrizMatematica p= m.resta(ñ);
               System.out.println(p.aString());
               return p;
}
public static MatrizMatematica por(MatrizMatematica m){
     MatrizMatematica ñ= crear();
           Cargar(ñ);
           MatrizMatematica p= m.producto(ñ);
               System.out.println(p.aString());
               return p;
}
public static MatrizMatematica escalar(MatrizMatematica m){
     System.out.println("ingrese nro");
     double ñ= TecladoIn.readLineDouble();
           MatrizMatematica p= m.productoEscalar(ñ);
               System.out.println(p.aString());
               return p;
}
}
