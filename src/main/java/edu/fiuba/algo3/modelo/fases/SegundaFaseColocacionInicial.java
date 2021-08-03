package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;

import java.util.ArrayList;

public class SegundaFaseColocacionInicial extends Fase{
    private int tropasAOtorgar;
    private ArrayList<CalculadorTropasDisponibles> calculador;
    public SegundaFaseColocacionInicial(ArrayList<Jugador> jugadores, int tropasAOtorgar,
                                        ArrayList<CalculadorTropasDisponibles> calculador) {
        super(jugadores);
        this.tropasAOtorgar = tropasAOtorgar;
        this.jugadorActual.agregarTropasDisponibles(tropasAOtorgar);
        this.calculador = calculador;

    }

    @Override
    public Fase proximoTurno() {
        int indiceTurno = jugadores.indexOf(jugadorActual);
        if(indiceTurno == (jugadores.size() - 1)){
            return new FaseDeAtaque(jugadores, calculador);
        }else{
            jugadorActual = jugadores.get(indiceTurno + 1);
            jugadorActual.agregarTropasDisponibles(tropasAOtorgar);
        }
        return this;
    }

}
