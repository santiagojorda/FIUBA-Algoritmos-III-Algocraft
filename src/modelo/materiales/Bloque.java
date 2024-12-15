package modelo.materiales;

import modelo.excepciones.ItemSeRompioError;
import modelo.excepciones.NoSeDesgastaError;
import modelo.mapa.Item;

public class Bloque extends Item implements ItemAtacable {
    private double durabilidad;
    private Material material;

    public Bloque(int durabilidad, Material material) {
        super("bloque");
        this.durabilidad = durabilidad;
        this.material = material;
    }

    public Bloque(int durabilidad, Material material, String nombre) {
        super(nombre);
        this.material = material;
        this.durabilidad = durabilidad;
    }

    public void desgastarseASiMismoCon(ItemAtacador item) {
        int desgaste = material.desgastarMaterial(item);
        durabilidad -= desgaste;
        if (durabilidad <= 0) {
            throw new ItemSeRompioError();
        }
    }

    public double obtenerDurabilidad() {
        return durabilidad;
    }

    public void desgastarItemAtacador(ItemAtacador itemAtacador) {
        try {
            material.desgastarContraMaterial(itemAtacador);
        } catch (NoSeDesgastaError Exception) {
        }
    }

    public Material soltarMaterial() {
        return material;
    }
}
