package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PaisTest {
    @Test
    public void PaisCreadoTieneElNombreCorrecto(){
        Pais pais = new Pais("Argentina", new Continente("América"));

        assertEquals("Argentina", pais.getNombre());
    }

    @Test
    public void DosPaisesCreadosNoSonLimitrofes(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        Pais otroPais = new Pais("Brasil", new Continente("América"));

        assertFalse(pais.esLimitrofeCon(otroPais));
    }

    @Test
    public void DosPaisesCreadosSonLimitrofesTrasIndicarlo(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        Pais otroPais = new Pais("Brasil", new Continente("América"));
        pais.agregarPaisLimitrofe(otroPais);

        assertTrue(pais.esLimitrofeCon(otroPais));

    }

    @Test
    public void UnNuevoPaisNoTieneTropasDesplegadas(){
        Pais unPais = new Pais("Algeria", new Continente("América"));
        assertEquals(unPais.getCantidadDeTropas(), 0);
    }

    @Test
    public void UnPaisTieneLaCantidadDeTropasIndicada(){
        Pais unPais = new Pais("Algeria", new Continente("América"));
        unPais.agregarTropas(4);
        assertEquals(unPais.getCantidadDeTropas(), 4);
    }

    @Test
    public void UnPaisNoTieneTropasSuficientesCuandoLaCantidadEsMayorALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria", new Continente("América"));
        unPais.agregarTropas(2);
        assertFalse(unPais.tieneTropasSuficientes(3));
    }

    @Test
    public void UnPaisNoTieneTropasSuficientesCuandoLaCantidadEsIgualALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria", new Continente("América"));
        unPais.agregarTropas(3);
        assertFalse(unPais.tieneTropasSuficientes(3));
    }

    @Test
    public void UnPaisTieneTropasSuficientesCuandoLaCantidadEsMenorALasTropasDesplegadas(){
        Pais unPais = new Pais("Algeria", new Continente("América"));
        unPais.agregarTropas(3);
        assertTrue(unPais.tieneTropasSuficientes(2));
    }

    @Test
    public void UnNuevoPaisNoEstaDominadoPorNadie(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        assertNull(pais.getJugador());
    }

    @Test
    public void UnNuevoPaisEstaDominadoPorElJugadorIndicado(){
        Pais pais = new Pais("Argentina", new Continente("América"));
        Jugador unJugador = new Jugador("Santi");
        pais.setJugador(unJugador);
        assertEquals(pais.getJugador(), unJugador);
    }

    @Test
    public void UnPaisSinTropasEsConquistadoCuandoIntentaDefenderUnaConquista() throws Exception{
        Pais atacante = new Pais("Argentina", new Continente("América"));
        atacante.agregarTropas(5);
        atacante.setJugador(new Jugador("Mario"));
        Pais defensor = new Pais("Brasil", new Continente("América"));
        atacante.agregarPaisLimitrofe(defensor);
        defensor.setJugador(new Jugador("Luigi"));

        defensor.defenderConquista(atacante);

        assert(atacante.esAliado(defensor));

    }

    @Test
    public void UnPaisConTropasNoEsConquistadoCuandoIntentaDefenderUnaConquista() throws Exception{
        Pais atacante = new Pais("Argentina", new Continente("América"));
        atacante.agregarTropas(5);
        atacante.setJugador(new Jugador("Mario"));

        Pais defensor = new Pais("Brasil", new Continente("América"));
        atacante.agregarPaisLimitrofe(defensor);
        defensor.agregarTropas(3);
        defensor.setJugador(new Jugador("Luigi"));

        defensor.defenderConquista(atacante);

        assertFalse(atacante.esAliado(defensor));

    }

}
