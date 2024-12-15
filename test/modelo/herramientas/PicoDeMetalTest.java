package modelo.herramientas;

import modelo.excepciones.DesgastadoPorCompletoError;
import modelo.excepciones.ItemSeRompioError;
import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PicoDeMetalTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnPicoDeMetalConDurabilidad400YFuerza12() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        Bloque metal = new Metal().crearBloque();
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        double durabilidadInicial = metal.obtenerDurabilidad();
        picoDeMetal.usarContra(metal);
        assertEquals(400, durabilidadPico, EPSILON);
        assertEquals(durabilidadInicial - 12, metal.obtenerDurabilidad(), EPSILON);
    }

    @Test
    public void test02SeUsaUnPicosDeMetal9vecesContraUnBloqueDeMaderaYSuDurabilidadNoSeReduce() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        double durabilidadInicialPico = picoDeMetal.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        for (int contador = 0; contador < 9; contador++) {
            picoDeMetal.usarContra(bloqueDeMadera);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test03SeUsaUnPicosDeMetal10vecesContraUnBloqueDeMaderaYSuDurabilidadSeReduceA0() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        try {
            for (int contador = 0; contador < 10; contador++) {
                picoDeMetal.usarContra(bloqueDeMadera);
            }
        } catch (DesgastadoPorCompletoError Exception) {}
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(0, durabilidadPico, EPSILON);
    }

    @Test
    public void test04SeUsaUnPicoDeMetal9vecesContraUnBloqueDePiedraYSuDurabilidadNoSeReduce() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        double durabilidadInicialPico = picoDeMetal.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 9; contador++) {
            picoDeMetal.usarContra(bloqueDePiedra);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test05SeUsaUnPicoDeMetal10vecesContraUnBloqueDePiedraYSuDurabilidadSeReduceA0() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 10; contador++) {
            picoDeMetal.usarContra(bloqueDePiedra);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(0, durabilidadPico, EPSILON);
    }

    @Test
    public void test06SeUsaUnPicoDeMetal9vecesContraUnBloqueDeMetalYSuDurabilidadNoSeReduce() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        double durabilidadInicialPico = picoDeMetal.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 9; contador++) {
            picoDeMetal.usarContra(bloqueDeMetal);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test07SeUsaUnPicoDeMetal10vecesContraUnBloqueDeMetalYSuDurabilidadSeReduceA0() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 10; contador++) {
            picoDeMetal.usarContra(bloqueDeMetal);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(0, durabilidadPico, EPSILON);
    }

    @Test
    public void test08SeUsaUnPicoDeMetal9vecesContraUnBloqueDeDiamanteYSuDurabilidadNoSeReduce() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        double durabilidadInicialPico = picoDeMetal.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 9; contador++) {
            picoDeMetal.usarContra(bloqueDeDiamante);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test09SeUsaUnPicoDeMetal10vecesContraUnBloqueDeDiamanteYSuDurabilidadSeReduceA0() {
        HerramientaNormal picoDeMetal = Metal.crearPico();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        for (int contador = 0; contador < 10; contador++) {
            picoDeMetal.usarContra(bloqueDeDiamante);
        }
        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertEquals(0, durabilidadPico, EPSILON);
    }

    @Test
    public void test09SeUsaUnPicoDeMetal10vecesContraUnBossYSuDurabilidadNoSeReduceA0() {

        HerramientaNormal picoDeMetal = Metal.crearPico();
        ItemAtacable boss = new Boss("pato");
        for (int contador = 0; contador < 10; contador++) {
            picoDeMetal.usarContra(boss);
        }

        double durabilidadPico = picoDeMetal.obtenerDurabilidad();
        assertNotEquals(0, durabilidadPico, EPSILON);

    }
}
