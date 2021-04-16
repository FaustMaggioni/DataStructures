/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Faustino
 */
public class Alumno {
    // Atributos
    private int legajo;
    private String nombre;
    private String apellido;
    private String tipodoc;
    private int dni;
    private String domicilio;
    private int telefono;
    private String usuario;
    private String clave;
    // Constructores
    public Alumno(int legajo){
        this.legajo=legajo;
    }
    public Alumno(int legajo, String nombre, String apellido, String tipodoc, int dni, String ciudad, String calle,int nro, int tel, String usu,String clave){
        this.legajo=legajo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipodoc=tipodoc;
        this.dni=dni;
        this.domicilio=calle+","+nro+","+ciudad;
        this.usuario=usu;
        this.clave=clave;
    }
    //Modificadores
    public void setDom(String ciudad, String calle, int nro){
        this.domicilio=calle+","+nro+","+ciudad;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setAp(String ap){
        this.apellido=ap;
    }
    public void setTel(int nro){
        this.telefono=nro;
    }
    public void setClave(String clave, String nueva){
        if(clave.equals(this.clave)){
            this.clave=nueva;
        }
    }
    public void setUsuario(String clave, String nuevoU, String usuario){
        if(clave.equals(this.clave)){
            this.usuario=nuevoU;
        }
    }
    //Observadores
    public String getNyM(){
        return this.nombre+this.apellido;
    }
    public int getLegajo(){
        return this.legajo;
    }
    public String aCadena(){
        return this.legajo+this.nombre+this.apellido+this.tipodoc+this.dni+this.domicilio+this.usuario+this.telefono;
    }
    public String getDom(){
        return this.domicilio;
    }
    public String getUsuario(){
        return this.usuario;
    }
    //Propias del Tipo
    public boolean esIgual(int legajo){
        return legajo==this.legajo;
    }
    public boolean claveCorrecta(String clave){
        return clave==this.clave;
    }
}












