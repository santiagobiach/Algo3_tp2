package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private ArrayList <Pais> paisesLimitrofes = new ArrayList<>();
    public Pais(String nombre){
        this.nombre = nombre;
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
    public void agregarPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
        unPais.agregarPaisLimitrofeAux(this);
    }
}
