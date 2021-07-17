package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BatallaTest {

    @Test
    public void NoSePuedeCrearUnaBatallaNormalConCeroTropasAtacantes(){
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Brasil", new Continente("América"));
        atacante.agregarPaisLimitrofe(defensor);
        atacante.agregarTropas(10);
        atacante.setJugador(new Jugador("Mario"));
        defensor.setJugador(new Jugador("Luigi"));

        assertThrows(ExcepcionBatallaInvalida.class, () ->
            {Batalla batalla = new BatallaNormal(atacante, defensor, 10);});
    }

    @Test
    public void NoSePuedeCrearUnaBatallaNormalConTropasAtacantesNegativas(){
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Brasil", new Continente("América"));
        atacante.agregarPaisLimitrofe(defensor);
        atacante.agregarTropas(10);
        atacante.setJugador(new Jugador("Mario"));
        defensor.setJugador(new Jugador("Luigi"));

        assertThrows(ExcepcionBatallaInvalida.class, () ->
            {Batalla batalla = new BatallaNormal(atacante, defensor, -1);});
    }

    @Test
    public void PaisNoPuedeAtacarAUnPaisAliado(){
        Jugador jugador = new Jugador("Pepe");
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Brasil", new Continente("América"));
        atacante.agregarPaisLimitrofe(defensor);
        atacante.agregarTropas(10);
        atacante.setJugador(jugador);
        defensor.setJugador(jugador);

        assertThrows(ExcepcionBatallaInvalida.class, () ->
            {Batalla batalla = new BatallaNormal(atacante, defensor, 2);});
    }

    @Test
    public void NoPuedeHaberUnaBatallaDeUnPaisConsigoMismo(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        pais.agregarTropas(2);

        assertThrows(ExcepcionBatallaInvalida.class, ()
                -> {Batalla batalla = new BatallaNormal(pais, pais, 1);});
    }

    @Test
    public void PaisNoPuedeAtacarAOtroQueNoEsLimitrofe(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        pais.agregarTropas(2);
        pais.setJugador(new Jugador("Pepe"));
        Pais otroPais = new Pais("Brasil", new Continente("América"));
        otroPais.setJugador(new Jugador("Mario"));

        assertThrows(ExcepcionBatallaInvalida.class, () ->
            {Batalla batalla = new BatallaNormal(pais, otroPais, 1);});
    }

    @Test
    public void atacanteOcupaADefensorCuandoLoVence() throws Exception {
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Bolivia", new Continente("América"));
        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(3);
        defensor.setJugador(new Jugador("Mario"));

        (new BatallaMockGanaAtacante(atacante, defensor)).combatir();

        assert(atacante.esAliado(defensor));
    }

    @Test
    public void atacanteNoOcupaADefensorCuandoSiNoLoVence() throws Exception {
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Bolivia", new Continente("América"));

        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(5);
        defensor.setJugador(new Jugador("Mario"));

        (new BatallaMockGanaDefensor(atacante, defensor)).combatir();
        assertFalse(atacante.esAliado(defensor));
    }

    @Test
    public void SeCreaLaBatallaExitosamente(){
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Bolivia", new Continente("América"));

        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(5);
        defensor.setJugador(new Jugador("Mario"));

        assertDoesNotThrow(() ->
        {Batalla batalla = new BatallaNormal(atacante, defensor, 1);});
    }
    @Test
    public void SeLograCombatirExitosamente() throws Exception {
        Pais atacante = new Pais("Argentina", new Continente("América"));
        Pais defensor = new Pais("Bolivia", new Continente("América"));

        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(5);
        defensor.setJugador(new Jugador("Mario"));
        Batalla batalla = new BatallaNormal(atacante, defensor, 1);
        assertDoesNotThrow(() ->
        {batalla.combatir();});


    }
}
