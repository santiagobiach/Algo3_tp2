package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vistas.botones.BotonAtacarHandler;
import edu.fiuba.algo3.modelo.vistas.botones.MenuFaseDeAtaque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

import java.util.Hashtable;


public class VistaJuego extends Vista{
    Stage stage;
    private Juego juego;
    public VistaJuego(Juego juego){
        this.juego = juego;
    }
    public Scene crearEscena(Hashtable data){


        MenuFaseDeAtaque menu = new MenuFaseDeAtaque(juego);

        this.getChildren().addAll(menu);

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/tableroteg.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        return new Scene(this, 1280, 720);
    }
}