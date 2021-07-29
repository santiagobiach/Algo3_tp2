package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAvanzarTurnoHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.ComboBoxPaisesConquistadosHandler;
import edu.fiuba.algo3.modelo.vistas.comboBox.ComboBoxPaisesLimitrofesHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuFaseDeAtaque extends VBox {
    private Juego juego;
    private Label turno;
    private ComboBox<String> cb;
    private Label tropasAtacante;
    private ComboBox<String> cb2;
    private Label tropasDefensor;
    private Button btn_atacar;
    private Button btn_reagrupar;
    private Button btn_avanzarTurno;
    public MenuFaseDeAtaque(Juego juego){
        this.juego = juego;
        this.turno = new Label();
        this.cb = new ComboBox<>();
        this.tropasAtacante = new Label();
        this.cb2 = new ComboBox<>();
        this.tropasDefensor = new Label();
        this.btn_atacar = new Button();
        this.btn_reagrupar = new Button();
        this.btn_avanzarTurno = new Button();
        HBox hBox = new HBox();
        hBox.setSpacing(10);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        ComboBoxPaisesConquistadosHandler cbxHandler = new ComboBoxPaisesConquistadosHandler(cb, cb2,
                tropasAtacante, juego);
        cb.setOnAction(cbxHandler);
        ComboBoxPaisesLimitrofesHandler cb2Handler = new ComboBoxPaisesLimitrofesHandler(cb2, tropasDefensor, juego);
        cb2.setOnAction(cb2Handler);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        btn_atacar.setText("atacar");
        BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(turno);
        btn_atacar.setOnAction(botonAtacarHandler);

        btn_reagrupar.setText("reagrupar");
        btn_avanzarTurno.setText("Terminar turno");
        BotonAvanzarTurnoHandler botonAvanzarTurnoHandler = new BotonAvanzarTurnoHandler(juego, this);
        btn_avanzarTurno.setOnAction(botonAvanzarTurnoHandler);
        btn_atacar.setPrefWidth(170);
        btn_reagrupar.setPrefWidth(170);
        btn_avanzarTurno.setPrefWidth(170);
        hBox.getChildren().addAll(cb, tropasAtacante);
        hBox2.getChildren().addAll(cb2, tropasDefensor);
        this.getChildren().addAll(turno, btn_atacar,hBox,hBox2, btn_reagrupar, btn_avanzarTurno);
        actualizar();
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
        this.turno.setText("Turno:" + juego.getJugadorActual().getNombre());
        cb.getItems().clear();
        cb2.getItems().clear();
        cb.getItems().addAll(conseguirNombrePaisesDeJugador(juego.getJugadorActual()));



    }
}
