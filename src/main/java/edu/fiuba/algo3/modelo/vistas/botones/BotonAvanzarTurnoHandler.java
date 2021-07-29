package edu.fiuba.algo3.modelo.vistas.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeAtaque;
import edu.fiuba.algo3.modelo.vistas.MenuFaseDeReagrupación;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAvanzarTurnoHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private MenuFaseDeReagrupación menu;
    public BotonAvanzarTurnoHandler(Juego juego, MenuFaseDeReagrupación menu){
        this.juego = juego;
        this.menu = menu;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("AAA");
        juego.proximoTurno();
        menu.actualizar();
    }
}
