package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.VistaComoJugar;
import edu.fiuba.algo3.vistas.VistaConfigurarPartida;
import edu.fiuba.algo3.vistas.VistaMenu;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public class ControladorMenu {

    private static Stage stage;

    public static void setEscenario(Stage escenario){
       stage = escenario;
    }

    public static void mostrarMenu(){
        Scene escena = (new VistaMenu().crearEscena(new Hashtable()));
        stage.setScene(escena);
        stage.show();
    }

    public static void mostrarComoJugar(){
        Scene escena = (new VistaComoJugar().crearEscena(new Hashtable()));
        stage.setScene(escena);
        stage.show();
    }

    public static void mostrarConfigurarPartida(Hashtable data){
        Scene escena = (new VistaConfigurarPartida().crearEscena(data));
        stage.setScene(escena);
        stage.show();
    }

    public static void empezarPartida(Hashtable data){
        ArrayList<String> nombres = new ArrayList<>();
        for(String nombre: (ArrayList<String>)data.get("nombres"))
            if (!nombre.equals(""))
                nombres.add(nombre);

        if(nombres.size() < 2 || nombres.size() > 6){
            Hashtable nuevaData = new Hashtable<>();
            nuevaData.put("mensaje","Cantidad de jugadores inválida");
            mostrarConfigurarPartida(nuevaData);
        } else {
            ControladorJuego.empezarPartida(nombres);

        }


    }

}
