package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class BotonColocarHandler implements EventHandler<ActionEvent> {
    private ComboBox<String> CBPaisDeOrigen;
    private Juego juego;
    private Label tropasPaisDeOrigen;
    private Label tropasDisponibles;
    private Spinner SPTropas;

    public BotonColocarHandler(ComboBox<String> CBPaisDeOrigen, Label tropasPaisDeOrigen, Label tropasDisponibles,
                               Spinner SPTropas, Juego juego){
        this.CBPaisDeOrigen = CBPaisDeOrigen;
        this.SPTropas = SPTropas;
        this.tropasPaisDeOrigen = tropasPaisDeOrigen;
        this.tropasDisponibles = tropasDisponibles;
        this.juego = juego;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(CBPaisDeOrigen.getSelectionModel().getSelectedItem() == null){
            System.out.println("Error");
        }else{
            Pais pais = juego.getTablero().getPais(CBPaisDeOrigen.getSelectionModel().getSelectedItem());

            juego.getJugadorActual().colocarEjercitosEn((int)SPTropas.getValue(), pais);
            tropasPaisDeOrigen.setText("Tropas: " + String.valueOf(pais.getCantidadDeTropas()));
            tropasDisponibles.setText("Tropas disponibles: " +  juego.getJugadorActual().tropasDisponibles());
        }
    }
}
