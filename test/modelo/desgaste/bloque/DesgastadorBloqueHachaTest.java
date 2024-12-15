package modelo.desgaste.bloque;

import modelo.desgaste.bloques.DesgastadorBloqueHacha;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DesgastadorBloqueHachaTest {
    @Test
    public void test01SeCreaUnDesgastadorHachaConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMaderaDevuelve2() {
        DesgastadorBloqueHacha desgaste = new DesgastadorBloqueHacha(2);
        int coeficienteDesgaste = desgaste.desgastarMadera();
        assertEquals(2, coeficienteDesgaste);
    }

    @Test
    public void test02SeCreaUnDesgastadorHachaConUnCoeficienteDeDesgaste2YAlLlamarADesgastarPiedraDevuelve0() {
        DesgastadorBloqueHacha desgaste = new DesgastadorBloqueHacha(2);
        int coeficienteDesgaste = desgaste.desgastarPiedra();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test03SeCreaUnDesgastadorHachaConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMetalDevuelve0() {
        DesgastadorBloqueHacha desgaste = new DesgastadorBloqueHacha(2);
        int coeficienteDesgaste = desgaste.desgastarMetal();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test04SeCreaUnDesgastadorHachaConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMaderaDevuelve0() {
        DesgastadorBloqueHacha desgaste = new DesgastadorBloqueHacha(2);
        int coeficienteDesgaste = desgaste.desgastarDiamante();
        assertEquals(0, coeficienteDesgaste);
    }
}
