package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.controladores.ControladorMenu;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAvanzarTurnoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonReagruparHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesConquistadosReagrupacionHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesLimitrofesReagrupacionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MenuFaseDeReagrupación extends VBox {
    private Juego juego;
    private Label turno;
    private HBox contenedorPaisDeOrigen;
    private HBox contenedorPaisDeDestino;
    private HBox contenedorReagrupar;
    private ComboBox CBPaisDeOrigen;
    private ComboBox CBPaisDeDestino;
    private Spinner SPTropas;
    private Button BTTropas;
    private Button BTTerminarTurno;
    private Label tropasPaisDeOrigen;
    private Label tropasPaisDeDestino;
    private Label paisDeOrigen;
    private Label paisDeDestino;
    private Label cantidadDeTropas;

    public MenuFaseDeReagrupación(Juego juego, Stage stage) {
        this.juego = juego;
        this.turno = new Label();
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setPrefHeight(1200);
        this.setMinWidth(200);
        BackgroundFill colorFondo = new BackgroundFill(Color.LIGHTGREY, null, null);
        this.setBackground(new Background(colorFondo));

        this.paisDeOrigen = new Label();
        paisDeOrigen.setText("Pais de Origen");

        this.CBPaisDeOrigen = new ComboBox();
        CBPaisDeOrigen.setPrefWidth(150);
        this.tropasPaisDeOrigen = new Label();

        this.paisDeDestino = new Label();
        paisDeDestino.setText("Pais de Destino");

        this.CBPaisDeDestino = new ComboBox();
        CBPaisDeDestino.setPrefWidth(150);
        this.tropasPaisDeDestino = new Label();

        this.cantidadDeTropas = new Label();
        cantidadDeTropas.setText("Cantidad de Tropas");

        this.SPTropas = new Spinner(1, 100, 1);
        SPTropas.setPrefWidth(80);
        this.BTTropas = new Button();
        BTTropas.setText("Mover");
        BTTropas.setPrefWidth(65);


        this.contenedorPaisDeOrigen = new HBox();
        contenedorPaisDeOrigen.setSpacing(5);
        contenedorPaisDeOrigen.getChildren().addAll(CBPaisDeOrigen, tropasPaisDeOrigen);

        this.contenedorPaisDeDestino = new HBox();
        contenedorPaisDeDestino.setSpacing(5);
        contenedorPaisDeDestino.getChildren().addAll(CBPaisDeDestino, tropasPaisDeDestino);

        this.contenedorReagrupar = new HBox();
        contenedorReagrupar.setSpacing(5);
        contenedorReagrupar.setPrefWidth(150);
        contenedorReagrupar.getChildren().addAll(SPTropas, BTTropas);

        BTTerminarTurno = new Button();
        BTTerminarTurno.setPrefWidth(150);
        BTTerminarTurno.setText("Terminar turno");

        this.getChildren().addAll(turno, paisDeOrigen, contenedorPaisDeOrigen, paisDeDestino,
                contenedorPaisDeDestino,cantidadDeTropas, contenedorReagrupar, BTTerminarTurno);


        PaisesConquistadosReagrupacionHandler handlerCBPaisDeOrigen =
                new PaisesConquistadosReagrupacionHandler(CBPaisDeOrigen,CBPaisDeDestino, tropasPaisDeOrigen,
                        this, juego);

        CBPaisDeOrigen.setOnAction(handlerCBPaisDeOrigen);

        PaisesLimitrofesReagrupacionHandler handlerCBPaisDeDestino =
                new PaisesLimitrofesReagrupacionHandler(CBPaisDeDestino, tropasPaisDeDestino, this, juego);

        CBPaisDeDestino.setOnAction(handlerCBPaisDeDestino);

        BotonReagruparHandler handlerBotonReagrupar = new BotonReagruparHandler(CBPaisDeOrigen, CBPaisDeDestino, SPTropas,
                tropasPaisDeOrigen, tropasPaisDeDestino, juego);

        BTTropas.setOnAction(handlerBotonReagrupar);

        BotonAvanzarTurnoHandler botonAvanzarTurnoHandler = new BotonAvanzarTurnoHandler(juego, stage);
        BTTerminarTurno.setOnAction(botonAvanzarTurnoHandler);

        actualizar();

    }

    public void actualizar(){
        //this.getChildren().removeAll();
        Jugador jugadorActual = juego.getJugadorActual();
        this.turno.setText("Turno: " + jugadorActual.getNombre());
        this.turno.setTextFill(ControladorJuego.getColorJugador(jugadorActual));
        CBPaisDeOrigen.getItems().clear();
        CBPaisDeDestino.getItems().clear();
        for(Pais p: jugadorActual.getPaisesConquistados()){
            CBPaisDeOrigen.getItems().add(p.getNombre());
        }
    }
}
