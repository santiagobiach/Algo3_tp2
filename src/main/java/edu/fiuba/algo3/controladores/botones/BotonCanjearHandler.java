package edu.fiuba.algo3.controladores.botones;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.vistas.MenuFaseDeColocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BotonCanjearHandler implements EventHandler<ActionEvent> {
    private ListView<TarjetaDePais> cartas;
    private Juego juego;
    private MenuFaseDeColocacion menu;
    public BotonCanjearHandler(Juego juego, ListView cartas, MenuFaseDeColocacion menu){
        this.juego = juego;
        this.cartas = cartas;
        this.menu = menu;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<TarjetaDePais> tarjetas = new ArrayList<>();
        for(TarjetaDePais tp: cartas.getSelectionModel().getSelectedItems()){
            tarjetas.add(tp);
        }
        if(tarjetas.size() == 1){
            juego.getJugadorActual().activarTarjeta(tarjetas.get(0));
        }else if(tarjetas.size() == 3){
            juego.getJugadorActual().canjearTarjetas(tarjetas.get(0),tarjetas.get(1),tarjetas.get(2));
        }
        menu.actualizar();
    }
}
