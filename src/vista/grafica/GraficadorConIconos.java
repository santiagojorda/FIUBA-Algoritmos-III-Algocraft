package vista.grafica;

import controlador.ControladorDeClicksItemsMovibles;
import controlador.SeleccionarCelda;
import javafx.scene.canvas.Canvas;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.mapa.Posicion;

public class GraficadorConIconos extends GraficadorMapa {
    protected ItemInventario itemSeleccionado;

    public GraficadorConIconos(int columnas, int filas, Canvas canvas, Juego juego) {
        super(columnas, filas, canvas, juego);
        canvas.setOnMouseClicked(e -> ControladorDeClicksItemsMovibles.seleccionarItem(SeleccionarCelda.seleccionarCelda(this, e), itemSeleccionado, this));
    }

    @Override
    protected void cargarInformacion() {
    }

    @Override
    public boolean hayItemEn(Posicion posicion) {
        return false;
    }

    @Override
    public void borrarItemEn(Posicion posicionInicial) {
    }

    @Override
    public void posicionarItem(Posicion posicionFinal, ItemInventario itemFinal) {
    }
}
