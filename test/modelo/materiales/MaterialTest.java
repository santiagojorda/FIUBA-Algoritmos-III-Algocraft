package modelo.materiales;

import modelo.herramientas.Herramienta;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MaterialTest {
    private static final double EPSILON = 1e-10;

    @Test
    public void test01DosMaderasSonSiempreIgualesAunqueSeCreenEnMomentosDistintos() {
        Material madera = new Madera();
        Material otraMadera = new Madera();
        assertEquals(madera, otraMadera);
    }

    @Test
    public void test02DosPiedrasSonSiempreIgualesAunqueSeCreenEnMomentosDistintos() {
        Material piedra = new Piedra();
        Material otraPiedra = new Piedra();
        assertEquals(piedra, otraPiedra);
    }

    @Test
    public void test03DosMetalesSonSiempreIgualesAunqueSeCreenEnMomentosDistintos() {
        Material metal = new Metal();
        Material otroMetal = new Metal();
        assertEquals(metal, otroMetal);
    }

    @Test
    public void test04DosDiamantesSonSiempreIgualesAunqueSeCreenEnMomentosDistintos() {
        Material diamante = new Diamante();
        Material otroDiamante = new Diamante();
        assertEquals(diamante, otroDiamante);
    }

    @Test
    public void test05UnMaterialNuncaEsIgualANull() {
        Material unMaterial = new Madera();
        assertNotEquals(null, unMaterial);
    }

    @Test
    public void test06UnMaterialEsIguaASiMismoSiempre() {
        Material unMaterial = new Madera();
        assertEquals(unMaterial, unMaterial);
    }

    @Test
    public void test07UnMaterialDeLaMismaClaseComparteHashCode() {
        Material unMaterial = new Madera();
        Material otroMaterial = new Madera();
        assertEquals(unMaterial.hashCode(), otroMaterial.hashCode());
    }

    @Test
    public void test08SeCreaUnaEspadaDeDiamanteConUnaDurabilidadDe10000() {
        Herramienta espada = Diamante.crearEspada();
        assertEquals(10000, espada.obtenerDurabilidad(), EPSILON);
    }
}
