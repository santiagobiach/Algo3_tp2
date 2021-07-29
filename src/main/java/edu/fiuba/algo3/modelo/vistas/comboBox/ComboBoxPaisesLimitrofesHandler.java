package edu.fiuba.algo3.modelo.vistas.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxPaisesLimitrofesHandler implements EventHandler<ActionEvent> {
    private ComboBox<String> cbxPaisesLimitrofes;
    private Juego juego;
    private Label tropasDefensor;
    public ComboBoxPaisesLimitrofesHandler(ComboBox<String> cbx, Label tropasDefensor,  Juego juego){
        this.cbxPaisesLimitrofes = cbx;
        this.juego = juego;
        this.tropasDefensor = tropasDefensor;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        if (!cbxPaisesLimitrofes.getItems().isEmpty()) {
            Pais pais = juego.getTablero().getPais(cbxPaisesLimitrofes.getSelectionModel().getSelectedItem());
            tropasDefensor.setText("Tropas: " + String.valueOf(pais.getCantidadDeTropas()));
        }
    }
}
