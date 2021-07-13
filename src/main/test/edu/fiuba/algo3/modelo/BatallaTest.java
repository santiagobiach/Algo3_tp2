package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BatallaTest {
    @Test
    public void NoPuedeHaberUnaBatallaDeUnPaisConsigoMismo(){
        Pais pais = new Pais("Argentina");
        pais.agregarTropas(2);
        assertThrows(ExcepcionBatallaInvalida.class, () -> {new Batalla(pais, pais, 1);});
    }

    @Test
    public void PaisNoPuedeAtacarAOtroQueNoEsLimitrofe(){
        Pais pais = new Pais("Argentina");
        pais.agregarTropas(2);
        Pais otroPais = new Pais("Brasil");
        assertThrows(ExcepcionBatallaInvalida.class, () -> {new Batalla(pais, otroPais, 1);});
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

        assertThrows(ExcepcionBatallaInvalida.class, () -> {new Batalla(pais, otroPais, 1);});
    }

}
