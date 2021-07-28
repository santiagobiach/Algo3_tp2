package edu.fiuba.algo3.modelo.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class VistaMenu extends StackPane{

    private void inicio(){
        Group grupo = new Group();

        Button btn_iniciarPartida = new Button();
        Button btn_reglas = new Button();
        Button btn_salir = new Button();

        grupo.getChildren().addAll(btn_iniciarPartida, btn_reglas, btn_salir);

        btn_iniciarPartida.setText("INICIAR PARTIDA");
        btn_reglas.setText("CÓMO JUGAR");
        btn_salir.setText("SALIR");

        btn_iniciarPartida.setLayoutX(0);
        btn_iniciarPartida.setLayoutY(30);

        btn_reglas.setLayoutX(0);
        btn_reglas.setLayoutY(60);

        btn_salir.setLayoutX(0);
        btn_salir.setLayoutY(90);

        btn_iniciarPartida.setPrefWidth(200);
        btn_reglas.setPrefWidth(200);
        btn_salir.setPrefWidth(200);
        btn_iniciarPartida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Juego Empezado");
            }
        });
        this.getChildren().addAll(grupo);
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/Portada_img.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);
    }

    public VistaMenu(){
       this.inicio();
    }
}

