package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeColocacionInicial implements Fase {
    private int cantidadDeTropas;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;

    public FaseDeColocacionInicial(int cantidadDeTropas, Tablero tablero, ArrayList<Jugador> jugadores){
        this.tablero = tablero;
        this.jugadores = jugadores;
    }
    @Override
    public void empezar() {
    }
}
