package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAvanzarTurnoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonColocarHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonMostrarObjetivoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonReagruparHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.ComboBoxPaisesColocacionHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesConquistadosReagrupacionHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesLimitrofesReagrupacionHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuFaseDeColocacion extends VBox {
    private Juego juego;
    private Label turno;
    private VBox contenedorPaisDeOrigen;
    private HBox contenedorColocar;
    private ComboBox CBPaisDeOrigen;
    private Spinner SPTropas;
    private Button BTTropas;
    private Button BTObjetivos;
    private Button BTTerminarTurno;
    private Label tropasPaisDeOrigen;
    private Label paisDeOrigen;
    private Label cantidadDeTropas;
    public MenuFaseDeColocacion(Juego juego, Stage stage){
        this.juego = juego;
        this.turno = new Label();
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setPrefHeight(1200);
        this.setMinWidth(200);
        BackgroundFill colorFondo = new BackgroundFill(Color.LIGHTGREY, null, null);
        this.setBackground(new Background(colorFondo));

        this.BTObjetivos = new Button();
        BTObjetivos.setText("Objetivos");
        BTObjetivos.setPrefWidth(80);

        BTTerminarTurno = new Button();
        BTTerminarTurno.setText("Terminar");
        BTTerminarTurno.setPrefWidth(80);

        HBox contenedorSuperior = new HBox();
        contenedorSuperior.setSpacing(10);
        contenedorSuperior.getChildren().addAll(BTObjetivos, BTTerminarTurno);

        this.paisDeOrigen = new Label();
        paisDeOrigen.setText("Pais de Origen");

        this.CBPaisDeOrigen = new ComboBox();
        CBPaisDeOrigen.setPrefWidth(170);
        this.tropasPaisDeOrigen = new Label();
        this.tropasPaisDeOrigen.setText("Tropas:");


        this.cantidadDeTropas = new Label();
        cantidadDeTropas.setText("Cantidad de Tropas disponibles: ");

        this.SPTropas = new Spinner(1, 100, 1);
        SPTropas.setPrefWidth(60);
        this.BTTropas = new Button();
        BTTropas.setText("Colocar");
        BTTropas.setPrefWidth(100);

        this.contenedorPaisDeOrigen = new VBox();
        contenedorPaisDeOrigen.setSpacing(5);
        contenedorPaisDeOrigen.getChildren().addAll(CBPaisDeOrigen, tropasPaisDeOrigen);



        this.contenedorColocar = new HBox();
        contenedorColocar.setSpacing(5);
        contenedorColocar.setPrefWidth(150);
        contenedorColocar.getChildren().addAll(SPTropas, BTTropas);



        this.getChildren().addAll(turno, contenedorSuperior, paisDeOrigen, contenedorPaisDeOrigen,
                cantidadDeTropas, contenedorColocar);

        ComboBoxPaisesColocacionHandler ComboBoxPaisesHandler = new ComboBoxPaisesColocacionHandler(CBPaisDeOrigen,
                tropasPaisDeOrigen, juego);
        CBPaisDeOrigen.setOnAction(ComboBoxPaisesHandler);
        BotonMostrarObjetivoHandler handlerBotonObjetivo = new BotonMostrarObjetivoHandler(juego);
        BTObjetivos.setOnAction(handlerBotonObjetivo);

        BotonAvanzarTurnoHandler botonAvanzarTurnoHandler = new BotonAvanzarTurnoHandler(juego, stage);
        BTTerminarTurno.setOnAction(botonAvanzarTurnoHandler);
        BotonColocarHandler botonColocarHandler = new BotonColocarHandler(CBPaisDeOrigen, tropasPaisDeOrigen,
                cantidadDeTropas,SPTropas, juego);
        BTTropas.setOnAction(botonColocarHandler);

        actualizar();
    }

    public void actualizar(){
        //this.getChildren().removeAll();
        Jugador jugadorActual = juego.getJugadorActual();
        this.turno.setText("Turno: " + jugadorActual.getNombre());
        this.cantidadDeTropas.setText("Tropas disponibles: " + jugadorActual.tropasDisponibles());
        this.turno.setTextFill(ControladorJuego.getColorJugador(jugadorActual));
        CBPaisDeOrigen.getItems().clear();
        for(Pais p: jugadorActual.getPaisesConquistados()){
            CBPaisDeOrigen.getItems().add(p.getNombre());
        }
    }
}
