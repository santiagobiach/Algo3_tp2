package edu.fiuba.algo3.modelo.canjes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;

public class TarjetaDePais {
    private Pais pais;
    private String simbolo;

    public TarjetaDePais(Pais pais, String simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
    }
    public Pais pais(){
        return this.pais;
    }

    public String simbolo(){
        return this.simbolo;
    }


    public void activar(Jugador jugador){
        if (pais.getJugador() == jugador){
            pais.agregarTropas(2);
            jugador.eliminarTarjeta(this);

        }
    }

}
