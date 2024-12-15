package modelo.materiales;

import modelo.jugador.ItemInventario;

public interface ItemAtacable {
    void desgastarItemAtacador(ItemAtacador itemAtacador);

    void desgastarseASiMismoCon(ItemAtacador itemAtacador);

    double obtenerDurabilidad();

    ItemInventario soltarMaterial();
}
