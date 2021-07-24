package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class JuegoTest {

    @Test
    public void UnJugadorCon2TropasDesplegadasTiene5TrasDecirleQueColoque3() throws Exception{
        Jugador jugador = new Jugador("Mario");
        Pais argentina = new Pais("Argentina", new Continente("America"));
        argentina.agregarTropas(2);
        argentina.setJugador(jugador);
        jugador.agregarTropasDisponibles(3);

        assertEquals(2, argentina.getCantidadDeTropas());
        jugador.colocarEjercitosEn(3, argentina);

        assertEquals(5, argentina.getCantidadDeTropas());
    }

    @Test
    public void RondaEntreDosJugadoresSinAtaqueAmbosPonenLaCantidadDeFicasCorrespondientes() throws Exception {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Mario");
        Jugador jugador2 = new Jugador("Pedro");
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Tablero tablero = new TableroMockDosJugadores();
        tablero.distribuirPaises(jugadores);

        ArrayList<CalculadorTropasDisponibles> calculadores = new ArrayList<>();
        calculadores.add(new CalculadorTropasPorPaisesConquistados());
        calculadores.add(new CalculadorTropasPorContinentesConquistados(tablero));

        for (CalculadorTropasDisponibles cal: calculadores) {
            jugador1.agregarTropasDisponibles(cal.calcularTropasParaJugador(jugador1));
            jugador2.agregarTropasDisponibles(cal.calcularTropasParaJugador(jugador1));
        }

        assertEquals(12, jugador1.tropasDisponibles());
        assertEquals(12, jugador2.tropasDisponibles());

        Pais francia = tablero.getPais("Francia");
        Pais alemania = tablero.getPais("Alemania");

        jugador1.colocarEjercitosEn(12, francia);
        jugador2.colocarEjercitosEn(12, alemania);

        assertEquals(0, jugador1.tropasDisponibles());
        assertEquals(0, jugador2.tropasDisponibles());
    }

    @Test
    public void unJugadorControlaTodoAsia() throws Exception{
        Tablero tablero = new TableroMockTodoAsiaParaJugadorUno();

        ArrayList <Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Pepe"));
        jugadores.add(new Jugador("Pipo"));
        jugadores.add(new Jugador("Martin"));

        tablero.distribuirPaises(jugadores);

        CalculadorTropasDisponibles calculador = new CalculadorTropasPorContinentesConquistados(tablero);
        assert(tablero.buscarContiente("Asia").conquistadoPor(jugadores.get(1)));
        assert(calculador.calcularTropasParaJugador(jugadores.get(1)) == 7);

    }

    @Test
    public void rondaJugadorUnoConquistaDosPaisesDelJugadorDos() throws Exception{
        Tablero tablero = new TableroMockJ1ArgentinaCon10TropasYJ2BrasilYChile();
        ArrayList <Jugador> jugadores = new ArrayList<>();

        Jugador atacante = new Jugador("Pepe");
        Jugador defensor = new Jugador("Pipo");

        jugadores.add(atacante);
        jugadores.add(defensor);

        tablero.distribuirPaises(jugadores);

        Pais argentina = tablero.getPais("Argentina");
        Pais chile = tablero.getPais("Chile");
        Pais brasil = tablero.getPais("Brasil");

        assert(argentina.dominadoPor(atacante) && brasil.dominadoPor(defensor) && chile.dominadoPor(defensor));

        (new BatallaMockGanaAtacante(argentina, brasil)).combatir();
        (new BatallaMockGanaAtacante(argentina, chile)).combatir();

        assert(argentina.dominadoPor(atacante) && brasil.dominadoPor(atacante) && chile.dominadoPor(atacante));
    }
}
