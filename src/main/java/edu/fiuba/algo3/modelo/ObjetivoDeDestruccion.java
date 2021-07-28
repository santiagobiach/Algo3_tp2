package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoDeDestruccion implements Objetivo{
    private ArrayList<Jugador> jugadoresADestruir;
    private String descripcion;
    public ObjetivoDeDestruccion(String desc){
        jugadoresADestruir = new ArrayList<>();
        this.descripcion = desc;
    }

    public boolean estaCumplido(Jugador jugador) {
        for(Jugador j: jugadoresADestruir){
            if(j.cantidadPaisesConquistados() > 0)
                return false;
        }
        return true;
    }

    public void agregarJugadorADestruir(Jugador jugadorADestruir){
        jugadoresADestruir.add(jugadorADestruir);
    }
}
