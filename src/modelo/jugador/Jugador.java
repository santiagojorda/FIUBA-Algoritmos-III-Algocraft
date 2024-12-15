package modelo.jugador;

import modelo.excepciones.*;
import modelo.mapa.Item;
import modelo.mapa.Posicion;
import modelo.materiales.ItemAtacable;
import modelo.materiales.Madera;

public class Jugador extends Item {
    private Inventario inventario;
    private ItemInventario itemEquipado;
    private Posicion posicionItemEquipado;

    public Jugador() {
        super("jugador");
        inventario = new Inventario();
        inventario.colocarItem(new Madera().crearHacha());
    }


    public void usarContra(ItemAtacable item) throws NoSeDesgastaError, NoPuedePegarConEsteItem, ItemSeRompioError, NoHayUnItemEquipadoError {
        if (noHayNingunItemEquipado()) {
            throw new NoHayUnItemEquipadoError();
        }
        try {
            itemEquipado.usarContra(item);
        } catch (DesgastadoPorCompletoError Exception) {
            desequipar();
            eliminarItem(posicionItemEquipado);
        } catch (SeRompioItemAtacadoYElItemAtacador Exception) {
            desequipar();
            eliminarItem(posicionItemEquipado);
            throw new ItemSeRompioError();
        }
    }

    private boolean noHayNingunItemEquipado() {
        return itemEquipado == null;
    }

    private void desequipar() {
        itemEquipado = null;
    }

    public ItemInventario obtenerItemEn(Posicion posicion) throws NoExistePosicionEnElMapaError, NoHayElementoEnEstaPosicionError {
        return inventario.obtener(posicion);
    }

    public String obtenerNombreObjetoEquipado() {
        if (noHayNingunItemEquipado()) {
            throw new NoHayUnItemEquipadoError();
        }
        return itemEquipado.obtenerNombre();
    }

    public void guardarItem(ItemInventario item) throws NoHayMasEspacioEnElInventarioError {
        inventario.colocarItem(item);
    }

    public void guardarItem(Posicion posicion, ItemInventario item) throws LugarOcupadoError, NoExistePosicionEnElMapaError {
        inventario.colocar(posicion, item);
    }

    public void equiparItemEnPosicion(Posicion posicion) throws NoHayElementoEnEstaPosicionError, NoExistePosicionEnElMapaError {
        ItemInventario itemObtenido = obtenerItemEn(posicion);
        itemEquipado = itemObtenido.equipar();
        posicionItemEquipado = new Posicion(posicion.columna(), posicion.fila());
    }

    public boolean hayUnItemEnInventarioEn(Posicion posicion) throws NoExistePosicionEnElMapaError {
        return inventario.hayElementoEn(posicion);
    }

    public void eliminarItem(Posicion posicion) {
        if (posicion.equals(posicionItemEquipado)) {
            desequipar();
        }
        inventario.eliminar(posicion);
    }

    public int obtenerCantidadItemsEnInventario() {
        return inventario.cantidadDeElementosCreados();
    }
}

