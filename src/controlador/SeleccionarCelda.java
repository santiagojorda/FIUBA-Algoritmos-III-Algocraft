package controlador;

import javafx.scene.input.MouseEvent;
import modelo.mapa.Posicion;
import vista.grafica.GraficadorMapa;

public class SeleccionarCelda {
    public static Posicion seleccionarCelda(GraficadorMapa graficador, MouseEvent e) {
        return graficador.obtenerPosicionCorrespondiente((int) e.getX(), (int) e.getY());
    }
}
