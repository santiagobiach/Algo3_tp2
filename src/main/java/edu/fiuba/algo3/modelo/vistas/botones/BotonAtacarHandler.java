package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeAtaque;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private ComboBox<String> cbxAtacante;
    private ComboBox<String> cbxDefensor;
    private MenuFaseDeAtaque menu;
    private Spinner tropas;
    public BotonAtacarHandler(Juego juego, ComboBox<String> cbxAtacante, ComboBox<String> cbxDefensor,
                              Spinner tropas, MenuFaseDeAtaque menu){
        this.juego = juego;
        this.cbxAtacante = cbxAtacante;
        this.cbxDefensor = cbxDefensor;
        this.menu = menu;
        this.tropas = tropas;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(cbxAtacante.getSelectionModel().getSelectedItem() == null ||
                cbxDefensor.getSelectionModel().getSelectedItem() == null){
            System.out.println("Debe seleccionar un pais atacante y uno defensor");
        }else{
            Pais atacante = juego.getTablero().getPais(cbxAtacante.getSelectionModel().getSelectedItem());
            Pais defensor = juego.getTablero().getPais(cbxDefensor.getSelectionModel().getSelectedItem());
            System.out.println((int)tropas.getValue());
            juego.crearBatalla(atacante, defensor, (int)tropas.getValue());
            menu.actualizar();
        }

    }
}
