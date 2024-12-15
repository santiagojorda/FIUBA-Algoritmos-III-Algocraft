package modelo.mapa;

import modelo.excepciones.LugarOcupadoError;

public class Ocupado<Tipo> implements EstadoCelda<Tipo> {
    @Override
    public boolean estaVacia() {
        return false;
    }

    @Override
    public boolean estaOcupada() {
        return true;
    }

    @Override
    public Tipo ocuparCon(Tipo nuevoItem) {
        throw new LugarOcupadoError();
    }
}
