package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class BatallaMockGanaAtacante implements Batalla{
    private final Pais atacante, defensor;

    public BatallaMockGanaAtacante(Pais unAtacante, Pais unDefensor){
        atacante = unAtacante;
        defensor = unDefensor;
    }

    public void combatir() throws ExcepcionBatallaInvalida{
        defensor.restarTropas(defensor.getCantidadDeTropas());
        defensor.defenderConquista(atacante);
    }
}
