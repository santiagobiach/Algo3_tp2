package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Pais extends Observable {

    private final String nombre;
    private Jugador jugador;
    private Continente continente;
    private ArrayList <Pais> paisesLimitrofes = new ArrayList<>();
    private int cantidadDeTropas;

    public Pais(String unNombre, Continente continente){
        this.nombre = unNombre;
        this.cantidadDeTropas = 0;
        this.jugador = null;
        this.continente = continente;
        continente.agregarPais(this);
    }

    public void agregarTropas(int unaCantidad){
        if (unaCantidad>0)
            cantidadDeTropas += unaCantidad;
    }

    public void agregarTropasDe(int unaCantidad, Jugador unJugador){
        if (this.dominadoPor(unJugador)){
            this.agregarTropas(unaCantidad);
            unJugador.restarTropasDisponibles(unaCantidad);
        }
    }

    public void defenderConquista(Pais atacante){
        if (cantidadDeTropas==0){
            this.setJugador(atacante.getJugador());
            this.cantidadDeTropas = 1;
            atacante.restarTropas(1);
        }
    }

    public void restarTropas(int unaCantidad){
        if (unaCantidad>0)
            cantidadDeTropas -= unaCantidad;

        if (cantidadDeTropas < 0)
            cantidadDeTropas = 0;
    }

    public void recibirTropasDe(Pais paisDeOrigen, Integer cantidad){
        if (paisDeOrigen.dominadoPor(this.jugador)){
            this.agregarTropas(cantidad);
            paisDeOrigen.restarTropas(cantidad);
        }
    }

    public void moverTropasA(Pais paisDeDestino, Integer cantidad){
        if (this.cantidadDeTropas>cantidad)
            paisDeDestino.recibirTropasDe(this, cantidad);
    }

    public int getCantidadDeTropas(){
        return cantidadDeTropas;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean dominadoPor(Jugador unJugador) {
        return (this.jugador == unJugador);
    }

    public boolean esNeutral(){
        return (jugador == null);
    }

    public boolean esLimitrofeCon(Pais unPais){
        return (paisesLimitrofes.contains(unPais));
    }

    /*private void agregarPaisLimitrofeAux(Pais unPais){
        paisesLimitrofes.add(unPais);
    }*/
    public ArrayList<Pais> getPaisesLimitrofes(){
        return this.paisesLimitrofes;
    }
    public boolean tieneTropasSuficientes(int cantidad){
        return (cantidadDeTropas > cantidad);
    }

    public void agregarPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
        //unPais.agregarPaisLimitrofeAux(this);
    }

    public void setJugador(Jugador unJugador){
        if(this.jugador != null)
            jugador.perdioControlDe(this);

        unJugador.conquistoA(this);
        jugador = unJugador;
        setChanged();
        notifyObservers(unJugador);
    }

    public Jugador getJugador(){
        return jugador;
    }

    public boolean esAliado(Pais otroPais){
        return (jugador == otroPais.getJugador());
    }


}
