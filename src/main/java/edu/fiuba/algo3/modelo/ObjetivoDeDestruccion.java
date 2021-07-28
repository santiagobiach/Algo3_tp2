package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoDeDestruccion implements Objetivo{
    private ArrayList<Jugador> jugadoresADestruir;
    public ObjetivoDeDestruccion(){
        jugadoresADestruir = new ArrayList<>();
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
