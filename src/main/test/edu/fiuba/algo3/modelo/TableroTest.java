package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void ningunPaisQuedaSinControlarTrasDistribuirlos() throws Exception{
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Mario", "000000"));
        jugadores.add(new Jugador("Pedro", "000000"));
        jugadores.add(new Jugador("Jose", "000000"));
        jugadores.add(new Jugador("Maria", "000000"));
        Tablero tablero =  new Tablero();
        tablero.distribuirPaises(jugadores);

        boolean sinConquistar = false;
        for(Pais p: tablero.getPaises())
            if(p.getJugador() == null)
                sinConquistar = true;

        assertFalse(sinConquistar);
    }


}
