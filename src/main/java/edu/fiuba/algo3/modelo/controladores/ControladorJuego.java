package edu.fiuba.algo3.modelo.controladores;

import edu.fiuba.algo3.mocks.TableroMock20TropasPorPais;
import edu.fiuba.algo3.mocks.TableroMockTodoAsiaParaJugadorUno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasDisponibles;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorContinentesConquistados;
import edu.fiuba.algo3.modelo.calculadores.CalculadorTropasPorPaisesConquistados;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeAtaque;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeColocacion;
import edu.fiuba.algo3.modelo.vistas.VistaJuego;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class ControladorJuego {
    private static Stage escenario;
    private static Juego juego;
    private static Hashtable<String, Color> coloresJugadores;

    public static void setEscenario(Stage escenario){
       ControladorJuego.escenario = escenario;
    }

    public static Color getColorJugador(Jugador jugador){
        return coloresJugadores.get(jugador.getNombre());
    }

    private static Hashtable<String, Color> asignarColoresRandomAJugadores(ArrayList<Jugador> jugadores){
        ArrayList<Color> colores = new ArrayList<>();
        colores.add(Color.rgb(0, 119, 119));
        colores.add(Color.rgb(204, 51, 17));
        colores.add(Color.rgb(238, 119, 51));
        colores.add(Color.rgb(0, 153, 136));
        colores.add(Color.rgb(238, 51, 119));
        colores.add(Color.rgb(0, 0, 0));

        Random generadorRandom = new Random();
        Hashtable<String, Color> coloresJugadores = new Hashtable<>();

        for (Jugador j: jugadores){
            int indice = Math.abs(generadorRandom.nextInt() % colores.size());
            coloresJugadores.put(j.getNombre(), colores.get(indice));
            colores.remove(indice);
        }
        return coloresJugadores;
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

        ControladorJuego.coloresJugadores = ControladorJuego.asignarColoresRandomAJugadores(jugadores);

        try{
            juego = new Juego(tablero, calculadores, jugadores);
        } catch (Exception e){
            System.out.printf("Excepcion creando juego");
            System.exit(-1);
        }
        juego.inicializar();
        mostrarTableroInicial();
        //mostrarFaseColocacion();
    }

    public static void mostrarTableroInicial(){

        Hashtable data = new Hashtable();
        data.put("menu", new MenuFaseDeAtaque(juego, escenario));
        Scene escena = (new VistaJuego(juego)).crearEscena(data);
        escenario.setScene(escena);
        escenario.show();
    }

    public static void mostrarFaseColocacion(){
        Hashtable data = new Hashtable();
        data.put("menu", new MenuFaseDeColocacion(juego, escenario));
        Scene escena = (new VistaJuego(juego)).crearEscena(data);
        escenario.setScene(escena);
        escenario.show();
    }
}
