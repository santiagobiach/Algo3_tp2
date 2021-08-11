package edu.fiuba.algo3.modelo.canjes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mazo;

public class CanjeadorDeTarjetas {

    private static Mazo mazo;

    private static boolean checkTresIguales(TarjetaDePais tarjeta1, TarjetaDePais tarjeta2, TarjetaDePais tarjeta3){
        return (tarjeta1.simbolo().equals(tarjeta2.simbolo()) && tarjeta1.simbolo().equals(tarjeta3.simbolo()));
    }

    private static boolean checkTresDistintas(TarjetaDePais tarjeta1, TarjetaDePais tarjeta2, TarjetaDePais tarjeta3){
        return (!tarjeta1.simbolo().equals(tarjeta2.simbolo()) && !tarjeta1.simbolo().equals(tarjeta3.simbolo())
                && !tarjeta2.simbolo().equals(tarjeta3.simbolo()));
    }

    public static void canjearTarjetas(TarjetaDePais tarjeta1, TarjetaDePais tarjeta2,
                                       TarjetaDePais tarjeta3, Jugador jugador){

        if(checkTresIguales(tarjeta1, tarjeta2, tarjeta3) || checkTresDistintas(tarjeta1, tarjeta2, tarjeta3)){
            mazo.reincorporarTarjeta(tarjeta1);
            mazo.reincorporarTarjeta(tarjeta2);
            mazo.reincorporarTarjeta(tarjeta3);
            jugador.canjeRealizado(tarjeta1, tarjeta2, tarjeta3);

        }


    }

    public static void setMazo(Mazo mazo) {
        CanjeadorDeTarjetas.mazo = mazo;
    }
}
