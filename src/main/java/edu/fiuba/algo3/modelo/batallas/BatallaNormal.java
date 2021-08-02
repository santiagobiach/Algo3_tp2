package edu.fiuba.algo3.modelo.batallas;

import edu.fiuba.algo3.modelo.Dados;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionBatallaInvalida;
import edu.fiuba.algo3.modelo.Pais;

import java.util.ArrayList;

public class BatallaNormal implements Batalla{

    private final int cantidadDeTropasAtacantes;
    private final Pais atacante, defensor;

    public BatallaNormal(Pais unAtacante, Pais unDefensor, int unaCantidadDeTropasAtacantes) throws ExcepcionBatallaInvalida {

        if (unaCantidadDeTropasAtacantes < 1)
            throw new ExcepcionBatallaInvalida("Numero inválido de tropas");

        else if (!unAtacante.tieneTropasSuficientes(unaCantidadDeTropasAtacantes))
            throw new ExcepcionBatallaInvalida("Tropas insuficientes");

        else if(unAtacante.esNeutral())
            throw new ExcepcionBatallaInvalida("Atacante Neutral");

        else if(!unAtacante.esLimitrofeCon(unDefensor))
            throw new ExcepcionBatallaInvalida("Paises no limítrofes");

        else if(unAtacante.esAliado(unDefensor))
            throw new ExcepcionBatallaInvalida("Batalla entre paises aliados");

        cantidadDeTropasAtacantes = unaCantidadDeTropasAtacantes;
        atacante = unAtacante;
        defensor = unDefensor;
    }

    public void combatir() throws ExcepcionBatallaInvalida{

        int cantidadDadosAtacante = Math.min(3, cantidadDeTropasAtacantes);
        int cantidadDadosDefensor = Math.min(3, defensor.getCantidadDeTropas());

        ArrayList <Integer> tirosAtacante = Dados.tirar(cantidadDadosAtacante);
        ArrayList <Integer> tirosDefensor = Dados.tirar(cantidadDadosDefensor);

        while(!tirosAtacante.isEmpty() && !tirosDefensor.isEmpty()){
            if(tirosAtacante.get(0) > tirosDefensor.get(0))
                defensor.restarTropas(1);
            else
                atacante.restarTropas(1);

            tirosAtacante.remove(0);
            tirosDefensor.remove(0);
        }

        defensor.defenderConquista(atacante);

    }

}