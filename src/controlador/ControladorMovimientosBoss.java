package controlador;

import modelo.excepciones.LugarOcupadoError;
import modelo.excepciones.NoExistePosicionEnElMapaError;
import modelo.mapa.Boss;
import modelo.mapa.Posicion;
import modelo.mapa.Tablero;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ControladorMovimientosBoss {
    private Tablero tablero;
    private Posicion posicionBoss;
    private Boss boss;

    public ControladorMovimientosBoss(Tablero tablero) {
        this.tablero = tablero;
        boss = new Boss("ghost");
        colocarEnTablero();
    }

    private void colocarEnTablero() {
        int columnaInicial = (int) (Math.random() * tablero.obtenerCantidadColumnas());
        int filaInicial = (int) (Math.random() * tablero.obtenerCantidadFilas());
        posicionBoss = new Posicion(columnaInicial, filaInicial);
        while (!tablero.esPosicionLibre(posicionBoss)) {
            columnaInicial = (int) (Math.random() * tablero.obtenerCantidadColumnas());
            filaInicial = (int) (Math.random() * tablero.obtenerCantidadFilas());
            posicionBoss = new Posicion(columnaInicial, filaInicial);
        }
        tablero.colocarItemEnTablero(posicionBoss, boss);
    }

    public void mover(Posicion posicion) {
        try {
            tablero.obtener(posicion).colocarObjeto(boss);
            tablero.obtener(posicionBoss).eliminarObjeto();
            posicionBoss = posicion;
        } catch (LugarOcupadoError Exception) {
        } catch (NoExistePosicionEnElMapaError e) {
        }
    }

    public void mover() {
        if (estaVivo()) {
            Timer temporizador = new Timer();
            TimerTask tarea = new TimerTask() {
                @Override
                public void run() {
                    if (estaVivo()) {
                        Posicion posicion = obtenerPosicionAleatoriaAlrededor(posicionBoss);
                        tablero.moverBoss(posicion);
                        ControladorDeImpresiones.imprimir();
                        mover();
                    } else {
                        posicionBoss = null;
                    }
                }
            };
            temporizador.schedule(tarea, 1500);
        }
    }

    private boolean estaVivo() {
        return posicionBoss != null;
    }

    public boolean esElBoss(Posicion posicion) {
        return posicionBoss.equals(posicion);
    }

    public void matarAlBoss() {
        posicionBoss = null;
    }

    private Posicion obtenerPosicionAleatoriaAlrededor(Posicion posicion) {
        int movimientoColumas = new Random().nextInt(3) - 1;
        int movimientoFilas = new Random().nextInt(3) - 1;
        return new Posicion(posicion.columna() + movimientoColumas, posicion.fila() + movimientoFilas);
    }
}
