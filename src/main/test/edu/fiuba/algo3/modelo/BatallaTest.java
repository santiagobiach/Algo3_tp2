package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BatallaTest {

//    @Test
//    public void NoPuedeHaberUnaBatallaDeUnPaisConsigoMismo(){
//        Pais pais = new Pais("Argentina");
//        pais.agregarTropas(2);
//
//        Batalla batalla = new BatallaNormal();
//        assertThrows(ExcepcionBatallaInvalida.class, () -> {batalla.combatir(pais, pais, 1);});
//    }
//
//    @Test
//    public void PaisNoPuedeAtacarAOtroQueNoEsLimitrofe(){
//        Pais pais = new Pais("Argentina");
//        pais.agregarTropas(2);
//        Pais otroPais = new Pais("Brasil");
//
//        Batalla batalla = new BatallaNormal();
//        assertThrows(ExcepcionBatallaInvalida.class, () -> {batalla.combatir(pais, otroPais, 1);});
//    }
//
//    @Test
//    public void PaisNoPuedeAtacarAUnPaisAliado(){
//        Jugador jugador = new Jugador("Pepe");
//
//        Pais pais = new Pais("Argentina");
//        Pais otroPais = new Pais("Brasil");
//        pais.agregarPaisLimitrofe(otroPais);
//        pais.agregarTropas(10);
//
//        pais.setJugador(jugador);
//        otroPais.setJugador(jugador);
//
//        Batalla batalla = new BatallaNormal();
//
//        assertThrows(ExcepcionBatallaInvalida.class, () -> {batalla.combatir(pais, otroPais, 1);});
//    }

}
