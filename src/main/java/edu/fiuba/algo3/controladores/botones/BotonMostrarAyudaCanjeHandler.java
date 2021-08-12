package edu.fiuba.algo3.controladores.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonMostrarAyudaCanjeHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Canjes");
        alert.setTitle("Ayuda para canje");


        alert.setContentText("Se le otorgara una carta al finalizar su turno de ataque si usted a conquistado un pais. " +
                "Cuando llega la fase de colocacion, usted puede, si domina al pais de la carta, activarla y " +
                " conseguir dos ejercitos adicionales en dicho pais. \n" +
                "A su vez, si usted junta 3 cartas del mismo simbolo, o 3 de simbolos distintos entre si, puede canjear" +
                "dichas cartas y conseguir un numero de tropas a poner donde usted quiera segun cuantas veces haya hecho" +
                "canjes. Primera: 4 tropas Segunda: 7 tropas Tercera: 10 tropas Cuarta y superior: (n-1)*5");
        alert.showAndWait();
    }
}
