package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.controladores.ControladorMenu;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAvanzarTurnoHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonReagruparHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesConquistadosReagrupacionHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.PaisesLimitrofesReagrupacionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuFaseDeReagrupación extends VBox {
    private Juego juego;
    private Label turno;
    private HBox contenedorPaisDeOrigen;
    private HBox contenedorPaisDeDestino;
    private HBox contenedorReagrupar;
    private ComboBox CBPaisDeOrigen;
    private ComboBox CBPaisDeDestino;
    private TextField TFTropas;
    private Button BTTropas;
    private Button BTTerminarTurno;
    private Label tropasPaisDeOrigen;
    private Label tropasPaisDeDestino;

    public MenuFaseDeReagrupación(Juego juego) {
        this.juego = juego;
        this.turno = new Label();
        this.setSpacing(5);

        this.CBPaisDeOrigen = new ComboBox();
        CBPaisDeOrigen.setPrefWidth(150);
        this.tropasPaisDeOrigen = new Label();

        this.CBPaisDeDestino = new ComboBox();
        CBPaisDeDestino.setPrefWidth(150);
        this.tropasPaisDeDestino = new Label();

        this.TFTropas = new TextField();
        this.BTTropas = new Button();
        BTTropas.setText("Mover");

        this.contenedorPaisDeOrigen = new HBox();
        contenedorPaisDeOrigen.setSpacing(5);
        contenedorPaisDeOrigen.getChildren().addAll(CBPaisDeOrigen, tropasPaisDeOrigen);

        this.contenedorPaisDeDestino = new HBox();
        contenedorPaisDeDestino.setSpacing(5);
        contenedorPaisDeDestino.getChildren().addAll(CBPaisDeDestino, tropasPaisDeDestino);

        this.contenedorReagrupar = new HBox();
        contenedorReagrupar.setSpacing(5);
        contenedorReagrupar.setPrefWidth(150);
        contenedorReagrupar.getChildren().addAll(TFTropas, BTTropas);

        BTTerminarTurno = new Button();
        BTTerminarTurno.setPrefWidth(205);
        BTTerminarTurno.setText("TERMINAR TURNO");

        this.getChildren().addAll(turno, contenedorPaisDeOrigen, contenedorPaisDeDestino, contenedorReagrupar, BTTerminarTurno);


        PaisesConquistadosReagrupacionHandler handlerCBPaisDeOrigen =
                new PaisesConquistadosReagrupacionHandler(CBPaisDeOrigen,CBPaisDeDestino, tropasPaisDeOrigen, this, juego);

        CBPaisDeOrigen.setOnAction(handlerCBPaisDeOrigen);

        PaisesLimitrofesReagrupacionHandler handlerCBPaisDeDestino =
                new PaisesLimitrofesReagrupacionHandler(CBPaisDeDestino, tropasPaisDeDestino, this, juego);

        CBPaisDeDestino.setOnAction(handlerCBPaisDeDestino);

        BotonReagruparHandler handlerBotonReagrupar = new BotonReagruparHandler(CBPaisDeOrigen, CBPaisDeDestino, TFTropas,
                tropasPaisDeOrigen, tropasPaisDeDestino, juego);

        BTTropas.setOnAction(handlerBotonReagrupar);

        BotonAvanzarTurnoHandler botonAvanzarTurnoHandler = new BotonAvanzarTurnoHandler(juego, this);
        BTTerminarTurno.setOnAction(botonAvanzarTurnoHandler);

        actualizar();

    }

    public void actualizar(){
        //this.getChildren().removeAll();
        this.turno.setText("Turno: " + juego.getJugadorActual().getNombre());
        CBPaisDeOrigen.getItems().clear();
        CBPaisDeDestino.getItems().clear();
        for(Pais p: juego.getJugadorActual().getPaisesConquistados()){
            CBPaisDeOrigen.getItems().add(p.getNombre());
        }
    }
}
