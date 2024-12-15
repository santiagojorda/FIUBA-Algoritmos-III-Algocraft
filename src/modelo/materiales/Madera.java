package modelo.materiales;

import modelo.desgaste.bloques.DesgastadorBloqueHacha;
import modelo.desgaste.bloques.DesgastadorBloquePicoDebil;
import modelo.desgaste.herramienta.DesgastadorHerramientaLineal;
import modelo.herramientas.HerramientaNormal;

public class Madera extends Material {
    public Madera() {
        super("madera");
    }

    public static HerramientaNormal crearHacha() {
        int fuerza = 2;
        double durabilidad = 100;
        String nombreHerramienta = "hacha de madera";
        DesgastadorBloqueHacha desgadorDeBloques = new DesgastadorBloqueHacha(fuerza);
        DesgastadorHerramientaLineal desgasteHerramienta = new DesgastadorHerramientaLineal(durabilidad, fuerza);
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, nombreHerramienta);
    }

    public static HerramientaNormal crearPico() {
        int fuerza = 2;
        double durabilidad = 100;
        String nombreHerramienta = "pico de madera";
        DesgastadorBloquePicoDebil desgadorDeBloques = new DesgastadorBloquePicoDebil(fuerza);
        DesgastadorHerramientaLineal desgasteHerramienta = new DesgastadorHerramientaLineal(durabilidad, fuerza);
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, nombreHerramienta);
    }

    public Bloque crearBloque() {
        int durabilidad = 10;
        Bloque bloque = new Bloque(durabilidad, new Madera(), "bloque de madera");
        return bloque;
    }

    public int desgastarMaterial(ItemAtacador item) {
        return item.desgastarMadera();
    }

    public void desgastarContraMaterial(ItemAtacador item) {
        item.desgastarmeContraMadera();
    }
}
