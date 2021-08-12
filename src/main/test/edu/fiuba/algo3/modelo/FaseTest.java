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
            tablero = new Tablero();
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
    public void UnaFaseDeColocacionDevuelveOtraInstanciaCuandoElJugadorActualNoEsElUltimo(){
        Fase fase = new FaseDeColocacion(jugadores, calculadores);
        assert(fase.proximoTurno().getClass() == FaseDeColocacion.class);
    }

    @Test
    public void UnaFaseDeColocacionDevuelveFaseDeAtaqueYReagrupacionCuandoElJugadorActualNoEsElUltimo(){
        Fase fase = new FaseDeColocacion(jugadores, calculadores);
        fase = fase.proximoTurno();
        System.out.println(fase.getClass());
        assert(fase.proximoTurno().getClass() == FaseDeAtaqueYReagrupacion.class);
    }

    @Test
    public void laFaseDeAtaqueYReagrupacionEsDeAtaqueYReagrupacion(){
        Fase fase = new FaseDeAtaqueYReagrupacion(jugadores, calculadores);
        assert(fase.esDeAtaqueYReagrupacion());
    }

    @Test
    public void UnaFaseDeAtaqueYRegrupacionDevuelveOtraInstanciaCuandoElJugadorActualNoEsElUltimo(){
        Fase fase = new FaseDeAtaqueYReagrupacion(jugadores, calculadores);
        assert(fase.proximoTurno().getClass() == FaseDeAtaqueYReagrupacion.class);
    }

    @Test
    public void UnaFaseDeAtaqueYRegrupacionDevuelveFaseDeColocacionCuandoElJugadorActualEsElUltimo(){
        Fase fase = new FaseDeAtaqueYReagrupacion(jugadores, calculadores);
        fase = fase.proximoTurno();
        assert(fase.proximoTurno().getClass() == FaseDeColocacion.class);
    }

}
