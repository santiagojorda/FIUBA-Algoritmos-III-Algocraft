package modelo.mapa;

import modelo.excepciones.MurioElBoss;
import modelo.jugador.Jugador;
import modelo.materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TableroTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SePosicionaAlJugadorCorrectamente() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        assertFalse(unTablero.esPosicionLibre(new Posicion(7, 7)));
    }

    @Test
    public void test02SePosicionaMetalEnElMapaCorrectamente() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Bloque bloque = new Metal().crearBloque();
        Posicion posicionBloque = new Posicion(5, 5);
        unTablero.colocarItemEnTablero(posicionBloque, bloque);
        assertFalse(unTablero.esPosicionLibre(posicionBloque));
    }

    @Test
    public void test03SePosicionaDiamanteEnElMapaCorrectamente() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Bloque bloque = new Diamante().crearBloque();
        Posicion posicionBloque = new Posicion(5, 5);
        unTablero.colocarItemEnTablero(posicionBloque, bloque);
        assertFalse(unTablero.esPosicionLibre(posicionBloque));
    }

    @Test
    public void test04SePosicionaMaderaEnElMapaCorrectamente() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Bloque bloque = new Madera().crearBloque();
        Posicion posicionBloque = new Posicion(5, 5);
        unTablero.colocarItemEnTablero(posicionBloque, bloque);
        assertFalse(unTablero.esPosicionLibre(posicionBloque));
    }

    @Test
    public void test05SePosicionaPiedraEnElMapaCorrectamente() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Bloque bloque = new Piedra().crearBloque();
        Posicion posicionBloque = new Posicion(5, 5);
        unTablero.colocarItemEnTablero(posicionBloque, bloque);
        assertFalse(unTablero.esPosicionLibre(posicionBloque));
    }

    @Test
    public void test06unaPosicionEstaOcupada() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Bloque bloque = new Piedra().crearBloque();
        Posicion posicionBloque = new Posicion(28, 28);
        unTablero.colocarItemEnTablero(posicionBloque, bloque);
        assertFalse(unTablero.esPosicionLibre(posicionBloque));
    }

    @Test
    public void test07unaPosicionLibre() {
        Tablero unTablero = new Tablero(30, 30, new Jugador());
        Posicion posicion = new Posicion(26, 26);
        assertTrue(unTablero.esPosicionLibre(posicion));
    }

    @Test
    public void test07SeIntentaObtenerUnaCeldaVaciaDelTableroYSeLanzaUnaExcepcion() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        Posicion posicion = new Posicion(6, 7);
        unTablero.obtener(posicion);
        assertTrue(unTablero.obtener(posicion).estaVacia());
    }

    @Test
    public void test08ElBossSeEncuentraEnLaPosicionConsultada() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        unTablero.moverBoss(new Posicion(6, 6));
        assertTrue(unTablero.esElBoss(new Posicion(6, 6)));
    }

    @Test
    public void test09ElBossSeEncuentraEnLaPosicionConsultada() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        Posicion posicionBoss = new Posicion(6, 6);
        unTablero.moverBoss(posicionBoss);
        assertTrue(unTablero.esElBoss(posicionBoss));
    }

    @Test
    public void test10SeIntentaEliminarUnItemEnElTableroDondeSeEncuentraElBossYEsteEnviaUnaExcepcion() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        Posicion posicionBoss = new Posicion(6, 6);
        unTablero.moverBoss(posicionBoss);
        thrown.expect(MurioElBoss.class);
        unTablero.eliminarItemEnElTablero(posicionBoss);
    }

    @Test
    public void test11SeQuiereEliminarUnaPosicionVaciaYLaCeldaSigueVacia() {
        Jugador jugador = new Jugador();
        Tablero unTablero = new Tablero(30, 30, jugador);
        unTablero.moverBoss(new Posicion(8, 9));
        Posicion posicionBorrada = new Posicion(7, 6);
        unTablero.eliminarItemEnElTablero(posicionBorrada);
        assertTrue(unTablero.esPosicionLibre(posicionBorrada));
    }
}
