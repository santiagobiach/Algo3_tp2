package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    private ArrayList<Pais> paises;
    private String nombre;

    public void agregarPais(Pais unPais){
        paises.add(unPais);
    }

    public Continente(String nombre){
        this.nombre = nombre;
        this.paises = new ArrayList<Pais>();
    }

    public boolean conquistadoPor(Jugador unJugador){
        boolean conquistado = true;

        if(unJugador == null || paises.isEmpty()){
            conquistado=false;
        }

        for(Pais pais: paises){
            if (!pais.dominadoPor(unJugador))
                 conquistado=false;
        }

        return conquistado;
    }
}
