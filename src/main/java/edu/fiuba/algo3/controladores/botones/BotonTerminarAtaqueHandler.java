package edu.fiuba.algo3.controladores.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.MenuFaseDeReagrupación;
import edu.fiuba.algo3.vistas.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.Hashtable;

public class BotonTerminarAtaqueHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Stage stage;
    public BotonTerminarAtaqueHandler(Juego juego, Stage stage){
        this.juego = juego;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Hashtable data = new Hashtable();
        data.put("menu", new MenuFaseDeReagrupación(juego, stage));
        stage.setScene(new VistaJuego(juego).crearEscena(data));
    }
}
