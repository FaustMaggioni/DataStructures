
package DDATP5;



        public class Conjunto {
           

    //Atributo
    private boolean []arreglo;
    //Constructor
    public Conjunto(){
       arreglo=new boolean[100];
       for(int i=0;i<this.arreglo.length;i++){
           this.arreglo[i]=false;
       }
      
    }

  
    //Observadores
    public boolean igualA(Conjunto otro){
        return this.arreglo==otro.arreglo;
    }
    public boolean comprobarVacio(){
        boolean vacio=true;
        int i=0;
        while((vacio)&&(i<this.arreglo.length)){
         if(this.arreglo[i]==false){
             vacio= true;
             i++;
         }
         else{
             vacio= false;
         }
              }
        return vacio;
    }
    public boolean comprobar(int elemento){
        return this.arreglo[elemento];
    }

      //Modificadores
    
      public Conjunto vacio(){
          Conjunto vacio= new Conjunto();
          return vacio;
          }
      public void borrar(int elemento){
           this.arreglo[elemento]=false;
      }  
      public void insertar( int elemento){
          this.arreglo[elemento]=true;
      }
      public Conjunto union(Conjunto otro){
          Conjunto union = new Conjunto();
          for(int i=0;i<arreglo.length;i++){
              if((otro.arreglo[i]=true)||(this.arreglo[i]=true)){
                  union.arreglo[i]=true;
              }
          }
          return union;
      }
       public Conjunto interseccion(Conjunto otro){
          Conjunto interseccion = new Conjunto();
          for(int i=0;i<arreglo.length;i++){
              if((otro.arreglo[i]=true)&&(this.arreglo[i]=true)){
                  interseccion.arreglo[i]=true;
              }
          }
          return interseccion;
      }
       public Conjunto resta(Conjunto otro){
           Conjunto resta= new Conjunto ();
           for(int j=0;j<this.arreglo.length;j++){
               resta.arreglo[j]=this.arreglo[j];
           }
           int i;
           for(i=0;i<resta.arreglo.length;i++){
               if((resta.arreglo[i]=true)&&(otro.arreglo[i]=true)){
                   resta.arreglo[i]= false;
               }
           }
           return resta;
       }
       public Conjunto complemento(){
           Conjunto comple= new Conjunto();
           for(int i=0;i<this.arreglo.length;i++){
               comple.arreglo[i]=!this.arreglo[i];
               }
           return comple;
           }
       
       public Conjunto copia(){
           Conjunto copia= new Conjunto();
           for(int i=0;i<this.arreglo.length;i++){
               copia.arreglo[i]=this.arreglo[i];
           }
           return copia;
       }
            
       public String toString(){
           String conjunto="";
           for(int i=0;i<this.arreglo.length;i++){
               if(this.arreglo[i]=true){
                   System.out.println(i);
                   conjunto=conjunto+","+i;
               }
           }
           return conjunto;
       }
       }
       

