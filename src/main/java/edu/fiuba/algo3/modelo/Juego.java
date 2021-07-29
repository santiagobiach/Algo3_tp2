package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;

import java.util.ArrayList;

public class Juego{
    private ArrayList<Jugador> jugadores;
    private ArrayList<TarjetaDePais> mazo;
    private Tablero tablero;
    private Jugador ganador;
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

    public TarjetaDePais getTarjeta(Pais pais){
        for (TarjetaDePais t: mazo){
            if (t.pais() == pais)
                return t;
        }
        return null;
    }

}
