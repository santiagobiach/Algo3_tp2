package edu.fiuba.algo3.modelo.vistas.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeReagrupación;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;

public class PaisesLimitrofesReagrupacionHandler implements EventHandler<ActionEvent> {

    private ComboBox<String> CBPaisDeDestino;
    private Juego juego;
    private MenuFaseDeReagrupación menu;
    private Label tropasPaisDeDestino;

    public PaisesLimitrofesReagrupacionHandler(ComboBox<String> CBPaisDeDestino, Label tropasPaisDeDestino,
                                               MenuFaseDeReagrupación menu, Juego juego){
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
