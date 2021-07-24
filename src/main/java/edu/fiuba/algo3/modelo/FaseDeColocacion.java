package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeColocacion implements Fase {
    private ArrayList<CalculadorTropasDisponibles> calculadoresDeTropasDisponibles;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public FaseDeColocacion(ArrayList<CalculadorTropasDisponibles> calculadores,
                            Tablero tablero, ArrayList<Jugador> jugadores){

        this.calculadoresDeTropasDisponibles = calculadores;
        this.jugadores = jugadores;
        this.tablero = tablero;
    }

    public void calcularTropasParaElJugador(Jugador jugador){
        for(CalculadorTropasDisponibles calc: calculadoresDeTropasDisponibles)
            jugador.agregarTropasDisponibles(calc.calcularTropasParaJugador(jugador));
    }

    @Override
    public void empezar(Jugador jugador) {
    }
}
