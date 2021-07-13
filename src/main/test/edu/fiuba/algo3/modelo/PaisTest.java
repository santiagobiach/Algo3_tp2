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
}
