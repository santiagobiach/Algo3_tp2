package edu.fiuba.algo3.modelo.canjes;

import edu.fiuba.algo3.modelo.canjes.Canje;
import edu.fiuba.algo3.modelo.canjes.TercerCanjeOPosterior;

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
