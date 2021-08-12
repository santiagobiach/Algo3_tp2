package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoMockNuncaCumplido implements Objetivo{
    @Override
    public boolean estaCumplido(Jugador jugador) {
        return false;
    }

    @Override
    public String getDescripcion() {
        return null;
    }
}
