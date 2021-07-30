package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeReagrupación;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class BotonReagruparHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private MenuFaseDeReagrupación menu;
    private Spinner SPTropas;
    private Label tropasPaisDeOrigen;
    private Label tropasPaisDeDestino;
    private ComboBox<String> CBPaisDeOrigen;
    private ComboBox<String> CBPaisDeDestino;

    public BotonReagruparHandler(ComboBox<String> CBPaisDeOrigen, ComboBox CBPaisDeDestino,
                                 Spinner SPTropas, Label tropasPaisDeOrigen, Label tropasPaisDeDestino, Juego juego){
        this.SPTropas = SPTropas;
        this.menu = menu;
        this.juego = juego;
        this.tropasPaisDeDestino = tropasPaisDeDestino;
        this.tropasPaisDeOrigen = tropasPaisDeOrigen;
        this.CBPaisDeDestino = CBPaisDeDestino;
        this.CBPaisDeOrigen = CBPaisDeOrigen;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Pais paisDeOrigen = null;
        Pais paisDeDestino = null;

        if (!CBPaisDeOrigen.getItems().isEmpty())
            paisDeOrigen = juego.getTablero().getPais((CBPaisDeOrigen.getSelectionModel().getSelectedItem()));

        if (!CBPaisDeDestino.getItems().isEmpty())
            paisDeDestino = juego.getTablero().getPais((CBPaisDeDestino.getSelectionModel().getSelectedItem()));

        Integer cantidad = 0;
        try{
            cantidad = (Integer)SPTropas.getValue();

        } catch (Exception e){};

        if(paisDeDestino != null && paisDeOrigen != null){
            System.out.println("ORIGEN: "+paisDeOrigen.getNombre());
            System.out.println("DESTINO: "+paisDeDestino.getNombre());
            System.out.println("ALIADOS: "+paisDeDestino.esAliado(paisDeOrigen));

            paisDeOrigen.moverTropasA(paisDeDestino, cantidad);
            tropasPaisDeOrigen.setText("Tropas: " + String.valueOf(paisDeOrigen.getCantidadDeTropas()));
            tropasPaisDeDestino.setText("Tropas: " + String.valueOf(paisDeDestino.getCantidadDeTropas()));
        }




    }
}
