package vista.grafica;

import javafx.scene.canvas.GraphicsContext;
import modelo.mapa.Posicion;

public class CeldaGraficaColor extends CeldaGrafica {
    public CeldaGraficaColor(GraphicsContext gc, Posicion posicion, int tamanoCelda) {
        super(gc, posicion, tamanoCelda);
    }

    public synchronized void imprimir() {
        imprimirColor(colorFondo);
    }
}
