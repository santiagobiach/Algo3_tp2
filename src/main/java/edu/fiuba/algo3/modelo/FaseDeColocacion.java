package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeColocacion implements Fase {
    private ArrayList<CalculadorTropasDisponibles> calculadoresDeTropasDisponibles;

    public FaseDeColocacion(ArrayList<CalculadorTropasDisponibles> calculadores){
        this.calculadoresDeTropasDisponibles = new ArrayList<>(calculadores);
    }
    @Override
    public void simular(ArrayList<Jugador> jugadores, Tablero tablero) {
        //foreach jugadores
            //foreach calculadores
                //calculador.calcular(jugador)
            //while(jugador.tropasDisponibles() > 0)
                //jugador.colocarTropasEn(cantidad, pais)
    }
}
