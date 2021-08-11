package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Jugador;

public class ObjetivoGeneral implements Objetivo{

    public boolean estaCumplido(Jugador jugador) {
        return (jugador.cantidadPaisesConquistados() >= 30);
    }

    @Override
    public String getDescripcion() {
        return "Conquistar 30 paises";
    }
}
