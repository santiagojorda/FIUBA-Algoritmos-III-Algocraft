package modelo.materiales;

public abstract class Material extends ItemNoDesgastableAlPegar {
    public Material(String nombre) {
        super(nombre);
    }

    abstract int desgastarMaterial(ItemAtacador item);

    abstract void desgastarContraMaterial(ItemAtacador item);

    public Bloque crearBloque() {
        return null;
    }
}
