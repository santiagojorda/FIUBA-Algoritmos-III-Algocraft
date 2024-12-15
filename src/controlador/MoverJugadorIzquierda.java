package controlador;

import modelo.juego.Juego;
import vista.grafica.Tablero;

public class MoverJugadorIzquierda {
    private final Tablero tablero;
    private final Juego juego;
    private ControladorMusicaFx musica = ControladorMusicaFx.getINSTANCIA();

    public MoverJugadorIzquierda(Tablero tablero, Juego juego) {
        musica.caminar();
        this.tablero = tablero;
        this.juego = juego;
        mover();
    }

    public void mover() {
        this.juego.moverJugadorHaciaIzquierda();
        tablero.voltearJugadorIzquierda();
        tablero.imprimir();
    }
}


