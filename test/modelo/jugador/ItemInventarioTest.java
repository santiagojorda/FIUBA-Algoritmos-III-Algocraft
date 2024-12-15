package modelo.jugador;

import modelo.excepciones.NoPuedePegarConEsteItem;
import modelo.materiales.Bloque;
import modelo.materiales.Madera;
import modelo.materiales.Material;
import modelo.materiales.Metal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ItemInventarioTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
//
//    @Test
//    public void test02IntentoObtenerLaDurabilidadDeUnMaterialYMeLanzaUnaExcepcion(){
//
//        Material unMaterial = new Madera();
//
//        thrown.expect(ItemSinDurabilidadError.class);
//        unMaterial.obtenerDurabilidad();
//
//    }

    @Test
    public void test03IntentoGolpearUnBloqueConUnMaterialYMeLanzaUnaExcepcion() {
        Material unMaterial = new Madera();
        Bloque unBloque = new Metal().crearBloque();
        thrown.expect(NoPuedePegarConEsteItem.class);
        unMaterial.usarContra(unBloque);
    }
}
