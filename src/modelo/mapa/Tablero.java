package modelo.mapa;

import controlador.ControladorMovimientosBoss;
import modelo.excepciones.LugarOcupadoError;
import modelo.excepciones.MovimientoInvalidoError;
import modelo.excepciones.MurioElBoss;
import modelo.excepciones.NoExistePosicionEnElMapaError;
import modelo.jugador.Jugador;
import modelo.materiales.*;

public class Tablero extends Mapeador<CeldaMapa> {
    private Jugador jugador;
    private Posicion posicionJugador;
    private ControladorMovimientosBoss controladorBoss;

    public Tablero(int columnas, int filas, Jugador jugador) {
        super(columnas, filas);
        this.jugador = jugador;
        inicializar();
        generarMapa();
        controladorBoss = new ControladorMovimientosBoss(this);
        controladorBoss.mover();
    }

    protected void inicializar() {
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                CeldaMapa celda = new CeldaMapa();
                colocar(new Posicion(x, y), celda);
            }
        }
    }

    private void inicializarJugador() {
        posicionJugador = new Posicion(7, 7);
        CeldaMapa celdaJugador = obtener(posicionJugador);
        celdaJugador.colocarObjeto(jugador);
    }

    public boolean hayItemEn(Posicion posicion) throws NoExistePosicionEnElMapaError {
        return obtener(posicion).estaOcupada();
    }

    public void generarMapa() {
        colocarGruposBloques(new Posicion(1, 4), new Posicion(4, 7), new Madera());
        colocarGruposBloques(new Posicion(1, 1), new Posicion(2, 2), new Metal());
        colocarGruposBloques(new Posicion(5, 1), new Posicion(6, 1), new Diamante());
        colocarGruposBloques(new Posicion(8, 3), new Posicion(8, 6), new Piedra());
        inicializarJugador();
    }

    private void colocarGruposBloques(Posicion posInicial, Posicion posFinal, Material unMaterial) {
        for (int x = posInicial.columna(); x <= posFinal.columna(); x++) {
            for (int y = posInicial.fila(); y <= posFinal.fila(); y++) {
                Posicion posicion = new Posicion(x, y);
                CeldaMapa celda = obtener(posicion);
                celda.colocarObjeto(unMaterial.crearBloque());
            }
        }
    }

    public Posicion posicionJugador() {
        return posicionJugador;
    }

    private void actualizarPosicion(Posicion unaPosicion) throws MovimientoInvalidoError {
        if (!estaDentroDeLosLimites(unaPosicion)) {
            throw new MovimientoInvalidoError();
        }
        CeldaMapa unaCelda = obtener(unaPosicion);
        try {
            unaCelda.colocarObjeto(jugador);
        } catch (LugarOcupadoError Exception) {
            throw new MovimientoInvalidoError();
        }
        intercambiarPor(unaPosicion, unaCelda);
        obtener(posicionJugador).eliminarObjeto();
        posicionJugador = unaPosicion;
    }

    public boolean esPosicionLibre(Posicion unaPosicion) {
        return obtener(unaPosicion).estaVacia();
    }

    public void colocarItemEnTablero(Posicion posicion, Item unItem) throws LugarOcupadoError, NoExistePosicionEnElMapaError {
        CeldaMapa unaCelda = obtener(posicion);
        unaCelda.colocarObjeto(unItem);
    }

    public void moverJugadorHaciaArriba() {
        Posicion temporal = new Posicion(posicionJugador.columna(), posicionJugador.fila());
        temporal.decrementarFila();
        actualizarPosicion(temporal);
    }

    public void moverJugadorHaciaAbajo() {
        Posicion temporal = new Posicion(posicionJugador.columna(), posicionJugador.fila());
        temporal.incrementarFila();
        actualizarPosicion(temporal);
    }

    public void moverJugadorHaciaDerecha() {
        Posicion temporal = new Posicion(posicionJugador.columna(), posicionJugador.fila());
        temporal.incrementarColumna();
        actualizarPosicion(temporal);
    }

    public void moverJugadorHaciaIzquierda() {
        Posicion temporal = new Posicion(posicionJugador.columna(), posicionJugador.fila());
        temporal.decrementarColuma();
        actualizarPosicion(temporal);
    }

    public void eliminarItemEnElTablero(Posicion posicion) {
        obtener(posicion).eliminarObjeto();
        if (esElBoss(posicion)) {
            controladorBoss.matarAlBoss();
            throw new MurioElBoss();
        }
    }

    public boolean esElBoss(Posicion posicion) {
        return controladorBoss.esElBoss(posicion);
    }

    public void moverBoss(Posicion posicion) {
        controladorBoss.mover(posicion);
    }

    public boolean esElJugador(Posicion unaPosicion) {
        return posicionJugador.equals(unaPosicion);
    }

    public Item obtenerItemEnTablero(Posicion posicion) {
        return obtener(posicion).obtenerObjeto();
    }
}
