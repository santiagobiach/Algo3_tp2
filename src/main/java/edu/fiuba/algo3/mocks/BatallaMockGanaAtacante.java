package edu.fiuba.algo3.mocks;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionBatallaInvalida;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.batallas.Batalla;

public class BatallaMockGanaAtacante implements Batalla {
    private final Pais atacante, defensor;

    public BatallaMockGanaAtacante(Pais unAtacante, Pais unDefensor){
        atacante = unAtacante;
        defensor = unDefensor;
    }

    public void combatir() throws ExcepcionBatallaInvalida {
        defensor.restarTropas(defensor.getCantidadDeTropas());
        defensor.defenderConquista(atacante);
    }
}
