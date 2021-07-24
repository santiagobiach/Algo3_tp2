package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeReagrupacion implements Fase {
    private ArrayList<CalculadorTropasDisponibles> calculadoresDeTropasDisponibles;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public FaseDeReagrupacion(Tablero tablero, ArrayList<Jugador> jugadores){
        this.tablero = tablero;
        this.jugadores = jugadores;
    }
    @Override
    public void empezar(Jugador jugador) {
    }
}
