package edu.fiuba.algo3.modelo.canjes;

public class PrimerCanje implements Canje {
    @Override
    public int tropasDisponibles() {
        return 4;
    }

    @Override
    public Canje siguiente() {
        return new SegundoCanje();
    }
}
