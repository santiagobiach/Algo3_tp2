package edu.fiuba.algo3.modelo.canjes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;

public class TarjetaDePais {
    private Pais pais;
    private String simbolo;
    private Jugador dueño;

    public TarjetaDePais(Pais pais, String simbolo){
        this.pais = pais;
        this.dueño = null;
        this.simbolo = simbolo;
    }
    public Pais pais(){
        return this.pais;
    }

    public String simbolo(){
        return this.simbolo;
    }

    public void setDueño(Jugador jugador){
        if(this.dueño != null)
            dueño.eliminarTarjeta(this);

        if(jugador!= null)
            jugador.darTarjeta(this);

        this.dueño = jugador;
    }
    public void activar(Jugador jugador){
        if (pais.getJugador() == jugador){
            pais.agregarTropas(2);
            jugador.eliminarTarjeta(this);
            this.dueño = (null);
        }
    }

}
