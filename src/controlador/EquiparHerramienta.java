package controlador;

import modelo.excepciones.NoHayElementoEnEstaPosicionError;
import modelo.excepciones.NoHayUnItemEquipadoError;
import modelo.juego.Juego;
import modelo.mapa.Posicion;

public class EquiparHerramienta {
    public EquiparHerramienta(Juego juego, Posicion posicionItem) {
        ControladorDeClicksItemsMovibles.borrarClicks();
        try {
            juego.equiparItemEnPosicion(posicionItem);
            ControladorDeImpresiones.imprimirEstado("Tiene en sus manos: " + juego.obtenerNombreItemEquipado());
        } catch (NoHayUnItemEquipadoError e) {
        }
        catch (NoHayElementoEnEstaPosicionError e) {
            ControladorDeImpresiones.imprimirEstado("Elige una item para equipar!");
        }
    }
}
