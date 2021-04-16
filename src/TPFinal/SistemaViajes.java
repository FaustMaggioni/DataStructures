package TPFinal;

import EDD.grafos.Grafo;
import EDD.grafos.NodoVert;
import TPFinalEDAT.Lista;
import TablaDeBusqueda.TablaDeBusqueda;
import TPFinalEDAT.TecladoIn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import EDD.conjuntistas.Heap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SistemaViajes {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);
        Grafo aeropuertos = new Grafo();
        TablaDeBusqueda clientes = new TablaDeBusqueda();
        TablaDeBusqueda vuelos = new TablaDeBusqueda();
        HashMap<ClaveCliente, Lista> mapeo;
        mapeo = new HashMap<ClaveCliente, Lista>();
        File salida = new File("C:\\Users\\Faustino\\Documents\\2do Año-Unco\\Estructura de Datos\\TPFinal\\salida.txt");
        FileWriter s = new FileWriter(salida);
        BufferedWriter bw = new BufferedWriter(s);
        cargaAeropuertos(aeropuertos, bw);
        cargaVuelos(vuelos, aeropuertos, bw);
        cargaClientes(clientes, mapeo, bw);
        cargaPasajes(vuelos, clientes, mapeo, aeropuertos, bw);
        //Preguntar sobre clave cliente, cliente o q onda
        boolean seguir = true;
        while (seguir) {
            System.out.println("Elija una opcion: \n 1) ABM de aereopuertos \n 2) ABM de cliente "
                    + "\n 3) ABM de vuelos \n 4) ABM de pasajes \n 5) Consultas sobre clientes \n 6) Consultas sobre vuelos "
                    + "\n 7) Consultas sobre tiempos de viaje \n 8) Listado de clientes para promoción \n 9) Mostrar sistema. \n 10) Parar.");
            int res = TecladoIn.readLineInt();
            switch (res) {
                case 1:
                    ABMAereopuerto(aeropuertos, vuelos, mapeo, bw);
                    break;
                case 2:
                    ABMClientes(clientes, mapeo, bw);
                    break;
                case 3:
                    ABMVuelos(vuelos, aeropuertos, mapeo, clientes, bw);
                    break;
                case 4:
                    ABMPasajes(mapeo, clientes, vuelos, bw);
                    break;
                case 5:
                    ConsultasCliente(clientes, mapeo, vuelos);
                    break;
                case 6:
                    ConsultasVuelos(vuelos);
                    break;
                case 7:
                    ConsultasSobreTiemposdeViaje(aeropuertos);
                    break;
                case 8:
                    HeapPromocion h = Promocion(mapeo);
                    System.out.println("Documentos de clientes ordenados segun cantidad de pasajes comprados: \n" + h.ordenado());
                    break;
                case 9:
                    MostrarTodo(aeropuertos, vuelos, clientes, mapeo);
                    break;
                case 10:
                    seguir = false;
                    break;
                default:
                    break;
            }
        }
        escrituraFinal(aeropuertos, vuelos, clientes, mapeo, bw);
        bw.flush();

    }

    public static void escrituraFinal(Grafo g, TablaDeBusqueda v, TablaDeBusqueda c, HashMap h, BufferedWriter bw) throws IOException {
        HeapPromocion hp = Promocion(h);
        bw.write("ESTADO FINAL DEL SISTEMA");
        bw.newLine();
        bw.write("");
        bw.newLine();
        Lista anchura = g.enAnchura();
        int largo = anchura.longitud();
        bw.write("Aeropuertos:");
        bw.newLine();
        bw.write("");
        bw.newLine();
        for (int i = 1; i <= largo; i++) {
            Aeropuerto a = (Aeropuerto) anchura.recuperar(i);
            bw.write(a.toString());
            bw.newLine();
        }
        bw.write(".............");
        bw.newLine();
        Lista vuelos = v.listarDatos();
        largo = vuelos.longitud();
        bw.write("Vuelos:");
        bw.newLine();
        bw.write("");
        bw.newLine();
        for (int i = 1; i <= largo; i++) {
            Vuelo vue = (Vuelo) vuelos.recuperar(i);
            bw.write(vue.toString());
            bw.newLine();
        }
        bw.write(".............");
        bw.newLine();
        Lista clientes = c.listarDatos();
        largo = clientes.longitud();
        bw.write("Clientes:");
        bw.newLine();
        bw.write("");
        bw.newLine();
        for (int i = 1; i <= largo; i++) {
            Cliente cli = (Cliente) clientes.recuperar(i);
            bw.write(cli.toString());
            bw.newLine();

        }
        bw.write(".............");
        bw.newLine();
        bw.write("Pasajes:");
        bw.newLine();
        bw.write("");
        bw.newLine();
        Iterator it = h.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            Lista aux = (Lista) pair.getValue();
            largo = aux.longitud();
            bw.write("Cliente " + pair.getKey() + " tiene los siguientes pasajes: ");
            bw.newLine();
            for (int i = 1; i <= largo; i++) {
                Pasaje pas = (Pasaje) aux.recuperar(i);
                bw.write(pas.toString());
                bw.newLine();
            }
            bw.write("");
            bw.newLine();
        }
        bw.write(".............");
        bw.newLine();
        bw.write("Documentos de clientes ordenados por cantidad de pasajes comprados.");
        bw.newLine();
        bw.write(hp.ordenado());
        bw.newLine();
        bw.write(".............");
        bw.newLine();
    }

    public static void cargaPasajes(TablaDeBusqueda v, TablaDeBusqueda c, HashMap h, Grafo g, BufferedWriter bw) throws FileNotFoundException, IOException {
        File f = new File("C:\\Users\\Faustino\\Documents\\2do Año-Unco\\Estructura de Datos\\TPFinal\\pasajes.txt");
        String line = "";
        FileReader fi = new FileReader(f);
        BufferedReader pasajes = new BufferedReader(fi);
        line = pasajes.readLine();
        bw.write("PASAJES");
        bw.newLine();
        bw.write("");
        bw.newLine();
        while (line != null) {
            int coma = line.indexOf(',');
            if (coma != -1) {
                String nomvuelo = line.substring(0, coma);
                ClaveVuelo aux = new ClaveVuelo(nomvuelo);
                if (v.existeClave(aux)) {
                    ClaveVuelo clave = (ClaveVuelo) v.getClave(aux);
                    Vuelo vuelo = (Vuelo) v.obtenerInformacion(clave);
                    if (vuelo.getAsientosVendidos() < vuelo.getAsientosTotales()) {
                        line = line.substring(coma + 1);
                        coma = line.indexOf(',');
                        String fecha = line.substring(0, coma);
                        line = line.substring(coma + 1);
                        coma = line.indexOf(',');
                        String nroasiento = line.substring(0, coma);
                        line = line.substring(coma + 1);
                        coma = line.indexOf(',');
                        String tipodoc = line.substring(0, coma);
                        line = line.substring(coma + 1);
                        int punto = line.indexOf('.');
                        String nrodoc = line.substring(0, punto);
                        ClaveCliente auxiliar = new ClaveCliente(tipodoc, nrodoc);
                        if (c.existeClave(auxiliar)) {
                            ClaveCliente cc = (ClaveCliente) c.getClave(auxiliar);
                            Pasaje nuevo = new Pasaje(vuelo, fecha, nroasiento);
                            Lista listapasajes = (Lista) h.get(cc);
                            listapasajes.insertar(nuevo, listapasajes.longitud() + 1);
                            vuelo.sumarVendidos(1);
                            bw.write("Cliente con tipo y nro documento: " + cc.toString() + ", compro el pasaje: " + nuevo);
                            bw.newLine();
                        }
                    }
                }
            }
            line = pasajes.readLine();
        }
        bw.write("");
        bw.newLine();
    }

    public static void cargaAeropuertos(Grafo aeropuertos, BufferedWriter bw) throws FileNotFoundException, IOException {
        File f = new File("C:\\Users\\Faustino\\Documents\\2do Año-Unco\\Estructura de Datos\\TPFinal\\aeropuertos.txt");
        String line = "";
        FileReader fi = new FileReader(f);
        BufferedReader apuertos = new BufferedReader(fi);
        line = apuertos.readLine();
        bw.write("AEROPUERTOS");
        bw.newLine();
        bw.write("");
        bw.newLine();
        while (line != null) {
            int posF = line.indexOf(',');
            String nombre = line.substring(3, posF);
            String aux = line.substring(posF + 2);
            posF = aux.indexOf(',');
            String ciudad = aux.substring(0, posF);
            int punto = aux.indexOf('.');
            String telefono = aux.substring(posF + 2, punto - 1);
            int tel = Integer.parseInt(telefono);
            // System.out.println(tel);
            Aeropuerto nuevo = new Aeropuerto(nombre, tel, ciudad);
            boolean a = aeropuertos.insertarVertice(nuevo);
            if (a) {
                bw.write(nuevo.toString());
                bw.newLine();
            }
            //System.out.println(ciudad);
            //System.out.println(aux);
            line = apuertos.readLine();
        }
        bw.write("");
        bw.newLine();
    }

    public static void cargaVuelos(TablaDeBusqueda v, Grafo g, BufferedWriter bw) throws FileNotFoundException, IOException {
        String line = "";
        File f = new File("C:\\Users\\Faustino\\Documents\\2do Año-Unco\\Estructura de Datos\\TPFinal\\vuelos.txt");
        FileReader fr = new FileReader(f);
        BufferedReader vuelos = new BufferedReader(fr);
        line = vuelos.readLine();
        bw.write("VUELOS");
        bw.newLine();
        bw.write("");
        bw.newLine();
        while (line != null) {
            int coma = line.indexOf(',');
            if (coma != -1) {
                String clave = line.substring(0, coma);
                if (verificarClave(clave)) {
                    line = line.substring(coma + 1);
                    coma = line.indexOf(',');
                    String nombreOrigen = line.substring(0, coma);
                    line = line.substring(coma + 1);
                    coma = line.indexOf(',');
                    String nombreDestino = line.substring(0, coma);
                    Aeropuerto auxOrigen = new Aeropuerto(nombreOrigen);
                    Aeropuerto auxDestino = new Aeropuerto(nombreDestino);
                    if (g.existeVertice(auxOrigen) && g.existeVertice(auxDestino)) {
                        Aeropuerto origen = (Aeropuerto) g.getElemento(auxOrigen);
                        Aeropuerto destino = (Aeropuerto) g.getElemento(auxDestino);
                        line = line.substring(coma + 1);
                        coma = line.indexOf(',');
                        String horaSalidaString = line.substring(0, coma);
                        line = line.substring(coma + 1);
                        coma = line.indexOf(',');
                        String horaLlegadaString = line.substring(0, coma);
                        int Hsalida = Integer.parseInt(horaSalidaString);
                        int Hllegada = Integer.parseInt(horaLlegadaString);
                        int minutos = getMinutos(Hsalida, Hllegada);
                        if (!g.existeArco(origen, destino)) {
                            g.insertarArco(origen, destino, minutos);
                        } else {
                            Lista etiq = g.getEtiqueta(origen, destino);
                            boolean ok = false;
                            int i = 1;
                            int largo = etiq.longitud();
                            while (!ok && i <= largo) {
                                int x = (int) etiq.recuperar(i);
                                if (x == minutos) {
                                    ok = true;
                                }
                                i = i + 1;
                            }
                            if (!ok) {
                                g.insertarArco(origen, destino, minutos);
                            }
                        }
                        line = line.substring(coma + 1);
                        coma = line.indexOf('.');
                        String auxAsientos = line.substring(0, coma);
                        int asientos = Integer.parseInt(auxAsientos);
                        ClaveVuelo cv = new ClaveVuelo(clave);
                        Vuelo nuevo = new Vuelo(cv, origen, destino, Hsalida, Hllegada, asientos);
                        boolean a = v.insertar(cv, nuevo);
                        if (a) {
                            bw.write(nuevo.toString());
                            bw.newLine();
                        }
                    }
                }
            }

            line = vuelos.readLine();
        }
        bw.write("");
        bw.newLine();
    }

    public static void cargaClientes(TablaDeBusqueda c, HashMap h, BufferedWriter bw) throws FileNotFoundException, IOException {
        String line = "";
        File f = new File("C:\\Users\\Faustino\\Documents\\2do Año-Unco\\Estructura de Datos\\TPFinal\\clientes.txt");
        FileReader fr = new FileReader(f);
        BufferedReader clientes = new BufferedReader(fr);
        line = clientes.readLine();
        bw.write("CLIENTES");
        bw.newLine();
        bw.write("");
        bw.newLine();
        while (line != null) {
            int coma = line.indexOf(',');
            if (coma != -1) {
                String tipoDoc = line.substring(0, coma);
                line = line.substring(coma + 1);
                coma = line.indexOf(',');
                String nroDoc = line.substring(0, coma);
                line = line.substring(coma + 1);
                coma = line.indexOf(',');
                String nombre = line.substring(0, coma);
                line = line.substring(coma + 1);
                coma = line.indexOf(',');
                String apellido = line.substring(0, coma);
                line = line.substring(coma + 1);
                coma = line.indexOf(',');
                String telefono = line.substring(0, coma);
                line = line.substring(coma + 1);
                int punto = line.indexOf('.');
                String domicilio = line.substring(0, punto);
                ClaveCliente cc = new ClaveCliente(tipoDoc, nroDoc);
                Cliente nuevo = new Cliente(tipoDoc, nroDoc, nombre, apellido, telefono, domicilio);
                boolean a = c.insertar(cc, nuevo);
                if (a) {
                    h.put(cc, new Lista());
                    bw.write(nuevo.toString());
                    bw.newLine();
                }

            }
            line = clientes.readLine();
        }
        bw.write("");
        bw.newLine();
    }

    public static HeapPromocion Promocion(HashMap h) {
        HeapPromocion hp = new HeapPromocion();
        Iterator it = h.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            Lista aux = (Lista) pair.getValue();
            int largo = aux.longitud();
            hp.insertar(largo, ((ClaveCliente) pair.getKey()));
        }
        //System.out.println("Tipo y nro de documentos de los clientes ordenados segun cantidad de pasajes comprados: \n" + hp.ordenado());
        return hp;
    }

    public static void MostrarTodo(Grafo a, TablaDeBusqueda v, TablaDeBusqueda c, HashMap h) {
        Lista aereopuertos = a.enProfundidad();
        int largo = aereopuertos.longitud();
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Aereopuertos: ");
        System.out.println("~~~~~~~~~~~~~~");
        for (int i = 1; i <= largo; i++) {
            System.out.println(((Aeropuerto) (aereopuertos.recuperar(i))).toString() + ", Ciudad:  " + ((Aeropuerto) (aereopuertos.recuperar(i))).getCiudad());

        }
        Lista vuelos = v.listarDatos();
        largo = vuelos.longitud();
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Vuelos: ");
        System.out.println("~~~~~~~~~~~~~~");
        for (int i = 1; i <= largo; i++) {
            System.out.println(((Vuelo) vuelos.recuperar(i)).mostrarInfo() + ".");
        }
        Lista clientes = c.listarDatos();
        largo = clientes.longitud();
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Clientes: ");
        System.out.println("~~~~~~~~~~~~~~");
        for (int i = 1; i <= largo; i++) {
            System.out.println(((Cliente) clientes.recuperar(i)).toString() + ". ");
        }
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Pasajes");
        System.out.println("~~~~~~~~~~~~~~");
        Iterator it = h.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            Lista aux = (Lista) pair.getValue();
            largo = aux.longitud();
            if (largo > 0) {
                System.out.println("Documento cliente: " + ((ClaveCliente) pair.getKey()).toString());
                System.out.println("Pasajes:");
                for (int i = 1; i <= largo; i++) {
                    System.out.print(aux.recuperar(i) + ", ");
                }
                System.out.println("\n.........");
            }
        }

    }

    public static void ConsultasSobreTiemposdeViaje(Grafo a) {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.println("Elija una opción: \n 1) Darnos dos aereopuertos y le decimos si es posible llegar del primero al segundo"
                    + "en algún número como máximo de vuelos. \n 2) Darnos dos aereopuertos y le decimos el camino del primero al segundo en el menor tiempo de vuelo."
                    + "\n 3) Nada.");
            int resp = TecladoIn.readLineInt();
            switch (resp) {
                case 1:
                    System.out.println("Como se llama el primer aereopuerto? (Nombre aereonáutico)");
                    String nombre1 = teclado.nextLine();
                    System.out.println("Como se llama el segundo aereopuerto? (Nombre aereonáutico)");
                    String nombre2 = teclado.nextLine();
                    System.out.println("Cual es su limite de vuelos?");
                    int cant = TecladoIn.readLineInt();
                    boolean posible = caminoEnXVuelos(cant, nombre1, nombre2, a);
                    if (posible) {
                        System.out.println("Si! Es posible.");
                    } else {
                        System.out.println("Lo lamentamos,es imposible hacer ese viaje en menos de o en " + cant + " vuelos.");
                    }
                    break;
                case 2:
                    System.out.println("Como se llama el primer aereopuerto? (Nombre aereonáutico)");
                    String nombreA = teclado.nextLine();
                    System.out.println("Como se llama el segundo aereopuerto? (Nombre aereonáutico)");
                    String nombreB = teclado.nextLine();
                    Aeropuerto aux1 = new Aeropuerto(nombreA);
                    Aeropuerto aux2 = new Aeropuerto(nombreB);
                    if (a.existeVertice(aux1) && a.existeVertice(aux2)) {
                        Lista liviano = a.liviano(aux1, aux2);
                        int largo = liviano.longitud();
                        Lista nombresLiviano = new Lista();
                        for (int i = 1; i <= largo; i++) {
                            nombresLiviano.insertar(((Aeropuerto) liviano.recuperar(i)).getNombre(), i);
                        }
                        System.out.println("Camino de menor tiempo posible: " + nombresLiviano);
// ESTA MAL EL METODO CORREGIRRRRR
                    }
                    break;
                case 3:
                    seguir = false;
                    break;
            }
        }
    }

    public static boolean caminoEnXVuelos(int cant, String a1, String a2, Grafo aereo) {
        boolean res = false;
        Aeropuerto aux = new Aeropuerto(a1);
        Aeropuerto aux2 = new Aeropuerto(a2);
        if (aereo.existeVertice(aux) && aereo.existeVertice(aux2)) {
            Aeropuerto origen = (Aeropuerto) aereo.getElemento(aux);
            Aeropuerto destino = (Aeropuerto) aereo.getElemento(aux2);
            Lista camino = aereo.caminoMasCorto(origen, destino);
            res = camino.longitud() - 1 <= cant;
        }
        return res;
    }

    public static void ConsultasVuelos(TablaDeBusqueda v) {
        Scanner teclado = new Scanner(System.in);
        boolean seg = true;
        while (seg) {
            System.out.println("Elija una opción. "
                    + "1) Mostrar información de un vuelo."
                    + "2) Mostrar nombres de vuelos existentes en un rango decidido por usted."
                    + "3) Nada.");
            int respuesta = TecladoIn.readLineInt();
            switch (respuesta) {
                case 1:
                    ConsultaVuelos1(v);
                    break;
                case 2:
                    System.out.println("Diganos el nombre del primer vuelo.");
                    String v1 = teclado.nextLine();
                    ClaveVuelo aux1 = new ClaveVuelo(v1);
                    System.out.println("Ahora el del segundo vuelo.");
                    String v2 = teclado.nextLine();
                    ClaveVuelo aux2 = new ClaveVuelo(v2);
                    if (v.existeClave(aux1) && v.existeClave(aux2)) {
                        ClaveVuelo primer = (ClaveVuelo) v.getClave(aux1);
                        ClaveVuelo segundo = (ClaveVuelo) v.getClave(aux2);
                        Lista rangoVuelos = null;
                        if (primer.compareTo(segundo) <= 0) {
                            rangoVuelos = v.listarRango(primer, segundo);
                        } else {
                            rangoVuelos = v.listarRango(segundo, primer);
                        }
                        System.out.println("q onda");
                        Lista nombres = new Lista();
                        int largo = rangoVuelos.longitud();
                        for (int i = 1; i <= largo; i++) {
                            nombres.insertar(((ClaveVuelo) rangoVuelos.recuperar(i)).getClave(), i);
                        }
                        System.out.println("Vuelos en el rango deseado: " + nombres);
                    } else {
                        System.out.println("Vuelos inexistentes.");
                    }

                    break;
                case 3:
                    seg = false;
                default:
                    System.out.println("Opción errónea.");
            }
        }

    }

    // PREGUNTAR SOBRE FECHASSSS
    public static void ConsultaVuelos1(TablaDeBusqueda v) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos el nombre del vuelo");
        String nombreVuelo = teclado.nextLine();
        ClaveVuelo claveV = new ClaveVuelo(nombreVuelo);
        if (v.existeClave(claveV)) {
            System.out.println("Y la fecha");
            System.out.println("get clave:");
            ClaveVuelo clave = (ClaveVuelo) v.getClave(claveV);
            System.out.println("obtener info: ");
            Vuelo nuevo = (Vuelo) v.obtenerInformacion(clave);
            System.out.println("Información del vuelo: \n" + nuevo.mostrarInfo());
        }
    }

    public static Lista pasajesPendientes(HashMap h, ClaveCliente clave) {
        // Preguntar por iterator
        Lista aux = (Lista) h.get(clave);
        Lista res = new Lista();
        int largo = aux.longitud();
        int j = 1;
        for (int i = 1; i <= largo; i++) {
            Pasaje n = (Pasaje) aux.recuperar(i);
            System.out.println("pasaje " + n + ", estado del pasaje: " + n.getEstado());
            if (n.getEstado() == 0) {
                System.out.println("pasó el equals");
                res.insertar(n, j);
                j++;
            }

        }
        return res;
    }

    public static Lista pasajesVolados(HashMap h, ClaveCliente clave) {
        // Preguntar por iterator
        Lista aux = (Lista) h.get(clave);
        Lista res = new Lista();
        int largo = aux.longitud();
        int j = 1;
        for (int i = 1; i <= largo; i++) {
            Pasaje n = (Pasaje) aux.recuperar(i);
            System.out.println("estado n: " + n.getEstado());
            if (n.getEstado() == 1) {
                res.insertar(n, j);
                j++;
            }

        }
        System.out.println(res);
        return res;
    }

    public static void ConsultasCliente(TablaDeBusqueda c, HashMap m, TablaDeBusqueda v) {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) { // Qué es información de contacto?
            System.out.println("Elija una opción. 1: Verificar y mostrar información de contacto de un cliente. 2: Mostrar ciudades visitadas por algún cliente. 3: Nada. ");
            int respuesta = TecladoIn.readLineInt();
            switch (respuesta) {
                case 1:
                    System.out.println("Diganos el tipo de documento del cliente a consultar");
                    String tipoD = teclado.nextLine();
                    System.out.println("Ahora el numero de documento");
                    String nroD = teclado.nextLine();
                    ClaveCliente claveAux = new ClaveCliente(tipoD, nroD);
                    if (c.existeClave(claveAux)) {
                        ClaveCliente claveC = (ClaveCliente) c.getClave(claveAux);
                        System.out.println("Información de contacto: " + ((Cliente) c.obtenerInformacion(claveC)).getNumeroTelefono());
                        Lista pasajesPend = pasajesPendientes(m, claveC);
                        System.out.println("Pasajes pendientes: " + pasajesPend);
                    }
                    break;
                case 2:
                    System.out.println("Diganos el tipo de documento del cliente a consultar");
                    String tipoDo = teclado.nextLine();
                    System.out.println("Ahora el numero de documento");
                    String nroDo = teclado.nextLine();
                    ClaveCliente claveAux2 = new ClaveCliente(tipoDo, nroDo);
                    if (c.existeClave(claveAux2)) {
                        ClaveCliente claveC2 = (ClaveCliente) c.getClave(claveAux2);
                        Lista visitados = new Lista();
                        Lista pasajesVola = pasajesVolados(m, claveC2);
                        int largo = pasajesVola.longitud();
                        for (int i = 1; i <= largo; i++) {
                            String ciudad = ((Pasaje) pasajesVola.recuperar(i)).getCiudadDestino();
                            visitados.insertar(ciudad, i);
                        }
                        System.out.println("Ciudades visitadas: " + visitados);

                    }
                    break;
                case 3:
                    seguir = false;
                    break;
            }
        }
    }

    public static void ABMPasajes(HashMap h, TablaDeBusqueda c, TablaDeBusqueda v, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elija una opcion: \n 1) Agregar pasaje. \n 2) Eliminar pasaje. "
                + "\n 3) Modificar pasaje.");
        int a = TecladoIn.readLineInt();
        switch (a) {
            case 1:
                PasajesCaso1(h, c, v, bw);
                break;
            case 2:
                PasajesCaso2(h, c, v, bw);
                break;
            case 3:
                PasajesCaso3(h, c, v, bw);
                break;

            default:
                break;

        }
    }

    public static void PasajesCaso3(HashMap h, TablaDeBusqueda c, TablaDeBusqueda v, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        System.out.println("Diganos el tipo de documento del cliente");
        String tipo = teclado.nextLine();
        System.out.println("Ahora el numero de documento");
        String nroD = teclado.nextLine();
        ClaveCliente clave = new ClaveCliente(tipo, nroD);
        if (c.existeClave(clave)) {
            ClaveCliente cc = (ClaveCliente) c.getClave(clave);
            Lista pasajes = (Lista) h.get(cc);
            Pasaje pas = (Pasaje) pasajes.recuperar(1);
            System.out.println("Cual era el vuelo? Diganos el nombre clave");
            String claveV = teclado.nextLine();
            ClaveVuelo cv = new ClaveVuelo(claveV);
            if (v.existeClave(cv)) {
                ClaveVuelo claveVuelo = (ClaveVuelo) v.getClave(cv);
                Vuelo vue = (Vuelo) v.obtenerInformacion(claveVuelo);
                int i = 2;
                while (!pas.getVuelo().equals(vue)) {
                    pas = (Pasaje) pasajes.recuperar(i);
                    i++;
                }
                while (seguir) {
                    System.out.println("Que desea modificar del pasaje? 1: Asiento. 2: Vuelo. 3: Estado del pasaje. 4: Nada.");
                    int respuesta = TecladoIn.readLineInt();
                    switch (respuesta) {
                        case 1:
                            System.out.println("Diganos el nuevo asiento");
                            String nuevoA = teclado.nextLine();
                            String viejoA = pas.getAsiento();
                            bw.write("El pasaje " + pas + " cambió del asiento " + viejoA + " al " + nuevoA);
                            bw.newLine();
                            pas.setAsiento(nuevoA);
                            break;
                        case 2:
                            System.out.println("Diganos la clave del nuevo vuelo");
                            String cvuelo = teclado.nextLine();
                            ClaveVuelo aux = new ClaveVuelo(cvuelo);
                            if (v.existeClave(aux)) {
                                Vuelo viejo = pas.getVuelo();
                                ClaveVuelo clav = (ClaveVuelo) v.getClave(aux);
                                Vuelo nuevo = (Vuelo) v.obtenerInformacion(clav);
                                pas.setVuelo(nuevo);
                                bw.write("El pasaje " + pas + " cambió del vuelo " + viejo + " al vuelo " + nuevo);
                                bw.newLine();
                            }
                            break;
                        case 3:
                            System.out.println("Diganos la actualización del pasaje");
                            String estado = teclado.nextLine();
                            switch (estado) {
                                case "Pendiente":
                                    pas.setEstado(0);
                                    bw.write("El pasaje " + pas + " ahora está pendiente");
                                    bw.newLine();
                                    break;
                                case "Cancelado":
                                    pas.setEstado(-1);
                                    bw.write("El pasaje " + pas + " fue cancelado");
                                    bw.newLine();
                                    break;
                                case "Volado":
                                    pas.setEstado(1);
                                    bw.write("El pasaje " + pas + " fue volado");
                                    bw.newLine();
                                    break;
                                default:
                                    break;
                            }
                        case 4:
                            seguir = false;
                            break;
                    }
                }
            }
        }
    }

    public static void PasajesCaso2(HashMap h, TablaDeBusqueda c, TablaDeBusqueda v, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos el tipo de documento del cliente");
        String tipo = teclado.nextLine();
        System.out.println("Ahora el numero de documento");
        String nroD = teclado.nextLine();
        ClaveCliente claveCliente = new ClaveCliente(tipo, nroD);
        if (c.existeClave(claveCliente)) {
            ClaveCliente claveC = (ClaveCliente) c.getClave(claveCliente);
            Lista pasajes = (Lista) h.get(claveC);
            Pasaje pas = (Pasaje) pasajes.recuperar(1);
            System.out.println("Cual era el vuelo? Diganos el nombre clave");
            String claveV = teclado.nextLine();
            ClaveVuelo cvAux = new ClaveVuelo(claveV);
            if (v.existeClave(cvAux)) {
                ClaveVuelo claveVuelo = (ClaveVuelo) v.getClave(cvAux);
                Vuelo vue = (Vuelo) v.obtenerInformacion(claveVuelo);
                int i = 2;
                while (!pas.getVuelo().equals(vue)) {
                    pas = (Pasaje) pasajes.recuperar(i);
                    i++;
                }
                bw.write("El cliente " + claveC.toString() + " canceló su pasaje: " + pas.toString());
                bw.newLine();
                pas.setEstado(-1);
                vue.restarVendidos(1);
            }
        }
    }

    public static void PasajesCaso1(HashMap h, TablaDeBusqueda c, TablaDeBusqueda v, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos el nombre clave del vuelo para el pasaje");
        String claveVuelo = teclado.nextLine();
        ClaveVuelo cv = new ClaveVuelo(claveVuelo);
        boolean existe = v.existeClave(cv);

        if (existe) {
            ClaveVuelo clave = (ClaveVuelo) v.getClave(cv);
            Vuelo delPasaje = (Vuelo) v.obtenerInformacion(clave);
            comprarPasaje(delPasaje, v, h, c, bw);
        }
    }

    public static void comprarPasaje(Vuelo delPasaje, TablaDeBusqueda v, HashMap h, TablaDeBusqueda c, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        if (delPasaje.getAsientosVendidos() < delPasaje.getAsientosTotales()) {
            System.out.println("Tipo de documento del cliente?");
            String tipo = teclado.nextLine();
            System.out.println("Numero de documento?");
            String doc = teclado.nextLine();
            ClaveCliente claveAux = new ClaveCliente(tipo, doc);
            boolean existeCliente = c.existeClave(claveAux);
            if (existeCliente) {
                ClaveCliente clave = (ClaveCliente) c.getClave(claveAux);
                System.out.println("¿Qué fecha tiene el pasaje?");
                String fechaPasaje = teclado.nextLine();
                System.out.println("¿Número de asiento?");
                String nroA = teclado.nextLine();
                Pasaje nuevo = new Pasaje(delPasaje, fechaPasaje, nroA);
                delPasaje.sumarVendidos(1);
                Lista pasajes = (Lista) h.get(clave);
                pasajes.insertar(nuevo, pasajes.longitud() + 1);
                bw.write("El cliente de documento " + clave.toString() + " compró el pasaje " + nuevo);
                bw.newLine();
            } // Preguntar que pasa si no hay cliente
        }
    }

    public static void VuelosCaso1(TablaDeBusqueda v, Grafo g, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cual es el aereopuerto de origen?");
        String nomO = teclado.nextLine();
        Aeropuerto o = new Aeropuerto(nomO);
        System.out.println("Y el de destino?");
        String nomD = teclado.nextLine();
        Aeropuerto d = new Aeropuerto(nomD);
        if (g.existeVertice(d) && g.existeVertice(o)) {
            boolean ok = false;
            String claveVuelo = "";
            while (!ok) {
                System.out.println("Diganos el nombre clave del vuelo");
                claveVuelo = teclado.nextLine();
                ok = verificarClave(claveVuelo);
                if (!ok) {
                    System.out.println("Clave o formato errónea/o, intente de nuevo.");
                }
            }
            ClaveVuelo cv = new ClaveVuelo(claveVuelo);
            System.out.println("Cuántos asientos tiene?");
            int asientos = TecladoIn.readLineInt();
            Aeropuerto origen = (Aeropuerto) g.getElemento(o);
            Aeropuerto destino = (Aeropuerto) g.getElemento(d);
            System.out.println("A que hora sale el vuelo? Ingresar numero de 4 cifras, las primeras 2 la hora, ultimas 2 los minutos. Sin comas ni puntos");
            int horaS = TecladoIn.readLineInt();
            System.out.println("A que hora llega el vuelo? Mismo formato que en la hora de salida.");
            int horaL = TecladoIn.readLineInt();
            int minutos = getMinutos(horaS, horaL);
            if (!g.existeArco(origen, destino)) {
                g.insertarArco(origen, destino, minutos);
            } else {
                Lista etiq = g.getEtiqueta(origen, destino);
                boolean okay = false;
                int i = 1;
                int largo = etiq.longitud();
                while (!okay && i <= largo) {
                    int x = (int) etiq.recuperar(i);
                    if (x == minutos) {
                        okay = true;
                    }
                    i++;
                }
                if (!ok) {
                    g.insertarArco(origen, destino, minutos);
                }
            }
            Vuelo nuevo = new Vuelo(cv, origen, destino, horaS, horaL, asientos);
            boolean a = v.insertar(cv, nuevo);
            if (a) {
                bw.write("Se agrego el vuelo " + nuevo);
                bw.newLine();
            }
        } else {
            System.out.println("Lo sentimos, no existen tales aeropuertos.");
        }
    }

    public static int getMinutos(int horaS, int horaL) {
        int mins = 0, auxMayor, auxMenor;
        if (horaL < horaS) {
            horaL = horaL + 2400;
        }
        auxMayor = (horaL - horaL % 100) - (horaS - horaS % 100);
        while (auxMayor > 0) {
            mins = mins + 60;
            auxMayor = auxMayor - 100;
        }
        int restoSalida = horaS % 100, restoLlegada = horaL % 100;
        if (restoSalida > restoLlegada) {
            mins = mins - (restoSalida - restoLlegada);
        } else if (restoLlegada > restoSalida) {
            mins = mins + (restoLlegada - restoSalida);
        }
        return mins;
    }

    public static boolean verificarClave(String clave) {
        boolean res = Character.isLetter(clave.charAt(0)) && !Character.isLowerCase(clave.charAt(0))
                && Character.isLetter(clave.charAt(1)) && !Character.isLowerCase(clave.charAt(1))
                && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4))
                && Character.isDigit(clave.charAt(5));
        return res;
    }

    public static int sumarMinutos(int s, int m) {
        int l = s;
        while (m >= 60) {
            l = l + 100;
            m = m - 60;
            if (l >= 2400) {
                l = 0000 + l % 2400;
            }
        }
        if (l % 100 + m >= 60) {
            l = l + 100;
            m = (l + m) - 60;
            l = l + m;
        } else {
            l = l + m;
        }
        return l;
    }

    public static void VuelosCaso2(TablaDeBusqueda v, Grafo g, HashMap h, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cual es el aereopuerto de origen?");
//Preguntar sobre si tambien eliminar el arco entre aereopuertos
        String nomOr = teclado.nextLine();
        Aeropuerto orAux = new Aeropuerto(nomOr);
        System.out.println("Y el de destino?");
        String nomDe = teclado.nextLine();
        Aeropuerto desAux = new Aeropuerto(nomDe);
        if (g.existeVertice(orAux) && g.existeVertice(desAux)) {
            Aeropuerto origen = (Aeropuerto) g.getElemento(orAux);
            Aeropuerto destino = (Aeropuerto) g.getElemento(desAux);

            System.out.println("Ahora diganos el nombre clave del vuelo");
            String cvuelo = teclado.nextLine();
            ClaveVuelo aux = new ClaveVuelo(cvuelo);
            if (v.existeClave(aux)) {
                ClaveVuelo cv = (ClaveVuelo) v.getClave(aux);
                Vuelo s = (Vuelo) v.obtenerInformacion(cv);
                //Preguntar sobre eliminación de pasajes.
                //g.eliminarArco(origen, destino);
                eliminarTodosLosPasajesDeUnVuelo(h, v, s, bw);
                boolean a = v.eliminar(cv);
                if (a) {
                    bw.write("Se elminó el vuelo: " + s);
                    bw.newLine();
                }
            }
        }
    }

    public static void VuelosCaso3(TablaDeBusqueda v, Grafo g, HashMap h, TablaDeBusqueda c, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos la clave del vuelo a modificar");
        String clavec = teclado.nextLine();
        ClaveVuelo aux = new ClaveVuelo(clavec);
        if (v.existeClave(aux)) {
            ClaveVuelo clave = (ClaveVuelo) v.getClave(aux);
            Vuelo mod = (Vuelo) v.obtenerInformacion(clave);
            boolean seguir = true;
            while (seguir) {
                System.out.println("Que quiere modificar? 1) Hora salida 2) Hora llegada 3) Asientos vendidos 4) Nada");
                int respuesta = TecladoIn.readLineInt();
                switch (respuesta) {
                    case 1:
                        int salidaVieja = mod.getHoraSalida();
                        System.out.println("Diganos la nueva hora de salida");
                        int sal = TecladoIn.readLineInt();
                        mod.setSalida(sal);
                        Aeropuerto origen = mod.getOrigen();
                        Aeropuerto destino = mod.getDestino();
                        int minutos = getMinutos(sal, mod.getHoraLlegada());
                        g.setEtiqueta(origen, destino, minutos);
                        bw.write("Se cambió la hora de salida del vuelo " + mod + " de " + salidaVieja + " pasó a " + sal + " por lo q tambien se cambió la etiq"
                                + "ueta de su arco a: " + minutos);
                        bw.newLine();
                        break;
                    case 2:
                        int llegadaVieja = mod.getHoraLlegada();
                        System.out.println("Diganos la nueva hora de llegada");
                        int lle = TecladoIn.readLineInt();
                        mod.setLlegada(lle);
                        Aeropuerto origen2 = mod.getOrigen();
                        Aeropuerto destino2 = mod.getDestino();
                        int minutos2 = getMinutos(mod.getHoraSalida(), lle);
                        g.setEtiqueta(origen2, destino2, minutos2);
                        bw.write("Se cambió la hora de llegada del vuelo " + mod + " de " + llegadaVieja + " pasó a " + lle + " por lo q tambien se cambió la etiq"
                                + "ueta de su arco a: " + minutos2);
                        bw.newLine();
                        break;
                    case 3:
                        //Preguntar sobre que hacer con los  pasajes
                        System.out.println("Si se vendieron asientos, presione 1. Si se cancelaron pasajes presione 2");
                        int asien = TecladoIn.readLineInt();
                        if (asien == 1) {
                            System.out.println("Cuantos?");
                            int suma = TecladoIn.readLineInt();
                            if (mod.getAsientosVendidos() + suma <= mod.getAsientosTotales()) {
                                mod.sumarVendidos(suma);
                                for (int i = 1; i <= suma; i++) {
                                    comprarPasaje(mod, v, h, c, bw);
                                }
                            }
                        } else {
                            System.out.println("Cuantos?");
                            int resta = TecladoIn.readLineInt();
                            mod.restarVendidos(resta);
                            for (int i = 1; i <= resta; i++) {
                                eliminarUnPasaje(mod, h, v, c, bw);
                            }
                        }
                }
            }
        }
    }

    public static void eliminarUnPasaje(Vuelo vuelo, HashMap h, TablaDeBusqueda v, TablaDeBusqueda c, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor diganos el tipo de documento del cliente dueño del pasaje a eliminar");
        String tipoD = teclado.nextLine();
        System.out.println("Ahora el número de documento");
        String nroD = teclado.nextLine();
        ClaveCliente claveC = new ClaveCliente(tipoD, nroD);
        Pasaje pas = null;
        if (c.existeClave(claveC)) {
            ClaveCliente cc = (ClaveCliente) c.getClave(claveC);
            Lista pasajes = (Lista) h.get(cc);
            int i = 1;
            int largo = pasajes.longitud();
            boolean seguir = true;
            while (seguir && i <= largo) {
                if (((Pasaje) pasajes.recuperar(i)).getVuelo().equals(vuelo)) {
                    pas = (Pasaje) pasajes.recuperar(i);
                    seguir = false;
                } else {
                    i++;
                }
            }
            if (!seguir) {
                boolean a= pasajes.eliminar(i);
                if(a){
                bw.write("Se eliminó el pasaje " + pas + ", que era del cliente con documento: " + cc.toString());
                }
            }
        }
    }

    public static void ABMVuelos(TablaDeBusqueda v, Grafo g, HashMap h, TablaDeBusqueda c, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elija una opcion: \n 1) Agregar vuelo. \n 2) Sacar vuelo. "
                + "\n 3) Modificar vuelo");
        int a = TecladoIn.readLineInt();
        switch (a) {
            case 1:
                VuelosCaso1(v, g, bw);
                break;
            case 2:
                VuelosCaso2(v, g, h, bw);
                break;
            case 3:
                VuelosCaso3(v, g, h, c, bw);
                break;
        }
    }

    public static void ABMClientes(TablaDeBusqueda c, HashMap h, BufferedWriter bw) throws IOException {
        System.out.println("Elija una opcion: \n 1) Agregar cliente. \n 2) Sacar cliente. "
                + "\n 3) Modificar cliente");
        int a = TecladoIn.readLineInt();
        switch (a) {
            case 1:
                caso1Cliente(c, h, bw);
                break;
            case 2:
                caso2Cliente(c, h, bw);
                break;
            case 3:
                caso3Cliente(c, bw);
                break;
        }
    }

    public static void caso2Cliente(TablaDeBusqueda c, HashMap h, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos el tipo de documento");
        String t = teclado.nextLine();
        System.out.println("y el numero");
        String num = teclado.nextLine();
        ClaveCliente aux = new ClaveCliente(t, num);
        if (c.existeClave(aux)) {
            ClaveCliente clave = (ClaveCliente) c.getClave(aux);
            boolean a= c.eliminar(clave);
            if(a){
            h.remove(clave);
            bw.write("Se eliminó el cliente con tipo y nro de documento: " + clave.toString());
            bw.newLine();}
        }
    }

    public static void caso3Cliente(TablaDeBusqueda c, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos el tipo de documento");
        String ti = teclado.nextLine();
        System.out.println("y el numero");
        String nume = teclado.nextLine();
        ClaveCliente aux = new ClaveCliente(ti, nume);
        if (c.existeClave(aux)) {
            ClaveCliente key = (ClaveCliente) c.getClave(aux);
            Cliente modificable = (Cliente) c.obtenerInformacion(key);
            System.out.println("Si quiere modificar el numero de telefono, responda 'T', si quiere modificar el domicilio responda 'D'");
            char r = TecladoIn.readLineNonwhiteChar();
            if (r == 'T') {
                String nroViejo = modificable.getNumeroTelefono();
                System.out.println("Cual es el nuevo numero?");
                String nuevo = teclado.nextLine();
                modificable.setNumeroTelefono(nuevo);
                bw.write("Se cambió el numero de telefono del cliente " + modificable + ", de " + nroViejo + " pasó a " + nuevo);
                bw.newLine();
            } else {
                if (r == 'D') {
                    String dom = modificable.getDomicilio();
                    System.out.println("Diga el nuevo domicilio");
                    String l = teclado.nextLine();
                    modificable.setDomicilio(l);
                    bw.write("Se cambió el domicilio del cliente " + modificable + ", de " + dom + " pasó a " + l);
                    bw.newLine();
                }
            }
        }
    }

    public static void caso1Cliente(TablaDeBusqueda c, HashMap h, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Diganos los datos del cliente \n Tipo documento?");
        String tipo = teclado.nextLine();
        System.out.println("El numero de documento ahora: ");
        String nro = teclado.nextLine();
        ClaveCliente cc = new ClaveCliente(tipo, nro);
        if (!c.existeClave(cc)) {
            System.out.println("Diganos su nombre");
            String nombre = teclado.nextLine();
            System.out.println("Apellido: ");
            String ap = teclado.nextLine();
            System.out.println("Telefono");
            String tel = teclado.nextLine();
            System.out.println("Y el domicilio");
            String dom = teclado.nextLine();
            Cliente cli = new Cliente(tipo, nro, nombre, ap, tel, dom);
            boolean a = c.insertar(cc, cli);
            if (a) {
                h.put(cc, new Lista());
                bw.write("Se agrego el cliente " + cli);
                bw.newLine();
            }
        }
    }

    public static void ABMAereopuerto(Grafo aereopuertos, TablaDeBusqueda v, HashMap h, BufferedWriter bw) throws IOException {
        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.println("Elija una opcion: \n 1) Agregar aereopuerto. \n 2) Modificar aereopuerto. "
                    + "\n 3) Nada");
            int a = TecladoIn.readLineInt();
            switch (a) {
                case 1:
                    System.out.println("Diganos la clave del nuevo aereopuerto");
                    String nombreClave = teclado.nextLine();

                    Aeropuerto aux = new Aeropuerto(nombreClave);
                    if (!aereopuertos.existeVertice(aux)) {
                        System.out.println("En que ciudad queda el aereopuerto?");
                        String city = teclado.nextLine();
                        System.out.println("Y cuál es el número de teléfono?");
                        int nroTel = TecladoIn.readLineInt();
                        aux = new Aeropuerto(nombreClave, nroTel, city);
                        boolean x = aereopuertos.insertarVertice(aux);
                        if (x) {
                            bw.write("Se agrego el aeropuerto " + aux);
                            bw.newLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Diganos la clave del aereopuerto a modificar");
                    String ar = teclado.nextLine();
                    Aeropuerto x1 = new Aeropuerto(ar);
                    boolean e = aereopuertos.existeVertice(x1);
                    System.out.println(e);
                    if (e) {
                        Aeropuerto m = (Aeropuerto) aereopuertos.getElemento(x1);
                        int nroViejo = m.getTelefono();
                        System.out.println("Ingrese numero de telefono, es lo unico modificable del aereopuerto");
                        int n = TecladoIn.readLineInt();
                        m.setNumero(n);
                        bw.write("Se cambió el número de telefono del aeropuerto " + m + ", pasó de " + nroViejo + " a " + n);
                        bw.newLine();
                    }
                    break;
                case 3:
                    seguir = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void eliminarTodosLosPasajesDeUnVuelo(HashMap h, TablaDeBusqueda v, Vuelo vuelo, BufferedWriter bw) throws IOException {
        Iterator it = h.entrySet().iterator();
        bw.write("Se eliminan todos los pasajes del vuelo: " + vuelo);
        bw.newLine();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            Lista aux = (Lista) pair.getValue();
            int largo = aux.longitud();
            for (int i = 1; i <= largo; i++) {
                Pasaje pas = (Pasaje) aux.recuperar(i);
                if (pas.getVuelo().equals(vuelo)) {
                    bw.write("Se elimina pasaje: " + pas);
                    bw.newLine();
                    pas.setEstado(-1);
                }
            }
        }
        // averiguar bien sobre iterator
    }

}
