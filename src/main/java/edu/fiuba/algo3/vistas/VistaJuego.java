package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Hashtable;


public class VistaJuego extends Vista{
    Stage stage;
    private Juego juego;
    public VistaJuego(Juego juego){
        this.juego = juego;
    }
    public Scene crearEscena(Hashtable data){

        Menu menu = ((Menu)data.get("menu"));
        VistaTablero vistaTablero = new VistaTablero(juego, menu.getComboBox());
        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.getChildren().addAll(menu, vistaTablero);

        this.getChildren().addAll(contenedorPrincipal);
        return new Scene(this, 1280, 720);
    }
}