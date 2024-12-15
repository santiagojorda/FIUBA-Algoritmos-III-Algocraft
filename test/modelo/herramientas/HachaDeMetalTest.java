package modelo.herramientas;

import modelo.excepciones.ItemSeRompioError;
import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class HachaDeMetalTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test02SeUsaUnHachaDeMetalContraUnBloqueDeMaderaYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDeMetal = Metal.crearHacha();
        double durabilidadInicialHacha = hachaDeMetal.obtenerDurabilidad();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        thrown.expect(ItemSeRompioError.class);
        hachaDeMetal.usarContra(bloqueDeMadera);
        double durabilidadHacha = hachaDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test03SeUsaUnHachaDeMetalContraUnBloqueDePiedraYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDeMetal = Metal.crearHacha();
        double durabilidadInicialHacha = hachaDeMetal.obtenerDurabilidad();
        Bloque bloqueDePiedra = new Piedra().crearBloque();
        hachaDeMetal.usarContra(bloqueDePiedra);
        double durabilidadHacha = hachaDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test04SeUsaUnHachaDeMetalContraUnBloqueDeMetalYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDeMetal = Metal.crearHacha();
        double durabilidadInicialHacha = hachaDeMetal.obtenerDurabilidad();
        Bloque bloqueDeMetal = new Metal().crearBloque();
        hachaDeMetal.usarContra(bloqueDeMetal);
        double durabilidadHacha = hachaDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test05SeUsaUnHachaDeMetalContraUnBloqueDeDiamanteYSuDurabilidadSeReduceEn5() {
        HerramientaNormal hachaDeMetal = Metal.crearHacha();
        double durabilidadInicialHacha = hachaDeMetal.obtenerDurabilidad();
        Bloque bloqueDeDiamante = new Diamante().crearBloque();
        hachaDeMetal.usarContra(bloqueDeDiamante);
        double durabilidadHacha = hachaDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha - 5, durabilidadHacha, EPSILON);
    }

    @Test
    public void test06SeUsaUnHachaDeMetalContraUnBossYSuDurabilidadNoSeReduce() {

        HerramientaNormal hachaDeMetal = Metal.crearHacha();
        double durabilidadInicialHacha = hachaDeMetal.obtenerDurabilidad();
        ItemAtacable boss = new Boss("pato");
        hachaDeMetal.usarContra(boss);
        double durabilidadHacha = hachaDeMetal.obtenerDurabilidad();
        assertEquals(durabilidadInicialHacha , durabilidadHacha, EPSILON);

    }

}
