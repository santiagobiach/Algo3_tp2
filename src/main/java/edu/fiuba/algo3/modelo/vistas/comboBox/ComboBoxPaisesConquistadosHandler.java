package edu.fiuba.algo3.modelo.vistas.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class ComboBoxPaisesConquistadosHandler implements EventHandler<ActionEvent> {
    private ComboBox<String> cbxPaisesLimitrofes;
    private ComboBox<String> cbx;
    private Juego juego;
    public ComboBoxPaisesConquistadosHandler(ComboBox<String> cbx, ComboBox<String> cbxPaisesLimitrofes, Juego juego){
       this.cbxPaisesLimitrofes = cbxPaisesLimitrofes;
       this.cbx = cbx;
       this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (!cbx.getItems().isEmpty()) {
            Pais pais = juego.getTablero().getPais(cbx.getSelectionModel().getSelectedItem());
            cbxPaisesLimitrofes.getItems().clear();

            for (Pais p : pais.getPaisesLimitrofes()) {
                cbxPaisesLimitrofes.getItems().add(p.getNombre());
            }
            cbxPaisesLimitrofes.getSelectionModel().selectFirst();
        }
    }
}
