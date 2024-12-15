package modelo.jugador;

import modelo.excepciones.NoHayMasEspacioEnElInventarioError;
import modelo.mapa.Mapeador;
import modelo.mapa.Posicion;

public class Inventario extends Mapeador<ItemInventario> {
    public Inventario() {
        super(6, 3);
    }

    public void colocarItem(ItemInventario item) throws NoHayMasEspacioEnElInventarioError {
        colocar(obtenerUnaPosicionVacia(), item);
    }

    private Posicion obtenerUnaPosicionVacia() throws NoHayMasEspacioEnElInventarioError {
        Posicion posicionVacia = new Posicion(0, 0);
        boolean encontroPosicionVacia = false;
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                Posicion posicionActual = new Posicion(x, y);
                if (!hayElementoEn(posicionActual) && !encontroPosicionVacia) {
                    posicionVacia = posicionActual;
                    encontroPosicionVacia = true;
                }
            }
        }
        if (!encontroPosicionVacia) {
            throw new NoHayMasEspacioEnElInventarioError();
        }
        return posicionVacia;
    }
}