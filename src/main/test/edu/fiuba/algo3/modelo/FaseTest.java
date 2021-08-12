package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorContinentesConquistados;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorPaisesConquistados;
import edu.fiuba.algo3.modelo.fases.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FaseTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private CalculadorTropasDisponibles calculadorContinentes;
    private CalculadorTropasDisponibles calculadorPaises;
    private ArrayList<Jugador> jugadores;
    private ArrayList<CalculadorTropasDisponibles> calculadores;


    //Setup
    public FaseTest(){
        try{
            Tablero tablero = new Tablero();
        } catch (Exception e) {}

        jugador1 = new Jugador("J1");
        jugador2 = new Jugador("J2");
        jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        calculadorContinentes = new CalculadorTropasPorContinentesConquistados(tablero);
        calculadorPaises = new CalculadorTropasPorPaisesConquistados();
        calculadores = new ArrayList<>();
        calculadores.add(calculadorContinentes);
        calculadores.add(calculadorPaises);
    }
    @Test
    public void lasFasesDeColocacionSonDeColocacion(){

        Fase colocacionInicial = new FaseColocacionInicial(jugadores, 5, 3,
                calculadores);

        Fase segundaColocacionInicial = new SegundaFaseColocacionInicial(jugadores, 3, calculadores);

        Fase colocacion = new FaseDeColocacion(jugadores, calculadores);

        assert(colocacionInicial.esDeColocacion());
        assert(segundaColocacionInicial.esDeColocacion());
        assert(colocacion.esDeColocacion());
    }

    @Test
    public void laFaseDeAtaqueEsDeAtaque(){
        Fase ataque = new FaseDeAtaqueYReagrupacion(jugadores, calculadores);
        assert(ataque.esDeAtaqueYReagrupacion());
    }

}
