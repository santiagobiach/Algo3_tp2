package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Pais {

    private final String nombre;
    private Jugador jugador;
    private Continente continente;
    private ArrayList <Pais> paisesLimitrofes = new ArrayList<>();
    private int cantidadDeTropas;

    public Pais(String unNombre, Continente continente){
        this.nombre = unNombre;
        this.cantidadDeTropas = 0;
        this.jugador = null;
    }

    public void agregarTropas(int unaCantidad){
        if (unaCantidad>0)
            cantidadDeTropas += unaCantidad;
    }

    //chequear que atacante tenga tropas qsyo?
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

    private void agregarPaisLimitrofeAux(Pais unPais){
        paisesLimitrofes.add(unPais);
    }

    public boolean tieneTropasSuficientes(int cantidad){
        return (cantidadDeTropas > cantidad);
    }

    public void agregarPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
        unPais.agregarPaisLimitrofeAux(this);
    }

    public void setJugador(Jugador unJugador){
        jugador = unJugador;
    }

    public Jugador getJugador(){
        return jugador;
    }

    public boolean esAliado(Pais otroPais){
        return (jugador == otroPais.getJugador());
    }


}
