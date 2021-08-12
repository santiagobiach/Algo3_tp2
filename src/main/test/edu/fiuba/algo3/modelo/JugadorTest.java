package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetivos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class JugadorTest {
    private Jugador jugador1;
    private Jugador jugador2;

    public JugadorTest(){
        jugador1 = new Jugador("J1");
        jugador2 = new Jugador("J2");
    }

    @Test
    public void jugadorConquistoEnUltimoTurnoSiConquistoOtroPais(){
        Continente continente = new Continente("America");
        Pais pais1 = new Pais("Argentina", continente);
        Pais pais2 = new Pais("Uruguay", continente);
        pais1.setJugador(jugador1);
        pais2.setJugador(jugador2);

        pais1.agregarPaisLimitrofe(pais2);
        pais2.agregarPaisLimitrofe(pais1);

        pais1.agregarTropas(3);
        pais2.agregarTropas(0);

        assertFalse(jugador1.conquistoEnUltimoTurno());
        assert(pais2.getJugador() == jugador2);

        pais2.defenderConquista(pais1);

        assert(pais2.getJugador() == jugador1);
        assert(jugador1.conquistoEnUltimoTurno() == true);

    }

    @Test
    public void jugadorCumplioObjetivosSiAlgunoDeSusObjetivosEstaCumplido(){
        Objetivo objetivo = new ObjetivoMockNuncaCumplido();
        Objetivo objetivo2 = new ObjetivoMockSiempreCumplido();

        jugador1.agregarObjetivo(objetivo);

        assertFalse(jugador1.cumplioObjetivos());
        jugador1.agregarObjetivo(objetivo2);
        assert(jugador1.cumplioObjetivos());
    }

    @Test
    public void unJugadorSinPaisesConquistadosPerdio(){
        assert(jugador1.getPaisesConquistados().size() == 0);
        assert(jugador1.perdio());
    }

    @Test
    public void unJugadorConPaisesConquistadosNoPerdio(){
        jugador1.agregarPais(new Pais("Argentina", new Continente("America")));
        assert(jugador1.getPaisesConquistados().size() == 1);
        assertFalse(jugador1.perdio());
    }
}
