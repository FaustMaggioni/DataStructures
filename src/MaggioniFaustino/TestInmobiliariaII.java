
package MaggioniFaustino;
import TPFinalEDAT.TecladoIn;
import java.util.Scanner;

public class TestInmobiliariaII {
    public static void main (String []args){
        Scanner teclado=new Scanner(System.in);
             Propiedad [] arreglo= new Propiedad[20];
            cargar10(arreglo);
            int cant=10;
            System.out.println("Si quiere cargar Propiedades responda: Si");
            boolean uno= teclado.nextLine().equalsIgnoreCase("si");
                if(uno){
                cant= cargarUsuario(arreglo,cant);}
                
                    menu(arreglo,cant);
    }
public static void cargar10(Propiedad []a){
     a[0]= new Propiedad(230,'c',"Astor Piazzola 1845",2,'V',500,true,24401);
     a[1]= new Propiedad(231,'d',"Sarmiento 184",4,'A',200,true,51000);
     a[2]= new Propiedad(232,'c',"Belgrano 45",1,'V',250,true,2311);
     a[3]= new Propiedad(233,'x',"Angel Edelman 400",8,'T',1200,false,52311);
     a[4]= new Propiedad(234,'c',"Universidad 2019",9,'T',3000,true,211111);
     a[5]= new Propiedad(235,'d',"Ruta Nacional 7 km 34",3,'V',2200,false,12311);
     a[6]= new Propiedad(236,'c',"San Juan 1000",2,'A',2001,false,6122);
     a[7]= new Propiedad(237,'c',"Cabrera 1845",6,'V',4200,true,5500);
     a[8]= new Propiedad(238,'c',"Paulo Londra 23",2,'T',2300,true,23000);
     a[9]= new Propiedad(239,'x',"Rodrigo Bueno 840",2,'V',20,false,1000);
             
}
public static void menu(Propiedad []a,int tope){
    boolean ordenado= false;
    Scanner teclado=new Scanner(System.in);
    boolean elegir=true;
    while(elegir){
    System.out.println("Elija una de las siguientes opciones\n 1: Cargar mas datos \n 2: Listar datos \n 3: Verificar casa \n 4: Verificar departamento \n 5: Ordenar el arreglo por precio \n 6: Contar la cantidad de propiedades disponibles con una cantidad de ambientes determinada \n 7: Buscar la casa en alquiler disponible con mayor superficie \n 8: Verificar si una propiedad existe mediante su precio \n 9: Ordenar las propiedades por superficie \n Si desea no elegir mas, escriba 0");
    int opcion= TecladoIn.readLineInt();
    switch(opcion){
        case 1:
            tope= cargarUsuario(a,tope);
            break;
        
        case 2: listarDatos(a,tope-1);
            break;
        case 3: verifCasa(a,tope-1);
            break;
        case 4: verifDepto(a,tope-1);
            break;
        case 5: 
         
            ordenado= menuOrdenamiento(a,tope);
         
         for(int k=0;k<=tope-1;k++){
             System.out.print(a[k]+",");
             System.out.println("");
         }
            System.out.println("");
            break;
        case 6: System.out.println("Ingrese una cantidad de ambientes para contar cuantas propiedades tenemos que cuenten con ellos");
            int n= TecladoIn.readLineInt();
            int cant2= contarNAmbientes(a,n,tope-1);
            System.out.println(cant2);
            break;
        case 7: int pos= casaAlquilerMaxSup(a,tope-1,0,-1);
        if(pos!=-1){
                System.out.println(a[pos].toString());}
        else{
            System.out.println("No hay casa con esas condiciones");
        }
            break;
        case 8: 
            if(ordenado){
                System.out.println("Diganos un precio para ver si contamos con alguna en ese valor");
                int precio= TecladoIn.readLineInt();
                boolean esta= busqueda(a,0,tope-1,precio);
                if(esta){
                    System.out.println("Si, contamos con una de ese precio");
                }else{
                    System.out.println("Lo sentimos no tenemos propiedades a ese precio");
                }
            }else{
                System.out.println("Ordene el arreglo usando algun metodo de la opcion 5 y vuelva a intentarlo.");
            }
            break;
        case 9:  
            mergeSort(a,tope);
            System.out.println("--------------------------------------");
          for(int k=0;k<=tope-1;k++){
             System.out.print(a[k]+",");
              System.out.println("");
         }
            break;
        case 0:
            elegir=false;
            break;
    }
    }
}
public static int cargarUsuario(Propiedad []a,int cant){
    Scanner teclado=new Scanner(System.in);
    boolean cargar=true;
    int []aux= new int [20];
    
    int i=cant,max= a.length;
    while((cargar)&&(i<max)){
        
        
        boolean codigo_ok=false;
        while(codigo_ok==false){
            int k= i-1;
            System.out.println("Ingrese el codigo de la propiedad");
            aux[i]= TecladoIn.readLineInt();
            codigo_ok= verifCod(aux[i],k,a);
            }
        int codigo= aux[i];
        System.out.println("Ingrese el tipo de propiedad; c: Casa, d: Departamento, x: Duplex.");
        char tipo= TecladoIn.readLineNonwhiteChar();
        System.out.println("Ingrese la direccion");
        String direc= teclado.nextLine();
        System.out.println("Ingrese la cantidad de ambientes");
        int amb= TecladoIn.readLineInt();
        System.out.println("Ingrese el tipo de operacion; A: Alquiler, V: Venta, T: Alquiler temporario.");
        char op= TecladoIn.readLineNonwhiteChar();
        System.out.println("Ingrese la superficie en metros cuadrados");
        int sup= TecladoIn.readLineInt();
        System.out.println("Si la propiedad está disponible escriba 'Si'");
        boolean disp= teclado.nextLine().equalsIgnoreCase("Si");
        System.out.println("Ingrese el precio de la propiedad en pesos $");
        int pr= TecladoIn.readLineInt();
        a[i]= new Propiedad(codigo,tipo,direc,amb,op,sup,disp,pr);
        i++;
        
        System.out.println("Si va a ingresar otra propiedad, responda con un Si");
        cargar= teclado.nextLine().equalsIgnoreCase("si");
    }
    return i;
    
}
public static boolean verifCod(int cod,int k,Propiedad[]a){
    boolean unico=true;
    int j=0;
    while((unico==true)&&(j<=k)){
        if(a[j].getCodigo()==cod){
            unico=false;
        }
        else{ j++;
    }
    
}
    return unico;
}
public static void listarDatos(Propiedad[]a,int tope){
    
    int i;
    for(i=0;i<=tope;i++){
        System.out.println(a[i].toString());
    }
}
public static void verifCasa(Propiedad[]a,int tope){
    boolean seguir=true;
    int i=0;
    while((seguir)&&(i<=tope)){
        
            if((a[i].getTipo()=='c')&&(a[i].getSuperficie()>100)&&(a[i].getDisponibilidad()==true)&&(a[i].getOperacion()=='V')){
        System.out.println(a[i]);
        
}       i++;
        }}
public static void verifDepto(Propiedad[]a,int tope){
     boolean seguir=true;
    int i=0;
    while((seguir)&&(i<=tope)){
        
            if(((a[i].getTipo()=='d')||(a[i].getTipo()=='D'))&&((a[i].getOperacion()=='A')||(a[i].getOperacion()=='a'))&&(a[i].getAmbientes()==1)&&(a[i].getPrecio()<20000)){
                System.out.println(a[i]);
            }
            i++;
        }}


public static void ordenarPrecioBurbuja(Propiedad []p,int tope){
     int n= tope-2;
         int i=0;
         int j;
         Propiedad temp;
         boolean listo=false;
         while((i<=n)&&(listo==false)){
             listo= true;
             
             for(j=0;j<=n-i;j++){
                 
                 if((p[j+1].getPrecio()<p[j].getPrecio())){
                     temp= p[j];
                     p[j]=p[j+1];
                     p[j+1]=temp;
                     listo= false;
                 }
         }
             
             
             i++;
     }
}
public static void ordenarPrecioInsercion(Propiedad []p,int tope){
    int largo= tope-1;
         for(int i=1;i<=largo;i++){
             Propiedad temp= p[i];
             int j=i;
             while((j>0)&&(temp.getPrecio()<p[j-1].getPrecio())){
                 p[j]=p[j-1];
                 j--;
             }
             p[j]=temp;
         }
}
public static void ordenarPrecioSeleccion(Propiedad []p,int tope){
     int i,j,min;
     Propiedad tmp;
        for(i=0;i<=tope-2;i++){
            min=i;
            for(j=i+1;j<=tope-1;j++){
              
                if(p[j].getPrecio()<p[min].getPrecio()){
                    min=j;
                }
            }
            tmp= p[min];
            p[min]=p[i];
            p[i]=tmp;
            
        }
}
public static int contarNAmbientes(Propiedad []p,int n,int pos){
    int res=0;
    if(pos!=-1){
        
        if((p[pos].getAmbientes()==n)&&(p[pos].getDisponibilidad()==true)){
            res= contarNAmbientes(p,n,pos-1)+1;
        }
        else{
            res= contarNAmbientes(p,n,pos-1);
        }
    }
    
    return res;
}
public static int casaAlquilerMaxSup(Propiedad []p,int pos, int max,int posres){
    // Max comienza en 0 asi la primer casa con las condiciones previstas queda como la de mayor superficie.
    int res=posres;
    //Toma este valor para retornar el -1 inicializado previamente en el llamado al modulo en caso de que no haya casas con tales condiciones, y para devolver la ultima propiedad guardada como maxima cuando termina.
    if(pos!=-1){
        
        if(((p[pos].getTipo()=='c')||(p[pos].getTipo()=='C'))&&((p[pos].getOperacion()=='a')||(p[pos].getOperacion()=='A'))&&(p[pos].getDisponibilidad()==true)&&(p[pos].getSuperficie()>max)){
           res= casaAlquilerMaxSup(p,pos-1,p[pos].getSuperficie(),pos);
            }
        else{
            res= casaAlquilerMaxSup(p,pos-1,max,posres);
        }
   }

return res;
}
public static boolean menuOrdenamiento(Propiedad []p, int tope){
    
    System.out.println("Elija como quiere ordenar las propiedades segun su precio: \n 1: Burbuja Mejorado \n 2: Inserrcion \n 3: Seleccion");
    int opcion= TecladoIn.readLineInt();
    switch(opcion){
        case 1: ordenarPrecioBurbuja(p,tope);
        break;
        case 2: ordenarPrecioInsercion(p,tope);
        break;
        case 3: 
                ordenarPrecioSeleccion(p,tope);
        break;
        
    }
    boolean res= true;
    return res;
}
public static boolean busqueda(Propiedad []p,int inicio,int tope, int precio){
    
    
    boolean res= false;
    while(inicio<=tope){
        int medio= Math.floorDiv(inicio+tope, 2);
       
    if(p[medio].getPrecio()==precio){
        res= true;
        inicio= tope+1;
    }else{
        if(p[medio].getPrecio()>precio){
            tope= medio-1;
        }else{
            inicio= medio+1;
        }
    }
    
}
    return res;
}

    public static void mergeSort(Propiedad[] p, int n) {
        if(n>=2){
            int medio=n/2;
            Propiedad[] izq = new Propiedad[medio];
            Propiedad[] der = new Propiedad[n - medio];

            for (int i=0; i < medio; i++) {
                izq[i]=p[i];
            }
            for (int i=medio; i < n; i++) {
                der[i-medio]=p[i];
            }
            mergeSort(izq, medio);
            mergeSort(der, n-medio);

            merge(p, izq, der, medio, n-medio);
        }
    }
    public static void merge(Propiedad[] p, Propiedad [] izq, Propiedad[] der, int finIzq, int finDer) {  
        int i=0, j=0, k=0;
        while (i<finIzq&&j<finDer) {
            if (izq[i].getSuperficie()<=der[j].getSuperficie()) {
                p[k++]=izq[i++];
            }
            else {
                p[k++]=der[j++];
            }
        }
        while (i<finIzq) {
            p[k++]=izq[i++];
        }
        while (j<finDer) {
            p[k++]=der[j++];
        }
    }



    
    
}