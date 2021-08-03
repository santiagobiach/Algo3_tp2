package edu.fiuba.algo3.modelo.vistas;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public abstract class Menu extends VBox {
    public abstract void actualizar();

    public abstract ComboBox<String> getComboBox();
}
