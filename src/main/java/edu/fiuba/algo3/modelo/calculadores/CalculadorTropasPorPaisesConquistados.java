package edu.fiuba.algo3.modelo.calculadores;

import edu.fiuba.algo3.modelo.Jugador;

public class CalculadorTropasPorPaisesConquistados implements CalculadorTropasDisponibles{
    @Override
    public int calcularTropasParaJugador(Jugador jugador) {
        return Math.max(jugador.cantidadPaisesConquistados()/2, 3);
    }
}
