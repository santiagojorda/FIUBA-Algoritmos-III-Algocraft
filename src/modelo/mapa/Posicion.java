package modelo.mapa;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int columna, int fila) {
        this.fila = fila;
        this.columna = columna;
    }

    public int fila() {
        return fila;
    }

    public int columna() {
        return columna;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fila;
        result = prime * result + columna;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion other = (Posicion) obj;
        return columna == other.columna && fila == other.fila;
    }

    public void incrementarFila() {
        fila++;
    }

    public void decrementarFila() {
        fila--;
    }

    public void incrementarColumna() {
        columna++;
    }

    public void decrementarColuma() {
        columna--;
    }
}