package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonAvanzarTurnoHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private MenuFaseDeAtaque menu;
    public BotonAvanzarTurnoHandler(Juego juego, MenuFaseDeAtaque menu){
        this.juego = juego;
        this.menu=menu;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.proximoTurno();
        menu.actualizar();
    }
}
