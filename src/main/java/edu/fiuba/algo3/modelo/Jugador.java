package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.canjes.Canje;
import edu.fiuba.algo3.modelo.canjes.CanjeadorDeTarjetas;
import edu.fiuba.algo3.modelo.canjes.PrimerCanje;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<TarjetaDePais> tarjetasObtenidas;
    private String nombre;
    private Canje numeroDeCanje;
    private int tropasDisponibles;

    private ArrayList<Pais> paisesConquistados;

    public void activarTarjeta(TarjetaDePais tarjeta){
        tarjeta.activar(this);
    }

    public void darTarjeta(TarjetaDePais tarjeta){
        tarjetasObtenidas.add(tarjeta);
    }

    public void eliminarTarjeta(TarjetaDePais tarjeta){
        if (tarjetasObtenidas.contains(tarjeta))
            tarjetasObtenidas.remove(tarjeta);
    }

    public void canjearTarjetas(TarjetaDePais tarjeta1, TarjetaDePais tarjeta2, TarjetaDePais tarjeta3){
        CanjeadorDeTarjetas.canjearTarjetas(tarjeta1, tarjeta2, tarjeta3, this);
    }
    public int tropasDisponibles(){
        return this.tropasDisponibles;
    }
    public void agregarTropasDisponibles(int numero){
        this.tropasDisponibles += numero;
    }
    public void restarTropasDisponibles(int numero){
        this.tropasDisponibles -= numero;
    }
    public void canjeRealizado(){

        agregarTropasDisponibles(numeroDeCanje.tropasDisponibles());
        this.numeroDeCanje = this.numeroDeCanje.siguiente();
    }

    public Jugador(String nombre){
        this.paisesConquistados = new ArrayList<>();
        this.nombre = nombre;
        this.numeroDeCanje = new PrimerCanje();
        this.tarjetasObtenidas = new ArrayList<>();
        this.tropasDisponibles = 0;
    }
    public void colocarEjercitos(int cantidad){
//        Scanner input = new Scanner(System.in);

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

    public void colocarEjercitosEn(int cantidad, Pais pais){
        if(tropasDisponibles >= cantidad)
            pais.agregarTropasDe(cantidad, this);
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
