package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.inicializadores.InicializadorDePaisesYContinentes;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    protected ArrayList<TarjetaDePais> tarjetas;
    public Mazo(Tablero tablero){
        try{
            this.tarjetas = InicializadorDePaisesYContinentes.inicializarCartasDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv",
                    tablero.getPaises());
        } catch (Exception e){
            System.out.println("Error creando tarjetas");
            System.exit(-1);
        }
    }
    public TarjetaDePais getTarjeta(Pais pais) {
        for (TarjetaDePais t : tarjetas) {
            if (t.pais() == pais)
                return t;
        }
        return null;
    }

    public void darTarjetaA(Jugador jugador){
        if(tarjetas.size() > 0){
            Random generadorRandom = new Random();
            int i = Math.abs(generadorRandom.nextInt()% tarjetas.size());
            jugador.darTarjeta(tarjetas.get(i));
            tarjetas.remove(i);
        }
    }
    public void reincorporarTarjeta(TarjetaDePais tarjeta)
    {tarjetas.add(tarjeta);}

    //Solo para pruebas
    public int cantidadCartas(){
        return this.tarjetas.size();
    }
}

