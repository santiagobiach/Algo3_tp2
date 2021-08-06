package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class Fase {
    protected ArrayList<Jugador> jugadores;
    protected Jugador jugadorActual;
    public Fase(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.jugadorActual = this.jugadores.get(0);
    }

    public abstract boolean esDeAtaque();

    public abstract boolean esDeColocacion();

    public abstract boolean esDeReagrupacion();

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public abstract Fase proximoTurno();
}
