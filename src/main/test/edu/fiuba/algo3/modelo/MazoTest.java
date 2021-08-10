package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MazoTest {

    @Test
    public void MazoSeCreaCorrectamente() throws Exception{


        Mazo mazo = new Mazo(new Tablero());
        assertNotNull(mazo);
    }
    @Test
    public void MazoSeCreaConLaCantidadDeCartasCorrectas() throws Exception{


        Mazo mazo = new Mazo(new Tablero());
        assertEquals(50, mazo.cantidadCartas());
    }
    @Test
    public void MazoConsigueLaCartaDeUnPais() throws Exception{
        Tablero tablero = new Tablero();
        Mazo mazo = new Mazo(tablero);
        TarjetaDePais tp = mazo.getTarjeta(tablero.getPais("Argentina"));
        assertNotNull(tp);
    }
    @Test
    public void MazoLeDaTarjetaAJugador() throws Exception{
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pedro");
        Mazo mazo = new Mazo(tablero);
        mazo.darTarjetaA(jugador);
        assertEquals(49, mazo.cantidadCartas());
    }

    @Test
    public void MazoLeDaTarjetaAJugadorYLuegoReincorporaOtra() throws Exception{
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pedro");
        Mazo mazo = new Mazo(tablero);
        TarjetaDePais tp = new TarjetaDePais(tablero.getPais("Turquia"),"Barco");
        mazo.darTarjetaA(jugador);
        mazo.reincorporarTarjeta(tp);
        assertEquals(50, mazo.cantidadCartas());
    }
}
