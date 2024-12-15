package modelo.mapa;

public interface EstadoCelda<Tipo> {
    boolean estaVacia();

    boolean estaOcupada();

    Tipo ocuparCon(Tipo nuevoItem);
}
