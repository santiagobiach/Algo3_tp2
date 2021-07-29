package edu.fiuba.algo3.modelo.calculadores;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

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
