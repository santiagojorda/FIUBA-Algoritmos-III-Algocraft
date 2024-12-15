package modelo.desgaste.herramienta;

import modelo.excepciones.DesgastadoPorCompletoError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DesgastadorHerramientaLinealTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnDesgastadorHerramientaLinealConUnCoeficienteDe1YUnaDurabilidadDe100YAlLllamarDesgasteLaDurabilidadQuedaEn99() {
        DesgastadorHerramientaLineal desgastador = new DesgastadorHerramientaLineal(100, 1);
        desgastador.desgastar();
        double durabilidad = desgastador.obtenerDurabilidad();
        assertEquals(99, durabilidad, EPSILON);
    }

    @Test
    public void test02SeCreaUnDesgastadorHerramientaLinealConUnCoeficienteDe5YUnaDurabilidadDe200YAlLllamarDesgasteLaDurabilidadQuedaEn195() {
        DesgastadorHerramientaLineal desgastador = new DesgastadorHerramientaLineal(200, 5);
        desgastador.desgastar();
        double durabilidad = desgastador.obtenerDurabilidad();
        assertEquals(195, durabilidad, EPSILON);
    }

    @Test
    public void test03SeCreaUnDesgastadorHerramientaLinealConUnCoeficienteDe5YUnaDurabilidadDe3YAlLllamarDesgasteLaDurabilidadLanzaUnaExcepcion() {
        DesgastadorHerramientaLineal desgastador = new DesgastadorHerramientaLineal(3, 5);
        thrown.expect(DesgastadoPorCompletoError.class);
        desgastador.desgastar();
    }
}
