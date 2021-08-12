package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;

import java.util.ArrayList;

public class FaseDeAtaqueYReagrupacion extends Fase{
    private ArrayList<CalculadorTropasDisponibles> calculador;
    public FaseDeAtaqueYReagrupacion(ArrayList<Jugador> jugadores, ArrayList<CalculadorTropasDisponibles> calculador) {
        super(jugadores);
        this.calculador = calculador;
    }

    @Override
    public boolean esDeColocacion() {
        return false;
    }

    @Override
    public boolean esDeAtaqueYReagrupacion() {
        return true;
    }

    @Override
    public Fase proximoTurno() {
        int indiceTurno = jugadores.indexOf(jugadorActual);
        if(indiceTurno == (jugadores.size() - 1)){
            return new FaseDeColocacion(jugadores, calculador);
        }else{
            jugadorActual = jugadores.get(indiceTurno + 1);
        }
        return this;
    }

}
