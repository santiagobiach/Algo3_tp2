package edu.fiuba.algo3.modelo.batallas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionBatallaInvalida;

public interface Batalla {
    void combatir() throws ExcepcionBatallaInvalida;
}
