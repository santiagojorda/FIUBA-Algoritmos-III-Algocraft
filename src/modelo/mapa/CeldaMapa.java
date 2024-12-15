package modelo.mapa;

public class CeldaMapa {
    private EstadoCelda<Item> estadoCelda = new Libre();
    private Item objetoFondo = new Item("bloque de tierra");
    private Item objeto = objetoFondo;

    public void eliminarObjeto() {
        objeto = objetoFondo;
        estadoCelda = new Libre();
    }

    public boolean estaVacia() {
        return estadoCelda.estaVacia();
    }

    public boolean estaOcupada() {
        return estadoCelda.estaOcupada();
    }

    public Item obtenerObjeto() {
        return objeto;
    }

    public void colocarObjeto(Item nuevoItem) {
        objeto = estadoCelda.ocuparCon(nuevoItem);
        estadoCelda = new Ocupado();
    }
}


