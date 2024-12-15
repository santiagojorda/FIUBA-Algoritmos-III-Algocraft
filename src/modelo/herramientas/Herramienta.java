package modelo.herramientas;

import controlador.ControladorDeImpresiones;
import modelo.desgaste.bloques.DesgastadorBloque;
import modelo.desgaste.herramienta.DesgastadorHerramienta;
import modelo.excepciones.DesgastadoPorCompletoError;
import modelo.excepciones.ItemSeRompioError;
import modelo.excepciones.SeRompioItemAtacadoYElItemAtacador;
import modelo.jugador.ItemInventario;
import modelo.materiales.ItemAtacable;

public abstract class Herramienta extends ItemInventario {
    protected DesgastadorHerramienta desgastadorHerramienta;
    protected DesgastadorBloque desgastadorBloque;

    public Herramienta(String nombre) {
        super(nombre);
    }

    public double obtenerDurabilidad() {
        return desgastadorHerramienta.obtenerDurabilidad();
    }

    public void usarContra(ItemAtacable unItem) {
        try {
            unItem.desgastarItemAtacador(this);
        } catch (DesgastadoPorCompletoError Exception) {
            try {
                unItem.desgastarseASiMismoCon(this);
            } catch (ItemSeRompioError otraExcepcion) {
                throw new SeRompioItemAtacadoYElItemAtacador();
            }
            throw new DesgastadoPorCompletoError();
        }
        unItem.desgastarseASiMismoCon(this);

        ControladorDeImpresiones.imprimirEstado(    "Durabilidad del bloque es " + unItem.obtenerDurabilidad() +
                "\nDurabilidad de " + this.obtenerNombre() + " es " + obtenerDurabilidad());
    }

    public void desgastar() {
        desgastadorHerramienta.desgastar();
    }

    public int desgastarMadera() {
        return desgastadorBloque.desgastarMadera();
    }

    public int desgastarMetal() {
        return desgastadorBloque.desgastarMetal();
    }

    public int desgastarPiedra() {
        return desgastadorBloque.desgastarPiedra();
    }

    public int desgastarDiamante() {
        return desgastadorBloque.desgastarDiamante();
    }

    public int desgastarBoss() {
        return desgastadorBloque.desgastarBoss();
    }
}
