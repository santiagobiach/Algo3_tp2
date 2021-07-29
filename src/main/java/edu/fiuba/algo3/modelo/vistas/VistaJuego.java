package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        MenuFaseDeReagrupación menuReagrupación = new MenuFaseDeReagrupación(juego);

        this.getChildren().addAll(menuReagrupación);

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/tableroteg.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        return new Scene(this, 1280, 720);
    }
}