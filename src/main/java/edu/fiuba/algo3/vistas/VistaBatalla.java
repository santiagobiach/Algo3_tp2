package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VistaBatalla extends VBox implements Observer {
    private Label paisAtacante;
    private Label paisDefensor;
    private Label tiradasPaisAtacante;
    private Label tiradasPaisDefensor;
    public VistaBatalla(){
        Label ultimaBatalla = new Label("Ultima Batalla:");
        paisAtacante = new Label("Atacante: ");
        paisDefensor = new Label("Defensor: ");
        tiradasPaisAtacante = new Label("Tiradas atacante: ");
        tiradasPaisDefensor = new Label("Tiradas defensor: ");

        this.getChildren().addAll(ultimaBatalla,paisAtacante, paisDefensor,tiradasPaisAtacante,tiradasPaisDefensor);
    }
    public void setLabelPaisAtacante(Pais pais){
        paisAtacante.setText("Atacante: " + pais.getNombre());
    }
    public void setLabelPaisDefensor(Pais pais){
        paisDefensor.setText("Defensor: " + pais.getNombre());
    }
    @Override
    public void update(Observable o, Object arg) {
        ArrayList<ArrayList<Integer>> tiradas = (ArrayList<ArrayList<Integer>>)arg;
        ArrayList<Integer> tiradasAtacante = tiradas.get(0);
        ArrayList<Integer> tiradasDefensor = tiradas.get(1);
        tiradasPaisAtacante.setText("Tiradas atacante: " + tiradasAtacante);
        tiradasPaisDefensor.setText("Tiradas defensor: " + tiradasDefensor);
    }
}
