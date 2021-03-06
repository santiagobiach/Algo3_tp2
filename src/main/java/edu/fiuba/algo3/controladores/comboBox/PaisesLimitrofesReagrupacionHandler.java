package edu.fiuba.algo3.controladores.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vistas.MenuFaseDeReagrupaciĆ³n;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PaisesLimitrofesReagrupacionHandler implements EventHandler<ActionEvent> {

    private ComboBox<String> CBPaisDeDestino;
    private Juego juego;
    private MenuFaseDeReagrupaciĆ³n menu;
    private Label tropasPaisDeDestino;

    public PaisesLimitrofesReagrupacionHandler(ComboBox<String> CBPaisDeDestino, Label tropasPaisDeDestino,
                                               MenuFaseDeReagrupaciĆ³n menu, Juego juego){
        this.CBPaisDeDestino = CBPaisDeDestino;
        this.juego = juego;
        this.menu = menu;
        this.tropasPaisDeDestino = tropasPaisDeDestino;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (!CBPaisDeDestino.getItems().isEmpty()) {
            Pais pais = juego.getTablero().getPais(CBPaisDeDestino.getSelectionModel().getSelectedItem());
            tropasPaisDeDestino.setText("Tropas: " + String.valueOf(pais.getCantidadDeTropas()));
        }
//        menu.actualizar();
    }
}
