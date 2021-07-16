package edu.fiuba.algo3.modelo;

public class BatallaMockGanaDefensor implements Batalla{

    private final Pais atacante, defensor;

    public BatallaMockGanaDefensor(Pais unAtacante, Pais unDefensor){
        atacante = unAtacante;
        defensor = unDefensor;
    }
    public void combatir() throws ExcepcionBatallaInvalida{
        atacante.restarTropas(3);
        defensor.defenderConquista(atacante);
    }
}
