package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoDeConquista;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoGeneral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetivoTest {
    @Test
    public void seCreaAlObjetivoCorrectamente(){
        Objetivo objetivo = new ObjetivoDeConquista("Obj");
        Objetivo otroObjetivoMas = new ObjetivoGeneral();

        assertNotNull(objetivo);
        assertNotNull(otroObjetivoMas);
    }

    @Test
    public void SiUnJugadorControlaMenosDe30PaisesNoCumpleElObjetivoGeneral(){
        Jugador jugador = new Jugador("Jose");
        Objetivo objetivo = new ObjetivoGeneral();

        assertFalse(objetivo.estaCumplido(jugador));
    }
    @Test
    public void SiUnJugadorControla30PaisesCumpleElObjetivoGeneral(){
        Jugador jugador = new Jugador("Jose");
        //Le agregamos 30 paises conquistados
        for(int i = 0; i < 30; i++){
            jugador.agregarPais(new Pais("nombre", new Continente("nombre")));
        }

        Objetivo objetivo = new ObjetivoGeneral();

        assertTrue(objetivo.estaCumplido(jugador));
    }

    @Test
    public void SiUnJugadorNoControlaTodosLosPaisesDeUnContinenteYDebeControlarTodoSuObjetivoNoEstaCumplido(){
        Jugador jugador = new Jugador("Jose");
        Continente continente = new Continente("Continente");
        Pais unPais = new Pais("unPais", continente);
        Pais otroPais = new Pais("otroPais", continente);
        Pais otroPaisMas = new Pais("otroPaisMas", continente);

        unPais.setJugador(jugador);
        otroPais.setJugador(jugador);



        ObjetivoDeConquista objetivo = new ObjetivoDeConquista("Obj");

        objetivo.agregarContinenteAConquistar(continente,-1);

        assertFalse(objetivo.estaCumplido(jugador));
    }

    @Test
    public void SiUnJugadorControlaTodosLosPaisesDeUnContinenteYDebeControlarTodoSuObjetivoEstaCumplido(){
        Jugador jugador = new Jugador("Jose");
        Continente continente = new Continente("Continente");
        Pais unPais = new Pais("unPais", continente);
        Pais otroPais = new Pais("otroPais", continente);
        Pais otroPaisMas = new Pais("otroPaisMas", continente);

        unPais.setJugador(jugador);
        otroPais.setJugador(jugador);
        otroPaisMas.setJugador(jugador);



        ObjetivoDeConquista objetivo = new ObjetivoDeConquista("Obj");

        objetivo.agregarContinenteAConquistar(continente,-1);

        assertTrue(objetivo.estaCumplido(jugador));
    }

    @Test
    public void SiUnJugadorUnPaisesDeUnContinenteYDebeUnPaisSuObjetivoEstaCumplido(){
        Jugador jugador = new Jugador("Jose");
        Continente continente = new Continente("Continente");
        Pais unPais = new Pais("unPais", continente);
        Pais otroPais = new Pais("otroPais", continente);
        Pais otroPaisMas = new Pais("otroPaisMas", continente);

        unPais.setJugador(jugador);




        ObjetivoDeConquista objetivo = new ObjetivoDeConquista("Obj");

        objetivo.agregarContinenteAConquistar(continente,1);

        assertTrue(objetivo.estaCumplido(jugador));
    }

    @Test
    public void SiUnJugadorUnPaisesDeUnContinenteY2DeOtroCumpleElObjetivo(){
        Jugador jugador = new Jugador("Jose");
        Continente continente = new Continente("Continente");
        Continente otroContinente = new Continente("otroContinente");
        Pais unPais = new Pais("unPais", continente);
        Pais otroPais = new Pais("otroPais",otroContinente);
        Pais otroPaisMas = new Pais("otroPaisMas", otroContinente);

        unPais.setJugador(jugador);
        otroPais.setJugador(jugador);
        otroPaisMas.setJugador(jugador);



        ObjetivoDeConquista objetivo = new ObjetivoDeConquista("Obj");

        objetivo.agregarContinenteAConquistar(continente,1);
        objetivo.agregarContinenteAConquistar(otroContinente,2);

        assertTrue(objetivo.estaCumplido(jugador));
    }

}
