
package DDATP5;

public class especie {
    private String nombre;
    private int poblacion;
    private double tasaCrecimiento;
    public especie(String nombre){
    this.nombre=nombre;
    this.poblacion=0;
    this.tasaCrecimiento=0;
    }
    public especie(String nombre,int poblacion,double tasaCrecimiento){
    this.nombre=nombre;
    this.poblacion=poblacion;
    this.tasaCrecimiento=tasaCrecimiento;}
    
    public String getNombre(){
        return nombre;
    }
    public void setPoblacion(int nuevapoblacion){
        poblacion= nuevapoblacion;}
    public int getPoblacion(){
        return poblacion;}
    public void setTasa(double tasa){
        tasaCrecimiento= tasa;}
    public double getTasa(){
        return tasaCrecimiento;}
    public String aCadena( ){
        return "Nombre_=_"+getNombre()+" Poblacion = "+getPoblacion()+" Tasa de Crecimiento = "+getTasa();}
    public boolean igualA(especie otroObjeto){
        return((nombre.equalsIgnoreCase(otroObjeto.nombre)))&&(poblacion==otroObjeto.poblacion)&&(tasaCrecimiento==otroObjeto.tasaCrecimiento);
    }
    public int poblacionProyectada(int años){
        int poblacionP;
        poblacionP= (int) (((poblacion%tasaCrecimiento)*años)+poblacion);
        return poblacionP;
    }
    }
  

    


