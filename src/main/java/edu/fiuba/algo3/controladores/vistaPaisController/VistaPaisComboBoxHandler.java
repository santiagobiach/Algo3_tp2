package edu.fiuba.algo3.controladores.vistaPaisController;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class VistaPaisComboBoxHandler implements EventHandler<MouseEvent> {
    private ComboBox<String> CBPais;
    private String nombrePais;
    public VistaPaisComboBoxHandler(ComboBox<String> CBPais, String nombrePais){
        this.CBPais = CBPais;
        this.nombrePais = nombrePais;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        ObservableList<String> items = CBPais.getItems();
        for(String item : items){
            if(item.equals(nombrePais)){
                CBPais.getSelectionModel().select(nombrePais);
            }
        }

    }
}
