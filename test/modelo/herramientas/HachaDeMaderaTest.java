package modelo.herramientas;

import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HachaDeMaderaTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test02SeUsaUnHachaDeMaderaContraUnBloqueDeMaderaYSuDurabilidadSeReduceEn2() {
        Herramienta hachaDeMadera = Madera.crearHacha();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        double durabilidadInicialHacha = hachaDeMadera.obtenerDurabilidad();
        hachaDeMadera.usarContra(bloqueDeMadera);
        double durabilidadHacha = hachaDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 2, durabilidadHacha, EPSILON);
    }

    @Test
    public void test03SeUsaUnHachaDeMaderaContraUnBloqueDePiedraYSuDurabilidadSeReduceEn2() {
        Herramienta hachaDeMadera = Madera.crearHacha();
        double durabilidadInicialHacha = hachaDeMadera.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        hachaDeMadera.usarContra(bloqueDePiedra);
        double durabilidadHacha = hachaDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 2, durabilidadHacha, EPSILON);
    }

    @Test
    public void test04SeUsaUnHachaDeMaderaContraUnBloqueDeMetalYSuDurabilidadSeReduceEn2() {
        Herramienta hachaDeMadera = Madera.crearHacha();
        double durabilidadInicialHacha = hachaDeMadera.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        hachaDeMadera.usarContra(bloqueDeMetal);
        double durabilidadHacha = hachaDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 2, durabilidadHacha, EPSILON);
    }

    @Test
    public void test05SeUsaUnHachaDeMaderaContraUnBloqueDeDiamanteYSuDurabilidadSeReduceEn2() {
        HerramientaNormal hachaDeMadera = Madera.crearHacha();
        double durabilidadInicialHacha = hachaDeMadera.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        hachaDeMadera.usarContra(bloqueDeDiamante);
        double durabilidadHacha = hachaDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 2, durabilidadHacha, EPSILON);
    }


    @Test
    public void test06SeUsaUnHachaDeMaderaContraUnBossYSuDurabilidadNoSeReduce() {

        HerramientaNormal hachaDeMadera = Madera.crearHacha();
        double durabilidadInicialHacha = hachaDeMadera.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        hachaDeMadera.usarContra(boss);
        double durabilidadHacha = hachaDeMadera.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha , durabilidadHacha, EPSILON);

    }
}
