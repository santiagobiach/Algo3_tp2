package edu.fiuba.algo3.modelo.canjes;

public class SegundoCanje implements Canje {
    @Override
    public int tropasDisponibles() {
        return 7;
    }

    @Override
    public Canje siguiente() {
        return new TercerCanjeOPosterior(3);
    }

}
