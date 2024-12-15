package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioControlador {
    @FXML
    public void jugar(ActionEvent event) throws Exception {
        Parent archivoJuego = FXMLLoader.load(getClass().getResource("../vista/ventanas/Juego.fxml"));
        Scene escenaJuego = new Scene(archivoJuego);
        Stage ventanaPrincipal = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaPrincipal.setTitle("Algocraft");
        ventanaPrincipal.setScene(escenaJuego);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.show();
    }
}
