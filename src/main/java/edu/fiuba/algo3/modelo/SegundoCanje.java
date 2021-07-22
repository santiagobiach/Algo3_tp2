package edu.fiuba.algo3.modelo;

public class SegundoCanje implements NumeroDeCanje{
    @Override
    public int tropasDisponibles() {
        return 7;
    }

    @Override
    public NumeroDeCanje siguiente() {
        return new TercerCanjeOPosterior(3);
    }

}
