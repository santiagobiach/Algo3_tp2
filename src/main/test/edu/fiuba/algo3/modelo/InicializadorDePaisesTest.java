package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InicializadorDePaisesTest {

    @Test
    public void NoSePuedeLeerUnArchivoQueNoExiste(){


        assertThrows(Exception.class, () ->
        {InicializadorDePaises.inicializarPaisesDesdeArchivo("NOEXISTE");});
    }

    @Test
    public void PuedeLeerCorrectamenteUnArchivoQueExiste(){


        assertDoesNotThrow(() -> {InicializadorDePaises.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");});

    }

    @Test
    public void LeeLaCantidadCorrectaDePaises() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<Pais> paises;
        paises = InicializadorDePaises.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");
        assertEquals(50,paises.size());

    }

    @Test
    public void DosPaisesLeidosDesdeArchivoSonLimitrofes() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<Pais> paises;
        paises = InicializadorDePaises.inicializarPaisesDesdeArchivo("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");
        Pais islandia = paises.get(48);
        Pais inglaterra = paises.get(1);
        assertTrue(islandia.esLimitrofeCon(inglaterra));
        assertTrue(inglaterra.esLimitrofeCon(islandia));

    }
}
