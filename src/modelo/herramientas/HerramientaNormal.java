package modelo.herramientas;

import modelo.desgaste.bloques.DesgastadorBloque;
import modelo.desgaste.herramienta.DesgastadorHerramienta;
import modelo.excepciones.NoSeDesgastaError;

public class HerramientaNormal extends Herramienta {
    public HerramientaNormal(DesgastadorHerramienta desgaste, DesgastadorBloque desgastadorBloque, String nombreHerramienta) {
        super(nombreHerramienta);
        this.desgastadorHerramienta = desgaste;
        this.desgastadorBloque = desgastadorBloque;
    }

    public void desgastarmeContraMadera() {
        desgastar();
    }

    public void desgastarmeContraMetal() {
        desgastar();
    }

    public void desgastarmeContraPiedra() {
        desgastar();
    }

    public void desgastarmeContraDiamante() {
        desgastar();
    }

    public void desgastarmeContraBoss() {
        throw new NoSeDesgastaError();
    }
}
