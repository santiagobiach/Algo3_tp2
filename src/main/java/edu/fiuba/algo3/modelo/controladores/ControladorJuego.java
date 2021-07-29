package edu.fiuba.algo3.modelo.controladores;

import edu.fiuba.algo3.mocks.TableroMock20TropasPorPais;
import edu.fiuba.algo3.mocks.TableroMockTodoAsiaParaJugadorUno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorContinentesConquistados;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorPaisesConquistados;
import edu.fiuba.algo3.modelo.vistas.VistaJuego;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public class ControladorJuego {
    private static Stage escenario;
    private static Juego juego;

    public static void setEscenario(Stage escenario){
       ControladorJuego.escenario = escenario;
    }

    public static void empezarPartida(ArrayList<String> nombres){
        Tablero tablero = null;
        try{
             tablero = new TableroMock20TropasPorPais();
        } catch (Exception e){
            System.out.printf("Excepcion creando tablero");
            System.exit(-1);
        }

        ArrayList<CalculadorTropasDisponibles> calculadores = new ArrayList<>();
        calculadores.add(new CalculadorTropasPorContinentesConquistados(tablero));
        calculadores.add(new CalculadorTropasPorPaisesConquistados());

        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(String n: nombres){
            jugadores.add(new Jugador(n));
        }

        try{
            juego = new Juego(tablero, calculadores, jugadores);
        } catch (Exception e){
            System.out.printf("Excepcion creando juego");
            System.exit(-1);
        }
        juego.inicializar();
        mostrarTableroInicial();
    }

    public static void mostrarTableroInicial(){
        Scene escena = (new VistaJuego(juego)).crearEscena(new Hashtable<>());
        escenario.setScene(escena);
        escenario.show();
    }
}
