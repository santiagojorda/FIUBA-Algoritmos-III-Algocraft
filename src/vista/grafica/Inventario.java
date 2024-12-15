package vista.grafica;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.mapa.Posicion;

public class Inventario extends GraficadorConIconos {
    public Inventario(Canvas canvas, Juego juego) {
        super(6, 3, canvas, juego);
    }

    @Override
    public void borrarItemEn(Posicion posicion) {
        juego.eliminarItemInventario(posicion);
    }

    @Override
    public void posicionarItem(Posicion posicion, ItemInventario item) {
        juego.agregarObjetoAlInventario(posicion, item);
    }

    protected void cargarInformacion() {
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda;
                if (hayItemEn(posicion)) {
                    Image imagenItem = obtenerImagen(juego.obtenerNombreItemEnInventario(posicion));
                    celda = new CeldaGraficaConImagen(gc, posicion, tamanoCelda, imagenItem);
                } else {
                    celda = new CeldaGraficaColor(gc, posicion, tamanoCelda);
                }
                intercambiarPor(posicion, celda);
            }
        }
    }

    public boolean hayItemEn(Posicion posicion) {
        return juego.hayItemEnInventarioEn(posicion);
    }

    @Override
    public Posicion obtenerPosicionCorrespondiente(int xSeleccionado, int ySeleccionado) {
        for (int x = 0; x < cantidadColumnas; x++) {
            for (int y = 0; y < cantidadFilas; y++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda = obtener(posicion);
                if (celda.elPuntoEstaDentro(xSeleccionado, ySeleccionado)) {
                    ultimaPosicionCliqueada = celda.getPosicionReal();
                    if (hayItemEn(posicion)) {
                        itemSeleccionado = juego.obtenerItemEnInventario(posicion);
                    }
                }
                celda.imprimir();
            }
        }
        return ultimaPosicionCliqueada;
    }
}
