package edu.fiuba.algo3.modelo.fases;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeAtaque;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeColocacion;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FaseDeColocacion extends Fase{

    private ArrayList<CalculadorTropasDisponibles> calculador;
    public FaseDeColocacion(ArrayList<Jugador> jugadores, ArrayList<CalculadorTropasDisponibles> calculador) {
        super(jugadores);
        this.calculador = calculador;
        this.jugadorActual.agregarTropasDisponibles(numeroDeTropasAOtorgar());
    }
    private int numeroDeTropasAOtorgar(){
        int numeroAOtorgar = 0;
        for(CalculadorTropasDisponibles c : calculador){
            numeroAOtorgar = numeroAOtorgar + c.calcularTropasParaJugador(this.jugadorActual);
        }
        return numeroAOtorgar;
    }
    @Override
    public VBox crearMenu(Juego juego, Stage escenario) {
        return new MenuFaseDeColocacion(juego, escenario);
    }

    @Override
    public Fase proximoTurno() {
        int indiceTurno = jugadores.indexOf(jugadorActual);
        if(indiceTurno == (jugadores.size() - 1)){
            return new FaseDeAtaque(jugadores, calculador);
        }else{
            jugadorActual = jugadores.get(indiceTurno + 1);
            this.jugadorActual.agregarTropasDisponibles(numeroDeTropasAOtorgar());
        }
        return this;
    }
}
