package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.controladores.ControladorMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
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

import javax.net.ssl.SSLEngineResult;
import java.util.Hashtable;


public class VistaComoJugar extends Vista{
    Stage stage;

    public Scene crearEscena(Hashtable data){
        Group grupo = new Group();
        Button btn_salir = new Button();
        grupo.getChildren().addAll(btn_salir);

        btn_salir.setText("Volver al menú");
        btn_salir.setLayoutX(0);
        btn_salir.setLayoutY(90);
        btn_salir.setPrefWidth(200);

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(grupo);
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/instrucciones.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        btn_salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControladorMenu.mostrarMenu();
            }
        });

        return new Scene(this, 1280, 720);
    }
}