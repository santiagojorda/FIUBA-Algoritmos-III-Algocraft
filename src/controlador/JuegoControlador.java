package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import modelo.juego.Juego;
import modelo.mapa.Posicion;
import vista.grafica.Inventario;
import vista.grafica.MesaCrafteo;
import vista.grafica.Tablero;

import java.net.URL;
import java.util.ResourceBundle;

public class JuegoControlador extends Pane implements Initializable {
    @FXML
    private Canvas canvasTablero;
    @FXML
    private Canvas canvasInventario;
    @FXML
    private Canvas canvasMesaCrafteo;
    @FXML
    private Label label;
    @FXML
    private Button botonMusica;
    private Juego juego;
    private MesaCrafteo mesaCrafteo;
    private Inventario inventario;
    private Tablero tablero;
    private ControladorMusicaFx musica = ControladorMusicaFx.getINSTANCIA();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        juego = new Juego();
        tablero = new Tablero(canvasTablero, juego);
        inventario = new Inventario(canvasInventario, juego);
        mesaCrafteo = new MesaCrafteo(canvasMesaCrafteo, juego);
        ControladorDeImpresiones.agregarConsola(label);
        ControladorDeImpresiones.mostrarInfoInicio();
        musica.parar();
        dibujar();
        musica.iniciar();
    }

    private void dibujar() {
        ControladorDeImpresiones.imprimir();
    }

    public void moverArribaJugador(ActionEvent actionEvent) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        new MoverJugadorArriba(tablero, juego);
        dibujar();
    }

    public void moverAbajoJugador(ActionEvent actionEvent) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        new MoverJugadorAbajo(tablero, juego);
        dibujar();
    }

    public void moverDerechaJugador(ActionEvent actionEvent) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        new MoverJugadorDerecha(tablero, juego);
        dibujar();
    }

    public void moverIzquierdaJugador(ActionEvent actionEvent) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        new MoverJugadorIzquierda(tablero, juego);
        dibujar();
    }

    @FXML
    private void moverJugadorConTeclas(KeyEvent e) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        new MoverJugadorConTeclado(tablero, juego, e);
        dibujar();
    }

    public void equiparItem(ActionEvent actionEvent) {

        Posicion posSelecionada = ControladorDeClicksItemsMovibles.obtenerPrimeraPosicion();
        Boolean fueEnInventario = ControladorDeClicksItemsMovibles.fueEn(inventario);
        ControladorDeClicksItemsMovibles.borrarClicks();
        if(fueEnInventario){
            if (posSelecionada != null) {
                new EquiparHerramienta(juego, posSelecionada);
            }
        }
        else
            ControladorDeImpresiones.imprimirEstado("No puedes equiparte un item fuera del inventario");
        ControladorDeClicksItemsMovibles.borrarClicks();

    }

    public void musicalizar(ActionEvent actionEvent) {
        ControladorDeClicksItemsMovibles.borrarClicks();

        musica.controlarMusica(botonMusica);
    }
}
