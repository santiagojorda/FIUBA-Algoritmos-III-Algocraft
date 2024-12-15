package vista.grafica;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.mapa.Posicion;

public abstract class CeldaGrafica extends Thread {
    protected Posicion posicionInicial;
    protected Posicion posicionFinal;
    protected Posicion posicionReal;
    protected int tamano;
    protected GraphicsContext gc;
    protected Paint colorFondo = Color.valueOf("#909090");

    public CeldaGrafica(GraphicsContext gc, Posicion posicion, int tamano) {
        this.gc = gc;
        this.tamano = tamano;
        this.posicionReal = new Posicion(posicion.columna(), posicion.fila());
        this.posicionInicial = new Posicion((tamano * posicion.columna()), (tamano * posicion.fila()));
        this.posicionFinal = new Posicion((posicionInicial.columna()) + tamano, (posicionInicial.fila()) + tamano);
    }

    public Posicion getPosicionReal() {
        return posicionReal;
    }

    private boolean estaEntreX(int x) {
        return (posicionInicial.columna() <= x) && (x < posicionFinal.columna());
    }

    private boolean estaEntreY(int y) {
        return (posicionInicial.fila() <= y) && (y < posicionFinal.fila());
    }

    public boolean elPuntoEstaDentro(int x, int y) {
        return estaEntreX(x) && estaEntreY(y);
    }

    protected    void imprimirColor(Paint color) {
        gc.setFill(color);
        gc.fillRect(posicionInicial.columna(), posicionInicial.fila(), tamano, tamano);

    }

    protected void imprimirImagen(Image imagen) {
        gc.drawImage(imagen, posicionInicial.columna(), posicionInicial.fila(), tamano, tamano);
    }

    public abstract void imprimir();
}
