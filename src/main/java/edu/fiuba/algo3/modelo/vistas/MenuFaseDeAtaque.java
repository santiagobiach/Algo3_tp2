package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAvanzarTurnoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonMostrarObjetivoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonTerminarAtaqueHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.ComboBoxPaisesConquistadosHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.ComboBoxPaisesLimitrofesHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MenuFaseDeAtaque extends Menu{
    private Juego juego;
    private Label turno;
    private ComboBox<String> CBPaisAtacante;
    private Label tropasAtacante;
    private ComboBox<String> CBPaisDefensor;
    private Label tropasDefensor;
    private Button BTAtacar;
    private Button BTContinuar;
    private Button BTObjetivos;
    private Spinner SPTropas;
    private Label LBpaisAtacante;
    private Label cantidadDeTropas;
    private Label LBpaisDefensor;

    public MenuFaseDeAtaque(Juego juego, Stage stage){
        this.setSpacing(10);
        this.setPadding(new Insets(20));

//        BorderStroke trazoBorde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
//        this.setBorder(new Border(trazoBorde));
        super.titulo.setText("FASE DE ATAQUE");

        this.setPrefHeight(1200);
        this.setMinWidth(200);
        BackgroundFill colorFondo = new BackgroundFill(Color.LIGHTGREY, null, null);
        this.setBackground(new Background(colorFondo));

        this.juego = juego;
        this.turno = new Label();
        this.CBPaisAtacante = new ComboBox<>();
        CBPaisAtacante.setPrefWidth(170);

        this.CBPaisDefensor = new ComboBox<>();
        CBPaisDefensor.setPrefWidth(170);

        this.tropasAtacante = new Label();
        this.tropasDefensor = new Label();

        this.BTAtacar = new Button();
        BTAtacar.setText("Atacar");
        BTAtacar.setPrefWidth(100);

        this.SPTropas = new Spinner(1,3,1);
        SPTropas.setPrefWidth(60);

        this.BTContinuar = new Button();
        BTContinuar.setText("Continuar");
        BTContinuar.setPrefWidth(80);

        this.BTObjetivos = new Button();
        BTObjetivos.setText("Objetivos");
        BTObjetivos.setPrefWidth(80);

        HBox contenedorSuperior = new HBox();
        contenedorSuperior.setSpacing(10);
        contenedorSuperior.getChildren().addAll(BTObjetivos, BTContinuar);

        this.LBpaisAtacante = new Label();
        LBpaisAtacante.setText("Seleccionar Pais Atacante");

        VBox contenedorPaisAtacante = new VBox();
        contenedorPaisAtacante.setSpacing(10);
        contenedorPaisAtacante.getChildren().addAll(CBPaisAtacante, tropasAtacante);

        this.LBpaisDefensor = new Label();
        LBpaisDefensor.setText("Seleccionar Pais para Atacar");

        VBox contenedorPaisDefensor = new VBox();
        contenedorPaisDefensor.setSpacing(10);
        contenedorPaisDefensor.getChildren().addAll(CBPaisDefensor, tropasDefensor);

        this.cantidadDeTropas = new Label();
        cantidadDeTropas.setText("Cantidad de Tropas");

        HBox contenedorControlesAtaque = new HBox();
        contenedorControlesAtaque.setSpacing(10);
        contenedorControlesAtaque.getChildren().addAll(SPTropas, BTAtacar);

        VistaBatalla vistaBatalla = new VistaBatalla();

        this.getChildren().addAll(super.titulo, turno, contenedorSuperior, LBpaisAtacante, contenedorPaisAtacante,
                LBpaisDefensor, contenedorPaisDefensor, cantidadDeTropas, contenedorControlesAtaque,vistaBatalla);
        actualizar();

        //Handlers
        ComboBoxPaisesConquistadosHandler handlerPaisAtacante = new ComboBoxPaisesConquistadosHandler(CBPaisAtacante, CBPaisDefensor,
                tropasAtacante, juego);
        CBPaisAtacante.setOnAction(handlerPaisAtacante);

        ComboBoxPaisesLimitrofesHandler handlerPaisDefensor = new ComboBoxPaisesLimitrofesHandler(CBPaisDefensor, tropasDefensor, juego);
        CBPaisDefensor.setOnAction(handlerPaisDefensor);

        BotonAtacarHandler handlearBotonAtacar = new BotonAtacarHandler(juego, CBPaisAtacante, CBPaisDefensor, SPTropas, this, vistaBatalla);
        BTAtacar.setOnAction(handlearBotonAtacar);

        BotonMostrarObjetivoHandler handlearBotonObjetivo = new BotonMostrarObjetivoHandler(juego);
        BTObjetivos.setOnAction(handlearBotonObjetivo);

        BotonTerminarAtaqueHandler botonTerminarAtaqueHandler = new BotonTerminarAtaqueHandler(juego, stage);
        BTContinuar.setOnAction(botonTerminarAtaqueHandler);
    }

    private ObservableList<String> conseguirNombrePaisesDeJugador(Jugador jugador){
        ObservableList<String> items = FXCollections.observableArrayList();
        for(Pais pais: jugador.getPaisesConquistados()){
            items.add(pais.getNombre());
        }
        return items;
    }

    public void actualizar(){
        //this.getChildren().removeAll();
        Jugador jugadorActual = juego.getJugadorActual();
        tropasAtacante.setText("Tropas:");
        tropasDefensor.setText("Tropas:");
        this.turno.setText("Turno: " + jugadorActual.getNombre());
        this.turno.setTextFill(ControladorJuego.getColorJugador(jugadorActual));
        CBPaisAtacante.getItems().clear();
        CBPaisDefensor.getItems().clear();
        CBPaisAtacante.getItems().addAll(conseguirNombrePaisesDeJugador(jugadorActual));
    }

    @Override
    public ComboBox<String> getComboBox() {
        return CBPaisAtacante;
    }
}
