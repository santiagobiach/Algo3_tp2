package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Hashtable;

public class VistaVictoria extends Vista{
    private Juego juego;

    public VistaVictoria(Juego juego){
        this.juego = juego;
    }
    @Override
    public Scene crearEscena(Hashtable data) {
        HBox contenedorPrincipal = new HBox();
        Label label = new Label();
        label.setText("El ganador es: " + juego.ganador().getNombre());
        contenedorPrincipal.getChildren().add(label);
        this.getChildren().addAll(contenedorPrincipal);
        return new Scene(this, 1280, 720);
    }
}
