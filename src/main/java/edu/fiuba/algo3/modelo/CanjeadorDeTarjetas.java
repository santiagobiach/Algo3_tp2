package edu.fiuba.algo3.modelo;

public class CanjeadorDeTarjetas {

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
            tarjeta3.setDueño(null);
            tarjeta1.setDueño(null);
            tarjeta2.setDueño(null);
            jugador.canjeRealizado();
        }


    }
}
