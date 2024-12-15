package modelo.herramientas;

import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PicoDeMaderaTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeUsaUnPicoDeMaderaContraUnBloqueDeMaderaYSuDurabilidadSeReduceEn2() {
        HerramientaNormal picoDeMadera = Madera.crearPico();
        double durabilidadInicialPico = picoDeMadera.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        picoDeMadera.usarContra(bloqueDeMadera);
        double durabilidadPico = picoDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - 2, durabilidadPico, EPSILON);
    }

    @Test
    public void test02SeUsaUnPicoDeMaderaContraUnBloqueDePiedraYSuDurabilidadSeReduceEn2() {
        HerramientaNormal picoDeMadera = Madera.crearPico();
        double durabilidadInicialPico = picoDeMadera.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        picoDeMadera.usarContra(bloqueDePiedra);
        double durabilidadPico = picoDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - 2, durabilidadPico, EPSILON);
    }

    @Test
    public void test03SeUsaUnPicoDeMaderaContraUnBloqueDeMetalYSuDurabilidadSeReduceEn2() {
        HerramientaNormal picoDeMadera = Madera.crearPico();
        double durabilidadInicialPico = picoDeMadera.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        picoDeMadera.usarContra(bloqueDeMetal);
        double durabilidadPico = picoDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - 2, durabilidadPico, EPSILON);
    }

    @Test
    public void test04SeUsaUnPicoDeMaderaContraUnBloqueDeDiamanteYSuDurabilidadSeReduceEn2() {
        HerramientaNormal picoDeMadera = Madera.crearPico();
        double durabilidadInicialPico = picoDeMadera.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        picoDeMadera.usarContra(bloqueDeDiamante);
        double durabilidadPico = picoDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - 2, durabilidadPico, EPSILON);
    }

    @Test
    public void test05SeUsaUnPicoDeMaderaContraUnBossYSuDurabilidadNoSeReduce() {

        HerramientaNormal picoDeMadera = Madera.crearPico();
        double durabilidadInicialPico = picoDeMadera.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        picoDeMadera.usarContra(boss);
        double durabilidadPico = picoDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico , durabilidadPico, EPSILON);

    }

}
