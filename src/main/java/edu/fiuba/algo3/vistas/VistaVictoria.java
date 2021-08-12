package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.objetivos.Objetivo;
import edu.fiuba.algo3.controladores.comboBox.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.util.Hashtable;

public class VistaVictoria extends Vista{
    private Juego juego;

    public VistaVictoria(Juego juego){
        this.juego = juego;
    }
    @Override
    public Scene crearEscena(Hashtable data) {
        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setAlignment(Pos.CENTER);

        VBox contenedorInformacionPartida = new VBox();
        contenedorInformacionPartida.setAlignment(Pos.CENTER);
        Label ganador = new Label();
        ganador.setText("Felicidades: " + juego.ganador().getNombre()+ ".");
        ganador.setFont(new Font(ganador.getFont().getName(), 24));

        Label objetivos = new Label();
        objetivos.setFont(new Font(objetivos.getFont().getName(), 16));
        for(Objetivo obj: juego.ganador().getObjetivos()){
            if(obj.estaCumplido(juego.ganador())){
                objetivos.setText("Cumplio el objetivo de: " + obj.getDescripcion());
            }
        }

        Label informacion = new Label();
        informacion.setText("Informacion de la partida:");
        informacion.setFont(new Font(informacion.getFont().getName(), 16));
        HBox contenedorJugadores = new HBox();
        Label jugadoresLabel = new Label("Jugadores: ");
        ComboBox<Jugador> jugadoresCB = new ComboBox<>();
        Callback<ListView<Jugador>, ListCell<Jugador>> factory = lv -> new ListCell<Jugador>() {

            @Override
            protected void updateItem(Jugador item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNombre());
            }

        };
        jugadoresCB.setCellFactory(factory);
        jugadoresCB.setButtonCell(factory.call(null));

        for(Jugador j: juego.getJugadores()){
            jugadoresCB.getItems().add(j);
        }
        jugadoresCB.getSelectionModel().select(juego.ganador());
        contenedorJugadores.getChildren().addAll(jugadoresLabel, jugadoresCB);
        ListView<Pais> listaPaisesJugador = new ListView<Pais>();
        listaPaisesJugador.setPrefWidth(300);
        listaPaisesJugador.setCellFactory(param -> new ListCell<Pais>() {
            @Override
            protected void updateItem(Pais item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.esNeutral()) {
                    setText(null);
                } else {
                    setText(item.getNombre() + " Tropas: " + item.getCantidadDeTropas());
                }
            }
        });

        for(Pais p: juego.ganador().getPaisesConquistados()){
            listaPaisesJugador.getItems().add(p);
        }
        ComboBoxJugadoresVistaVictoriaHandler jugadoresVistaVictoriaHandler = new ComboBoxJugadoresVistaVictoriaHandler(jugadoresCB,listaPaisesJugador);
        jugadoresCB.setOnAction(jugadoresVistaVictoriaHandler);

        contenedorInformacionPartida.getChildren().addAll(informacion,contenedorJugadores, listaPaisesJugador);
        contenedorPrincipal.getChildren().addAll(ganador, objetivos, contenedorInformacionPartida);
        this.getChildren().addAll(contenedorPrincipal);
        return new Scene(this, 1280, 720);
    }
}
