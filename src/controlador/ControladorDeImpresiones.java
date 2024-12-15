package controlador;

import javafx.scene.control.Label;
import vista.grafica.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeImpresiones {
    private static Label consola;
    private static List<Imprimible> objetosImprimibles = new ArrayList<>();

    private static boolean hayObjetosParaImprimir() {
        return objetosImprimibles.size() != 0;
    }

    public static void agregarObjeto(Imprimible objetoImprimible) {
        objetosImprimibles.add(objetoImprimible);
    }

    public static void imprimir() {
        if (hayObjetosParaImprimir()) {
            for (Imprimible objeto : objetosImprimibles) {
                objeto.imprimir();
            }
        }
    }


    public static void agregarConsola(Label label) {
        consola = label;
    }

    public static void mostrarInfoInicio() {
        consola.setText("Bienvenido! puede jugar con los botones o con las flechas" + "\n"
                + "Para pasar items a la mesa de crafteo haga click en el item deseado \n" +
                "y luego la posicion en la que lo quiere mover");
    }

    public static void imprimirEstado(String informacion) {
        if (consola != null) {
            consola.setText(informacion);
        }
    }
}
