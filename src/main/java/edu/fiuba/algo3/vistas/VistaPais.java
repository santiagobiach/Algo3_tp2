package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.vistas.vistaPaisController.VistaPaisComboBoxHandler;
import edu.fiuba.algo3.vistas.vistaPaisController.VistaPaisLabelHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

import java.util.Observable;
import java.util.Observer;

public class VistaPais extends SVGPath implements Observer {


    public VistaPais(Pais pais, Label labelNombrePais, ComboBox<String> CBPais){
        pais.addObserver(this);
        this.setFill(ControladorJuego.getColorJugador(pais.getJugador()));

        VistaPaisLabelHandler paisPopupHandler = new VistaPaisLabelHandler(this,labelNombrePais,pais.getNombre());
        this.setOnMouseEntered(paisPopupHandler);
        VistaPaisComboBoxHandler paisComboBoxHandler = new VistaPaisComboBoxHandler(CBPais, pais.getNombre());
        this.setOnMouseClicked(paisComboBoxHandler);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setFill(ControladorJuego.getColorJugador((Jugador) arg));
    }
}
