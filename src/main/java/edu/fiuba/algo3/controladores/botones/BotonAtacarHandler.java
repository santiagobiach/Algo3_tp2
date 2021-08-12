package edu.fiuba.algo3.controladores.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.vistas.MenuFaseDeAtaque;
import edu.fiuba.algo3.vistas.VistaBatalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private ComboBox<String> cbxAtacante;
    private ComboBox<String> cbxDefensor;
    private MenuFaseDeAtaque menu;
    private Spinner tropas;
    private VistaBatalla vistaBatalla;

    public BotonAtacarHandler(Juego juego, ComboBox<String> cbxAtacante, ComboBox<String> cbxDefensor,
                              Spinner tropas, MenuFaseDeAtaque menu, VistaBatalla vistaBatalla){
        this.juego = juego;
        this.cbxAtacante = cbxAtacante;
        this.cbxDefensor = cbxDefensor;
        this.menu = menu;
        this.tropas = tropas;
        this.vistaBatalla = vistaBatalla;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(cbxAtacante.getSelectionModel().getSelectedItem() == null ||
                cbxDefensor.getSelectionModel().getSelectedItem() == null){
            System.out.println("Debe seleccionar un pais atacante y uno defensor");
        }else{
            Pais atacante = juego.getTablero().getPais(cbxAtacante.getSelectionModel().getSelectedItem());
            Pais defensor = juego.getTablero().getPais(cbxDefensor.getSelectionModel().getSelectedItem());
            vistaBatalla.setLabelPaisAtacante(atacante);
            vistaBatalla.setLabelPaisDefensor(defensor);
            juego.crearBatalla(atacante, defensor, (int)tropas.getValue(), vistaBatalla);
            menu.actualizar();
            ControladorJuego.chequearVictoria();
        }

    }
}
