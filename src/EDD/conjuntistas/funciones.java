package EDD.conjuntistas;

public class funciones {

    public static int cuadradodigitoscentralea(int k, int m) {
        int aux = (int) Math.pow(k, 2);//Elevo al cuadrado k
        String s = "",
                aux2 = String.valueOf(aux); //Paso a string el cuadrado de k para manejar las posiciones
        int cant = aux2.length(), longitud = (int) (Math.log10(m) + 1); //cantidad de digitos de M
        int ayuda = (cant / 2) - 1; //comienzo desde uno antes de la mitad
        for (int i = 1; i <= longitud; i++) {
            s = s + aux2.charAt(ayuda);
            ayuda++;
        }
        int x = Integer.parseInt(s);
        return x;

    }

    public static int funcioncadena(Object e) {
        int suma = 0;
        String k= e.toString();
        for (int i = 0; i < k.length(); i++) {
            suma = suma + k.codePointAt(i);
        }
        return suma;
    }
    public static int rehash(int i, Object e, int m){
        return (int)(funcioncadena(e)+(i-1)*h2(e))%m;
    }
    public static int h2(Object e){
        String x= e.toString();
        int res= x.codePointAt(0) / 2;
        return res;
    }
}
