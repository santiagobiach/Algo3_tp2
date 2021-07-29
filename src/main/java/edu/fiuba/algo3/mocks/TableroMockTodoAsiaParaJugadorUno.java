package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;
import java.util.Random;

public class TableroMockTodoAsiaParaJugadorUno extends Tablero {

    public TableroMockTodoAsiaParaJugadorUno() throws Exception{
        super();
    }

    @Override
    public void distribuirPaises(ArrayList<Jugador> jugadores) {
        Random generadorRandom = new Random();

        int j = 0;
        for(int i=0; i<paises.size(); i++){

            int numeroRandom = generadorRandom.nextInt(paises.size()-i);
            Pais pais = paises.get(numeroRandom);
            pais.setJugador(jugadores.get(j));
            pais.agregarTropas(1);

            Pais aux = paises.get(paises.size()-i-1);
            paises.set(paises.size()-i-1, paises.get(numeroRandom));
            paises.set(numeroRandom, aux);

            j = (j+1)%jugadores.size();
        }

        Continente asia = this.buscarContiente("Asia");
        for (Pais p: asia.getPaises())
            p.setJugador(jugadores.get(1));


    }
}
