package controlador;

import modelo.juego.Juego;
import vista.grafica.Tablero;

public class MoverJugadorAbajo {
    private final Tablero tablero;
    private final Juego juego;
    private ControladorMusicaFx musica = ControladorMusicaFx.getINSTANCIA();

    public MoverJugadorAbajo(Tablero tablero, Juego juego) {
        musica.caminar();
        this.tablero = tablero;
        this.juego = juego;
        mover();
    }

    public void mover() {
        this.juego.moverJugadorHaciaAbajo();
        tablero.voltearJugadorAbajo();
        tablero.imprimir();
    }
}


