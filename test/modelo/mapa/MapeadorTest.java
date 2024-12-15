package modelo.mapa;

import modelo.excepciones.NoExistePosicionEnElMapaError;
import modelo.excepciones.NoHayElementoEnEstaPosicionError;
import modelo.materiales.Madera;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class MapeadorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeIntentaObtenerUnaCeldaFueraDelMapaYSeLanzaUnaExcepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoExistePosicionEnElMapaError.class);
        mapa.obtener(new Posicion(5, 5));
    }

    @Test
    public void test02SeIntentaObtenerUnaCeldaVaciaDelMapaYSeLanzaUnaExcepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoHayElementoEnEstaPosicionError.class);
        mapa.obtener(new Posicion(1, 1));
    }

    @Test
    public void test03SeIntentaColocarUnElementoEnUnaPosicionFueraDelMapaYSeLanzaUnaExepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoExistePosicionEnElMapaError.class);
        mapa.obtener(new Posicion(1, -2));
    }

    @Test
    public void test04SeIntentaSaberSiHayUnItemEnUnaPosicionFueraDelMapaYSeLanzaUnaExepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoExistePosicionEnElMapaError.class);
        mapa.hayElementoEn(new Posicion(1, -2));
    }

    @Test
    public void test05SeIntentaIntercambiarUnItemEnUnaPosicionFueraDelMapaYSeLanzaUnaExepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoExistePosicionEnElMapaError.class);
        mapa.intercambiarPor(new Posicion(1, -2), new Madera());
    }

    @Test
    public void test06SeIntentaColocarUnItemEnUnaPosicionFueraDelMapaYSeLanzaUnaExepcion() {
        Mapeador mapa = new Mapeador(2, 2);
        thrown.expect(NoExistePosicionEnElMapaError.class);
        mapa.colocar(new Posicion(1, -2), new Madera());
    }

    @Test
    public void test07SeInicializaUnMapaCorrectamente() {
        Mapeador mapa = new Mapeador(2, 2);
        mapa.inicializar("objeto");
        boolean seInicializoCorrectamente = true;
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                Posicion posicion = new Posicion(x, y);
                if (!mapa.hayElementoEn(posicion)) {
                    seInicializoCorrectamente = false;
                }
            }
        }
        assertTrue(seInicializoCorrectamente);
    }
}
