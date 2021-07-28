package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente{
    private ArrayList<Pais> paises;
    private String nombre;
    private int bonusPorConquista;

    public void agregarPais(Pais unPais){
        paises.add(unPais);
    }

    public Continente(String nombre){
        this.nombre = nombre;
        this.bonusPorConquista = 0;
        this.paises = new ArrayList<Pais>();
    }

    public int bonusPorConquista(){
        return this.bonusPorConquista;
    }

    public void setBonusPorConquista(int bonusPorConquista){
        this.bonusPorConquista = bonusPorConquista;
    }

    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Pais> getPaises(){
        return this.paises;
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
    public boolean jugadorControlaXProvincias(Jugador unJugador, int x){
        boolean conquistado = true;
        int numeroDePronviciasControladas = 0;
        if(unJugador == null || paises.isEmpty()){
            conquistado=false;
        }

        for(Pais pais: paises){
            if (pais.dominadoPor(unJugador))
                numeroDePronviciasControladas += 1;
        }

        return (numeroDePronviciasControladas >= x);
    }
}
