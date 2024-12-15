package modelo.mapa;

import modelo.excepciones.LugarOcupadoError;
import modelo.excepciones.NoExistePosicionEnElMapaError;
import modelo.excepciones.NoHayElementoEnEstaPosicionError;

import java.util.HashMap;
import java.util.Map;

public class Mapeador<Tipo> {
    protected int cantidadColumnas;
    protected int cantidadFilas;
    private Map<Posicion, Tipo> mapa;

    public Mapeador(int cantidadColumnas, int cantidadFilas) {
        mapa = new HashMap<>();
        this.cantidadColumnas = cantidadColumnas;
        this.cantidadFilas = cantidadFilas;
    }

    public int cantidadDeElementosCreados() {
        int cantidadItems = 0;
        for (int x = 0; x < cantidadColumnas; x++) {
            for (int y = 0; y < cantidadFilas; y++) {
                Posicion posicion = new Posicion(x, y);
                if (hayElementoEn(posicion)) {
                    cantidadItems++;
                }
            }
        }
        return cantidadItems;
    }

    protected void inicializar(Tipo objeto) {
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                mapa.put(new Posicion(x, y), objeto);
            }
        }
    }

    protected boolean estaDentroDeLosLimites(Posicion posicion) {
        return estaDentroDeFilas(posicion.fila()) && estaDentroDeLasColumnas(posicion.columna());
    }

    private boolean estaDentroDeFilas(int fila) {
        return (fila >= 0) && (fila < cantidadFilas);
    }

    private boolean estaDentroDeLasColumnas(int columna) {
        return (columna >= 0) && (columna < cantidadColumnas);
    }

    public Tipo obtener(Posicion posicion) {
        if (!estaDentroDeLosLimites(posicion)) {
            throw new NoExistePosicionEnElMapaError();
        } else if (!hayElementoEn(posicion)) {
            throw new NoHayElementoEnEstaPosicionError();
        }
        return mapa.get(posicion);
    }

    public void colocar(Posicion posicion, Tipo objeto) throws NoExistePosicionEnElMapaError, LugarOcupadoError {
        if (!estaDentroDeLosLimites(posicion)) {
            throw new NoExistePosicionEnElMapaError();
        }
        if (estaOcupado(posicion)) {
            throw new LugarOcupadoError();
        }
        mapa.put(posicion, objeto);
    }

    public void intercambiarPor(Posicion posicion, Tipo itemAAgregar) throws NoExistePosicionEnElMapaError {
        if (!estaDentroDeLosLimites(posicion)) {
            throw new NoExistePosicionEnElMapaError();
        }
        mapa.put(posicion, itemAAgregar);
    }

    private boolean estaOcupado(Posicion posicion) {
        return mapa.containsKey(posicion);
    }

    public boolean hayElementoEn(Posicion posicion) {
        if (!estaDentroDeLosLimites(posicion)) {
            throw new NoExistePosicionEnElMapaError();
        }
        return mapa.containsKey(posicion);
    }

    public void vaciar() {
        mapa.clear();
    }

    public void eliminar(Posicion posicion) {
        mapa.remove(posicion);
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Mapeador otroMapa = (Mapeador) obj;
        return mapa.equals(otroMapa.mapa);
    }

    public int cantidadElementosPosibles() {
        return cantidadFilas * cantidadColumnas;
    }

    public int obtenerCantidadFilas() {
        return cantidadFilas;
    }

    public int obtenerCantidadColumnas() {
        return cantidadColumnas;
    }
}
