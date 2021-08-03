package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.vistas.vistaPaisController.VistaPaisPopupHandler;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import javafx.stage.Popup;
import java.util.Observable;
import java.util.Observer;

public class VistaPais extends SVGPath implements Observer {


    public VistaPais(Pais pais, Label labelNombrePais){
        pais.addObserver(this);
        this.setFill(ControladorJuego.getColorJugador(pais.getJugador()));

        VistaPaisPopupHandler paisPopupHandler = new VistaPaisPopupHandler(this,labelNombrePais,pais.getNombre());
        this.setOnMouseEntered(paisPopupHandler);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setFill(ControladorJuego.getColorJugador((Jugador) arg));
    }
}
