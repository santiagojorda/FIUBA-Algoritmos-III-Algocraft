package controlador;

import modelo.jugador.ItemInventario;
import modelo.mapa.Posicion;
import vista.grafica.GraficadorMapa;

public class ControladorDeClicksItemsMovibles {
    private static Posicion posicionInicial;
    private static GraficadorMapa graficarInicial;
    private static ItemInventario itemInicial;
    private static Posicion posicionFinal;
    private static GraficadorMapa graficarFinal;

    private static void borrarClickInicial() {
        posicionInicial = null;
        graficarInicial = null;
        itemInicial = null;
    }

    public static void borrarClicks(){
        borrarClickFinal();
        borrarClickInicial();
    }

    private static void borrarClickFinal() {
        posicionFinal = null;
        graficarFinal = null;
    }

    private static boolean estaVacio(Posicion posicion) {
        return posicion == null;
    }

    private static void intercambiar() {
        if (graficarInicial.hayItemEn(posicionInicial)) {
            if (!graficarFinal.hayItemEn(posicionFinal)) {
                graficarInicial.borrarItemEn(posicionInicial);
                graficarFinal.posicionarItem(posicionFinal, itemInicial);
                ControladorDeImpresiones.imprimir();
                ControladorDeImpresiones.imprimirEstado("Se ha intercambiado correctamente de posicion!");
            } else {
                ControladorDeImpresiones.imprimirEstado("No puedes colocar el item aca!");
            }
        }
    }

    public static void seleccionarItem(Posicion posicionClick, ItemInventario item, GraficadorMapa graficarOrigen) {
        if (estaVacio(posicionInicial)) {
            itemInicial = item;
            posicionInicial = posicionClick;
            graficarInicial = graficarOrigen;
            if(graficarOrigen.hayItemEn(posicionClick)){
                ControladorDeImpresiones.imprimirEstado("Hiciste click en " + item.obtenerNombre());
            }
            else
                ControladorDeImpresiones.imprimirEstado("Hiciste click en " + posicionClick.columna() + "," + posicionClick.fila());


        } else if (estaVacio(posicionFinal)) {
            posicionFinal = posicionClick;
            graficarFinal = graficarOrigen;

            intercambiar();
            borrarClicks();
        }
    }



    public static Boolean fueEn(GraficadorMapa grafico) {
        return grafico.equals(graficarInicial);
    }

    public static Posicion obtenerPrimeraPosicion() {
        return posicionInicial;
    }
}
