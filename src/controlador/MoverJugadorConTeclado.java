package controlador;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.juego.Juego;
import vista.grafica.Tablero;

public class MoverJugadorConTeclado {
    private KeyEvent keyEvent;

    public MoverJugadorConTeclado(Tablero tablero, Juego juego, KeyEvent keyEvent) {
        this.keyEvent = keyEvent;
        if (seMovioParaArriba())
            new MoverJugadorArriba(tablero, juego);
        else if (seMovioParaAbajo())
            new MoverJugadorAbajo(tablero, juego);
        else if (seMovioParaLaIzquierda())
            new MoverJugadorIzquierda(tablero, juego);
        else if (seMovioParaLaDerecha())
            new MoverJugadorDerecha(tablero, juego);
    }

    private boolean seTocoLaTecla(KeyCode tecla) {
        return keyEvent.getCode() == tecla;
    }

    private boolean seMovioParaArriba() {
        return (seTocoLaTecla(KeyCode.W) || seTocoLaTecla(KeyCode.UP));
    }

    private boolean seMovioParaAbajo() {
        return (seTocoLaTecla(KeyCode.S) || seTocoLaTecla(KeyCode.DOWN));
    }

    private boolean seMovioParaLaDerecha() {
        return (seTocoLaTecla(KeyCode.D) || seTocoLaTecla(KeyCode.RIGHT));
    }

    private boolean seMovioParaLaIzquierda() {
        return (seTocoLaTecla(KeyCode.A) || seTocoLaTecla(KeyCode.LEFT));
    }
}
