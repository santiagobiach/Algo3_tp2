package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String color;
    private String nombre;

    private final static int cantidadMaxima = 6;
    private static int cantidadDeJugadores = 0;
    private final String[] colores = {"077bb","cc3311", "ee7733", "009988", "ee3377", "000000"};
    private ArrayList<Pais> paisesConquistados;

    public Jugador(String nombre){
        this.paisesConquistados = new ArrayList<>();
        this.nombre = nombre;
        this.color = colores[cantidadDeJugadores];
        cantidadDeJugadores ++;
    }

    public void colocarEjercitos(int cantidad){
        Scanner input = new Scanner(System.in);

//        System.out.println("Paises Conquistados:");
//        for(Pais p: paisesConquistados)
//            System.out.println(p.getNombre());

        for (int i = 0; i < cantidad; i++) {
            Pais pais = this.getPaisesConquistados().get(0);
//            Pais pais = Pais.buscar(nombrePais, paisesConquistados);
            if(pais.getJugador() == this)
                pais.agregarTropas(1);
            else
                System.out.printf("Ingrese el nombre de un pais controlado");
        }
    }

    public ArrayList<Pais> getPaisesConquistados(){
        return paisesConquistados;
    }

    public int calcularTropasDisponibles(){
        return this.cantidadPaisesConquistados()/2;
    }

    public int cantidadPaisesConquistados(){
        return paisesConquistados.size();
    }

    public void perdioControlDe(Pais unPais){
        this.paisesConquistados.remove(unPais);
    }

    public void conquistoA(Pais unPais){
        this.paisesConquistados.add(unPais);
    }

    public String getNombre(){
        return this.nombre;
    }
}
