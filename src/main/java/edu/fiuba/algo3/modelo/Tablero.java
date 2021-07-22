package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private ArrayList<Pais> paises;
    private ArrayList<Continente> continentes;

    private String csvCartas = "src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv";
    private String csvFronteras = "src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv";

    public Tablero() throws Exception{
        continentes = InicializadorDePaisesYContinentes.InicializarContinentes();
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo(csvFronteras, continentes);
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public void distribuirPaises(ArrayList<Jugador> jugadores){
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

//        for(Jugador ju: jugadores)
//            System.out.println(ju.getNombre()+": "+ju.cantidadPaisesConquistados());
//        for(Pais pais: paises)
//            System.out.printf(pais.getNombre()+": "+(pais.getJugador()).getNombre()+" ("+pais.getCantidadDeTropas()+")\n");

    }

}
