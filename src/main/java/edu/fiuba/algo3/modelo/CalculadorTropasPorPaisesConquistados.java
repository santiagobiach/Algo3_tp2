package edu.fiuba.algo3.modelo;

public class CalculadorTropasPorPaisesConquistados implements CalculadorTropasDisponibles{
    @Override
    public int calcularTropasParaJugador(Jugador jugador) {
        return Math.max(jugador.cantidadPaisesConquistados()/2, 3);
    }
}
