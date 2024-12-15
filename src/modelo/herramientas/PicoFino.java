package modelo.herramientas;

import modelo.desgaste.bloques.DesgastadorBloquePico;
import modelo.desgaste.herramienta.DesgastadorHerramientaLineal;
import modelo.excepciones.NoSeDesgastaError;

public class PicoFino extends Herramienta {
    public PicoFino() {
        super("pico fino");
        int fuerza = 20;
        double durabilidad = 1000;
        desgastadorHerramienta = new DesgastadorHerramientaLineal(durabilidad, durabilidad * 0.1);
        desgastadorBloque = new DesgastadorBloquePico(fuerza);
    }

    public void desgastarmeContraMadera() {
        throw new NoSeDesgastaError();
    }

    public void desgastarmeContraMetal() {
        throw new NoSeDesgastaError();
    }

    public void desgastarmeContraPiedra() {
        throw new NoSeDesgastaError();
    }

    public void desgastarmeContraDiamante() {
        desgastar();
    }

    public void desgastarmeContraBoss() {
        throw new NoSeDesgastaError();
    }
}