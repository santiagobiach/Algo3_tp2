package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;

import java.util.ArrayList;
import java.util.Random;

public class TableroMock20TropasPorPais extends Tablero {
    protected ArrayList<Pais> paises;
    protected ArrayList<Continente> continentes;

    private String csvFronteras = "src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv";
    private String csvCartas = "src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv";

    public TableroMock20TropasPorPais() throws Exception{
        continentes = InicializadorDePaisesYContinentes.InicializarContinentes();
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo(csvFronteras, continentes);
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public ArrayList<Continente> continentesConquistadosPorJugador(Jugador jugador){
        ArrayList<Continente> continentesConquistados = new ArrayList<>();
        for(Continente c: continentes){
            if (c.conquistadoPor(jugador))
                continentesConquistados.add(c);
        }

        return continentesConquistados;
    }

    public Continente buscarContiente(String nombre){
        for(Continente c: continentes)
            if (c.getNombre().equals(nombre))
                return c;

        return null;
    }

    public Pais getPais(String nombre){
        for (Pais p: paises)
            if (p.getNombre().equals(nombre))
                return p;

        return null;
    }

    public void distribuirPaises(ArrayList<Jugador> jugadores){
        Random generadorRandom = new Random();

        int j = 0;
        for(int i=0; i<paises.size(); i++){

            int numeroRandom = generadorRandom.nextInt(paises.size()-i);
            Pais pais = paises.get(numeroRandom);
            pais.setJugador(jugadores.get(j));
            pais.agregarTropas(20);

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
