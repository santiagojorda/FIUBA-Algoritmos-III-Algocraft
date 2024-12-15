package modelo.desgaste.bloque;

import modelo.desgaste.bloques.DesgastadorBloquePico;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DesgastadorBloquePicoTest {
    @Test
    public void test01SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMaderaDebuelbe0() {
        DesgastadorBloquePico desgaste = new DesgastadorBloquePico(2);
        int coeficienteDesgaste = desgaste.desgastarMadera();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test02SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarDiamanteDebuelbe2() {
        DesgastadorBloquePico desgaste = new DesgastadorBloquePico(2);
        int coeficienteDesgaste = desgaste.desgastarDiamante();
        assertEquals(2, coeficienteDesgaste);
    }

    @Test
    public void test03SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarPiedraDebuelbe2() {
        DesgastadorBloquePico desgaste = new DesgastadorBloquePico(2);
        int coeficienteDesgaste = desgaste.desgastarPiedra();
        assertEquals(2, coeficienteDesgaste);
    }

    @Test
    public void test04SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMetalDebuelbe2() {
        DesgastadorBloquePico desgaste = new DesgastadorBloquePico(2);
        int coeficienteDesgaste = desgaste.desgastarMetal();
        assertEquals(2, coeficienteDesgaste);
    }
}
