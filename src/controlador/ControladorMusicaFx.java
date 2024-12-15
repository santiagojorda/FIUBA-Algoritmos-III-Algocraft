package controlador;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControladorMusicaFx {
    private static ControladorMusicaFx INSTANCIA;
    protected String URL_SONIDOS = "/vista/sonidos/";
    private MediaPlayer sonidoFondo;
    private MediaPlayer caminar = new MediaPlayer(new Media(getClass().getResource(URL_SONIDOS + "caminarEnMadera.mp3").toExternalForm()));
    private MediaPlayer golpear = new MediaPlayer(new Media(getClass().getResource(URL_SONIDOS + "golpe.mp3").toExternalForm()));
    private MediaPlayer obtenerItem = new MediaPlayer(new Media(getClass().getResource(URL_SONIDOS + "obtenerItem.mp3").toExternalForm()));
    private MediaPlayer sonidoAccion = caminar;

    public ControladorMusicaFx() {
        INSTANCIA = this;
    }

    public static ControladorMusicaFx getINSTANCIA() {
        return INSTANCIA;
    }

    private void play(MediaPlayer reproductor, Double volumen, boolean auto) {
        reproductor.play();
        reproductor.setVolume(volumen);
        if (auto) {
            reproductor.setOnEndOfMedia(() -> reproductor.seek(Duration.ZERO));
        }
    }

    private MediaPlayer crearSonido(String nombreArchivo) {
        MediaPlayer sonido = new MediaPlayer(new Media(getClass().getResource(URL_SONIDOS + nombreArchivo + ".mp3").toExternalForm()));
        return sonido;
    }

    public void inicio() {
        MediaPlayer inicio = crearSonido("cat");
        this.play(inicio, 10.0, false);
        this.sonidoFondo = inicio;
    }

    public void caminar() {
        this.sonidoAccion.stop();
        MediaPlayer accion = caminar;
        this.play(accion, 10.0, false);
        this.sonidoAccion = accion;
    }

    public void golpear() {
        this.sonidoAccion.stop();
        MediaPlayer accion = golpear;
        this.play(accion, 10.0, false);
        this.sonidoAccion = accion;
    }

    public void controlarMusica(Button botonMusica) {
        if (!estaSonando()) {
            iniciar();
            botonMusica.setText("Desactivar Musica");
        } else {
            sonidoFondo.stop();
            botonMusica.setText("Activar Musica");
        }
    }

    private boolean estaSonando() {
        return sonidoFondo.getStatus().equals(MediaPlayer.Status.PLAYING);
    }

    public void iniciar() {
        MediaPlayer inGame = crearSonido("juego");
        this.play(inGame, 15.99, true);
        this.sonidoFondo = inGame;
    }

    public void obtenerItem() {
        this.sonidoAccion.stop();
        MediaPlayer accion = obtenerItem;
        this.play(accion, 10.0, false);
        this.sonidoAccion = accion;
    }

    public void parar() {
        this.sonidoFondo.stop();
    }
}