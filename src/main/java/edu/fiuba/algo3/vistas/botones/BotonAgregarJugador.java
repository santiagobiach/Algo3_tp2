package edu.fiuba.algo3.vistas.botones;

public class BotonAgregarJugador extends BotonModificarCantidadDeJugadores {

    public void nuevoNumeroDeJugadores(int numeroDeJugadores){
        this.setDisabled((numeroDeJugadores > 5));
    }
}
