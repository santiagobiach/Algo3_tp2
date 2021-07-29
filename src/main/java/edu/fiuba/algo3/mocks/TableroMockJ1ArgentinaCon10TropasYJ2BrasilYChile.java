package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

public class TableroMockJ1ArgentinaCon10TropasYJ2BrasilYChile extends Tablero {

    public TableroMockJ1ArgentinaCon10TropasYJ2BrasilYChile() throws Exception{
        super();
    }

    @Override
    public void distribuirPaises(ArrayList<Jugador> jugadores){
        super.distribuirPaises(jugadores);
        for(Pais p: paises){
            if (p.getNombre().equals("Argentina")){
                p.setJugador(jugadores.get(0));
                p.agregarTropas(10);
            }
            else if (p.getNombre().equals("Brasil") || p.getNombre().equals("Chile"))
                p.setJugador(jugadores.get(1));
        }
    }

}
