package modelo.mesaDeCrafteo;

import modelo.excepciones.CrafteoIncorrectoError;
import modelo.herramientas.Herramienta;
import modelo.herramientas.PicoFino;
import modelo.jugador.ItemInventario;
import modelo.mapa.Mapeador;
import modelo.mapa.Posicion;
import modelo.materiales.Diamante;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;

import java.util.HashMap;
import java.util.Map;

public class ManejadorDeRecetas {
    private Map<Mapeador<ItemInventario>, ItemInventario> recetario = new HashMap<>();

    public ManejadorDeRecetas() {
        this.crearRecetasDeHachas();
        this.crearRecetasDePicos();
        this.crearRecetaEspadaDiamante();
    }

    private void crearRecetaEspadaDiamante() {
        Mapeador<ItemInventario> receta = new Mapeador<>(3, 3);
        receta.colocar(new Posicion(1, 0), new Diamante());
        receta.colocar(new Posicion(1, 1), new Diamante());
        receta.colocar(new Posicion(1, 2), new Madera());
        recetario.put(receta, Diamante.crearEspada());
    }

    private void crearRecetasDePicos() {
        Posicion posicionCaracteristica = new Posicion(2, 0);
        crearRecetaDeHerramientaDe(new Madera(), posicionCaracteristica, Madera.crearPico());
        crearRecetaDeHerramientaDe(new Piedra(), posicionCaracteristica, Piedra.crearPico());
        crearRecetaDeHerramientaDe(new Metal(), posicionCaracteristica, Metal.crearPico());
        crearRecetaDePicoFino();
    }

    private void crearRecetaDePicoFino() {
        Mapeador<ItemInventario> receta = new Mapeador<>(3, 3);
        receta.colocar(new Posicion(0, 0), new Metal());
        receta.colocar(new Posicion(1, 0), new Metal());
        receta.colocar(new Posicion(2, 0), new Metal());
        receta.colocar(new Posicion(0, 1), new Piedra());
        crearMangoMadera(receta);
        recetario.put(receta, new PicoFino());
    }

    private void crearRecetasDeHachas() {
        Posicion posicionCaracteristica = new Posicion(0, 1);
        crearRecetaDeHerramientaDe(new Madera(), posicionCaracteristica, Madera.crearHacha());
        crearRecetaDeHerramientaDe(new Piedra(), posicionCaracteristica, Piedra.crearHacha());
        crearRecetaDeHerramientaDe(new Metal(), posicionCaracteristica, Metal.crearHacha());
    }

    private void crearRecetaDeHerramientaDe(ItemInventario material, Posicion posicionCaracteristica,ItemInventario herramienta) {
        Mapeador<ItemInventario> receta = new Mapeador<>(3, 3);
        receta.colocar(new Posicion(0, 0), material);
        receta.colocar(new Posicion(1, 0), material);
        receta.colocar(posicionCaracteristica, material);
        crearMangoMadera(receta);
        recetario.put(receta, herramienta);
    }

    private void crearMangoMadera(Mapeador<ItemInventario> receta) {
        receta.colocar(new Posicion(1, 1), new Madera());
        receta.colocar(new Posicion(1, 2), new Madera());
    }

    public Herramienta clasificar(Mapeador<ItemInventario> receta) {
        if(recetario.containsKey(receta)){
            return (Herramienta) recetario.get(receta);
        }
        else {
            throw new CrafteoIncorrectoError();
        }
    }
}