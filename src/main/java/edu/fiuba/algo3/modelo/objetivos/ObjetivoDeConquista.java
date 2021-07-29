package edu.fiuba.algo3.modelo.objetivos;

import edu.fiuba.algo3.modelo.Continente;
import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ObjetivoDeConquista implements Objetivo{

    private ArrayList<Continente> continentesAConquistar;
    private ArrayList<Integer> numeroDePaisesAConquistar;
    private String descripcion;

    public ObjetivoDeConquista(String descripcion){
        continentesAConquistar = new ArrayList<>();
        numeroDePaisesAConquistar = new ArrayList<>();
        this.descripcion = descripcion;

    }
    public boolean estaCumplido(Jugador jugador){
        int numeroDePaisesAConquistarAux;
        for(int i = 0; i < continentesAConquistar.size(); i++){
            numeroDePaisesAConquistarAux = numeroDePaisesAConquistar.get(i);
            if(numeroDePaisesAConquistarAux == -1){
                if(!continentesAConquistar.get(i).conquistadoPor(jugador))

                    return false;
            }else{
                if(!continentesAConquistar.get(i).jugadorControlaXProvincias(jugador, numeroDePaisesAConquistarAux))
                    return false;
            }
        }
        return true;
    }
    public void agregarContinenteAConquistar(Continente continente, int numeroDeProvinciasAConquistar){
        continentesAConquistar.add(continente);
        numeroDePaisesAConquistar.add(numeroDeProvinciasAConquistar);
    }
}
