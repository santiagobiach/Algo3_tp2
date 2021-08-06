package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.mocks.MazoMockTodasParaUnJugador;
import edu.fiuba.algo3.modelo.batallas.BatallaNormal;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.canjes.CanjeadorDeTarjetas;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionBatallaInvalida;
import edu.fiuba.algo3.modelo.fases.Fase;
import edu.fiuba.algo3.modelo.fases.FaseColocacionInicial;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.modelo.objetivos.ObjetivoGeneral;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Random;

public class Juego{
    private ArrayList<Jugador> jugadores;
    private Mazo mazo;
    private Tablero tablero;
    private Jugador ganador;
    private ArrayList<Objetivo> objetivos;
    private Fase fase;
    //private Jugador jugadorActual;
    private ArrayList<CalculadorTropasDisponibles> calculadores;

    public Juego(Tablero tablero, ArrayList<CalculadorTropasDisponibles> calculadores,
                 ArrayList<Jugador> jugadores) throws Exception{

        this.ganador = null;
        this.tablero = tablero;

        this.objetivos = InicializadorDePaisesYContinentes.inicializarObjetivosDesdeArchivo(
                "src/main/java/edu/fiuba/algo3/archivoscsv/Teg- Objetivos.csv", tablero.getContinentes());
        this.jugadores = jugadores;
        this.calculadores = calculadores;
        this.mazo = new Mazo(tablero);
    }

    public void distribuirTarjetas(){
        for(Jugador j: jugadores){
            if (j.conquistoEnUltimoTurno())
                mazo.darTarjetaA(j);
        }
    }

    private void repartirObjetivos(ArrayList<Jugador> jugadores){
        Random generadorRandom = new Random();

        for(Jugador j: jugadores){
            int numeroRandom = generadorRandom.nextInt(objetivos.size());

            j.agregarObjetivo(objetivos.get(numeroRandom));
            j.agregarObjetivo(new ObjetivoGeneral());
        }
    }

    public void inicializar(){
        tablero.distribuirPaises(jugadores);
        Random generadorRandom = new Random();
        int numeroRandom = generadorRandom.nextInt(jugadores.size());
        repartirObjetivos(jugadores);
        this.jugadores = ordenarJugadores(jugadores, numeroRandom);
        this.calculadores = calculadores;
        this.fase = new FaseColocacionInicial(jugadores, 5, 3, calculadores);
        this.ganador = null;
        CanjeadorDeTarjetas.setMazo(this.mazo);
        chequearVictoria();
    }

    public Jugador getJugadorActual(){
        return fase.getJugadorActual();
    }

    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

    private void chequearVictoria(){
        for(Jugador j: jugadores){
            if(j.cumplioObjetivos()){
                this.ganador = j;
                return;
            }
        }
    }

    public Jugador ganador(){
        return ganador;
    }

    private void eliminarPerdedores(){
        for (Jugador j: jugadores)
            if (j.perdio())
                jugadores.remove(j);
    }

    public TarjetaDePais getTarjeta(Pais pais){
        return mazo.getTarjeta(pais);
    }

    public Tablero getTablero(){
        return this.tablero;
    }

    public void proximoTurno(){
        if (this.getJugadorActual().tropasDisponibles() == 0){
            eliminarPerdedores();
            this.fase = fase.proximoTurno();
            distribuirTarjetas();
        }
    }

    public Fase getFase() {
        return fase;
    }

    public void crearBatalla(Pais atacante, Pais defensor, int tropasAtacantes, Observer o){
        try{
            BatallaNormal batalla = new BatallaNormal(atacante,defensor, tropasAtacantes);
            batalla.addObserver(o);
            batalla.combatir();
            chequearVictoria();
            batalla.deleteObserver(o);
        }catch(ExcepcionBatallaInvalida e){
            System.out.println("La batalla es invalida");
        }

    }

    private ArrayList<Jugador> ordenarJugadores(ArrayList<Jugador> jugadores, int indiceJugadorInicial){
        ArrayList<Jugador> jugadoresOrdenados = new ArrayList<>();

        for(int i = 0; i < jugadores.size(); i++){
            int aux = i + indiceJugadorInicial;
            if(aux >=jugadores.size())
                jugadoresOrdenados.add(jugadores.get(aux-jugadores.size()));
            else
                jugadoresOrdenados.add(jugadores.get(aux));
        }
        return jugadoresOrdenados;
    }
}
