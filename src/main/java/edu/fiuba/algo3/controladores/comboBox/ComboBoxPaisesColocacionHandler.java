package edu.fiuba.algo3.controladores.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxPaisesColocacionHandler implements EventHandler<ActionEvent> {

    private ComboBox<String> cbx;
    private Label tropas;
    private Juego juego;
    public ComboBoxPaisesColocacionHandler(ComboBox<String> cbx, Label tropas, Juego juego){
        this.cbx = cbx;
        this.tropas = tropas;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (!cbx.getItems().isEmpty()) {
            Pais pais = juego.getTablero().getPais(cbx.getSelectionModel().getSelectedItem());

            tropas.setText("Tropas: " + String.valueOf(pais.getCantidadDeTropas()));

        }
    }
}
