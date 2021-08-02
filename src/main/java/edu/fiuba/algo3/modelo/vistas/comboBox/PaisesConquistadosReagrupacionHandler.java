package edu.fiuba.algo3.modelo.vistas.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeReagrupación;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PaisesConquistadosReagrupacionHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private MenuFaseDeReagrupación menu;
    private ComboBox<String> CBPaisDeOrigen;
    private ComboBox<String> CBPaisDeDestino;
    private Label tropasPaisDeOrigen;
    private Label tropasPaisDeDestino;

    public PaisesConquistadosReagrupacionHandler(ComboBox<String> CBPaisDeOrigen, ComboBox<String> CBPaisDeDestino,
                                                 Label tropasPaisDeOrigen, MenuFaseDeReagrupación menu, Juego juego){
        this.CBPaisDeDestino = CBPaisDeDestino;
        this.CBPaisDeOrigen = CBPaisDeOrigen;
        this.menu = menu;
        this.juego = juego;
        this.tropasPaisDeOrigen = tropasPaisDeOrigen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (!CBPaisDeOrigen.getItems().isEmpty()) {
            Pais pais = juego.getTablero().getPais(CBPaisDeOrigen.getSelectionModel().getSelectedItem());
            CBPaisDeDestino.getItems().clear();
            tropasPaisDeOrigen.setText("Tropas: " + String.valueOf(pais.getCantidadDeTropas()));
            for (Pais p : pais.getPaisesLimitrofes()) {
                if(p.dominadoPor(juego.getJugadorActual()))
                    CBPaisDeDestino.getItems().add(p.getNombre());
            }
        }
//        menu.actualizar();
    }
}
