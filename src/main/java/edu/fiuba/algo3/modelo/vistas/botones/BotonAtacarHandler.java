package edu.fiuba.algo3.modelo.vistas.botones;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
    Label txt;
    public BotonAtacarHandler(Label txt){
        this.txt = txt;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.txt.setText("Turno: Jugador ");
        this.txt.setTextFill(Color.RED);
    }
}
