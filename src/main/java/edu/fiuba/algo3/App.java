package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorContinentesConquistados;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorPaisesConquistados;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.controladores.ControladorMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

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
        ControladorMenu.mostrarMenu();
    }


    public static void main(String[] args) {
        launch();
    }

}