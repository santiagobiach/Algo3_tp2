package edu.fiuba.algo3.modelo;

public class TercerCanjeOPosterior implements NumeroDeCanje{
    private int numeroDeCajes;

    public TercerCanjeOPosterior(int numero){
        this.numeroDeCajes = numero;
    }
    @Override
    public int tropasDisponibles() {
        return 10 + 5*(numeroDeCajes-3);
    }

    @Override
    public NumeroDeCanje siguiente() {
        return new TercerCanjeOPosterior(numeroDeCajes+1);
    }
}
