package modelo.materiales;

import modelo.herramientas.HerramientaNormal;
import modelo.herramientas.PicoFino;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BloqueMetalTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeGolpeaUnBloqueDeMetalConUnPicoDeMaderaYNoSeReduceLaDurabilidad() {
        HerramientaNormal pico = Madera.crearPico();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeGolpeaUnBloqueDeMetalConUnHachaDeMaderaYNoReduceSuDurabilidad() {
        HerramientaNormal hacha = Madera.crearHacha();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03SeGolpeaUnBloqueDeMetalConUnHachaDeMetalYNoReduceSuDurabilidad() {
        HerramientaNormal hacha = Metal.crearHacha();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test04SeGolpeaUnBloqueDeMetalConUnHachaDePiedraYNoReduceSuDurabilidad() {
        HerramientaNormal hacha = Piedra.crearHacha();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test05SeGolpeaUnBloqueDeMetalConUnPicoDePiedraYSeReduseSuDurabilidaEn4() {
        HerramientaNormal pico = Piedra.crearPico();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 4, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test06SeGolpeaUnBloqueDeMetalConUnPicoDeMetalYSeReduseSuDurabilidaEn12() {
        HerramientaNormal pico = Metal.crearPico();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 12, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test07SeGolpeaUnBloqueDeMetalConUnPicoFinoYSeReduseSuDurabilidaEn20() {
        PicoFino pico = new PicoFino();
        Bloque bloque = new Metal().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 20, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test08SeCreaUnBloqueDeMetalConUnaDurabilidadDe50() {
        Bloque bloque = new Metal().crearBloque();
        assertEquals(50, bloque.obtenerDurabilidad(), EPSILON);
    }
}
