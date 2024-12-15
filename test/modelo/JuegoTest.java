package modelo;

import modelo.excepciones.*;
import modelo.herramientas.Herramienta;
import modelo.herramientas.HerramientaNormal;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.jugador.Jugador;
import modelo.mapa.Item;
import modelo.mapa.Posicion;
import modelo.materiales.Bloque;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class JuegoTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01ElJugadorSeMueveHaciaArriba() {
        Juego miJuego = new Juego();
        Posicion posicionInicial = miJuego.posicionJugador();
        miJuego.moverJugadorHaciaArriba();
        Posicion posicionFinal = miJuego.posicionJugador();
        posicionInicial.decrementarFila();
        Posicion posicionEsperada = new Posicion(posicionInicial.columna(), posicionInicial.fila());
        assertEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void test02ElJugadorSeMueveHaciaAbajo() {
        Juego miJuego = new Juego();
        Posicion posicionInicial = miJuego.posicionJugador();
        miJuego.moverJugadorHaciaAbajo();
        Posicion posicionFinal = miJuego.posicionJugador();
        posicionInicial.incrementarFila();
        Posicion posicionEsperada = new Posicion(posicionInicial.columna(), posicionInicial.fila());
        assertEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void test03ElJugadorSeMueveHaciaDerecha() {
        Juego miJuego = new Juego();
        Posicion posicionInicial = miJuego.posicionJugador();
        miJuego.moverJugadorHaciaDerecha();
        Posicion posicionFinal = miJuego.posicionJugador();
        posicionInicial.incrementarColumna();
        Posicion posicionEsperada = new Posicion(posicionInicial.columna(), posicionInicial.fila());
        assertEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void test04ElJugadorSeMueveHaciaIzquierda() {
        Juego miJuego = new Juego();
        Posicion posicionInicial = miJuego.posicionJugador();
        miJuego.moverJugadorHaciaIzquierda();
        Posicion posicionFinal = miJuego.posicionJugador();
        posicionInicial.decrementarColuma();
        Posicion posicionEsperada = new Posicion(posicionInicial.columna(), posicionInicial.fila());
        assertEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void test05SeColocaUnBloqueADosPosicionesDelJugadorYAlMoverseHastaEsaPosicionSeQuedaUnPasoAtras() {
        Juego miJuego = new Juego();
        Posicion posicionInicial = miJuego.posicionJugador();
        miJuego.moverJugadorHaciaIzquierda();
        Posicion posicionFinal = miJuego.posicionJugador();
        posicionInicial.decrementarColuma();
        Posicion posicionEsperada = new Posicion(posicionInicial.columna(), posicionInicial.fila());
        assertEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void test06SeColocaUnBloqueDeMaderaALaDerechaDelJugadorYAlIntentarMoverseSobreElSeQuedaEnElLugar() {
        Juego miJuego = new Juego();
        Posicion posicionInicialJugador = miJuego.posicionJugador();
        miJuego.colocarItemEnElTablero(new Madera().crearBloque(), new Posicion(8, 7));
        miJuego.moverJugadorHaciaDerecha();
        Posicion posicionFinalJugador = miJuego.posicionJugador();
        assertEquals(posicionFinalJugador, posicionInicialJugador);
    }

    @Test
    public void test07SeColocaUnBloqueDeMaderaArribaDelJugadorYAlIntentarMoverseSobreElSeQuedaEnElLugar() {
        Juego miJuego = new Juego();
        Posicion posicionInicialJugador = miJuego.posicionJugador();
        miJuego.colocarItemEnElTablero(new Madera().crearBloque(), new Posicion(7, 6));
        miJuego.moverJugadorHaciaArriba();
        Posicion posicionFinalJugador = miJuego.posicionJugador();
        assertEquals(posicionFinalJugador, posicionInicialJugador);
    }

    @Test
    public void test08SeColocaUnBloqueDeMaderaAbajoDelJugadorYAlIntentarMoverseSobreElSeQuedaEnElLugar() {
        Juego miJuego = new Juego();
        Posicion posicionInicialJugador = miJuego.posicionJugador();
        miJuego.colocarItemEnElTablero(new Madera().crearBloque(), new Posicion(7, 8));
        miJuego.moverJugadorHaciaAbajo();
        Posicion posicionFinalJugador = miJuego.posicionJugador();
        assertEquals(posicionFinalJugador, posicionInicialJugador);
    }

    @Test
    public void test09SeobtieneElNombreDelHachaDeMaderaComoPrimerHerramientaDelInventarioLuegodeCrearseElJugador() {
        Juego miJuego = new Juego();
        String primerHerramienta = miJuego.obtenerNombreItemEnInventario(new Posicion(0, 0));
        String hachaDeMadera = "hacha de madera";
        assertEquals(primerHerramienta, hachaDeMadera);
    }

    @Test
    public void test10SeObtieneElNombreDelPicoDeMaderaComoSegundaHerramientaLuegoDeAgregarloAlInventario() {
        Juego miJuego = new Juego();
        HerramientaNormal pico = Madera.crearPico();
        miJuego.agregarObjetoAlInventario(pico);
        String segundaHerramienta = miJuego.obtenerNombreItemEnInventario(new Posicion(1, 0));
        String picoDeMadera = "pico de madera";
        assertEquals(segundaHerramienta, picoDeMadera);
    }

    @Test
    public void test11SeObtieneElNombreDelPicoDePiedraComoTercerHerramientaLuegoDeAgregarElPicoDePiedraAlInventario() {
        Juego miJuego = new Juego();
        HerramientaNormal pico = Madera.crearPico();
        miJuego.agregarObjetoAlInventario(pico);
        HerramientaNormal picoPiedra = Piedra.crearPico();
        miJuego.agregarObjetoAlInventario(picoPiedra);
        String terceraHerramienta = miJuego.obtenerNombreItemEnInventario(new Posicion(2, 0));
        String picoDePiedra = "pico de piedra";
        assertEquals(terceraHerramienta, picoDePiedra);
    }

    @Test
    public void test12SeObtieneUnSoloItemEnElInventarioDespuesDeInicializarElJuego() {
        Juego miJuego = new Juego();
        int cantidadItems = miJuego.obtenerCantidadItemsEnInventario();
        assertEquals(cantidadItems, 1);
    }

    @Test
    public void test13SeAgregaUnItemAlInventarioDespuesDeInicializarElJuegoYSeObtienenDosItems() {
        Juego miJuego = new Juego();
        HerramientaNormal pico = Madera.crearPico();
        miJuego.agregarObjetoAlInventario(pico);
        int cantidadItems = miJuego.obtenerCantidadItemsEnInventario();
        assertEquals(cantidadItems, 2);
    }

    @Test
    public void test14UnJugadorRompeUnBloqueYSeAgregaASuInventario() throws NoHayUnItemEquipadoError {
        Jugador jugador = new Jugador();
        Bloque unBloque = new Madera().crearBloque();
        Herramienta hacha = Metal.crearHacha();
        Posicion posicionHacha = new Posicion(1, 0);
        jugador.guardarItem(hacha);
        int objetosIniciales = jugador.obtenerCantidadItemsEnInventario();
        jugador.equiparItemEnPosicion(posicionHacha);
        thrown.expect(ItemSeRompioError.class);
        jugador.usarContra(unBloque);
        int objetosFinales = jugador.obtenerCantidadItemsEnInventario();
        assertEquals(objetosIniciales + 1, objetosFinales);
    }

    @Test
    public void test15UnJugadorNoRompeUnBloquePorqueEstaFueraDeRangoYSeLanzaUnaExcepcion() throws NoHayUnItemEquipadoError, NoSePuedePegarAlJugador {
        Juego juego = new Juego();
        Posicion diamante = new Posicion(5, 2);
        thrown.expect(JugadorNoSeEncuentraEnElRangoDeAtacaError.class);
        juego.usarHerramientaEquipadaEn(diamante);
    }

    @Test
    public void test16SeIntentaEquiparUnaHerramientaYSePuede() {
        Juego juego = new Juego();
        Posicion posicion = new Posicion(0, 0);
        juego.equiparItemEnPosicion(posicion);
        assertEquals(juego.obtenerNombreItemEnInventario(posicion), (juego.obtenerNombreItemEquipado()));
    }

    @Test
    public void test17SeEquipaUnEspacioVacioYSeLanzaUnaExcepcion() {
        Juego juego = new Juego();
        Posicion posicion = new Posicion(1, 1);
        thrown.expect(NoHayElementoEnEstaPosicionError.class);
        juego.equiparItemEnPosicion(posicion);
    }

    @Test
    public void test18SeCargaCorrectamenteLaMesaDeCrafteoAlPonerUnaMadera() {
        Juego juego = new Juego();
        juego.agregarItemMesaCrafteo(new Posicion(0, 0), new Madera());
        String nombre = juego.obtenerNombreItemEnMesaCrafteo(new Posicion(0, 0));
        assertEquals("madera", nombre);
    }

    @Test
    public void test19SeCreaUnHachaConLaMesaDeCrafteo() {
        Juego juego = new Juego();
        juego.agregarItemMesaCrafteo(new Posicion(0, 0), new Madera());
        juego.agregarItemMesaCrafteo(new Posicion(0, 1), new Madera());
        juego.agregarItemMesaCrafteo(new Posicion(1, 0), new Madera());
        juego.agregarItemMesaCrafteo(new Posicion(1, 1), new Madera());
        juego.agregarItemMesaCrafteo(new Posicion(1, 2), new Madera());
        Herramienta hacha = juego.crearHerramienta();
        hacha.usarContra(new Madera().crearBloque());
        assertEquals(98, hacha.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test20SeObtieneUnItemDelTableroCorrectamente() {
        Juego juego = new Juego();
        Item item = juego.obtenerItemEnTablero(new Posicion(7, 7));
        assertEquals("jugador", item.obtenerNombre());
    }

    @Test
    public void test21SeQuiereObtenerUnItemDelTableroEnUnaPosicionFueraDeRango() {
        Juego juego = new Juego();
        thrown.expect(NoExistePosicionEnElMapaError.class);
        juego.obtenerItemEnTablero(new Posicion(-2, -4));
    }

    @Test
    public void test22SeQuiereAgregarItemAlMapaEnUnaPosicionOcupadaYNoPuede() {
        Juego juego = new Juego();
        thrown.expect(LugarOcupadoError.class);
        juego.colocarItemEnElTablero(new Madera().crearBloque(), new Posicion(7, 7));
    }

    @Test
    public void test23SeAgregarUnItemAlTableroEnUnaPosicionLibreCorrectamente() {
        Juego juego = new Juego();
        juego.colocarItemEnElTablero(new Jugador(), new Posicion(0, 0));
        Item item = juego.obtenerItemEnTablero(new Posicion(0, 0));
        assertEquals("jugador", item.obtenerNombre());
    }

    @Test
    public void test24SeIntentaSaberSiHayUnItemEnUnaPosicionFueraDelTableroYLanzaExcepcion() {
        Juego juego = new Juego();
        thrown.expect(NoExistePosicionEnElMapaError.class);
        juego.hayItemEnTablero(new Posicion(-1, 2));
    }

    @Test
    public void test25SeIntentaObtenerItemEnUnaPosicionFueraDelMapaYDevuelveUnaExcepcion() {
        Juego juego = new Juego();
        thrown.expect(NoExistePosicionEnElMapaError.class);
        juego.hayItemEnTablero(new Posicion(-1, 2));
    }

    @Test
    public void test26SeIntentaEquiparUnItemFueraDelRangoDeInventarioYDevuelveUnaExcepcion() {
        Juego juego = new Juego();
        thrown.expect(NoExistePosicionEnElMapaError.class);
        juego.equiparItemEnPosicion(new Posicion(-1, -1));
    }

    @Test
    public void test27SeIntentaAgregarUnItemAUnEspacioOcupadoDelInventarioYDevuelveUnaExcepcion() {
        Juego juego = new Juego();
        Posicion posicionAgregada = new Posicion(2, 1);
        juego.agregarObjetoAlInventario(posicionAgregada, new Madera());
        thrown.expect(LugarOcupadoError.class);
        juego.agregarObjetoAlInventario(posicionAgregada, new Madera());
    }

    @Test
    public void test28ElJugadorSeQuierePegarASiMismoYLanzaUnaExcepcion() throws NoHayUnItemEquipadoError, NoSePuedePegarAlJugador {
        Juego juego = new Juego();
        Posicion posicionJugador = new Posicion(7, 7);
        thrown.expect(NoSePuedePegarAlJugador.class);
        juego.usarHerramientaEquipadaEn(posicionJugador);
    }

    @Test
    public void test29ElJugadorAgregaUnMAterialALaMesaDeCrafteoYSeOCupaElLugarConEseMaterialLuegoLoEliminaYSeDesocupa() {
        Juego juego = new Juego();
        ItemInventario madera = new Madera();
        Posicion posicion = new Posicion(0, 0);
        juego.agregarItemMesaCrafteo(posicion, madera);
        assertEquals(true, juego.hayItemEnLaMesaDeCrafteoEn(posicion));
        assertEquals("madera", juego.obtenerNombreItemEnMesaCrafteo(posicion));
        juego.eliminarItemMesaCrafteo(posicion);
        assertEquals(false, juego.hayItemEnLaMesaDeCrafteoEn(posicion));
    }

    @Test
    public void test30MuevoElJugadorAlLadoDeUnBloqueLoGolpeoYSeDesgasta() throws NoSePuedePegarAlJugador {
        Juego juego = new Juego();
        juego.equiparItemEnPosicion(new Posicion(0, 0));
        juego.moverJugadorHaciaIzquierda();
        juego.moverJugadorHaciaIzquierda();
        Posicion posicionBloque = new Posicion(4, 7);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        Bloque bloque = (Bloque) juego.obtenerItemEnTablero(posicionBloque);
        assertEquals(8, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test31MuevoElJugadorAlLadoDeUnBloqueLoGolpeoHastaQueSeRompeYSeAgregaAlInventario() throws NoSePuedePegarAlJugador {
        Juego juego = new Juego();
        juego.equiparItemEnPosicion(new Posicion(0, 0));
        juego.moverJugadorHaciaIzquierda();
        juego.moverJugadorHaciaIzquierda();
        Posicion posicionBloque = new Posicion(4, 7);
        int itemsIniciales = juego.obtenerCantidadItemsEnInventario();
        thrown.expect(ItemSeRompioError.class);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        juego.usarHerramientaEquipadaEn(posicionBloque);
        int itemsFinales = juego.obtenerCantidadItemsEnInventario();
        assertEquals(itemsIniciales + 1, itemsFinales);
        assertEquals("madera", juego.obtenerNombreItemEnInventario(new Posicion(1, 0)));
    }

    @Test
    public void test32SeQuiereEliminarItemYloHaceCorrectamente() {
        Juego juego = new Juego();
        Posicion posicion = new Posicion(2, 2);
        ItemInventario item = new Madera();
        juego.agregarObjetoAlInventario(posicion, item);
        juego.eliminarItemInventario(posicion);
        thrown.expect(NoHayElementoEnEstaPosicionError.class);
        juego.obtenerItemEnInventario(posicion);
    }
}





