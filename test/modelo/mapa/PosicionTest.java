package modelo.mapa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PosicionTest {
    @Test
    public void test01SeCreaUnaPosicionConLasCoordenadasFila1YColumna2Correctamente() {
        Posicion unaPosicion = new Posicion(2, 1);
        assertEquals(1, unaPosicion.fila());
        assertEquals(2, unaPosicion.columna());
    }

    @Test
    public void test02DosPosicionesConElMismoValorDeFilaYColumnaSeConsideranIguales() {
        Posicion unaPosicion = new Posicion(1, 2);
        Posicion otraPosicion = new Posicion(1, 2);
        assertEquals(unaPosicion, otraPosicion);
    }

    @Test
    public void test03DosPosicionesSinElMismoValorDeFilaYColumnaNoSeConsideranIguales() {
        Posicion unaPosicion = new Posicion(1, 2);
        Posicion otraPosicion = new Posicion(2, 3);
        assertNotEquals(unaPosicion, otraPosicion);
    }

    @Test
    public void test04DosPosicionesConElMismoValorTieneHashIguales() {
        Posicion unaPosicion = new Posicion(1, 2);
        Posicion otraPosicion = new Posicion(1, 2);
        assertEquals(unaPosicion.hashCode(), otraPosicion.hashCode());
    }
}
