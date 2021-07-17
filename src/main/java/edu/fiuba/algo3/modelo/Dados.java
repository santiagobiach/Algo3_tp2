package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Collections;

public class Dados {

    public static ArrayList <Integer> tirar(int cantidad){
        ArrayList<Integer> listaTiros = new ArrayList<Integer>();

        for(int i=0; i<cantidad; i++) {
            listaTiros.add((int)(Math.random()*5 + 1));
            Collections.sort(listaTiros, Collections.reverseOrder());
        }

        return listaTiros;
    }
}
