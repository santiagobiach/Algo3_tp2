package edu.fiuba.algo3.modelo.vistas;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import java.util.Hashtable;

public abstract class Vista extends VBox{
    public abstract Scene crearEscena(Hashtable data);
}
