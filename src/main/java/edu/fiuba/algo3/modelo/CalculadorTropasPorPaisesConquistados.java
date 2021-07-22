package edu.fiuba.algo3.modelo;

public class CalculadorTropasPorPaisesConquistados implements CalculadorTropasDisponibles{

    @Override
    public int calcular(Jugador jugador, Tablero tablero) {
        return jugador.cantidadPaisesConquistados()/2;
    }
}
