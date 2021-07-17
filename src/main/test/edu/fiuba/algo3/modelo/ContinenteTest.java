package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {
    @Test
    public void unContinenteVacíoNoEstaConquistadoPorUnJugador(){
        Jugador jugador = new Jugador("Santi");
        Continente continente = new Continente("América");

        assertFalse(continente.conquistadoPor(jugador));
    }

    @Test
    public void unContinenteVacíoNoEstaConquistadoPorUnJugadorNulo(){
        Jugador jugador = new Jugador("Santi");
        Continente continente = new Continente("América");

        assertFalse(continente.conquistadoPor(null));
    }

    @Test
    public void unContinenteEstaConquistadoPorUnJugadorSiTodosSusPaisesLoEstan(){
        Jugador jugador = new Jugador("Santi");
        Continente continente = new Continente("América");

        Pais argentina = new Pais("Argentina", new Continente("América"));
        argentina.setJugador(jugador);
        continente.agregarPais(argentina);

        assert(continente.conquistadoPor(jugador));
    }

    @Test
    public void unContinenteEstaConquistadoPorUnJugadorSiSiUnoDeSusPaisesNoLoEsta(){
        Jugador jugador = new Jugador("Santi");
        Continente continente = new Continente("América");

        Pais argentina = new Pais("Argentina", new Continente("América"));
        Pais chile = new Pais("Chile", new Continente("América"));
        chile.setJugador(new Jugador("Mario"));
        argentina.setJugador(jugador);
        continente.agregarPais(argentina);
        continente.agregarPais(chile);

        assertFalse(continente.conquistadoPor(jugador));
    }


}
