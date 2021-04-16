
package DDATP5;

public class Patinador {
    // Atributos:
    private String apellido;
    private String nombre;
    private String dni;
    private int edad;
    private char categoria;
    
    // Constructores:
    public Patinador(){
        this.apellido=null;
        this.categoria='P';
        this.dni=null;
        this.edad=0;
        this.nombre=null;
    }
    public Patinador(String last,String name,String doc,int e,char cat){
        this.apellido=last;
        this.categoria=cat;
        this.dni=doc;
        this.edad=e;
        this.nombre=name;
    }

    
    
    // Observadores:
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getDoc(){
        return this.dni;
    }
    public int getEdad(){
        return this.edad;
        }
    public char getCat(){
        return this.categoria;
    }
    @Override
    public String toString(){
        return "Nombre: "+this.nombre+", Apellido: "+this.apellido+", Documento: "+this.dni+", Edad: "+this.edad+", Categoría: "+this.categoria;
    }
    
    // Modificadores:
    public void setNombre(String name){
        this.nombre=name;
    }
     public void setApellido(String last){
         this.apellido=last;
     }
      public void setDoc(String doc){
          this.dni=doc;
      }
       public void setEdad(int edad){
           this.edad=edad;
       }
        public void setCat(char cate){
            this.categoria=cate;
        }
    
        // Propias del Tipo:
        public void asciende(){
           switch(this.categoria){
               case 'P':
                   this.setCat('I');
                   break;
               case 'I':
                   this.setCat('C');
                   break;
                    case 'C':
                   this.setCat('B');
                   break;
                    case 'B':
                   this.setCat('A');
                   break;
           }
        }
        public boolean equals(Patinador otro){
            return otro.getDoc().equals(this.getDoc());
        }
}
