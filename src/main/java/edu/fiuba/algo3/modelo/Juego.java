package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<TarjetaDePais> mazo;
    private Tablero tablero;
    private Jugador ganador;
    private ArrayList<CalculadorTropasDisponibles> calculadores;

//    fase_inicial (distribucion)
//    fase_ataque (ataques entre paises limitrofes)
//    fase_reagrupacion (mover ejercitos entre p. limitrofes)
//    fase_colocacion (sacar tarjeta + nuevos ejercitos + canjear tarjetas)

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

    public void comenzarPartida(){
        tablero.distribuirPaises(jugadores);

        Fase faseColocacion5 = new FaseDeColocacionInicial(5, tablero, jugadores);
        Fase faseColocacion3 = new FaseDeColocacionInicial(3, tablero, jugadores);

        for (Jugador j: jugadores){
            faseColocacion5.empezar(j);
        }

        for (Jugador j: jugadores){
            faseColocacion3.empezar(j);
        }

        Fase faseDeAtaque = new FaseDeAtaque(tablero, jugadores);
        Fase faseDeReagrupacion = new FaseDeReagrupacion(tablero, jugadores);
        Fase faseDeColocacion = new FaseDeColocacion(calculadores, tablero, jugadores);

        ArrayList<Fase> fases = new ArrayList<>();
        fases.add(faseDeAtaque);
        fases.add(faseDeReagrupacion);
        fases.add(faseDeColocacion);

        while(this.ganador == null ){
            for(Jugador j: jugadores){
                for (int i = 0; i < fases.size(); i++) {
                    fases.get(i).empezar(j);
                }
            }
        }
    }

}
