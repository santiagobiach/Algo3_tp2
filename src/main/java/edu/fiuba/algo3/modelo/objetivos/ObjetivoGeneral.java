package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoGeneral implements Objetivo{
    public ObjetivoGeneral(){}

    public boolean estaCumplido(Jugador jugador) {
        return (jugador.cantidadPaisesConquistados() >= 30);
    }
}
