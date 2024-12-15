package modelo.mapa;

import modelo.jugador.Jugador;
import modelo.materiales.Madera;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CeldaTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnaCeldaSinNingunElemento() {
        CeldaMapa unaCelda = new CeldaMapa();
        assertTrue(unaCelda.estaVacia());
    }

    @Test
    public void test02SeLeAgregaUnBloqueDeMaderaALaCeldaCorrectamente() {
        CeldaMapa unaCelda = new CeldaMapa();
        Item unItem = new Madera().crearBloque();
        unaCelda.colocarObjeto(unItem);
        assertFalse(unaCelda.estaVacia());
    }

    @Test
    public void test03SeLeBorraUnObjetoAUnaCeldaCargadaYVuelveAQuedarVacia() {
        CeldaMapa unaCelda = new CeldaMapa();
        Item unItem = new Madera().crearBloque();
        unaCelda.colocarObjeto(unItem);
        unaCelda.eliminarObjeto();
        assertTrue(unaCelda.estaVacia());
    }

    @Test
    public void test04SeLeBorraUnObjetoAUnaCeldaVaciaYLaCeldaSigueVacia() {
        CeldaMapa unaCelda = new CeldaMapa();
        Item unItem = new Madera().crearBloque();
        unaCelda.colocarObjeto(unItem);
        unaCelda.eliminarObjeto();
        assertTrue(unaCelda.estaVacia());
    }

    @Test
    public void test05SeLeAgregaUnJugadorALaCeldaCorrectamente() {
        CeldaMapa unaCelda = new CeldaMapa();
        Item unItem = new Jugador();
        unaCelda.colocarObjeto(unItem);
        assertFalse(unaCelda.estaVacia());
    }

    @Test
    public void test06UnaCeldaEstaOcupadaYSeLePreguntaSiEstaOcupadaDevuelveTrue() {
        CeldaMapa unaCelda = new CeldaMapa();
        Item unItem = new Jugador();
        unaCelda.colocarObjeto(unItem);
        assertTrue(unaCelda.estaOcupada());
    }

    @Test
    public void test07UnaCeldaEstaLibreYSeLePreguntaSiEstaOcupadaDevuelveFalse() {
        CeldaMapa unaCelda = new CeldaMapa();
        assertFalse(unaCelda.estaOcupada());
    }
}
