package edu.fiuba.algo3.modelo.vistas;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class Menu extends VBox {
    protected Label titulo = new Label();
    public abstract void actualizar();

    public abstract ComboBox<String> getComboBox();
}
