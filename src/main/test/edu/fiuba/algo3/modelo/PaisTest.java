package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
