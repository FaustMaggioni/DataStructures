
package DDATP8;

public class hanoi {
    public static void main(String[] args)
{
int discos=5;
System.out.println("Torres de hanoi\n");
System.out.println("Cantidad de discos"+discos);
char origen = 'A', auxiliar ='B', destino = 'C';
mover(discos, origen, destino, auxiliar);
}
private static void moverDisco(int n, char origen, char destino){
System.out.println("Mover disco "+n+" de "+origen+" a "+destino);
}
private static void mover(int disco, char fuente,
char destino, char auxiliar)
{
if (disco == 1){
moverDisco(disco, fuente, destino);}
else {
mover(disco-1, fuente, auxiliar,destino);
moverDisco(disco, fuente, destino);
mover(disco-1,auxiliar, destino, fuente);
}
}
}

