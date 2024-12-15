package modelo.desgaste.herramienta;

public abstract class DesgastadorHerramienta {
    protected double durabilidad;

    public DesgastadorHerramienta(double durabilidad) {
        this.durabilidad = durabilidad;
    }

    public double obtenerDurabilidad() {
        return durabilidad;
    }

    public abstract void desgastar();
}