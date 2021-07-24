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
    public void TodosLosJugadoresTienen5EjercitosMasDespuesDePedirlesQueColoquen5Ejercitos() throws Exception{
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Mario", "000000"));
        jugadores.add(new Jugador("Pedro", "000000"));
        jugadores.add(new Jugador("Jose", "000000"));
        jugadores.add(new Jugador("Maria", "000000"));
        Tablero tablero = new Tablero();
        tablero.distribuirPaises(jugadores);

        Juego juego = new Juego(tablero, crearCalculadores(), jugadores);

        ArrayList<Integer> primerConteo = new ArrayList<>();
        for(Jugador j: jugadores){
            int contador = 0;
            for(Pais p: j.getPaisesConquistados())
                contador += p.getCantidadDeTropas();

            primerConteo.add(contador);
        }

        for(Jugador j: jugadores)
            j.colocarEjercitos(5);

        int i=0;
        boolean sumoCinco = true;
        for(Jugador j: jugadores){
            int contador = 0;
            for(Pais p: j.getPaisesConquistados())
                contador += p.getCantidadDeTropas();
            if(contador != primerConteo.get(i) + 5)
                sumoCinco = false;
            i++;
        }

        assert(sumoCinco);

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
            for(Pais p: j.getPaisesConquistados())
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

        Juego juego = new Juego(tablero, crearCalculadores(), jugadores);

        tablero.distribuirPaises(jugadores);

        for(Jugador j: jugadores){
            int cantidadJugador = juego.calcularTropasParaElJugador(j);
            j.colocarEjercitos(cantidadJugador);
        }

        CalculadorTropasDisponibles calculador = new CalculadorTropasPorContinentesConquistados();
        assert(tablero.buscarContiente("Asia").conquistadoPor(jugadores.get(1)));
        assert(calculador.calcular(jugadores.get(1), tablero) == 7);

    }

    @Test
    public void unJugadorActivaUnaTarjetaDeUnPaisQueControlaYEsteTiene2TropasMas() throws Exception{

        Jugador jugador = new Jugador("Pepe", "000000");
        Pais pais = new Pais("Argentina", new Continente("America"));

        TarjetaDePais tarjeta = new TarjetaDePais(pais, "Globo");
        pais.setJugador(jugador);
        jugador.obtuvoTarjeta(tarjeta);
        int primerConteo = tarjeta.pais().getCantidadDeTropas();
        jugador.activarTarjeta(tarjeta);
        int segundoConteo = tarjeta.pais().getCantidadDeTropas();

        assert(primerConteo == segundoConteo-2);
    }

    @Test
    public void unJugadorCanjea3TarjetasDelMismoSimbolo() throws Exception{

        Jugador jugador = new Jugador("Pepe", "000000");

        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "cañon");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "cañon");

        jugador.obtuvoTarjeta(tarjeta1);
        jugador.obtuvoTarjeta(tarjeta2);
        jugador.obtuvoTarjeta(tarjeta3);

        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(4, jugador.tropasDisponibles());
    }

    @Test
    public void unJugadorCanjea3TarjetasDeDistintoSimbolo() throws Exception{

        Jugador jugador = new Jugador("Pepe", "000000");
        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "globo");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "barco");

        jugador.obtuvoTarjeta(tarjeta1);
        jugador.obtuvoTarjeta(tarjeta2);
        jugador.obtuvoTarjeta(tarjeta3);

        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(4, jugador.tropasDisponibles());
    }

    @Test
    public void unJugadorNoPuedeCanjear2TarjetasDelMismoSimboloYUnaDiferente() throws Exception{


        Jugador jugador = new Jugador("Pepe", "000000");
        TarjetaDePais tarjeta1 = new TarjetaDePais(new Pais("Argentina", new Continente("America")), "cañon");
        TarjetaDePais tarjeta2 = new TarjetaDePais(new Pais("Brasil", new Continente("America")), "barco");
        TarjetaDePais tarjeta3 = new TarjetaDePais(new Pais("Chile", new Continente("America")), "cañon");


        jugador.obtuvoTarjeta(tarjeta1);
        jugador.obtuvoTarjeta(tarjeta2);
        jugador.obtuvoTarjeta(tarjeta3);


        jugador.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3);

        assertEquals(0, jugador.tropasDisponibles());
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

        assert(argentina.getJugador() != brasil.getJugador() && argentina.getJugador() != chile.getJugador());

        (new BatallaMockGanaAtacante(argentina, brasil)).combatir();
        (new BatallaMockGanaAtacante(argentina, chile)).combatir();

        assert(argentina.getJugador() == brasil.getJugador() && argentina.getJugador() == chile.getJugador());
    }
}
