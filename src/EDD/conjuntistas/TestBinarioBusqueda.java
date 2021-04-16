
import EDD.conjuntistas.ArbolBB;

public class TestBinarioBusqueda {
    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";   

   
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  
   public static final String RESET = "\u001B[0m";
    
    public static void main(String args[]){
    
        System.out.println( ANSI_CYAN_BACKGROUND  + ROJO +  "**************************************************************");
        System.out.println( ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Binario de Busqueda                  *");
        System.out.println( ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************"+"\n\n"+ RESET);
        
        ArbolBB a= new ArbolBB();
        ArbolBB b= new ArbolBB();
        
        System.out.println(ANSI_YELLOW_BACKGROUND+"--------------------------------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n");
        
        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");
      
        System.out.println("Checkeo si es vacio " + ((  a.esVacío()) ? sOk : sErr));  
        System.out.println("Intento vaciar arbol vacio ");
        a.vaciar();
	
        System.out.println("Inserto el 10 en raiz " + ((  a.insertar(10)) ? sOk : sErr));
        System.out.println("Inserto el 6 " + ((  a.insertar(6)) ? sOk : sErr));
        System.out.println("Inserto el 3 " + ((  a.insertar(3)) ? sOk : sErr));
        System.out.println("Inserto el 8 " + ((  a.insertar(8)) ? sOk : sErr));
        System.out.println("Inserto el 14 " + ((  a.insertar(14)) ? sOk : sErr));
        System.out.println("Inserto el 12 " + ((  a.insertar(12)) ? sOk : sErr));
        System.out.println("Inserto el 17 " + ((  a.insertar(17)) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 6 \t \t \t 14"
                + " \n \t 3 \t \t 8 \t 12 \t \t 17"
                +"\t \t --> \t \t"+ "\n\n"+ a.toString());
        System.out.println("\n");
        ArbolBB clonA=a.clone();//clono el arbol creado para testear el mismo en eliminar minimo y en eliminar maximo!
        ArbolBB clonA2=a.clone();//clono el arbol creado para testear el listar por rangos
        System.out.println("Inserto 3 (elemento repetido). Tiene que dar " + sErr+" --> "  + ((  a.insertar(3)) ? sOk : sErr));
        System.out.println("Checkeo si el Arbol es vacio. Tiene que dar" + sErr+" --> "  +((  a.esVacío()) ? sOk : sErr));  
        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"-------------------------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------------------------"+RESET);
       
        
        
        System.out.println("\n\n********************************");
        System.out.println("*  Test de Eliminar Minimo  do      *");
        System.out.println("********************************\n");
        
        System.out.println("Eliminar Minimo de un arbol Vacio. Tiene que dar "+sErr+" --> " + (( b.eliminarMinimo()) ? sOk : sErr));
        System.out.println("Arbol A :\n"+a.toString());
	System.out.println("Eliminar Minimo del arbol A. Tiene que dar "+sOk+" --> " + (( a.eliminarMinimo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
              + " \n \t \t 6 \t \t \t 14"
              + " \n \t  \t \t 8 \t 12 \t \t 17"
              +"\t \t --> \t \t"+ "\n\n"+ a.toString());
        System.out.println("\n");
        System.out.println("Eliminar Minimo del arbol A. Tiene que dar "+sOk+" --> " + (( a.eliminarMinimo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
              + " \n \t \t 8 \t \t \t 14"
              + " \n \t  \t \t   \t 12 \t \t 17"
              +"\t \t --> \t \t"+ "\n\n"+ a.toString());
        System.out.println("\n");
        System.out.println("Eliminar Minimo del arbol A. Tiene que dar "+sOk+" --> " + (( a.eliminarMinimo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
              + " \n \t \t   \t \t \t 14"
              + " \n \t  \t \t   \t 12 \t \t 17"
              +"\t \t --> \t \t"+ "\n\n"+ a.toString());
        System.out.println("\n");
        System.out.println("Eliminar Minimo del arbol A. Tiene que dar "+sOk+" --> " + (( a.eliminarMinimo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      14"
              + " \n \t \t 12 \t \t \t 17"
              + " \n \t  \t \t   \t   \t \t  "
              +"\t \t --> \t \t"+ "\n\n"+ a.toString());
        System.out.println("\n");
        
        
       
        
        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n********************************");
        System.out.println("*  Test de Eliminar Maximo  do      *");
        System.out.println("********************************\n");
        
        System.out.println("Eliminar Maximo de un arbol Vacio. Tiene que dar "+sErr+" --> " + (( b.eliminarMaximo()) ? sOk : sErr));
        System.out.println("Arbol A :\n"+clonA.toString());
	System.out.println("Eliminar Maximo del arbol A. Tiene que dar "+sOk+" --> " + (( clonA.eliminarMaximo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 6 \t \t \t 14"
                + " \n \t 3 \t \t 8 \t 12 \t \t   "
                +"\t \t --> \t \t"+ "\n\n"+ clonA.toString());
        System.out.println("\n");
        System.out.println("Eliminar Maximo del arbol A. Tiene que dar "+sOk+" --> " + (( clonA.eliminarMaximo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 6 \t \t \t 12"
                + " \n \t 3 \t \t 8 \t    \t \t   "
                +"\t \t --> \t \t"+ "\n\n"+ clonA.toString());
        System.out.println("\n");
        System.out.println("Eliminar Maximo del arbol A. Tiene que dar "+sOk+" --> " + (( clonA.eliminarMaximo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 6 \t \t \t   "
                + " \n \t 3 \t \t 8 \t    \t \t   "
                +"\t \t --> \t \t"+ "\n\n"+ clonA.toString());
        System.out.println("\n");
        System.out.println("Eliminar Maximo del arbol A. Tiene que dar "+sOk+" --> " + (( clonA.eliminarMaximo()) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      6"
                + " \n \t \t 3 \t \t \t 8 "
                + " \n \t   \t \t   \t    \t \t   "
                +"\t \t --> \t \t"+ "\n\n"+ clonA.toString());
        System.out.println("\n");
        
        
        
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n**********************************");
        System.out.println("*    Test de Listar por Rangos      *");
        System.out.println("**********************************\n");
        System.out.println("Arbol A :\n"+clonA2.toString()+"\n");
        //Lista rango;
        int min=4;
        int max=100;
        //rango=clonA2.listarRango(min, max);
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: 6 8 10 12 14 17 \n Retorna: "+clonA2.listarRango(min,max).toString() );
        min=0;
        max=14;
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: 3 6 8 10 12 14 \n Retorna: "+clonA2.listarRango(min,max).toString() );
        min=10;
        max=12;
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: 10 12 \n Retorna: "+clonA2.listarRango(min,max).toString() );
        min=14;
        max=0;
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: lista Vacia! \n Retorna: "+clonA2.listarRango(min,max).toString() );
        System.out.println("Inserto el 4 " + ((  clonA2.insertar(4)) ? sOk : sErr));
        System.out.println("Inserto el 5 " + ((  clonA2.insertar(5)) ? sOk : sErr));
        System.out.println("Inserto el 11 " + ((  clonA2.insertar(11)) ? sOk : sErr));
        min=4;
        max=11;
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: 4 5 6 8 10 11 \n Retorna: "+clonA2.listarRango(min,max).toString() );
        System.out.println("Vacio el Arbol " ) ;
        clonA2.vaciar();
        System.out.println("Listar mayores igual a "+min+" y menores igual a "+max+" : \n Deberia retornar: Lista Vacia! \n Retorna: "+clonA2.listarRango(min,max).toString() );
        
        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        
        
    }
}
