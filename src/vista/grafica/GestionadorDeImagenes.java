package vista.grafica;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class GestionadorDeImagenes {
    public Map<String, Image> imagenes;
    protected String URL_IMAGENES = "vista/imagenes/";
    protected Image metal = crearImagen("metal.png");
    protected Image madera = crearImagen("madera.png");
    protected Image piedra = crearImagen("piedra.png");
    protected Image diamante = crearImagen("diamante.png");
    protected Image bloqueMetal = crearImagen("bloqueMetal.png");
    protected Image bloqueMadera = crearImagen("bloqueMadera.png");
    protected Image bloquePiedra = crearImagen("bloquePiedra.png");
    protected Image bloqueDiamante = crearImagen("bloqueDiamante.png");
    protected Image bloqueTierra = crearImagen("bloqueTierra.png");
    protected Image hachaMadera = crearImagen("hachaMadera.png");
    protected Image picoMadera = crearImagen("picoMadera.png");
    protected Image hachaPiedra = crearImagen("hachaPiedra.png");
    protected Image picoPiedra = crearImagen("picoPiedra.png");
    protected Image picoMetal = crearImagen("picoMetal.png");
    protected Image hachaMetal = crearImagen("hachaMetal.png");
    protected Image picoFino = crearImagen("picoFino.png");
    protected Image espadaDiamante = crearImagen("espadaDiamante.png");
    protected Image jugadorMirandoIzquierda = crearImagen("jugadorMirandoIzquierda.gif");
    protected Image jugadorMirandoDerecha = crearImagen("jugadorMirandoDerecha.gif");
    protected Image jugadorMirandoAbajo = crearImagen("jugadorMirandoAbajo.gif");
    protected Image jugadorMirandoArriba = crearImagen("jugadorMirandoArriba.gif");
    protected Image jugador = jugadorMirandoAbajo;
    protected Image donald = crearImagen("donald.gif");
    protected Image ghost = crearImagen("ghost.gif");

    public GestionadorDeImagenes() {
        imagenes = new HashMap<>();
        imagenes.put("metal", metal);
        imagenes.put("madera", madera);
        imagenes.put("piedra", piedra);
        imagenes.put("diamante", diamante);
        imagenes.put("bloque de metal", bloqueMetal);
        imagenes.put("bloque de madera", bloqueMadera);
        imagenes.put("bloque de piedra", bloquePiedra);
        imagenes.put("bloque de diamante", bloqueDiamante);
        imagenes.put("bloque de tierra", bloqueTierra);
        imagenes.put("pico de madera", picoMadera);
        imagenes.put("hacha de madera", hachaMadera);
        imagenes.put("hacha de piedra", hachaPiedra);
        imagenes.put("pico de piedra", picoPiedra);
        imagenes.put("pico de metal", picoMetal);
        imagenes.put("hacha de metal", hachaMetal);
        imagenes.put("pico fino", picoFino);
        imagenes.put("espada de diamante", espadaDiamante);
        imagenes.put("jugador", jugador);
        imagenes.put("donald", donald);
        imagenes.put("ghost", ghost);
    }

    private Image crearImagen(String nombreImagen) {
        return new Image(URL_IMAGENES + nombreImagen);
    }

    public Image obtenerImagen(String nombreObjeto) {
        return imagenes.get(nombreObjeto);
    }

    public void jugadorMiraArriba() {
        imagenes.put("jugador", jugadorMirandoArriba);
    }

    public void jugadorMiraAbajo() {
        imagenes.put("jugador", jugadorMirandoAbajo);
    }

    public void jugadorMiraALaDerecha() {
        imagenes.put("jugador", jugadorMirandoDerecha);
    }

    public void jugadorMiraALaIzquierda() {
        imagenes.put("jugador", jugadorMirandoIzquierda);
    }
}