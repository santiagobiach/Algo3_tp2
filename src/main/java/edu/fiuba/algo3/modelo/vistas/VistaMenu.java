package edu.fiuba.algo3.modelo.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.controladores.*;


import java.util.Hashtable;


public class VistaMenu extends Vista{
    VistaJuego escenaJuego;
    Stage stage;
    VistaComoJugar escenaInstrucciones;

    public Scene crearEscena(Hashtable data) {
        Group grupo = new Group();

        Button btn_iniciarPartida = new Button();
        Button btn_reglas = new Button();
        Button btn_salir = new Button();

        grupo.getChildren().addAll(btn_iniciarPartida, btn_reglas, btn_salir);

        btn_iniciarPartida.setText("INICIAR PARTIDA");
        btn_iniciarPartida.setLayoutY(30);
        btn_iniciarPartida.setPrefWidth(200);

        btn_reglas.setText("CÓMO JUGAR");
        btn_reglas.setLayoutY(60);
        btn_reglas.setPrefWidth(200);

        btn_salir.setText("SALIR");
        btn_salir.setLayoutY(90);
        btn_salir.setPrefWidth(200);

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(grupo);
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/Portada_img.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        btn_iniciarPartida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControladorMenu.mostrarConfigurarPartida(new Hashtable());
            }
        });
        btn_reglas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControladorMenu.mostrarComoJugar();
            }
        });

        return new Scene(this, 740, 580);
    }

}

