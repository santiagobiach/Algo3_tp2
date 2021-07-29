package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;

import java.util.ArrayList;
import java.util.Random;

public class Juego{
    private ArrayList<Jugador> jugadores;
    private ArrayList<TarjetaDePais> mazo;
    private Tablero tablero;
    private Jugador ganador;
    private Jugador jugadorActual;
    private ArrayList<CalculadorTropasDisponibles> calculadores;

    public Juego(Tablero tablero, ArrayList<CalculadorTropasDisponibles> calculadores,
                 ArrayList<Jugador> jugadores) throws Exception{

        this.ganador = null;
        this.tablero = tablero;
        this.mazo = InicializadorDePaisesYContinentes.inicializarCartasDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv",
                tablero.getPaises());
        this.jugadores = jugadores;
        this.calculadores = calculadores;
    }
    public void inicializar(){
        tablero.distribuirPaises(jugadores);
        Random generadorRandom = new Random();
        int numeroRandom = generadorRandom.nextInt(jugadores.size());
        this.jugadorActual = jugadores.get(numeroRandom);
    }
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    public TarjetaDePais getTarjeta(Pais pais){
        for (TarjetaDePais t: mazo){
            if (t.pais() == pais)
                return t;
        }
        return null;
    }
    public Tablero getTablero(){
        return this.tablero;
    }
    public void proximoTurno(){
        int indiceTurno = jugadores.indexOf(jugadorActual);
        if(indiceTurno == (jugadores.size() - 1)){
            indiceTurno = 0;
            jugadorActual = jugadores.get(indiceTurno);
        }else{
            jugadorActual = jugadores.get(indiceTurno + 1);
        }
    }
}
