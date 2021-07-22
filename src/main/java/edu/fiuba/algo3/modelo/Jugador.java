package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String color;
    private ArrayList<TarjetaDePais> tarjetasObtenidas;
    private String nombre;
    private NumeroDeCanje numeroDeCanje;

    private ArrayList<Pais> paisesConquistados;

    public void activarTarjeta(TarjetaDePais tarjeta){
        tarjeta.activar(this);
    }

    public void obtuvoTarjeta(TarjetaDePais tarjeta){
        tarjetasObtenidas.add(tarjeta);
    }

    public void perdioTarjeta(TarjetaDePais tarjeta){
        if (tarjetasObtenidas.contains(tarjeta))
            tarjetasObtenidas.remove(tarjeta);
    }

    public void canjearTarjetas(TarjetaDePais tarjeta1, TarjetaDePais tarjeta2, TarjetaDePais tarjeta3){
        CanjeadorDeTarjetas.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3, this);
    }

    public void canjeRealizado(){
        colocarEjercitos(numeroDeCanje.tropasDisponibles());
        this.numeroDeCanje = this.numeroDeCanje.siguiente();
    }

    public Jugador(String nombre, String color){
        this.paisesConquistados = new ArrayList<>();
        this.nombre = nombre;
        this.color = color;
        this.numeroDeCanje = new PrimerCanje();
        this.tarjetasObtenidas = new ArrayList<>();
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
