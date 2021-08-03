package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;

import java.util.ArrayList;
import java.util.Random;

public class MazoMockTodasParaUnJugador extends Mazo {

    public MazoMockTodasParaUnJugador(Tablero tablero, Jugador j){
        super(tablero);
        for (TarjetaDePais t: super.tarjetas)
            j.darTarjeta(t);
    }
}
