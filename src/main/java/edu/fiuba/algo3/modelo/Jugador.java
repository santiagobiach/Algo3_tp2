package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.canjes.Canje;
import edu.fiuba.algo3.modelo.canjes.CanjeadorDeTarjetas;
import edu.fiuba.algo3.modelo.canjes.PrimerCanje;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<TarjetaDePais> tarjetasObtenidas;
    private String nombre;
    private Canje numeroDeCanje;
    private int tropasDisponibles;
    private ArrayList<Objetivo> objetivos;
    private boolean conquistoEnUltimoTurno;

    private ArrayList<Pais> paisesConquistados;

    public Jugador(String nombre){
        this.paisesConquistados = new ArrayList<>();
        this.nombre = nombre;
        this.numeroDeCanje = new PrimerCanje();
        this.tarjetasObtenidas = new ArrayList<>();
        this.objetivos = new ArrayList<>();
        this.tropasDisponibles = 0;
        this.conquistoEnUltimoTurno = false;
    }

    public boolean perdio(){
        return (paisesConquistados.size() == 0);
    }

    public void activarTarjeta(TarjetaDePais tarjeta){
        if(tarjetasObtenidas.contains(tarjeta))
            tarjeta.activar(this);
    }

    public void darTarjeta(TarjetaDePais tarjeta){
        tarjetasObtenidas.add(tarjeta);
        System.out.println(this.getNombre()+" recibió: "+tarjeta.pais().getNombre()+" ("+tarjeta.simbolo()+")");
        conquistoEnUltimoTurno = false;
    }

    public void eliminarTarjeta(TarjetaDePais tarjeta){
            tarjetasObtenidas.remove(tarjeta);
    }

    public boolean conquistoEnUltimoTurno(){
        return conquistoEnUltimoTurno;
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
    public void canjeRealizado(TarjetaDePais t1, TarjetaDePais t2, TarjetaDePais t3){

        agregarTropasDisponibles(numeroDeCanje.tropasDisponibles());
        this.numeroDeCanje = this.numeroDeCanje.siguiente();
        eliminarTarjeta(t1);
        eliminarTarjeta(t2);
        eliminarTarjeta(t3);
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
        agregarPais(unPais);
        System.out.println(nombre+" conquisto a "+unPais.getNombre());
        conquistoEnUltimoTurno = true;
    }

    public void agregarPais(Pais unPais){
        if(!paisesConquistados.contains(unPais))
            this.paisesConquistados.add(unPais);
    }

    public String getNombre(){
        return this.nombre;
    }

    public void agregarObjetivo(Objetivo objetivo){
        objetivos.add(objetivo);
    }
    public boolean cumplioObjetivos(){
        for(Objetivo obj: objetivos){
            if(obj.estaCumplido(this)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Objetivo> getObjetivos(){
        return objetivos;
    }

    public ArrayList<TarjetaDePais> getTarjetasObtenidas() {
        return tarjetasObtenidas;
    }
}
