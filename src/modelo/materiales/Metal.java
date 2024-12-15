package modelo.materiales;

import modelo.desgaste.bloques.DesgastadorBloqueHacha;
import modelo.desgaste.bloques.DesgastadorBloquePico;
import modelo.desgaste.herramienta.DesgastadorHerramientaAGolpez;
import modelo.desgaste.herramienta.DesgastadorHerramientaLineal;
import modelo.herramientas.HerramientaNormal;

public class Metal extends Material {
    public Metal() {
        super("metal");
    }

    public static HerramientaNormal crearHacha() {
        int fuerza = 10;
        double durabilidad = 400;
        DesgastadorBloqueHacha desgadorDeBloques = new DesgastadorBloqueHacha(fuerza);
        DesgastadorHerramientaLineal desgasteHerramienta = new DesgastadorHerramientaLineal(durabilidad, fuerza / 2);
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, "hacha de metal");
    }

    public static HerramientaNormal crearPico() {
        int fuerza = 12;
        double durabilidad = 400;
        int usosMaximos = 10;
        String nombreHerramienta = "pico de metal";
        DesgastadorBloquePico desgadorDeBloques = new DesgastadorBloquePico(fuerza);
        DesgastadorHerramientaAGolpez desgasteHerramienta = new DesgastadorHerramientaAGolpez(durabilidad, usosMaximos);
        return new HerramientaNormal(desgasteHerramienta, desgadorDeBloques, nombreHerramienta);
    }

    public Bloque crearBloque() {
        int durabilidad = 50;
        Bloque bloque = new Bloque(durabilidad, new Metal(), "bloque de metal");
        return bloque;
    }

    public int desgastarMaterial(ItemAtacador item) {
        return item.desgastarMetal();
    }

    public void desgastarContraMaterial(ItemAtacador item) {
        item.desgastarmeContraMetal();
    }
}
