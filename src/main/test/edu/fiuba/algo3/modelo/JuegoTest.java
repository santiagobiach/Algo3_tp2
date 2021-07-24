package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class JuegoTest {
    private ArrayList<CalculadorTropasDisponibles> crearCalculadores(){
        ArrayList<CalculadorTropasDisponibles> calculadores = new ArrayList<>();
        calculadores.add(new CalculadorTropasPorPaisesConquistados());
        calculadores.add(new CalculadorTropasPorContinentesConquistados());
        return calculadores;
    }

    @Test
    public void UnJugadorCon2TropasDesplegadasTiene5TrasDecirleQueColoque3() throws Exception{
        Jugador jugador = new Jugador("Mario", "000000");
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
        jugadores.add(new Jugador("Mario", "000000"));
        jugadores.add(new Jugador("Pedro", "000000"));
        Tablero tablero = new TableroMockDosJugadores();
        tablero.distribuirPaises(jugadores);

        Juego juego = new Juego(tablero, crearCalculadores(), jugadores);

        /*ArrayList<Integer> primerConteo = new ArrayList<>();
        for(Jugador j: jugadores){
            int contador = 0;
            for(Pais p: j.getPaiasesConquistados())
                contador += p.getCantidadDeTropas();

            primerConteo.add(contador);
        }

        ArrayList<Integer> tropasDisponibles = new ArrayList();
        boolean sumaCorrecta = true;

        int i=0;
        for(Jugador j: jugadores){
            tropasDisponibles.add(juego.calcularTropasParaElJugador(j));
            j.colocarEjercitos(tropasDisponibles.get(i));
            i++;
        }

        i=0;
        for(Jugador j: jugadores){
            int contador = 0;
            for(Pais p: j.getPaisesConquistados())
                contador += p.getCantidadDeTropas();
            if(contador != primerConteo.get(i) + tropasDisponibles.get(i))
                sumaCorrecta = false;
            i++;
        }*/

        assertEquals(12, juego.calcularTropasParaElJugador(jugadores.get(0)));
        assertEquals(12, juego.calcularTropasParaElJugador(jugadores.get(1)));

    }

    @Test
    public void unJugadorControlaTodoAsia() throws Exception{
        Tablero tablero = new TableroMockTodoAsiaParaJugadorUno();

        ArrayList <Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Pepe", "000000"));
        jugadores.add(new Jugador("Pipo", "000000"));
        jugadores.add(new Jugador("Martin", "000000"));

        tablero.distribuirPaises(jugadores);

        CalculadorTropasDisponibles calculador = new CalculadorTropasPorContinentesConquistados();
        assert(tablero.buscarContiente("Asia").conquistadoPor(jugadores.get(1)));
        assert(calculador.calcular(jugadores.get(1), tablero) == 7);

    }

    @Test
    public void rondaJugadorUnoConquistaDosPaisesDelJugadorDos() throws Exception{
        Tablero tablero = new TableroMockJ1ArgentinaCon10TropasYJ2BrasilYChile();
        ArrayList <Jugador> jugadores = new ArrayList<>();

        Jugador atacante = new Jugador("Pepe", "000000");
        Jugador defensor = new Jugador("Pipo", "000000");

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
