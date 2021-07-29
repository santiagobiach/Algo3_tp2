package edu.fiuba.algo3.modelo.canjes;

public class TercerCanjeOPosterior implements Canje {
    private int numeroDeCajes;

    public TercerCanjeOPosterior(int numero){
        this.numeroDeCajes = numero;
    }
    @Override
    public int tropasDisponibles() {
        return 10 + 5*(numeroDeCajes-3);
    }

    @Override
    public Canje siguiente() {
        return new TercerCanjeOPosterior(numeroDeCajes+1);
    }
}
