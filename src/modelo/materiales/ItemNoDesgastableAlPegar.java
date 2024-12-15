package modelo.materiales;

import modelo.excepciones.NoPuedePegarConEsteItem;
import modelo.excepciones.NoSeDesgastaError;
import modelo.jugador.ItemInventario;

public abstract class ItemNoDesgastableAlPegar extends ItemInventario {
    public ItemNoDesgastableAlPegar(String nombre) {
        super(nombre);
    }

    public void usarContra(ItemAtacable item) {
        throw new NoPuedePegarConEsteItem();
    }

    @Override
    public int desgastarMadera() {
        return 0;
    }

    @Override
    public void desgastarmeContraMadera() {
        throw new NoSeDesgastaError();
    }

    @Override
    public int desgastarMetal() {
        return 0;
    }

    @Override
    public void desgastarmeContraMetal() {
        throw new NoSeDesgastaError();
    }

    @Override
    public int desgastarPiedra() {
        return 0;
    }

    @Override
    public void desgastarmeContraPiedra() {
        throw new NoSeDesgastaError();
    }

    @Override
    public int desgastarDiamante() {
        return 0;
    }

    @Override
    public void desgastarmeContraDiamante() {
        throw new NoSeDesgastaError();
    }

    @Override
    public int desgastarBoss() {
        return 0;
    }

    @Override
    public void desgastarmeContraBoss() {
        throw new NoSeDesgastaError();
    }
}
