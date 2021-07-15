package edu.fiuba.algo3.modelo;

public interface Batalla {
    void combatir(Pais atacante, Pais defensor, int cantidadDeTropasAtacantes) throws ExcepcionBatallaInvalida;
}
