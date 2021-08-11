package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.controladores.ControladorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonAvanzarTurnoHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Stage stage;

    public BotonAvanzarTurnoHandler(Juego juego, Stage stage){
        this.juego = juego;
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.proximoTurno();
        ControladorJuego.mostrarTablero();

    }
}
