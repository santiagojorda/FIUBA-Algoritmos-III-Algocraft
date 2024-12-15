package modelo.mesaDeCrafteo;

import modelo.excepciones.CrafteoIncorrectoError;
import modelo.excepciones.SeRompioItemAtacadoYElItemAtacador;
import modelo.herramientas.Herramienta;
import modelo.jugador.ItemInventario;
import modelo.mapa.Boss;
import modelo.mapa.Posicion;
import modelo.materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MesaDeCrafteoTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnaHachaDeMaderaDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario madera = new Madera();
        mesa.agregarItem(madera, new Posicion(0, 0));
        mesa.agregarItem(madera, new Posicion(1, 0));
        mesa.agregarItem(madera, new Posicion(2, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta hacha = mesa.crearHerramienta();
        Bloque bloqueMadera = new Madera().crearBloque();
        double durabilidadInicial = bloqueMadera.obtenerDurabilidad();
        hacha.usarContra(bloqueMadera);
        assertEquals(durabilidadInicial, bloqueMadera.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeCreaUnaHachaDePiedraDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario piedra = new Piedra();
        ItemInventario madera = new Madera();
        mesa.agregarItem(piedra, new Posicion(0, 0));
        mesa.agregarItem(piedra, new Posicion(0, 1));
        mesa.agregarItem(piedra, new Posicion(1, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta hacha = mesa.crearHerramienta();
        Bloque bloqueMadera = new Madera().crearBloque();
        double durabilidadInicial = bloqueMadera.obtenerDurabilidad();
        hacha.usarContra(bloqueMadera);
        assertEquals(durabilidadInicial - 5, bloqueMadera.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03SeCreaUnaHachaDeMetalDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario metal = new Metal();
        ItemInventario madera = new Madera();
        mesa.agregarItem(metal, new Posicion(0, 1));
        mesa.agregarItem(metal, new Posicion(1, 0));
        mesa.agregarItem(metal, new Posicion(0, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta hacha = mesa.crearHerramienta();
        System.out.println(hacha.obtenerNombre());
        Bloque bloquePiedra = new Piedra().crearBloque();
        double durabilidadInicial = bloquePiedra.obtenerDurabilidad();
        hacha.usarContra(bloquePiedra);
        assertEquals(durabilidadInicial, bloquePiedra.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test04SeCreaUnPicoDeMaderaDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario madera = new Madera();
        mesa.agregarItem(madera, new Posicion(0, 0));
        mesa.agregarItem(madera, new Posicion(1, 0));
        mesa.agregarItem(madera, new Posicion(2, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta pico = mesa.crearHerramienta();
        Bloque bloqueMetal = new Metal().crearBloque();
        double durabilidadInicial = bloqueMetal.obtenerDurabilidad();
        pico.usarContra(bloqueMetal);
        assertEquals(durabilidadInicial, bloqueMetal.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test05SeCreaUnPicoDePiedraDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario piedra = new Piedra();
        ItemInventario madera = new Madera();
        mesa.agregarItem(piedra, new Posicion(0, 0));
        mesa.agregarItem(piedra, new Posicion(1, 0));
        mesa.agregarItem(piedra, new Posicion(2, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta pico = mesa.crearHerramienta();
        Bloque bloqueMetal = new Metal().crearBloque();
        double durabilidadInicial = bloqueMetal.obtenerDurabilidad();
        pico.usarContra(bloqueMetal);
        assertEquals(durabilidadInicial - 4, bloqueMetal.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test06SeCreaUnPicoDeMetalDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario metal = new Metal();
        ItemInventario madera = new Madera();
        mesa.agregarItem(metal, new Posicion(0, 0));
        mesa.agregarItem(metal, new Posicion(1, 0));
        mesa.agregarItem(metal, new Posicion(2, 0));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta pico = mesa.crearHerramienta();
        Bloque bloqueMetal = new Metal().crearBloque();
        double durabilidadInicial = bloqueMetal.obtenerDurabilidad();
        pico.usarContra(bloqueMetal);
        assertEquals(durabilidadInicial - 12, bloqueMetal.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test07SeCreaUnPicoFinoDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario metal = new Metal();
        ItemInventario piedra = new Piedra();
        ItemInventario madera = new Madera();
        mesa.agregarItem(metal, new Posicion(0, 0));
        mesa.agregarItem(metal, new Posicion(1, 0));
        mesa.agregarItem(metal, new Posicion(2, 0));
        mesa.agregarItem(piedra, new Posicion(0, 1));
        mesa.agregarItem(madera, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta picoFino = mesa.crearHerramienta();
        Bloque bloqueMetal = new Metal().crearBloque();
        double durabilidadInicial = picoFino.obtenerDurabilidad();
        picoFino.usarContra(bloqueMetal);
        assertEquals(picoFino.obtenerDurabilidad(), durabilidadInicial, EPSILON);
    }

    @Test
    public void test08SeCreaUnaEspadaDeDiamanteDesdeUnaMesaDeCrafteo() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario diamante = new Diamante();
        ItemInventario madera = new Madera();
        mesa.agregarItem(diamante, new Posicion(1, 0));
        mesa.agregarItem(diamante, new Posicion(1, 1));
        mesa.agregarItem(madera, new Posicion(1, 2));
        Herramienta espada = mesa.crearHerramienta();
        Boss boss = new Boss("boss");
        thrown.expect(SeRompioItemAtacadoYElItemAtacador.class);
        espada.usarContra(boss);
    }

    @Test
    public void test09SeIntentaCrearUnaHerramientaMalYSeRecibeCrafteoIncorrectoError() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        ItemInventario madera = new Madera();
        mesa.agregarItem(madera, new Posicion(0, 0));
        mesa.agregarItem(madera, new Posicion(0, 1));
        thrown.expect(CrafteoIncorrectoError.class);
        mesa.crearHerramienta();
    }

    @Test
    public void test10AgregoUnBloqueDeMaderaEnLaPosicionColumna0Fila0Correctamente() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion = new Posicion(0, 0);
        Material madera = new Madera();
        mesa.agregarItem(madera, posicion);
        assertEquals(madera, mesa.obtenerItem(posicion));
    }

    @Test
    public void test11AgregoUnItemALaRecetaYSeOcupaElLugar() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion = new Posicion(0, 0);
        Material madera = new Madera();
        mesa.agregarItem(madera, posicion);
        boolean mesaOcupada = true;
        assertEquals(mesaOcupada, mesa.hayItemEn(posicion));
        assertEquals("madera", mesa.obtenerNombreItem(posicion));
    }

    @Test
    public void test12AgregoUnItemALaRecetaYAlBorrarloSeDesocupaElLugar() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion = new Posicion(0, 0);
        Material madera = new Madera();
        mesa.agregarItem(madera, posicion);
        mesa.eliminarItem(posicion);
        boolean mesaOcupada = true;
        assertNotEquals(mesaOcupada, mesa.hayItemEn(posicion));
    }
}
