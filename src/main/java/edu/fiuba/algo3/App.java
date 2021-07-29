package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.controladores.ControladorMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Hashtable;

/**
 * JavaFX App
 */
public class App extends Application {

    private void vistaAgregarJugadores(){

    }

    @Override
    public void start(Stage stage) {
        //Button btn = new Button();
        //btn.setText("TEG");

        //var scene = new Scene(new VistaMenu(), 640, 480);

        //stage.setTitle("A.L.T.E.G.O");
        //stage.setScene(scene);

        //stage.show();
        stage.setTitle("A.L.T.E.G.O");

        ControladorMenu.setEscenario(stage);
        ControladorJuego.setEscenario(stage);
        ControladorMenu.mostrarMenu();
    }


    public static void main(String[] args) {
        launch();
    }

}