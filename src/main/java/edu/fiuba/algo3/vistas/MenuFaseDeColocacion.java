package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.vistas.botones.BotonCanjearHandler;
import edu.fiuba.algo3.vistas.botones.BotonColocarHandler;
import edu.fiuba.algo3.vistas.botones.BotonMostrarAyudaCanjeHandler;
import edu.fiuba.algo3.vistas.botones.BotonMostrarObjetivoHandler;
import edu.fiuba.algo3.vistas.comboBox.ComboBoxPaisesColocacionHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuFaseDeColocacion extends Menu {
    private Juego juego;
    private Label turno;
    private VBox contenedorPaisDeDestino;
    private HBox contenedorColocar;
    private ComboBox CBPaisDeDestino;
    private Spinner SPTropas;
    private Button BTTropas;
    private Button BTObjetivos;
    private Button BTTerminarTurno;
    private Label tropasPaisDeDestino;
    private Label paisDeDestino;
    private Label cantidadDeTropas;
    private ListView<TarjetaDePais> cartas;

    public MenuFaseDeColocacion(Juego juego, Stage stage){
        this.juego = juego;
        this.turno = new Label();
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setPrefHeight(1200);
        this.setMinWidth(200);
        BackgroundFill colorFondo = new BackgroundFill(Color.LIGHTGREY, null, null);
        this.setBackground(new Background(colorFondo));
        super.titulo.setText("FASE DE COLOCACIÓN");

        this.BTObjetivos = new Button();
        BTObjetivos.setText("Objetivos");
        BTObjetivos.setPrefWidth(80);

        BTTerminarTurno = new Button();
        BTTerminarTurno.setText("Terminar");
        BTTerminarTurno.setPrefWidth(80);

        HBox contenedorSuperior = new HBox();
        contenedorSuperior.setSpacing(10);
        contenedorSuperior.getChildren().addAll(BTObjetivos, BTTerminarTurno);

        this.paisDeDestino = new Label();
        paisDeDestino.setText("Colocar en:");

        this.CBPaisDeDestino = new ComboBox();
        CBPaisDeDestino.setPrefWidth(170);
        this.tropasPaisDeDestino = new Label();
        this.tropasPaisDeDestino.setText("Tropas:");

        this.cantidadDeTropas = new Label();
        cantidadDeTropas.setText("Cantidad de Tropas disponibles: ");

        this.SPTropas = new Spinner(1, 100, 1);
        SPTropas.setPrefWidth(60);
        this.BTTropas = new Button();
        BTTropas.setText("Colocar");
        BTTropas.setPrefWidth(100);

        this.contenedorPaisDeDestino = new VBox();
        contenedorPaisDeDestino.setSpacing(5);
        contenedorPaisDeDestino.getChildren().addAll(CBPaisDeDestino, tropasPaisDeDestino);

        this.contenedorColocar = new HBox();
        contenedorColocar.setSpacing(5);
        contenedorColocar.setPrefWidth(150);
        contenedorColocar.getChildren().addAll(SPTropas, BTTropas);

        VBox contenedorCartas = new VBox();
        contenedorCartas.setSpacing(10);
        HBox contenedorBotonesCanje = new HBox();
        contenedorBotonesCanje.setSpacing(10);
        Label tituloCartas = new Label("Cartas obtenidas:");
        Button BTAyuda = new Button("Ayuda");
        BTAyuda.setPrefWidth(80);
        Button BTCanjear = new Button("Canjear");
        BTCanjear.setPrefWidth(80);
        this.cartas = new ListView();
        cartas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        cartas.setPrefHeight(120);
        cartas.setCellFactory(param -> new ListCell<TarjetaDePais>() {
            @Override
            protected void updateItem(TarjetaDePais item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.pais() == null) {
                    setText(null);
                } else {
                    setText(item.pais().getNombre() + ", " + item.simbolo());
                }
            }
        });

        contenedorBotonesCanje.getChildren().addAll(BTAyuda,BTCanjear);
        contenedorCartas.getChildren().addAll(tituloCartas,cartas, contenedorBotonesCanje);
        this.getChildren().addAll(super.titulo, turno, contenedorSuperior, paisDeDestino, contenedorPaisDeDestino,
                cantidadDeTropas, contenedorColocar,contenedorCartas);

        //Handlers
        ComboBoxPaisesColocacionHandler ComboBoxPaisesHandler = new ComboBoxPaisesColocacionHandler(CBPaisDeDestino,
                tropasPaisDeDestino, juego);
        CBPaisDeDestino.setOnAction(ComboBoxPaisesHandler);

        BotonMostrarObjetivoHandler handlerBotonObjetivo = new BotonMostrarObjetivoHandler(juego);
        BTObjetivos.setOnAction(handlerBotonObjetivo);

        BotonColocarHandler botonColocarHandler = new BotonColocarHandler(CBPaisDeDestino, tropasPaisDeDestino,
                cantidadDeTropas,SPTropas, juego);
        BTTropas.setOnAction(botonColocarHandler);
        BotonMostrarAyudaCanjeHandler botonMostrarAyudaCanjeHandler = new BotonMostrarAyudaCanjeHandler();
        BTAyuda.setOnAction(botonMostrarAyudaCanjeHandler);

        BotonCanjearHandler botonCanjearHandler = new BotonCanjearHandler(juego,cartas,this);
        BTCanjear.setOnAction(botonCanjearHandler);
        BTTerminarTurno.setOnAction(actionEvent -> {
            juego.proximoTurno();
            ControladorJuego.mostrarTablero();
        });

        actualizar();
    }

    public void actualizar(){
        //this.getChildren().removeAll();
        Jugador jugadorActual = juego.getJugadorActual();
        this.turno.setText("Turno: " + jugadorActual.getNombre());
        this.cantidadDeTropas.setText("Tropas disponibles: " + jugadorActual.tropasDisponibles());
        this.turno.setTextFill(ControladorJuego.getColorJugador(jugadorActual));
        CBPaisDeDestino.getItems().clear();
        for(Pais p: jugadorActual.getPaisesConquistados()){
            CBPaisDeDestino.getItems().add(p.getNombre());
        }
        cartas.getItems().clear();
        for(TarjetaDePais tp: juego.getJugadorActual().getTarjetasObtenidas()){
            cartas.getItems().add(tp);
        }
    }

    @Override
    public ComboBox<String> getComboBox() {
        return CBPaisDeDestino;
    }
}
