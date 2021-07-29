package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.inicializadores.CSVParser;
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

        assertDoesNotThrow(() -> {parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");});

    }
    @Test
    public void LeeLaCantidadCorrectaDePaises() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> paises = new ArrayList<>();
        paises = parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");
        assertEquals(50,paises.size());

    }

    @Test
    public void LaCantidadDeCamposEsCorrecta() throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> paises = new ArrayList<>();
        paises = parser.readFromFile("src/main/java/edu/fiuba/algo3/archivoscsv/Teg - Fronteras.csv");
        String[] pais = paises.get(0);
        //Nombre de pais, Continente, Paises Limitrofes(Notese que paises limitrofes es un String de paises
        //separados por comas. Para separarlos habria que parsear, se podria hacer con string.split(",")
        assertEquals(3, pais.length);

    }
}
