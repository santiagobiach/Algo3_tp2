package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.image.ImageView;
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

        VBox menu = ((VBox)data.get("menu"));
        VistaTablero vistaTablero = new VistaTablero(juego);
        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.getChildren().addAll(menu, vistaTablero);

        this.getChildren().addAll(contenedorPrincipal);
        return new Scene(this, 1280, 720);
    }
}