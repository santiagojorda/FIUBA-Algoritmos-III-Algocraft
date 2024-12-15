package modelo.mesaDeCrafteo;

import modelo.herramientas.Herramienta;
import modelo.jugador.ItemInventario;
import modelo.mapa.Mapeador;
import modelo.mapa.Posicion;

public class MesaDeCrafteo {
    private Mapeador<ItemInventario> recetaActual;
    private ManejadorDeRecetas manejadorDeRecetas;

    public MesaDeCrafteo() {
        recetaActual = new Mapeador<>(3, 3);
        manejadorDeRecetas = new ManejadorDeRecetas();
    }

    public ItemInventario obtenerItem(Posicion posicion) {
        return recetaActual.obtener(posicion);
    }

    public void agregarItem(ItemInventario item, Posicion posicion) {
        recetaActual.colocar(posicion, item);
    }

    public Herramienta crearHerramienta() {
        Herramienta objetoCreado = manejadorDeRecetas.clasificar(recetaActual);
        vaciarMesaDeCrafteo();
        return objetoCreado;
    }

    private void vaciarMesaDeCrafteo() {
        recetaActual.vaciar();
    }

    public boolean hayItemEn(Posicion posicion) {
        return recetaActual.hayElementoEn(posicion);
    }

    public String obtenerNombreItem(Posicion posicion) {
        return obtenerItem(posicion).obtenerNombre();
    }

    public void eliminarItem(Posicion posicion) {
        recetaActual.eliminar(posicion);
    }
}
