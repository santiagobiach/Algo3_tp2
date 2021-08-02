package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public abstract class Fase {
    protected ArrayList<Jugador> jugadores;
    protected Jugador jugadorActual;
    public Fase(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.jugadorActual = this.jugadores.get(0);
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }


    public abstract Fase proximoTurno();
}
