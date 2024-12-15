package controlador;

import modelo.juego.Juego;
import vista.grafica.Tablero;

public class MoverJugadorArriba {
    private final Juego juego;
    private final Tablero tablero;
    private ControladorMusicaFx musica = ControladorMusicaFx.getINSTANCIA();

    public MoverJugadorArriba(Tablero tablero, Juego juego) {
        musica.caminar();
        this.juego = juego;
        this.tablero = tablero;
        mover();
    }

    public void mover() {
        this.juego.moverJugadorHaciaArriba();
        tablero.voltearJugadorArriba();
        tablero.imprimir();
    }
}



