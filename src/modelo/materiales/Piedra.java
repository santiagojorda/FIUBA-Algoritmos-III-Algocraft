package modelo.materiales;

import modelo.desgaste.bloques.DesgastadorBloqueHacha;
import modelo.desgaste.bloques.DesgastadorBloquePico;
import modelo.desgaste.herramienta.DesgastadorHerramientaLineal;
import modelo.herramientas.HerramientaNormal;

public class Piedra extends Material {
    public Piedra() {
        super("piedra");
    }

    public static HerramientaNormal crearHacha() {
        int fuerza = 5;
        double durabilidad = 200;
        DesgastadorBloqueHacha desgadorDeBloques = new DesgastadorBloqueHacha(fuerza);
        DesgastadorHerramientaLineal desgasteHerramienta = new DesgastadorHerramientaLineal(durabilidad, fuerza);
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, "hacha de piedra");
    }

    public static HerramientaNormal crearPico() {
        int fuerza = 4;
        double durabilidad = 200;
        String nombreHerramienta = "pico de piedra";
        DesgastadorBloquePico desgadorDeBloques = new DesgastadorBloquePico(fuerza);
        DesgastadorHerramientaLineal desgasteHerramienta = new DesgastadorHerramientaLineal(durabilidad, ((double) (fuerza)) / (1.5));
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, nombreHerramienta);
    }

    public Bloque crearBloque() {
        int durabilidad = 30;
        Bloque bloque = new Bloque(durabilidad, new Piedra(), "bloque de piedra");
        return bloque;
    }

    public int desgastarMaterial(ItemAtacador item) {
        return item.desgastarPiedra();
    }

    public void desgastarContraMaterial(ItemAtacador item) {
        item.desgastarmeContraPiedra();
    }
}
