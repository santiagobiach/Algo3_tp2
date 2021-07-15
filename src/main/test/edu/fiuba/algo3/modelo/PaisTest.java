package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaisTest {
    @Test
    public void PaisCreadoTieneElNombreCorrecto(){
        Pais pais = new Pais("Argentina");

        assertEquals("Argentina", pais.getNombre());
    }

    @Test
    public void DosPaisesCreadosNoSonLimitrofes(){
        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");

        assertFalse(pais.esLimitrofe(otroPais));
    }

    @Test
    public void DosPaisesCreadosSonLimitrofesTrasIndicarlo(){
        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        pais.agregarPaisLimitrofe(otroPais);

        assertTrue(pais.esLimitrofe(otroPais));
        assertTrue(otroPais.esLimitrofe(pais));
    }

    @Test
    public void UnNuevoPaisNoTieneTropasDesplegadas(){
        Pais unPais = new Pais("Algeria");
        assertEquals(unPais.getCantidadDeTropas(), 0);
    }

    @Test
    public void UnPaisTieneLaCantidadDeTropasIndicada(){
        Pais unPais = new Pais("Algeria");
        unPais.agregarTropas(4);
        assertEquals(unPais.getCantidadDeTropas(), 4);
    }

    @Test
    public void UnPaisNoTieneTropasSuficientesCuandoLaCantidadEsMayorALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria");
        unPais.agregarTropas(2);
        assertFalse(unPais.tieneTropasSuficientes(3));
    }

    @Test
    public void UnPaisNoTieneTropasSuficientesCuandoLaCantidadEsIgualALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria");
        unPais.agregarTropas(3);
        assertFalse(unPais.tieneTropasSuficientes(3));
    }

    @Test
    public void UnPaisTieneTropasSuficientesCuandoLaCantidadEsMenorALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria");
        unPais.agregarTropas(3);
        assertTrue(unPais.tieneTropasSuficientes(2));
    }

    @Test
    public void UnNuevoPaisNoEstaDominadoPorNadie(){
        Pais pais = new Pais("Argentina");
        assertNull(pais.getJugador());
    }

    @Test
    public void UnNuevoPaisEstaDominadoPorElJugadorIndicado(){
        Pais pais = new Pais("Argentina");
        Jugador unJugador = new Jugador("Santi");
        pais.setJugador(unJugador);
        assertEquals(pais.getJugador(), unJugador);
    }

    @Test
    public void PaisNoPuedeAtacarConCeroTropas(){
        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        pais.agregarPaisLimitrofe(otroPais);
        pais.agregarTropas(10);
        pais.setJugador(new Jugador("Mario"));
        otroPais.setJugador(new Jugador("Luigi"));
        Batalla batalla = new BatallaNormal();

        assertThrows(ExcepcionCantidadDeTropasInvalida.class, () -> {pais.atacarA(otroPais, 0, batalla);});
    }

    @Test
    public void PaisNoPuedeAtacarConCantidadNegativaDeTropas(){
        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        pais.agregarPaisLimitrofe(otroPais);
        pais.agregarTropas(10);
        pais.setJugador(new Jugador("Mario"));
        otroPais.setJugador(new Jugador("Luigi"));
        Batalla batalla = new BatallaNormal();

        assertThrows(ExcepcionCantidadDeTropasInvalida.class, () -> {pais.atacarA(otroPais, -1, batalla);});
    }

    @Test
    public void PaisNoPuedeAtacarAOtroSiNoTieneTropasSuficientes(){
        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        pais.agregarPaisLimitrofe(otroPais);
        Batalla batalla = new BatallaNormal();

        assertThrows(ExcepcionTropasInsuficientes.class, () -> {pais.atacarA(otroPais, 1, batalla);});
    }

    @Test
    public void PaisNoPuedeAtacarAUnPaisAliado(){
        Jugador jugador = new Jugador("Pepe");

        Pais pais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        pais.agregarPaisLimitrofe(otroPais);
        pais.agregarTropas(10);

        pais.setJugador(jugador);
        otroPais.setJugador(jugador);

        Batalla batalla = new BatallaNormal();
        assertThrows(ExcepcionBatallaInvalida.class, () -> {pais.atacarA(pais, 1, batalla);});
    }

    @Test
    public void NoPuedeHaberUnaBatallaDeUnPaisConsigoMismo(){
        Pais pais = new Pais("Argentina");
        pais.agregarTropas(2);

        Batalla batalla = new BatallaNormal();
        assertThrows(ExcepcionBatallaInvalida.class, () -> {pais.atacarA(pais, 1, batalla);});
    }

    @Test
    public void PaisNoPuedeAtacarAOtroQueNoEsLimitrofe(){
        Pais pais = new Pais("Argentina");
        pais.agregarTropas(2);
        Pais otroPais = new Pais("Brasil");

        Batalla batalla = new BatallaNormal();
        assertThrows(ExcepcionBatallaInvalida.class, () -> {pais.atacarA(otroPais, 1, batalla);});
    }

    @Test
    public void atacanteOcupaADefensorCuandoLoVence() throws Exception {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Bolivia");
        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(3);
        defensor.setJugador(new Jugador("Mario"));

        Batalla batalla = new BatallaMockGanaAtacante();
        atacante.atacarA(defensor, 3, batalla);
        assert(atacante.esAliado(defensor));
    }

    @Test
    public void atacanteNoOcupaADefensorCuandoSiNoLoVence() throws Exception {
        Pais atacante = new Pais("Argentina");
        Pais defensor = new Pais("Bolivia");
        atacante.setJugador(new Jugador("Pepe"));
        atacante.agregarTropas(4);
        atacante.agregarPaisLimitrofe(defensor);

        defensor.agregarTropas(3);
        defensor.setJugador(new Jugador("Mario"));

        Batalla batalla = new BatallaMockGanaDefensor();
        atacante.atacarA(defensor, 3, batalla);
        assertFalse(atacante.esAliado(defensor));
    }
}
