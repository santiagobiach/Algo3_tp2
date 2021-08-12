package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoMockSiempreCumplido implements Objetivo{
    @Override
    public boolean estaCumplido(Jugador jugador) {
        return true;
    }

    @Override
    public String getDescripcion() {
        return null;
    }
}
