package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeAtaque;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeReagrupación;
import edu.fiuba.algo3.modelo.vistas.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.Hashtable;

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
        ControladorJuego.mostrarTableroSegunFase();

    }
}
