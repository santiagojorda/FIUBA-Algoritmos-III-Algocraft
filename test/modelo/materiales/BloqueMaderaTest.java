package modelo.materiales;

import modelo.excepciones.ItemSeRompioError;
import modelo.herramientas.HerramientaNormal;
import modelo.herramientas.PicoFino;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BloqueMaderaTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeGolpeaUnBloqueDeMaderaConUnHachaDeMaderaYSeReduceLaDurabilidadDelBloqueEn2() {
        HerramientaNormal hacha = Madera.crearHacha();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial - 2, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeGolpeaUnBloqueDeMaderaConUnHachaDePiedraYSeReduceLaDurabilidaDelBloqueEn5() {
        HerramientaNormal hacha = Piedra.crearHacha();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial - 5, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03SeGolpeaUnBloqueDeMaderaConUnHachaDeMetalYSeReduceLaDurabilidaDelBloqueEn10() {
        HerramientaNormal hacha = Metal.crearHacha();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        thrown.expect(ItemSeRompioError.class);
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial - 10, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test04SeGolpeaUnBloqueDeMaderaConUnPicoDeMaderaYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal pico = Madera.crearPico();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test05SeGolpeaUnBloqueDeMaderaConUnPicoDePiedraYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal pico = Piedra.crearPico();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test06SeGolpeaUnBloqueDeMaderaConUnPicoDeMetalYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal pico = Metal.crearPico();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test07SeGolpeaUnBloqueDeMaderaConUnPicoFinoYNoSeReduceLaDurabilidadDelBloque() {
        PicoFino pico = new PicoFino();
        Bloque bloque = new Madera().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test08SeCreaUnBloqueDeMaderaConUnaDurabilidadDe10() {
        Bloque bloque = new Madera().crearBloque();
        assertEquals(10, bloque.obtenerDurabilidad(), EPSILON);
    }
}
