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
import javafx.scene.control.Spinner;
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
    private Button btn_siguienteFase;
    private Spinner tropas;

    public MenuFaseDeAtaque(Juego juego){
        this.juego = juego;
        this.turno = new Label();
        this.cb = new ComboBox<>();
        this.tropasAtacante = new Label();
        this.cb2 = new ComboBox<>();
        this.tropasDefensor = new Label();
        this.btn_atacar = new Button();
        this.tropas = new Spinner(1,3,1);
        this.btn_siguienteFase = new Button();

        HBox hBoxAtacar = new HBox();
        hBoxAtacar.setSpacing(10);
        HBox hBoxPaisesConquistados = new HBox();
        hBoxPaisesConquistados.setSpacing(10);

        HBox hBoxPaisesLimitrofes = new HBox();
        hBoxPaisesLimitrofes.setSpacing(10);

        ComboBoxPaisesConquistadosHandler cbxHandler = new ComboBoxPaisesConquistadosHandler(cb, cb2,
                tropasAtacante, juego);
        cb.setOnAction(cbxHandler);
        ComboBoxPaisesLimitrofesHandler cb2Handler = new ComboBoxPaisesLimitrofesHandler(cb2, tropasDefensor, juego);
        cb2.setOnAction(cb2Handler);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        btn_atacar.setText("atacar");
        BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(juego, cb, cb2, tropas, this);
        btn_atacar.setOnAction(botonAtacarHandler);


        btn_siguienteFase.setText("Fase siguiente");
        BotonAvanzarTurnoHandler botonAvanzarTurnoHandler = new BotonAvanzarTurnoHandler(juego, new MenuFaseDeReagrupación(juego));
        btn_siguienteFase.setOnAction(botonAvanzarTurnoHandler);
        btn_atacar.setPrefWidth(100);
        tropas.setPrefWidth(60);
        btn_siguienteFase.setPrefWidth(170);
        hBoxPaisesConquistados.getChildren().addAll(cb, tropasAtacante);
        hBoxPaisesLimitrofes.getChildren().addAll(cb2, tropasDefensor);
        hBoxAtacar.getChildren().addAll(btn_atacar, tropas);
        this.getChildren().addAll(turno, hBoxAtacar,hBoxPaisesConquistados,hBoxPaisesLimitrofes, btn_siguienteFase);
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
