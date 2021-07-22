package edu.fiuba.algo3.modelo;

public class PrimerCanje implements NumeroDeCanje{
    @Override
    public int tropasDisponibles() {
        return 4;
    }

    @Override
    public NumeroDeCanje siguiente() {
        return new SegundoCanje();
    }
}
