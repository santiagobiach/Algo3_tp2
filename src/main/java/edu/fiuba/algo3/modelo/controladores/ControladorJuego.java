package edu.fiuba.algo3.modelo.controladores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.vistas.VistaComoJugar;
import edu.fiuba.algo3.modelo.vistas.VistaConfigurarPartida;
import edu.fiuba.algo3.modelo.vistas.VistaJuego;
import edu.fiuba.algo3.modelo.vistas.VistaMenu;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public class ControladorJuego {
    private static Stage stage;

    public static void setEscenario(Stage escenario){
       stage = escenario;
    }

    public static void empezarPartida(ArrayList<String> nombres){
        //DEBUG
        System.out.println("Comenzando partida con "+nombres.size()+" jugadores");
        for(String n: nombres){
            System.out.println(n);
        }
        //END-DEBUG

        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(String n: nombres){
            jugadores.add(new Jugador(n));
        }

        Hashtable data = new Hashtable();
        Scene escena = (new VistaJuego()).crearEscena(data);
        stage.setScene(escena);
        stage.show();





    }
}
