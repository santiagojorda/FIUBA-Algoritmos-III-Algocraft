package modelo.herramientas;

import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HachaDePiedraTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test02SeUsaUnHachaDePiedraContraUnBloqueDeMaderaYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDePiedra = Piedra.crearHacha();
        double durabilidadInicialHacha = hachaDePiedra.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        hachaDePiedra.usarContra(bloqueDeMadera);
        double durabilidadHacha = hachaDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test03SeUsaUnHachaDePiedraContraUnBloqueDePiedraYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDePiedra = Piedra.crearHacha();
        double durabilidadInicialHacha = hachaDePiedra.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        hachaDePiedra.usarContra(bloqueDePiedra);
        double durabilidadHacha = hachaDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test04SeUsaUnHachaDePiedraContraUnBloqueDeMetalYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDePiedra = Piedra.crearHacha();
        double durabilidadInicialHacha = hachaDePiedra.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        hachaDePiedra.usarContra(bloqueDeMetal);
        double durabilidadHacha = hachaDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test05SeUsaUnHachaDePiedraContraUnBloqueDeDiamanteYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDePiedra = Piedra.crearHacha();
        double durabilidadInicialHacha = hachaDePiedra.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        hachaDePiedra.usarContra(bloqueDeDiamante);
        double durabilidadHacha = hachaDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test06SeUsaUnHachaDePiedraContraUnBossYSuDurabilidadNoSeReduce() {

        HerramientaNormal hachaDePiedra = Piedra.crearHacha();
        double durabilidadInicialHacha = hachaDePiedra.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        hachaDePiedra.usarContra(boss);
        double durabilidadHacha = hachaDePiedra.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha , durabilidadHacha, EPSILON);

    }
}
