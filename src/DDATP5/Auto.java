
package DDATP5;

public class Auto {
    private  String  patente;
    private int cuentaKm;
    private String modelo;
    private boolean disponible;
    public Auto (String patente){
    this.patente=patente;}
    public Auto(String patente, int km,boolean disp){
    this.patente=patente;
    this.cuentaKm=km;
    this.disponible=disp;}
    public void setCuentaKM (int km){
        int cuentaKm= km;
        
    }
    public void setPatente(String pat){
        this.patente= pat;
    }
    public  void setModelo(String mod){
        this.modelo= mod;
    }
    public void setDisponible(boolean disp){
        this.disponible= disp;
    }
    public String getPatente(){
      
       return patente;
    }
    public int getCuentaKM(){
        return cuentaKm;
    }
    public String getModelo(){
    return modelo;
}
    public boolean getDisp(){
        return disponible;
    }
    private String logico(boolean disp){
        String logic;
        if(disp){
            logic= "Está disponible";
        }
        else{
            logic= "No está disponible";
        }
        return logic;
    }
    public String aString(){
        return "Patente= "+getPatente()+" CuentaKM= "+getCuentaKM()+" Modelo= "+getModelo()+" Disponibilidad= "+this.logico(this.getDisp());
    }
    public boolean igualA (Auto a){
        return (patente.equalsIgnoreCase(a.patente));}
}