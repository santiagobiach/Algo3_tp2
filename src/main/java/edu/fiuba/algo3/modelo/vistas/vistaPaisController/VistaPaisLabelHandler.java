package edu.fiuba.algo3.modelo.vistas.vistaPaisController;

import edu.fiuba.algo3.modelo.vistas.VistaPais;

import javafx.event.EventHandler;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;


public class VistaPaisLabelHandler implements EventHandler<MouseEvent> {
    private VistaPais vistaPais;
    private Label labelNombreDePais;
    private String nombrePais;
    public VistaPaisLabelHandler(VistaPais vistaPais, Label labelNombreDePais, String nombrePais){
        this.vistaPais = vistaPais;
        this.labelNombreDePais = labelNombreDePais;
        this.nombrePais = nombrePais;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        labelNombreDePais.setText("Pais seleccionado: " + nombrePais);
    }


}
