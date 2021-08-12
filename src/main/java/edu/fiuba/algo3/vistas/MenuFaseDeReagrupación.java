package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.controladores.botones.BotonMostrarObjetivoHandler;
import edu.fiuba.algo3.controladores.botones.BotonReagruparHandler;
import edu.fiuba.algo3.controladores.botones.BotonTerminarReagrupacionHandler;
import edu.fiuba.algo3.controladores.comboBox.PaisesConquistadosReagrupacionHandler;
import edu.fiuba.algo3.controladores.comboBox.PaisesLimitrofesReagrupacionHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuFaseDeReagrupación extends Menu{
    private Juego juego;
    private Label turno;
    private VBox contenedorPaisDeOrigen;
    private VBox contenedorPaisDeDestino;
    private HBox contenedorReagrupar;
    private ComboBox CBPaisDeOrigen;
    private ComboBox CBPaisDeDestino;
    private Spinner SPTropas;
    private Button BTTropas;
    private Button BTObjetivos;
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
        super.titulo.setText("FASE DE REAGRUPACIÓN");

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

        this.paisDeDestino = new Label();
        paisDeDestino.setText("Pais de Destino");

        this.CBPaisDeDestino = new ComboBox();
        CBPaisDeDestino.setPrefWidth(170);
        this.tropasPaisDeDestino = new Label();
        this.tropasPaisDeDestino.setText("Tropas:");

        this.cantidadDeTropas = new Label();
        cantidadDeTropas.setText("Cantidad de Tropas");

        this.SPTropas = new Spinner(1, 100, 1);
        SPTropas.setPrefWidth(60);
        this.BTTropas = new Button();
        BTTropas.setText("Mover");
        BTTropas.setPrefWidth(100);

        this.contenedorPaisDeOrigen = new VBox();
        contenedorPaisDeOrigen.setSpacing(5);
        contenedorPaisDeOrigen.getChildren().addAll(CBPaisDeOrigen, tropasPaisDeOrigen);

        this.contenedorPaisDeDestino = new VBox();
        contenedorPaisDeDestino.setSpacing(5);
        contenedorPaisDeDestino.getChildren().addAll(CBPaisDeDestino, tropasPaisDeDestino);

        this.contenedorReagrupar = new HBox();
        contenedorReagrupar.setSpacing(5);
        contenedorReagrupar.setPrefWidth(150);
        contenedorReagrupar.getChildren().addAll(SPTropas, BTTropas);



        this.getChildren().addAll(super.titulo, turno, contenedorSuperior, paisDeOrigen, contenedorPaisDeOrigen, paisDeDestino,
                contenedorPaisDeDestino,cantidadDeTropas, contenedorReagrupar);

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
        BotonMostrarObjetivoHandler handlerBotonObjetivo = new BotonMostrarObjetivoHandler(juego);
        BTObjetivos.setOnAction(handlerBotonObjetivo);

        BotonTerminarReagrupacionHandler handlerBotonTerminar = new BotonTerminarReagrupacionHandler(juego, stage);
        BTTerminarTurno.setOnAction(handlerBotonTerminar);

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

    @Override
    public ComboBox<String> getComboBox() {
        return CBPaisDeOrigen;
    }
}
