package vista.grafica;

import controlador.ControladorDeImpresiones;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.mapa.Mapeador;
import modelo.mapa.Posicion;

public abstract class GraficadorMapa extends Mapeador<CeldaGrafica> implements Imprimible {
    protected Juego juego;
    protected int tamanoCelda;
    protected GraphicsContext gc;
    GestionadorDeImagenes gestionadorDeImagenes = new GestionadorDeImagenes();
    Posicion ultimaPosicionCliqueada;

    public GraficadorMapa(int columnas, int filas, Canvas canvas, Juego juego) {
        super(columnas, filas);
        tamanoCelda = (int) (canvas.getHeight() / cantidadFilas);
        this.juego = juego;
        this.gc = canvas.getGraphicsContext2D();
        ControladorDeImpresiones.agregarObjeto(this);
        cargarInformacion();
    }

    public Image obtenerImagen(String nombreObjeto) {
        return gestionadorDeImagenes.obtenerImagen(nombreObjeto);
    }

    public synchronized void imprimir() {
            cargarInformacion();
            for (int y = 0; y < cantidadFilas; y++) {
                for (int x = 0; x < cantidadColumnas; x++) {
                    imprimirCelda(new Posicion(x, y));
                }
            }
    }
    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return getClass() == obj.getClass();
    }

    protected void imprimirCelda(Posicion posicion) {
        CeldaGrafica celdaMapa = obtener(posicion);
        celdaMapa.imprimir();
    }

    public Posicion obtenerPosicionSelecionada() {
        return ultimaPosicionCliqueada;
    }

    protected abstract void cargarInformacion();

    public Posicion obtenerPosicionCorrespondiente(int xSeleccionado, int ySeleccionado) {
        for (int x = 0; x < cantidadColumnas; x++) {
            for (int y = 0; y < cantidadFilas; y++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda = obtener(posicion);
                if (celda.elPuntoEstaDentro(xSeleccionado, ySeleccionado)) {
                    ultimaPosicionCliqueada = posicion;
                }
                celda.imprimir();
            }
        }
        return ultimaPosicionCliqueada;
    }

    public abstract boolean hayItemEn(Posicion posicion);

    public abstract void borrarItemEn(Posicion posicionInicial);

    public abstract void posicionarItem(Posicion posicionFinal, ItemInventario itemFinal);
}