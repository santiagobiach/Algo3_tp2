package edu.fiuba.algo3.controladores.botones;

public class BotonQuitarJugador extends BotonModificarCantidadDeJugadores {

    public void nuevoNumeroDeJugadores(int numeroDeJugadores){
        this.setDisabled((numeroDeJugadores < 3));
    }
}
