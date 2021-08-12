package edu.fiuba.algo3.controladores.comboBox;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ComboBoxJugadoresVistaVictoriaHandler implements EventHandler<ActionEvent> {
    private ComboBox<Jugador> jugadoresCB;
    private ListView<Pais> paises;
    public ComboBoxJugadoresVistaVictoriaHandler(ComboBox<Jugador> jugadoresCB, ListView<Pais> paises){
        this.jugadoresCB = jugadoresCB;
        this.paises = paises;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        paises.getItems().clear();
        Jugador aux = jugadoresCB.getSelectionModel().getSelectedItem();
        for(Pais p: aux.getPaisesConquistados()){
            paises.getItems().add(p);
        }
    }
}
