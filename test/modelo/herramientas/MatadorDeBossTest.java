package modelo.herramientas;

import modelo.excepciones.DesgastadoPorCompletoError;
import modelo.excepciones.SeRompioItemAtacadoYElItemAtacador;
import modelo.mapa.Boss;
import modelo.materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MatadorDeBossTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeUsaUnMatadorDeBossContraUnBloqueDeMaderaYLanzaUnaExcepcionDeRotoPorCompletoError() {
        Herramienta matadorDeBoss = Diamante.crearEspada();
        Bloque bloqueDeMadera = new Madera().crearBloque();
        thrown.expect(DesgastadoPorCompletoError.class);
        matadorDeBoss.usarContra(bloqueDeMadera);
    }

    @Test
    public void test02SeUsaUnMatadorDeBossContraUnBloqueDeDiamanteYLanzaUnaExcepcionDeRotoPorCompletoError() {
        Herramienta matadorDeBoss = Diamante.crearEspada();
        Bloque bloque = new Diamante().crearBloque();
        thrown.expect(DesgastadoPorCompletoError.class);
        matadorDeBoss.usarContra(bloque);
    }

    @Test
    public void test03SeUsaUnMatadorDeBossContraUnBloqueDeMetalYLanzaUnaExcepcionDeRotoPorCompletoError() {
        Herramienta matadorDeBoss = Diamante.crearEspada();
        Bloque bloque = new Metal().crearBloque();
        thrown.expect(DesgastadoPorCompletoError.class);
        matadorDeBoss.usarContra(bloque);
    }

    @Test
    public void test04SeUsaUnMatadorDeBossContraUnBloqueDePiedraYLanzaUnaExcepcionDeRotoPorCompletoError() {
        Herramienta matadorDeBoss = Diamante.crearEspada();
        Bloque bloque = new Piedra().crearBloque();
        thrown.expect(DesgastadoPorCompletoError.class);
        matadorDeBoss.usarContra(bloque);
    }

    @Test
    public void test05SeUsaUnMatadorDeBossContraUnBossYLanzaUnaExcepcionDeSeRompioItemAtacadoYElItemAtacador() {
        Herramienta matadorDeBoss = Diamante.crearEspada();
        ItemAtacable item = new Boss("Pato");
        thrown.expect(SeRompioItemAtacadoYElItemAtacador.class);
        matadorDeBoss.usarContra(item);
    }
}