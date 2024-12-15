package vista.grafica;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import modelo.mapa.Posicion;

public class CeldaGraficaConImagen extends CeldaGrafica {
    private Image imagenFondo = null;
    private Image imagenSuperior = null;

    public CeldaGraficaConImagen(GraphicsContext gc, Posicion posicion, int tamanoCelda, Image imagenSuperior) {
        super(gc, posicion, tamanoCelda);
        this.gc = gc;
        this.imagenSuperior = imagenSuperior;
    }

    public CeldaGraficaConImagen(GraphicsContext gc, Posicion posicion, int tamanoCelda, Image imagenFondo, Image imagenSuperior) {
        super(gc, posicion, tamanoCelda);
        this.imagenFondo = imagenFondo;
        this.imagenSuperior = imagenSuperior;
    }

    public void imprimir() {
        if(colorFondo != null){
            imprimirColor(colorFondo);

        }
        if (imagenFondo != null) {
            imprimirImagen(imagenFondo);
        }
        imprimirImagen(imagenSuperior);
    }
}
