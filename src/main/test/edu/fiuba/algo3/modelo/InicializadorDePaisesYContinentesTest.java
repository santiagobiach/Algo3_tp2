package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InicializadorDePaisesYContinentesTest {

    @Test
    public void NoSePuedeLeerUnArchivoQueNoExiste(){

        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        assertThrows(Exception.class, () ->
        {
            InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("NOEXISTE", continentes);});
    }

    @Test
    public void PuedeLeerCorrectamenteUnArchivoQueExiste(){

        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        assertDoesNotThrow(() -> {
            InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv", continentes);});

    }

    @Test
    public void LeeLaCantidadCorrectaDePaises() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        ArrayList<Pais> paises;
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv", continentes);
        assertEquals(50,paises.size());

    }

    @Test
    public void DosPaisesLeidosDesdeArchivoSonLimitrofes() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        ArrayList<Pais> paises;
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv", continentes);
        Pais islandia = paises.get(48);
        Pais inglaterra = paises.get(1);
        assertTrue(islandia.esLimitrofeCon(inglaterra));
        assertTrue(inglaterra.esLimitrofeCon(islandia));

    }

    @Test
    public void LaCantidadDeContinentesEsLaCorrecta() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        assertEquals(continentes.size(), 6);

    }
    @Test
    public void LosContinentesTienenNombresCorrectos() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        assertEquals("Europa", continentes.get(0).getNombre());
        assertEquals("Asia", continentes.get(1).getNombre());
        assertEquals("Africa", continentes.get(2).getNombre());
        assertEquals("America del Norte", continentes.get(3).getNombre());
        assertEquals("America del Sur", continentes.get(4).getNombre());
        assertEquals("Oceania", continentes.get(5).getNombre());

    }

    @Test
    public void LaCantidadDeTarjetasEsLaCorrecta() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        ArrayList<Pais> paises;
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv", continentes);
        ArrayList<TarjetaDePais> tarjetas = InicializadorDePaisesYContinentes.inicializarCartasDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv", paises);
        assertEquals(50,tarjetas.size());

    }
    @Test
    public void LaTarjetaTieneElNombreCorrecto() throws Exception{
        ArrayList<Continente> continentes= InicializadorDePaisesYContinentes.InicializarContinentes();
        ArrayList<Pais> paises;
        paises = InicializadorDePaisesYContinentes.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv", continentes);
        ArrayList<TarjetaDePais> tarjetas = InicializadorDePaisesYContinentes.inicializarCartasDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv", paises);
        assertEquals("Francia",tarjetas.get(0).pais().getNombre());

    }
}
