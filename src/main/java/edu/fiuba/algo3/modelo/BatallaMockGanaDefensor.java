package edu.fiuba.algo3.modelo;

public class BatallaMockGanaDefensor implements Batalla{

    public void combatir(Pais atacante, Pais defensor, int cantidadDeTropasAtacantes) throws ExcepcionBatallaInvalida{
        atacante.restarTropas(3);
    }
}
