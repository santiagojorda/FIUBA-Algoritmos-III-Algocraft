package vista.grafica;

import controlador.ControladorDeImpresiones;
import controlador.ControladorMusicaFx;
import controlador.Pegar;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.jugador.ItemInventario;
import modelo.mapa.Item;
import modelo.mapa.Posicion;

public class Tablero extends GraficadorMapa {
    public Tablero(Canvas canvas, Juego juego) {
        super(10, 10, canvas, juego);
        canvas.setOnMouseClicked(e -> Pegar.Pegar(this, e));
    }

    public boolean hayItemEn(Posicion posicion) {
        return false;
    }

    @Override
    public void borrarItemEn(Posicion posicionInicial) {
    }

    @Override
    public void posicionarItem(Posicion posicionFinal, ItemInventario itemFinal) {
    }

    protected void cargarInformacion() {
        for (int y = 0; y < cantidadFilas; y++) {
            for (int x = 0; x < cantidadColumnas; x++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda;
                String nombre = juego.obtenerItemEnTablero(posicion).obtenerNombre();
                Image imagenActual = obtenerImagen(nombre);
                Image imagenFondo = obtenerImagen("bloque de tierra");
                celda = new CeldaGraficaConImagen(gc, posicion, tamanoCelda, imagenFondo, imagenActual);
                intercambiarPor(posicion, celda);
            }
        }
    }

    public void voltearJugadorArriba() {
        gestionadorDeImagenes.jugadorMiraArriba();
    }

    public void voltearJugadorIzquierda() {
        gestionadorDeImagenes.jugadorMiraALaIzquierda();
    }

    public void voltearJugadorAbajo() {
        gestionadorDeImagenes.jugadorMiraAbajo();
    }

    public void voltearJugadorDerecha() {
        gestionadorDeImagenes.jugadorMiraALaDerecha();
    }

    private void utilizarHerramientaEquipadaEn(Posicion posicion) {
        Item itemAtacado = juego.obtenerItemEnTablero(posicion);
        ControladorMusicaFx musica = ControladorMusicaFx.getINSTANCIA();
        try {
            juego.usarHerramientaEquipadaEn(posicion);
            musica.golpear();
        } catch (NoSeDesgastaError Exception) {
            ControladorDeImpresiones.imprimirEstado("No puedes desgastar " + itemAtacado.obtenerNombre() + " con " + juego.obtenerNombreItemEquipado());
            musica.golpear();
        } catch (JugadorNoSeEncuentraEnElRangoDeAtacaError Exception) {
            ControladorDeImpresiones.imprimirEstado("El objeto se encuentra muy lejos");
        } catch (NoHayUnItemEquipadoError noHayUnItemEquipado) {
            ControladorDeImpresiones.imprimirEstado("No posees ningun item equipado");
        } catch (NoPuedePegarConEsteItem e) {
            ControladorDeImpresiones.imprimirEstado("No puedes pegar con este item!");
        } catch (NoSePuedePegarAlJugador noSePuedePegarAlJugador) {
            ControladorDeImpresiones.imprimirEstado("No puedes pegarte a ti mismo!");
        } catch (ItemSeRompioError e) {
            musica.obtenerItem();
            ControladorDeImpresiones.imprimirEstado("Has conseguido " + itemAtacado.obtenerNombre());
            ControladorDeImpresiones.imprimir();
        } catch (NoTieneMaterialParaSoltar Exception) {
            ControladorDeImpresiones.imprimirEstado("El objeto no solto un item.");
            ControladorDeImpresiones.imprimir();

        } catch (MurioElBoss Exception) {
            musica.inicio();
            ControladorDeImpresiones.imprimir();
            ControladorDeImpresiones.imprimirEstado("Ganaste!");
        }
    }

    public void pegarAUnaCelda(int xSeleccionado, int ySeleccionado) {
        for (int x = 0; x < cantidadColumnas; x++) {
            for (int y = 0; y < cantidadFilas; y++) {
                Posicion posicion = new Posicion(x, y);
                CeldaGrafica celda = obtener(posicion);
                if (celda.elPuntoEstaDentro(xSeleccionado, ySeleccionado)) {
                    Posicion posicionCliqueada = celda.getPosicionReal();
                    if (juego.hayItemEnTablero(posicionCliqueada)) {
                        utilizarHerramientaEquipadaEn(posicionCliqueada);
                    }
                }
            }
        }
    }
}

