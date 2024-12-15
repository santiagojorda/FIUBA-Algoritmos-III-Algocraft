package modelo.materiales;

import modelo.herramientas.HerramientaNormal;
import modelo.herramientas.PicoFino;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BloquePiedraTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeGolpeaUnBloqueDePiedraConUnHachaDeMaderaYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal hacha = Madera.crearHacha();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeGolpeaUnBloqueDePiedraConUnHachaDePiedraYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal hacha = Piedra.crearHacha();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test03SeGolpeaUnBloqueDePiedraConUnHachaDeMetalYNoSeReduceLaDurabilidadDelBloque() {
        HerramientaNormal hacha = Metal.crearHacha();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(hacha);
        assertEquals(durabilidadInicial, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test04SeGolpeaUnBloqueDePiedraConUnPicoDeMaderaYSeReduceLaDurabilidadDelBloqueEn2() {
        HerramientaNormal pico = Madera.crearPico();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 2, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test05SeGolpeaUnBloqueDePiedraConUnPicoDePiedraYSeReduceLaDurabilidadDelBloqueEn4() {
        HerramientaNormal pico = Piedra.crearPico();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 4, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test06SeGolpeaUnBloqueDePiedraConUnPicoDeMetalYSeReduceLaDurabilidadDelBloqueEn12() {
        HerramientaNormal pico = Metal.crearPico();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 12, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test07SeGolpeaUnBloqueDePiedraConUnPicoFinoEn20() {
        PicoFino pico = new PicoFino();
        Bloque bloque = new Piedra().crearBloque();
        double durabilidadInicial = bloque.obtenerDurabilidad();
        bloque.desgastarseASiMismoCon(pico);
        assertEquals(durabilidadInicial - 20, bloque.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test08SeCreaUnBloqueDePiedraConUnaDurabilidadDe30() {
        Bloque bloque = new Piedra().crearBloque();
        assertEquals(30, bloque.obtenerDurabilidad(), EPSILON);
    }
}
