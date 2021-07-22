package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class CalculadorTropasPorContinentesConquistados implements CalculadorTropasDisponibles {
    @Override
    public int calcular(Jugador jugador, Tablero tablero) {
        ArrayList<Continente> continentesConquistados = tablero.continentesConquistadosPorJugador(jugador);
        int cantidadDeTropas = 0;
        for(Continente c: continentesConquistados)
            cantidadDeTropas += c.bonusPorConquista();

        return cantidadDeTropas;
    }
}
