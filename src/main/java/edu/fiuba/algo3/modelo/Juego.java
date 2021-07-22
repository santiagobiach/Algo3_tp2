package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<TarjetaDePais> mazo;
    private Tablero tablero;
    private ArrayList<CalculadorTropasDisponibles> calculadores;

//    fase_inicial (distribucion)
//    fase_ataque (ataques entre paises limitrofes)
//    fase_reagrupacion (mover ejercitos entre p. limitrofes)
//    fase_colocacion (sacar tarjeta + nuevos ejercitos + canjear tarjetas)

    public Juego(Tablero tablero, ArrayList<CalculadorTropasDisponibles> calculadores,
                 ArrayList<Jugador> jugadores) throws Exception{

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

    public void comenzarPartida(){
        tablero.distribuirPaises(jugadores);
        for(Jugador jugador: jugadores)
            jugador.colocarEjercitos(5);
        for(Jugador jugador: jugadores)
            jugador.colocarEjercitos(3);
    }

    public int calcularTropasParaElJugador(Jugador jugador){
        int cantidad=0;
        for(CalculadorTropasDisponibles calc: calculadores)
            cantidad += calc.calcular(jugador, this.tablero);
        return cantidad;
    }
}
