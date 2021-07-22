package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void ningunPaisQuedaSinControlarTrasDistribuirlos() throws Exception{
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Mario", "000000"));
        jugadores.add(new Jugador("Pedro", "000000"));
        jugadores.add(new Jugador("Jose", "000000"));
        jugadores.add(new Jugador("Maria", "000000"));
        Tablero tablero =  new Tablero();
        tablero.distribuirPaises(jugadores);

        boolean sinConquistar = false;
        for(Pais p: tablero.getPaises())
            if(p.getJugador() == null)
                sinConquistar = true;

        assertFalse(sinConquistar);
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
        Tablero tablero = new Tablero();
        tablero.distribuirPaises(jugadores);

        ArrayList<Integer> primerConteo = new ArrayList<>();
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
            tropasDisponibles.add(j.calcularTropasDisponibles());
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
        }

        assert(sumaCorrecta);

    }

    @Test
    public void uno() throws Exception{
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Mario", "000000"));
        jugadores.add(new Jugador("Pedro", "000000"));
        jugadores.add(new Jugador("Jose", "000000"));
        jugadores.add(new Jugador("Maria", "000000"));
        Tablero tablero = new Tablero();
        tablero.distribuirPaises(jugadores);
    }
}
