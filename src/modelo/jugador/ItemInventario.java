package modelo.jugador;

import modelo.mapa.Item;
import modelo.materiales.ItemAtacador;

public abstract class ItemInventario extends Item implements ItemAtacador {
    public ItemInventario(String nombre) {
        super(nombre);
    }

    public ItemInventario equipar() {
        return this;
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return getClass() == obj.getClass();
    }
}
