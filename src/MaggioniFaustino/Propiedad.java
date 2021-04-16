
package MaggioniFaustino;

public class Propiedad {
    // Atributos
    private int codigo;
    private char tipo;
    private String direccion;
    private int cantAmbientes;
    private char operacion;
    private int superficie;
    private boolean disponibilidad;
    private int precio;
    //Constructores
    public Propiedad(int codigo){
    this.codigo=codigo;}
    public Propiedad(int cod,char tipo, String direcc,int cAmb,char op,int sup,boolean disp,int pr)
    {
        this.codigo= cod;
        this.direccion= direcc;
        this.tipo= tipo;
        this.operacion=op;
        this.cantAmbientes=cAmb;
        this.superficie= sup;
        this.disponibilidad= disp;
        this.precio=pr;
    }
    //Modificadores
    public void setTipo(char nuevoTipo){
        this.tipo= nuevoTipo;
    }
    public void setDireccion(String direcc){
        this.direccion= direcc;
    }
    public void setAmbientes(int cAmb){
        this.cantAmbientes= cAmb;
    }
    public void setOperacion(char op){
        this.operacion= op;
    }
    public void setSuperficie(int sup){
        this.superficie= sup;
    }
    public void setDisponibilidad(boolean disp){
        this.disponibilidad=disp;
    }
    public void setPrecio(int precio){
        this.precio= precio;
    }
    //Observadores
    public int getCodigo(){
        return this.codigo;
    }
    public char getTipo(){
        return this.tipo;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public int getAmbientes(){
        return this.cantAmbientes;
    }
    public char getOperacion(){
        return this.operacion;
    }
    public int getSuperficie(){
        return this.superficie;
    }
    public boolean getDisponibilidad(){
        return this.disponibilidad;
    }
    public int getPrecio(){
        return this.precio;
    }
    
   
    @Override
    public String toString(){
       
        return "Codigo: "
                +getCodigo()
                +", Tipo: "
                +this.tipo+", Direccion: "
                +this.direccion
                +", Cantidad de Ambientes: "
                +this.cantAmbientes+", Operacion: "
                +this.operacion+", Superficie: "
                +this.superficie+", Disponibilidad: "
                +this.disponibilidad+", Precio: "
                    +this.precio;
                
    }
    public boolean equals(Propiedad p){
        return this.codigo==p.codigo;
    }
    
}
