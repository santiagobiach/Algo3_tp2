package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeAtaque implements Fase {
    private ArrayList<CalculadorTropasDisponibles> calculadoresDeTropasDisponibles;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public FaseDeAtaque(Tablero tablero, ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.tablero = tablero;

    }
    @Override
    public void empezar(Jugador jugador) {

    }
}
