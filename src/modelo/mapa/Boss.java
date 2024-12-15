package modelo.mapa;

import modelo.excepciones.ItemSeRompioError;
import modelo.excepciones.NoSeDesgastaError;
import modelo.jugador.ItemInventario;
import modelo.materiales.ItemAtacable;
import modelo.materiales.ItemAtacador;
import modelo.materiales.ItemNoDesgastableAlPegar;

public class Boss extends ItemNoDesgastableAlPegar implements ItemAtacable {
    private double durabilidad = 1;

    public Boss(String nombre) {
        super(nombre);
    }

    @Override
    public void desgastarItemAtacador(ItemAtacador itemAtacador) {
        try {
            itemAtacador.desgastarmeContraBoss();
        } catch (NoSeDesgastaError Exception) {
        }
    }

    @Override
    public void desgastarseASiMismoCon(ItemAtacador item) {
        int desgaste = item.desgastarBoss();
        durabilidad -= desgaste;
        if (durabilidad <= 0) {
            throw new ItemSeRompioError();
        }
    }

    public double obtenerDurabilidad() {
        return durabilidad;
    }

    public ItemInventario soltarMaterial() {
        return this;
    }
}
