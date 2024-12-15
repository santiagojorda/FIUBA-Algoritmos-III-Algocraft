package modelo.desgaste.herramienta;

import modelo.excepciones.DesgastadoPorCompletoError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DesgastadorHerramientaAGolpezTest {
    private static final double EPSILON = 1e-10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaUnDesgastadorAGolpezDe5GolpezY100DeDurabilidadYLadurabilidadEs0EnElQuintoGolpe() {
        DesgastadorHerramientaAGolpez desgastador = new DesgastadorHerramientaAGolpez(100, 5);
        try {
            for (int contador = 0; contador < 5; contador++) {
                desgastador.desgastar();
            }
        } catch (DesgastadoPorCompletoError Exception) {
        }
        double durabilidad = desgastador.obtenerDurabilidad();
        assertEquals(0, durabilidad, EPSILON);
    }

    @Test
    public void test02SeCreaUnDesgastadorAGolpezDe5GolpezY100DeDurabilidadYLadurabilidadEs0EnElCuartoGolpeLaDurabilidadEs100() {
        DesgastadorHerramientaAGolpez desgastador = new DesgastadorHerramientaAGolpez(100, 5);
        for (int contador = 0; contador < 4; contador++) {
            desgastador.desgastar();
        }
        double durabilidad = desgastador.obtenerDurabilidad();
        assertEquals(100, durabilidad, EPSILON);
    }

    @Test
    public void test03SeCreaUnDesgastadorAGolpezDe5GolpezY100DeDurabilidadYAlSextoGolpeLanzaUnaExcepcion() {
        DesgastadorHerramientaAGolpez desgastador = new DesgastadorHerramientaAGolpez(100, 5);
        for (int contador = 0; contador < 4; contador++) {
            desgastador.desgastar();
        }
        thrown.expect(DesgastadoPorCompletoError.class);
        desgastador.desgastar();
    }
}
