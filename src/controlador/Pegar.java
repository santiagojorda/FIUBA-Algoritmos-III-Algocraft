package controlador;

import javafx.scene.input.MouseEvent;
import vista.grafica.Tablero;

public class Pegar {
    public static void Pegar(Tablero graficador, MouseEvent e) {
        graficador.pegarAUnaCelda((int) e.getX(), (int) e.getY());
    }
}
