package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.vistas.VistaMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Stack;

/**
 * JavaFX App
 */
public class App extends Application {

    private void vistaAgregarJugadores(){

    }

    @Override
    public void start(Stage stage) {
        Button btn = new Button();
        btn.setText("TEG");

        var scene = new Scene(new VistaMenu(), 640, 480);

        stage.setTitle("A.L.T.E.G.O");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}