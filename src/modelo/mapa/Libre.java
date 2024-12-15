package modelo.mapa;

public class Libre<Tipo> implements EstadoCelda<Tipo> {
    public boolean estaVacia() {
        return true;
    }

    @Override
    public boolean estaOcupada() {
        return false;
    }

    public Tipo ocuparCon(Tipo nuevoItem) {
        return nuevoItem;
    }
}
