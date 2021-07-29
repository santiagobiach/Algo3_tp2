package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

public class TableroMockDosJugadores extends Tablero {
    public TableroMockDosJugadores() throws Exception {
        super();
    }
    @Override
    public void distribuirPaises(ArrayList<Jugador> jugadores){
        int contador = 0;
        for(Pais pais: paises){
            if(contador < 25)
                pais.setJugador(jugadores.get(0));
            else
                pais.setJugador((jugadores.get(1)));
            contador = contador + 1;
        }
    }
}
