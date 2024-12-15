package modelo.materiales;

import modelo.desgaste.bloques.DesgastadorBloqueEspada;
import modelo.desgaste.herramienta.DesgastadorHerramientaAGolpez;
import modelo.herramientas.Herramienta;
import modelo.herramientas.MatadorDeBoss;

public class Diamante extends Material {
    public Diamante() {
        super("diamante");
    }

    public static Herramienta crearEspada() {
        double durabilidad = 10000;
        String nombreHerramienta = "espada de diamante";
        DesgastadorBloqueEspada desgadorDeBloques = new DesgastadorBloqueEspada(100);
        DesgastadorHerramientaAGolpez desgasteHerramienta = new DesgastadorHerramientaAGolpez(durabilidad, 1);
        return new MatadorDeBoss(desgasteHerramienta, desgadorDeBloques, nombreHerramienta);
    }

    public Bloque crearBloque() {
        int durabilidad = 100;
        Bloque bloque = new Bloque(durabilidad, new Diamante(), "bloque de diamante");
        return bloque;
    }

    public int desgastarMaterial(ItemAtacador item) {
        return item.desgastarDiamante();
    }

    public void desgastarContraMaterial(ItemAtacador item) {
        item.desgastarmeContraDiamante();
    }
}
