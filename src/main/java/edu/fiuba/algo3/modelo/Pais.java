package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {

    private String nombre;

    private int cantidadDeTropas;

    private ArrayList <Pais> paisesLimitrofes = new ArrayList<>();

    public Pais(String nombre){
        this.nombre = nombre;
        this.cantidadDeTropas = 0;
    }

    public void agregarTropas(int cantidad){
        cantidadDeTropas += cantidad;
    }

    public int getCantidadDeTropas(){
        return cantidadDeTropas;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean esLimitrofe(Pais unPais){
        return (paisesLimitrofes.contains(unPais));
    }

    private void agregarPaisLimitrofeAux(Pais unPais){
        paisesLimitrofes.add(unPais);
    }

    public boolean tieneTropasSuficientes(int cantidad){
        return (cantidadDeTropas >= (cantidad+1));
    }

    public void agregarPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
        unPais.agregarPaisLimitrofeAux(this);
    }
}
