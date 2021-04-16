/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPFinal;

public class Vuelo {
    private ClaveVuelo clave;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int horaSalida;
    private int horaLlegada;
    private int asientos;
    private int vendidos;
    
    public Vuelo(ClaveVuelo clave){
        this.clave=clave;
    }
    public Vuelo(ClaveVuelo c, Aeropuerto origen, Aeropuerto d, int horaS, int horaLL, int a){
        
        this.clave=c;
        this.origen=origen;
        this.destino=d;
        this.horaSalida=horaS;
        this.horaLlegada=horaLL;
        this.asientos=a;
        this.vendidos=0;
    }
    public String mostrarInfo(){
        String info= "Nombre: "+this.clave+"\n Origen: "+this.origen.getNombre()+"\n Destino: "
                +this.destino.getNombre() +"\n Hora de salida: "+ this.horaSalida +"\n Hora de llegada: "+this.horaLlegada 
                +" Cantidad de asientos totales: "+this.asientos+"\n Cantidad de asientos vendidos: "+ this.vendidos;
        return info;
    }
    public boolean verificarClave(String clave){
        boolean res= Character.isLetter(clave.charAt(0)) && !Character.isLowerCase(clave.charAt(0))
                && Character.isLetter(clave.charAt(1)) && !Character.isLowerCase(clave.charAt(1))
                && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4))
                && Character.isDigit(clave.charAt(5));
    return res;
    }
    public String toString(){
        return this.clave.toString();
    }
    public int getAsientosVendidos(){
        return this.vendidos;
    }
    public int getAsientosTotales(){
        return this.asientos;
    }
    public void sumarVendidos(int suma){
        this.vendidos= this.vendidos+suma;
    }
    
    public void restarVendidos(int suma){
        this.vendidos= this.vendidos-suma;
    }
    public void setSalida(int h){
        this.horaSalida=h;
    }
    
    public void setLlegada(int l){
        this.horaSalida=l;
    }
    
    
    public String getClave(){
        return this.clave.toString();
    }
    public Aeropuerto getOrigen(){
        return this.origen;
    }
    public Aeropuerto getDestino(){
        return this.destino;
    }
    public int getHoraSalida(){
        return this.horaSalida;
    }
    public int getHoraLlegada(){
        return this.horaLlegada;
    }
}
