package modelo.jugador;

import modelo.excepciones.ItemSeRompioError;
import modelo.excepciones.NoHayElementoEnEstaPosicionError;
import modelo.excepciones.NoHayUnItemEquipadoError;
import modelo.herramientas.Herramienta;
import modelo.mapa.Boss;
import modelo.mapa.Posicion;
import modelo.materiales.Bloque;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JugadorTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnJugadorConUnHachaDeMaderaEnElInventario() {
        Jugador jugador = new Jugador();
        ItemInventario hacha = jugador.obtenerItemEn(new Posicion(0, 0));
        Bloque madera = new Madera().crearBloque();
        double durabilidadInicial = madera.obtenerDurabilidad();
        hacha.usarContra(madera);
        assertEquals(durabilidadInicial - 2, madera.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02ElJugadorSeEquipaUnHachaDeMaderaYLaUsaContraUnBloqueDeMaderaDesgastandoloEn2() throws NoHayUnItemEquipadoError {
        Bloque bloque = new Madera().crearBloque();
        Jugador jugador = new Jugador();
        jugador.equiparItemEnPosicion(new Posicion(0, 0));
        jugador.usarContra(bloque);
        assertEquals(8, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03ElJugadorIntentaAtacarSinTenerNingunArmaEquipadaYrecibeUnaExcepcion() {
        Jugador jugador = new Jugador();
        Bloque madera = new Madera().crearBloque();
        thrown.expect(NoHayUnItemEquipadoError.class);
        jugador.usarContra(madera);
    }

    @Test
    public void test04ElJugadorIntentaAtacarConUnaHerramientaSinDurabilidadYEsEliminadaDeSuInventarioLanzandoUnaExcepcionAlIntentarObtenerlo() {
        Jugador jugador = new Jugador();
        Herramienta hacha = Madera.crearHacha();
        Posicion posicion = new Posicion(1, 0);
        jugador.guardarItem(posicion, hacha);
        jugador.equiparItemEnPosicion(posicion);
        for (int i = 0; i < 50; i++) {
            jugador.usarContra(new Madera().crearBloque());
        }
        thrown.expect(NoHayElementoEnEstaPosicionError.class);
        jugador.obtenerItemEn(posicion);
    }

    @Test
    public void test05ElJugadorEliminaUnItemDelInventarioYEsaPosicionQuedaLibre() {
        Jugador jugador = new Jugador();
        Herramienta hacha = Madera.crearHacha();
        Posicion posicion = new Posicion(1, 0);
        jugador.guardarItem(posicion, hacha);
        boolean esLugarOcupadoInicial = jugador.hayUnItemEnInventarioEn(posicion);
        jugador.eliminarItem(posicion);
        boolean esLugarOcupadoFinal = jugador.hayUnItemEnInventarioEn(posicion);
        assertNotEquals(esLugarOcupadoFinal, esLugarOcupadoInicial);
        assertEquals(false, esLugarOcupadoFinal);
    }

    @Test
    public void test06SiElJugadorEliminaUnObjetoEquipadoSeDesequipaAutomaticamente() {
        Jugador jugador = new Jugador();
        Herramienta hacha = Madera.crearHacha();
        Posicion posicion = new Posicion(1, 0);
        jugador.guardarItem(posicion, hacha);
        jugador.equiparItemEnPosicion(posicion);
        jugador.eliminarItem(posicion);
        thrown.expect(NoHayUnItemEquipadoError.class);
        jugador.usarContra(new Madera().crearBloque());
    }

    @Test
    public void test07SeQuiereEliminarUnItemDelInventarioYEsteSeEncuentraEquipadoYLoDesequipaYLuegoLoBorra() {
        Jugador jugador = new Jugador();
        Herramienta espadaDeDiamante = Diamante.crearEspada();
        Posicion posicion = new Posicion(1, 0);
        jugador.eliminarItem(posicion);
        jugador.guardarItem(posicion, espadaDeDiamante);
        jugador.equiparItemEnPosicion(posicion);
        Boss boss = new Boss("unBoss");
        thrown.expect(ItemSeRompioError.class);
        jugador.usarContra(boss);
    }
}
