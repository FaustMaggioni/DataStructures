
package DDATP5;
public class racional {
      private int mcd(int num1, int num2) {
        int mcd = 0;
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        do {
            mcd = b;
            b = a%b;
            a = mcd;
        } while(b!=0);
        return mcd;
     
    
     }
    private int mcm(int num1, int num2){
        int mcm=0;
        int a = Math.max(num1, num2);
        int b= Math.min(num1, num2);
        mcm= (a/mcd(a,b))*b;
        return mcm;
    }
    // Atributos
    private int numerador;
    private int denomiador;
    
    // Constructores
    public racional(int n, int d){
        this.denomiador=d;
        this.numerador=n;
    }
    
    // Observadores
    public int getNumerador(){
        return this.numerador;
    }
    public int getDenominador(){
        return this.denomiador;
    }
    public double aReal(){
        return ((double)(this.numerador/this.denomiador));
    }
    public String aString(){
        return "Numerador: "+this.numerador+", Denominador: "+this.denomiador;
    }
    public boolean equals(racional r){
        return (this.denomiador==r.denomiador)&&(this.numerador==r.numerador);
    }
    
    // Modificadores
    public void setNum(int n){
        this.numerador=n;
    }
    public void setDen(int d){
        this.denomiador=d;
    }
    
    // Propias
    public racional sumar(racional r){
        
        int n1= this.numerador,d1=this.denomiador,n2=r.numerador,d2=r.denomiador;
        int mcm= mcm(d1,d2);
        int n3= n2*d1+n1*d2;
        racional suma= new racional(n3,mcm);
        return suma;
    }
    public racional restar(racional r){
        int n1= this.numerador,d1=this.denomiador,n2=r.numerador,d2=r.denomiador;
        int mcm= mcm(d1,d2);
        int n3= n1*d2-n2*d1;
        racional resta= new racional(n3,mcm);
        return resta;
    }
    public racional multiplicar(racional r){
       int n1= this.numerador,d1=this.denomiador,n2=r.numerador,d2=r.denomiador;
       int n3= n1*n2,d3=d1*d2;
       racional producto= new racional(n3,d3);
       return producto;
       
    }
    public racional dividir(racional r){
        
            int n1= this.numerador,d1=this.denomiador,n2=r.numerador,d2=r.denomiador;
            int n3= n1*d2,d3=d1*n2;
            
        racional division= new racional(n3,d3);
       return division;  
    }
      
    public racional simplificar(){
        int n1= this.numerador,d1=this.denomiador,d2=d1,n2=n1;
        int mcd= mcd(n1,d1);
        if((n1%d1==0)||(d1%n1==0)){
        do{
            d2=d1/mcd;
            n2=n1/mcd;
        } while(n2>=1);}
        racional sim= new racional(n2,d2);
        return sim;
    }

        
    


  

    
}
    
