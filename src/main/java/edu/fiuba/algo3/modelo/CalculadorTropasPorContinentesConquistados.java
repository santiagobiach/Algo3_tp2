package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class CalculadorTropasPorContinentesConquistados implements CalculadorTropasDisponibles {
    private Tablero tablero;

    public CalculadorTropasPorContinentesConquistados(Tablero tablero){
        this.tablero = tablero;
    }
    @Override
    public int calcularTropasParaJugador(Jugador jugador) {
        ArrayList<Continente> continentesConquistados = tablero.continentesConquistadosPorJugador(jugador);
        int cantidadDeTropas = 0;
        for(Continente c: continentesConquistados)
            cantidadDeTropas += c.bonusPorConquista();

        return cantidadDeTropas;
    }
}
