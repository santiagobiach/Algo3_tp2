package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class BatallaNormal implements Batalla{

    private ArrayList<Integer> tirarDados(int cantidadDeTiros){
        ArrayList<Integer> listaTiros = new ArrayList<Integer>();

        for(int i=0; i<cantidadDeTiros; i++) {
            listaTiros.add((int)(Math.random()*5 + 1));
            Collections.sort(listaTiros, Collections.reverseOrder());
        }

        return listaTiros;
    }

//    private void compararTiros(ArrayList<Integer> tirosAtacante, ArrayList<Integer> tirosDefensor){
//        while(!tirosAtacante.isEmpty() && !tirosDefensor.isEmpty()){
//
//            if(tirosAtacante.get(0) > tirosDefensor.get(0)){
//
//            }
//            tirosAtacante.remove(0);
//            tirosDefensor.remove(0);
//        }
//    }

    public void combatir(Pais atacante, Pais defensor, int cantidadDeTropasAtacantes) throws ExcepcionBatallaInvalida{

        int cantidadDadosAtacante = Math.min(3, cantidadDeTropasAtacantes);
        int cantidadDadosDefensor = Math.min(3, defensor.getCantidadDeTropas());

        ArrayList<Integer> tirosAtacante = this.tirarDados(cantidadDadosAtacante);
        ArrayList<Integer> tirosDefensor = this.tirarDados(cantidadDadosDefensor);

        while(!tirosAtacante.isEmpty() && !tirosDefensor.isEmpty()){

            if(tirosAtacante.get(0) > tirosDefensor.get(0)){
                defensor.restarTropas(1);
            } else {
                atacante.restarTropas(1);
            }
            tirosAtacante.remove(0);
            tirosDefensor.remove(0);
        }

        if(tirosAtacante.isEmpty())
            atacante.vencioA(defensor);
    }

}