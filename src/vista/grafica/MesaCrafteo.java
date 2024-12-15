package vista.grafica;

import controlador.ControladorDeImpresiones;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import modelo.excepciones.CrafteoIncorrectoError;
import modelo.excepciones.NoHayMasEspacioEnElInventarioError;
import modelo.herramientas.Herramienta;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.mapa.Posicion;

public class MesaCrafteo extends GraficadorConIconos {
    public MesaCrafteo(Canvas canvas, Juego juego) {
        super(3, 3, canvas, juego);
    }

    public boolean hayItemEn(Posicion posicion) {
        return juego.hayItemEnLaMesaDeCrafteoEn(posicion);
    }

    @Override
    public void borrarItemEn(Posicion posicion) {
        juego.eliminarItemMesaCrafteo(posicion);
    }

    @Override
    public void posicionarItem(Posicion posicion, ItemInventario item) {
        agregarItem(posicion, item);
    }

    @Override
    protected void cargarInformacion() {
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda;
                if (hayItemEnLaMesaDeCrafteoEn(posicion)) {
                    Image imagenItem = obtenerImagen(juego.obtenerNombreItemEnMesaCrafteo(posicion));
                    celda = new CeldaGraficaConImagen(gc, posicion, tamanoCelda, imagenItem);
                } else {
                    celda = new CeldaGraficaColor(gc, posicion, tamanoCelda);
                }
                intercambiarPor(posicion, celda);
            }
        }
    }

    public boolean hayItemEnLaMesaDeCrafteoEn(Posicion posicion) {
        return juego.hayItemEnLaMesaDeCrafteoEn(posicion);
    }

    public void agregarItem(Posicion posicion, ItemInventario item) {
        juego.agregarItemMesaCrafteo(posicion, item);
        comprararCreacion();
    }

    public void comprararCreacion() {
        try {
            Herramienta herramienta = juego.crearHerramienta();
            juego.agregarObjetoAlInventario(herramienta);
        } catch (CrafteoIncorrectoError Exception) {
        } catch (NoHayMasEspacioEnElInventarioError Exception) {
            ControladorDeImpresiones.imprimirEstado("No Hay mas lugar en el inventario");
        }
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
                        itemSeleccionado = juego.obtenerItemEnMesaCrafteo(posicion);
                    }
                }
                celda.imprimir();
            }
        }
        return ultimaPosicionCliqueada;
    }
}
