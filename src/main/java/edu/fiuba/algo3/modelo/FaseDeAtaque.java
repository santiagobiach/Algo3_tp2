package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FaseDeAtaque implements Fase {
    private ArrayList<CalculadorTropasDisponibles> calculadoresDeTropasDisponibles;

    public FaseDeAtaque(ArrayList<CalculadorTropasDisponibles> calculadores){
        this.calculadoresDeTropasDisponibles = new ArrayList<>(calculadores);
    }
    @Override
    public void simular(ArrayList<Jugador> jugadores, Tablero tablero) {
        //foreach jugadores
            //while(!terminado)
                //jugador.colocarTropasEn(cantidad, pais)
    }
}
