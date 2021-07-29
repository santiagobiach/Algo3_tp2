package edu.fiuba.algo3.modelo.vistas.botones;

import javafx.scene.control.Button;

public class BotonQuitarJugador extends BotonModificarCantidadDeJugadores {

    public void nuevoNumeroDeJugadores(int numeroDeJugadores){
        this.setDisabled((numeroDeJugadores < 3));
    }
}
