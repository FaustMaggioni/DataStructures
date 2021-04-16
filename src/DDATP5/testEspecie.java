
package DDATP5;


public class testEspecie {
    public static void main (String []args){
       
        especie e1= new especie("Elefante");
        e1.setNombre("Elefante");
        e1.setPoblacion(10);
        e1.setTasa(35);
        
        especie e2= new especie("Rinoceronte");
        e2.setNombre("Rinoceronte");
        e2.setPoblacion(100);
        e2.setTasa(15);
        
        if (e1.igualA(e2)){
            System.out.println("todos los datos son iguales");
        }
        else{
            System.out.println("algun dato es distinto");
        }
        
        
    }
    public static int años(especie e1, especie e2){
        int años=0;
        boolean igual= false;
        while(!igual){
            años++;
            igual= (e2.poblacionProyectada(años))==(e1.poblacionProyectada(años));
            
        }
        return años;
    }
    
}