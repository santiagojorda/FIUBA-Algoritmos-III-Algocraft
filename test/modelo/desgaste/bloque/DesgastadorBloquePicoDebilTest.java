package modelo.desgaste.bloque;

import modelo.desgaste.bloques.DesgastadorBloquePicoDebil;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DesgastadorBloquePicoDebilTest {
    @Test
    public void test01SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMaderaDebuelbe0() {
        DesgastadorBloquePicoDebil desgaste = new DesgastadorBloquePicoDebil(2);
        int coeficienteDesgaste = desgaste.desgastarMadera();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test02SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarMetalDebuelbe0() {
        DesgastadorBloquePicoDebil desgaste = new DesgastadorBloquePicoDebil(2);
        int coeficienteDesgaste = desgaste.desgastarMetal();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test03SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarDiamanteDebuelbe0() {
        DesgastadorBloquePicoDebil desgaste = new DesgastadorBloquePicoDebil(2);
        int coeficienteDesgaste = desgaste.desgastarDiamante();
        assertEquals(0, coeficienteDesgaste);
    }

    @Test
    public void test04SeCreaUnDesgastadorPicoConUnCoeficienteDeDesgaste2YAlLlamarADesgastarPiedraDebuelbe2() {
        DesgastadorBloquePicoDebil desgaste = new DesgastadorBloquePicoDebil(2);
        int coeficienteDesgaste = desgaste.desgastarPiedra();
        assertEquals(2, coeficienteDesgaste);
    }
}
