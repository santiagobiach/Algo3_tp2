package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class BatallaMockGanaAtacante implements Batalla{

    public void combatir(Pais atacante, Pais defensor, int cantidadDeTropasAtacantes) throws ExcepcionBatallaInvalida{
        defensor.restarTropas(3);
        atacante.vencioA(defensor);
    }
}
