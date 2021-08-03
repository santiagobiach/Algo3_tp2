package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import javafx.scene.shape.SVGPath;

import java.util.Observable;
import java.util.Observer;

public class VistaPais extends SVGPath implements Observer {

    //private SVGPath fotoPais;
    public VistaPais(Pais pais){
        pais.addObserver(this);
        this.setFill(ControladorJuego.getColorJugador(pais.getJugador()));
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setFill(ControladorJuego.getColorJugador((Jugador) arg));
    }
}
