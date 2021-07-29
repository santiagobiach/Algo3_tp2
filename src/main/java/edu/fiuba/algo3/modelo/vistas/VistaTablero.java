package edu.fiuba.algo3.modelo.vistas;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Hashtable;

public class VistaTablero extends Vista{
    @Override
    public Scene crearEscena(Hashtable data) {

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/tableroteg.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);
        return new Scene(this, 740, 580);
    }
}
