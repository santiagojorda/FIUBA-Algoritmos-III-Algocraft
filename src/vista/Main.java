package vista;

import controlador.ControladorMusicaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {
        ventanaPrincipal.setTitle("Algocraft ");
        ventanaPrincipal.getIcons().add(new Image("vista/imagenes/icono.png"));
        Parent inicio = FXMLLoader.load(getClass().getResource("ventanas/Inicio.fxml"));
        ventanaPrincipal.setResizable(false);
        ControladorMusicaFx musica = new ControladorMusicaFx();
        musica.inicio();
        ventanaPrincipal.setScene(new Scene(inicio));
        ventanaPrincipal.show();
    }
}
