package modelo.herramientas;

import modelo.desgaste.bloques.DesgastadorBloque;
import modelo.desgaste.herramienta.DesgastadorHerramienta;

public class MatadorDeBoss extends Herramienta {
    public MatadorDeBoss(DesgastadorHerramienta desgaste, DesgastadorBloque desgastadorBloque, String nombreHerramienta) {
        super(nombreHerramienta);
        this.desgastadorHerramienta = desgaste;
        this.desgastadorBloque = desgastadorBloque;
    }

    @Override
    public void desgastarmeContraMadera() {
        desgastar();
    }

    @Override
    public void desgastarmeContraMetal() {
        desgastar();
    }

    @Override
    public void desgastarmeContraPiedra() {
        desgastar();
    }

    @Override
    public void desgastarmeContraDiamante() {
        desgastar();
    }

    @Override
    public void desgastarmeContraBoss() {
        desgastar();
    }
}
