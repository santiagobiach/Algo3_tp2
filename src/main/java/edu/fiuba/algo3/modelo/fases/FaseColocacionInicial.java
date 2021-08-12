package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;

import java.util.ArrayList;

public class FaseColocacionInicial extends Fase{
    private int tropasAOtorgar;
    private int tropasAOtorgarSegundaFase;
    private ArrayList<CalculadorTropasDisponibles> calculador;
    public FaseColocacionInicial(ArrayList<Jugador> jugadores, int tropasAOtorgar,
                                 int tropasAOtorgarSegundaFase, ArrayList<CalculadorTropasDisponibles> calculador) {
        super(jugadores);
        this.tropasAOtorgar = tropasAOtorgar;
        this.tropasAOtorgarSegundaFase = tropasAOtorgarSegundaFase;
        this.jugadorActual.agregarTropasDisponibles(tropasAOtorgar);
        this.calculador = calculador;
    }

    @Override
    public boolean esDeAtaqueYReagrupacion() {
        return false;
    }

    @Override
    public boolean esDeColocacion() {
        return true;
    }

    @Override
    public Fase proximoTurno() {
        int indiceTurno = jugadores.indexOf(jugadorActual);
        if(indiceTurno == (jugadores.size() - 1)){
            return new SegundaFaseColocacionInicial(jugadores, tropasAOtorgarSegundaFase, calculador);
        }else{
            jugadorActual = jugadores.get(indiceTurno + 1);
            jugadorActual.agregarTropasDisponibles(tropasAOtorgar);
        }
        return this;
    }
}
