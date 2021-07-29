package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonMostrarObjetivoHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    public BotonMostrarObjetivoHandler(Juego juego){
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Objetivos(Solo se debe cumplir uno para ganar)");
        alert.setTitle("Objetivos");
        String descripciones= "";
        for(Objetivo obj: juego.getJugadorActual().getObjetivos()){

            descripciones = descripciones + obj.getDescripcion() + "\n";

        }

        alert.setContentText(descripciones);
        alert.showAndWait();
    }
}
