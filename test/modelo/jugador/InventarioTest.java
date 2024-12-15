package modelo.jugador;

import modelo.excepciones.NoHayMasEspacioEnElInventarioError;
import modelo.herramientas.HerramientaNormal;
import modelo.mapa.Posicion;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class InventarioTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01InventarioSeCreaSinItems() {
        Inventario inventario = new Inventario();
        assertEquals(0, inventario.cantidadDeElementosCreados());
    }

    @Test
    public void test02AgregarHerramientaAlInventarioYCantidadDeHerramientasIncrementaEnUno() {
        Inventario inventario = new Inventario();
        HerramientaNormal unPico = Metal.crearPico();
        inventario.colocarItem(unPico);
        assertEquals(1, inventario.cantidadDeElementosCreados());
    }

    @Test
    public void test03Agrego10ElementosAlInventarioYSeLanzaUnaExcepcion() {
        Inventario inventario = new Inventario();
        int i = 0;
        thrown.expect(NoHayMasEspacioEnElInventarioError.class);
        while (i <= inventario.cantidadElementosPosibles()) {
            inventario.colocarItem(Metal.crearPico());
            i++;
        }
    }

    @Test
    public void test04GuardoUnElementoEnElInventarioYAumentanLosElementosEn1() {
        Inventario inventario = new Inventario();
        int itemsIniciales = inventario.cantidadDeElementosCreados();
        inventario.colocar(new Posicion(1, 0), new Madera());
        int itemsFinales = inventario.cantidadDeElementosCreados();
        assertEquals(itemsIniciales + 1, itemsFinales);
    }

    @Test
    public void test05EliminoUnElementoEnElInventarioYDecrementanLosElementosEn1() {
        Inventario inventario = new Inventario();
        Posicion posicion = new Posicion(1, 0);
        inventario.colocar(posicion, new Madera());
        int itemsIniciales = inventario.cantidadDeElementosCreados();
        inventario.eliminar(posicion);
        int itemsFinales = inventario.cantidadDeElementosCreados();
        assertEquals(itemsIniciales - 1, itemsFinales);
    }
}

