package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;

    public Juego() throws Exception{
       tablero = new Tablero();
    }

    public void comenzarPartida(){
        tablero.distribuirPaises(jugadores);
        for(Jugador jugador: jugadores)
            jugador.colocarEjercitos(5);
        for(Jugador jugador: jugadores)
            jugador.colocarEjercitos(3);
    }
}
