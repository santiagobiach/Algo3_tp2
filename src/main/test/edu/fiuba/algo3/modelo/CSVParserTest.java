package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CSVParserTest {
    @Test
    public void NoSePuedeLeerUnArchivoQueNoExiste(){
       CSVParser parser = new CSVParser();

        assertThrows(Exception.class, () ->
        {parser.readFromFile("NOEXISTE");});
    }
    @Test
    public void PuedeLeerCorrectamenteUnArchivoQueExiste() throws Exception{
        CSVParser parser = new CSVParser();

        assertDoesNotThrow(() -> {parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv");});

    }
    @Test
    public void LeeLaCantidadCorrectaDePaises() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> paises = new ArrayList<>();
        paises = parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv");
        assertEquals(50,paises.size());

    }

    @Test
    public void LaCantidadDeCamposEsCorrecta() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> paises = new ArrayList<>();
        paises = parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Cartas.csv");
        String[] pais = paises.get(0);
        //Nombre de pais, tipo de carta
        assertEquals(2, pais.length);

    }
}
