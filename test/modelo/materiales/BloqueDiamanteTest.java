package modelo.materiales;

import modelo.herramientas.HerramientaNormal;
import modelo.herramientas.PicoFino;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BloqueDiamanteTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeGolpeaUnBloqueDeDiamanteConUnHachaDeMaderaYNoSeReduceLaDurabilidadDelBloque() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal hacha = Madera.crearHacha();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeGolpeaUnBloqueDeDiamantConUnHachaDePiedraYNoSeReduceLaDurabilidadDelBloque() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal hacha = Piedra.crearHacha();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03SeGolpeaUnBloqueDeDiamantConUnHachaDeMetalYNoSeReduceLaDurabilidadDelBloque() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal hacha = Metal.crearHacha();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test04SeGolpeaUnBloqueDeDiamantConUnPicoDeMaderaYNoSeReduceLaDurabilidadDelBloque() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal pico = Madera.crearPico();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test05SeGolpeaUnBloqueDeDiamanteConUnPicoDePiedraYSeReduceLaDurabilidadDelBloqueEn4() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal pico = Piedra.crearPico();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 4, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test06SeGolpeaUnBloqueDeDiamanteConUnPicoDeMetalYSeReduceLaDurabilidadDelBloqueEn12() {
        Bloque bloque = new Diamante().crearBloque();
        HerramientaNormal pico = Metal.crearPico();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 12, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test07SeGolpeaUnBloqueDeDiamanteConUnPicoFinoYSeReduceLaDurabilidadDelBloqueEn20() {
        Bloque bloque = new Diamante().crearBloque();
        PicoFino pico = new PicoFino();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 20, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test08SeCreaUnBloqueDeDiamanteConDurabilidad100() {
        Bloque bloque = new Diamante().crearBloque();
        assertEquals(100, bloque.obtenerDurabilidad(), EPSILON);
    }
}
