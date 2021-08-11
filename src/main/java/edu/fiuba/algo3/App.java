package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.controladores.ControladorMenu;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws  Exception{
        stage.setTitle("A.L.T.E.G.O");
        ControladorMenu.setEscenario(stage);
        ControladorJuego.setEscenario(stage);
//        ArrayList<String> jugadores = new ArrayList<>();
//        jugadores.add("Franco");
//        jugadores.add("Santi");
//        jugadores.add("Martin");
//        ControladorJuego.empezarPartida(jugadores);
       ControladorMenu.mostrarMenu();

    }

    public static void main(String[] args) {
        launch();
    }

}