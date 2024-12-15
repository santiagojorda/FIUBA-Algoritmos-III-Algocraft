package modelo.juego;

import modelo.excepciones.*;
import modelo.herramientas.Herramienta;
import modelo.jugador.ItemInventario;
import modelo.jugador.Jugador;
import modelo.mapa.Item;
import modelo.mapa.Posicion;
import modelo.mapa.Tablero;
import modelo.materiales.ItemAtacable;
import modelo.mesaDeCrafteo.MesaDeCrafteo;

public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private MesaDeCrafteo mesaDeCrafteo;

    public Juego() {
        jugador = new Jugador();
        mesaDeCrafteo = new MesaDeCrafteo();
        tablero = new Tablero(10, 10, jugador);
    }

    public void moverJugadorHaciaArriba() {
        try {
            tablero.moverJugadorHaciaArriba();
        } catch (MovimientoInvalidoError exception) {
        }
    }

    public void moverJugadorHaciaAbajo() {
        try {
            tablero.moverJugadorHaciaAbajo();
        } catch (MovimientoInvalidoError exception) {
        }
    }

    public void moverJugadorHaciaDerecha() {
        try {
            tablero.moverJugadorHaciaDerecha();
        } catch (MovimientoInvalidoError exception) {
        }
    }

    public void moverJugadorHaciaIzquierda() {
        try {
            tablero.moverJugadorHaciaIzquierda();
        } catch (MovimientoInvalidoError exception) {
        }
    }

    public Posicion posicionJugador() {
        return tablero.posicionJugador();
    }

    public Herramienta crearHerramienta() throws CrafteoIncorrectoError {
        return mesaDeCrafteo.crearHerramienta();
    }

    public void colocarItemEnElTablero(Item unItem, Posicion unaPosicion) throws LugarOcupadoError {
        tablero.colocarItemEnTablero(unaPosicion, unItem);
    }

    public Item obtenerItemEnTablero(Posicion posicion) throws NoExistePosicionEnElMapaError, NoHayElementoEnEstaPosicionError {
        return tablero.obtenerItemEnTablero(posicion);
    }

    public boolean hayItemEnTablero(Posicion posicionCliqueada) throws NoHayElementoEnEstaPosicionError {
        return tablero.hayItemEn(posicionCliqueada);
    }

    public void agregarObjetoAlInventario(ItemInventario item) throws NoHayMasEspacioEnElInventarioError {
        this.jugador.guardarItem(item);
    }

    public void agregarObjetoAlInventario(Posicion posicion, ItemInventario item) throws LugarOcupadoError, NoExistePosicionEnElMapaError {
        jugador.guardarItem(posicion, item);
    }

    public String obtenerNombreItemEnInventario(Posicion posicion) throws NoExistePosicionEnElMapaError, NoHayElementoEnEstaPosicionError {
        return jugador.obtenerItemEn(posicion).obtenerNombre();
    }

    public int obtenerCantidadItemsEnInventario() {
        return this.jugador.obtenerCantidadItemsEnInventario();
    }

    public ItemInventario obtenerItemEnInventario(Posicion posicion) throws NoExistePosicionEnElMapaError, NoHayElementoEnEstaPosicionError {
        return jugador.obtenerItemEn(posicion);
    }

    public void agregarItemMesaCrafteo(Posicion posicion, ItemInventario item) throws NoExistePosicionEnElMapaError, LugarOcupadoError {
        mesaDeCrafteo.agregarItem(item, posicion);
    }

    public String obtenerNombreItemEnMesaCrafteo(Posicion posicion) throws NoHayElementoEnEstaPosicionError, NoExistePosicionEnElMapaError {
        return mesaDeCrafteo.obtenerNombreItem(posicion);
    }

    public void usarHerramientaEquipadaEn(Posicion unaPosicion) throws NoSeDesgastaError, MurioElBoss, NoTieneMaterialParaSoltar, NoPuedePegarConEsteItem, ItemSeRompioError, NoHayUnItemEquipadoError, NoSePuedePegarAlJugador {
        if (elJugadorSeEncuentraAMasDeUnBloqueDeDistancia(unaPosicion)) {
            throw new JugadorNoSeEncuentraEnElRangoDeAtacaError();
        } else if (tablero.esElJugador(unaPosicion)) {
            throw new NoSePuedePegarAlJugador();
        }
        try {
            ItemAtacable item = (ItemAtacable) tablero.obtenerItemEnTablero(unaPosicion);
            jugador.usarContra(item);
        } catch (ItemSeRompioError Exception) {
            ItemAtacable itemRoto = (ItemAtacable) tablero.obtener(unaPosicion).obtenerObjeto();
            ItemInventario materialSoltado = itemRoto.soltarMaterial();
            jugador.guardarItem(materialSoltado);
            tablero.eliminarItemEnElTablero(unaPosicion);
            throw new ItemSeRompioError();
        }
    }

    private boolean elJugadorSeEncuentraAMasDeUnBloqueDeDistancia(Posicion unaPosicion) {
        boolean fueraDelRangoDeFilas = (unaPosicion.fila() < posicionJugador().fila() - 1 || unaPosicion.fila() > posicionJugador().fila() + 1);
        boolean fueraDelRangoDeColumna = (unaPosicion.columna() < posicionJugador().columna() - 1 || unaPosicion.columna() > posicionJugador().columna() + 1);
        return (fueraDelRangoDeFilas || fueraDelRangoDeColumna);
    }

    public boolean hayItemEnLaMesaDeCrafteoEn(Posicion posicion) throws NoExistePosicionEnElMapaError {
        return mesaDeCrafteo.hayItemEn(posicion);
    }

    public boolean hayItemEnInventarioEn(Posicion posicion) throws NoExistePosicionEnElMapaError {
        return jugador.hayUnItemEnInventarioEn(posicion);
    }

    public void equiparItemEnPosicion(Posicion posicionItem) throws NoHayElementoEnEstaPosicionError, NoExistePosicionEnElMapaError {
        jugador.equiparItemEnPosicion(posicionItem);
    }

    public String obtenerNombreItemEquipado() throws NoHayUnItemEquipadoError {
        return jugador.obtenerNombreObjetoEquipado();
    }

    public void eliminarItemInventario(Posicion posicion) {
        jugador.eliminarItem(posicion);
    }

    public void eliminarItemMesaCrafteo(Posicion posicion) {
        mesaDeCrafteo.eliminarItem(posicion);
    }

    public ItemInventario obtenerItemEnMesaCrafteo(Posicion posicion) throws NoExistePosicionEnElMapaError, NoHayElementoEnEstaPosicionError {
        return mesaDeCrafteo.obtenerItem(posicion);
    }
}