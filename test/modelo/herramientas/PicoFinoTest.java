package modelo.herramientas;

import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PicoFinoTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeUsaUnPicoFinoContraUnBloqueDeMaderaYSuDurabilidadNoSeReduce() {
        Herramienta picoFino = new PicoFino();
        double durabilidadInicialPico = picoFino.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        picoFino.usarContra(bloqueDeMadera);
        double durabilidadPico = picoFino.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test02SeUsaUnPicoFinoContraUnBloqueDePiedraYSuDurabilidadNoSeReduce() {
        Herramienta picoFino = new PicoFino();
        double durabilidadInicialPico = picoFino.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        picoFino.usarContra(bloqueDePiedra);
        double durabilidadPico = picoFino.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);
    }

    @Test
    public void test03SeUsaUnPicoFinoContraUnBloqueDeMetalYSuDurabilidadNoSeReduce() {
        Herramienta picoFino = new PicoFino();
        double durabilidadInicialPico = picoFino.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        picoFino.usarContra(bloqueDeMetal);
        double durabilidadFinalPico = picoFino.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadFinalPico, EPSILON);
    }

    @Test
    public void test04SeUsaUnPicoFinoContraUnBloqueDeDiamanteYSuDurabilidadSeReduceUnDiezPorciento() {
        Herramienta picoFino = new PicoFino();
        double durabilidadInicialPico = picoFino.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        picoFino.usarContra(bloqueDeDiamante);
        double durabilidadPico = picoFino.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - (durabilidadInicialPico * 0.1), durabilidadPico, EPSILON);
    }

    @Test
    public void test05SeUsaUnPicoFinoContraUnBossYSuDurabilidadNoSeReduce() {

        Herramienta picoFino = new PicoFino();
        double durabilidadInicialPico = picoFino.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        picoFino.usarContra(boss);
        double durabilidadPico = picoFino.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico, durabilidadPico, EPSILON);

    }

}
