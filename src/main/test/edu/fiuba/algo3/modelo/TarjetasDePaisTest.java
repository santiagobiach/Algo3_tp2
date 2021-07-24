package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetasDePaisTest {

    @Test
    public void unJugadorCon0TropasActivaUnaTarjetaDeUnPaisQueControlaYTiene2Tropas() throws Exception{

        Jugador jugador = new Jugador("Pepe");
        Pais pais = new Pais("Argentina", new Continente("America"));

        TarjetaDePais tarjeta = new TarjetaDePais(pais, "Globo");
        pais.setJugador(jugador);
        jugador.darTarjeta(tarjeta);

        assertEquals(0, pais.getCantidadDeTropas());
        jugador.activarTarjeta(tarjeta);
        assertEquals(2, pais.getCantidadDeTropas());
    }

    @Test
    public void unJugadorCanjea3TarjetasDelMismoSimboloYObtiene4Tropas() throws Exception{

        Jugador jugador = new Jugador("Pepe");

        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "cañon");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "cañon");

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);

        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(4, jugador.tropasDisponibles());
    }

    @Test
    public void unJugadorCanjea3TarjetasDeDistintoSimboloYObtiene4Tropas() throws Exception{

        Jugador jugador = new Jugador("Pepe");
        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "globo");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "barco");

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);

        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(4, jugador.tropasDisponibles());
    }

    @Test
    public void unJugadorNoPuedeCanjear2TarjetasDelMismoSimboloYUnaDiferente(){


        Jugador jugador = new Jugador("Pepe");
        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "barco");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "cañon");


        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);


        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(0, jugador.tropasDisponibles());
    }

    @Test
    public void unJugadorObtieneTresCuatroDiezYQuinceTropasEnCanjesSucesivos() {
        Jugador jugador = new Jugador("Pepe");
        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "cañon");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "cañon");

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);
        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
        assertEquals(4, jugador.tropasDisponibles());
        jugador.restarTropasDisponibles(4);

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);
        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
        assertEquals(7, jugador.tropasDisponibles());
        jugador.restarTropasDisponibles(7);

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);
        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
        assertEquals(10, jugador.tropasDisponibles());
        jugador.restarTropasDisponibles(10);

        jugador.darTarjeta(tarjeta1);
        jugador.darTarjeta(tarjeta2);
        jugador.darTarjeta(tarjeta3);
        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
        assertEquals(15, jugador.tropasDisponibles());
    }
}
