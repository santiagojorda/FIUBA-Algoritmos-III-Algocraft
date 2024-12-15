package modelo.desgaste;

import modelo.materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemNoDesgastableAlPegarTest {
    @Test
    public void test01UnMaterialSiIntentaDesgastarDiamanteElCoeficienteDeDesgasteEs0() {
        ItemNoDesgastableAlPegar madera = new Madera();
        ItemNoDesgastableAlPegar piedra = new Piedra();
        ItemNoDesgastableAlPegar diamante = new Diamante();
        ItemNoDesgastableAlPegar metal = new Metal();
        assertEquals(0, madera.desgastarDiamante());
        assertEquals(0, piedra.desgastarDiamante());
        assertEquals(0, diamante.desgastarDiamante());
        assertEquals(0, metal.desgastarDiamante());
    }

    @Test
    public void test02UnMaterialSiIntentaDesgastarMaderaYElCoeficienteDeDesgasteEs0() {
        ItemNoDesgastableAlPegar madera = new Madera();
        ItemNoDesgastableAlPegar piedra = new Piedra();
        ItemNoDesgastableAlPegar diamante = new Diamante();
        ItemNoDesgastableAlPegar metal = new Metal();
        assertEquals(0, madera.desgastarMadera());
        assertEquals(0, piedra.desgastarMadera());
        assertEquals(0, diamante.desgastarMadera());
        assertEquals(0, metal.desgastarMadera());
    }

    @Test
    public void test03UnMaterialSiIntentaDesgastarPiedraYElCoeficienteDeDesgasteEs0() {
        ItemNoDesgastableAlPegar madera = new Madera();
        ItemNoDesgastableAlPegar piedra = new Piedra();
        ItemNoDesgastableAlPegar diamante = new Diamante();
        ItemNoDesgastableAlPegar metal = new Metal();
        assertEquals(0, madera.desgastarPiedra());
        assertEquals(0, piedra.desgastarPiedra());
        assertEquals(0, diamante.desgastarPiedra());
        assertEquals(0, metal.desgastarPiedra());
    }

    @Test
    public void test04UnMaterialSiIntentaDesgastarMetalYElCoeficienteDeDesgasteEs0() {
        ItemNoDesgastableAlPegar madera = new Madera();
        ItemNoDesgastableAlPegar piedra = new Piedra();
        ItemNoDesgastableAlPegar diamante = new Diamante();
        ItemNoDesgastableAlPegar metal = new Metal();
        assertEquals(0, madera.desgastarMetal());
        assertEquals(0, piedra.desgastarMetal());
        assertEquals(0, diamante.desgastarMetal());
        assertEquals(0, metal.desgastarMetal());
    }
}
