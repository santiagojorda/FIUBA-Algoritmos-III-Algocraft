package modelo.herramientas;

import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PicoDePiedraTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01SeUsaUnPicoDePiedraContraUnBloqueDeMaderaYSuDurabilidadSeReduceEn2Coma6Periodico() {
        HerramientaNormal picoDePiedra = Piedra.crearPico();
        double durabilidadInicialPico = picoDePiedra.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        picoDePiedra.usarContra(bloqueDeMadera);
        double durabilidadPico = picoDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - (4 / 1.5), durabilidadPico, EPSILON);
    }

    @Test
    public void test03SeUsaUnPicoDePiedraContraUnBloqueDePiedraYSuDurabilidadSeReduceEn2Coma6Periodico() {
        HerramientaNormal picoDePiedra = Piedra.crearPico();
        double durabilidadInicialPico = picoDePiedra.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        picoDePiedra.usarContra(bloqueDePiedra);
        double durabilidadPico = picoDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - (4 / 1.5), durabilidadPico, EPSILON);
    }

    @Test
    public void test04SeUsaUnPicoDePiedraContraUnBloqueDeMetalYSuDurabilidadSeReduceEn2Coma6Periodico() {
        HerramientaNormal picoDePiedra = Piedra.crearPico();
        double durabilidadInicialPico = picoDePiedra.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        picoDePiedra.usarContra(bloqueDeMetal);
        double durabilidadPico = picoDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - (4 / 1.5), durabilidadPico, EPSILON);
    }

    @Test
    public void test06SeUsaUnPicoDePiedraContraUnBossYSuDurabilidadNoSeReduce() {

        HerramientaNormal picoDePiedra = Piedra.crearPico();
        double durabilidadInicialPico = picoDePiedra.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        picoDePiedra.usarContra(boss);
        double durabilidadPico = picoDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico , durabilidadPico, EPSILON);

    }

    @Test
    public void test05SeUsaUnPicoDePiedraContraUnBloqueDeDiamanteYSuDurabilidadSeReduceEn2Coma6Periodico() {
        HerramientaNormal picoDePiedra = Piedra.crearPico();
        double durabilidadInicialPico = picoDePiedra.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        picoDePiedra.usarContra(bloqueDeDiamante);
        double durabilidadPico = picoDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialPico - (4 / 1.5), durabilidadPico, EPSILON);
    }
}
