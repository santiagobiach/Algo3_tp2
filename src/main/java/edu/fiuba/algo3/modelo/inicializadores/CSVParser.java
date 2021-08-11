package edu.fiuba.algo3.modelo.inicializadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private final char DEFAULT_SEPARATOR = ',';
    private final char DOUBLE_QUOTES = '"';
    private final char DEFAULT_QUOTE_CHAR = DOUBLE_QUOTES;
    private final String NEW_LINE = "\n";

    public ArrayList<String[]> readFromFile(String path) throws Exception {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        //Me salteo la primera linea
        String row = csvReader.readLine();
        ArrayList<String[]> lineasParseadas = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {


            String[] data = parseLine(row,DEFAULT_SEPARATOR);
            lineasParseadas.add(data);
        }
        csvReader.close();
        return lineasParseadas;
    }

    private String[] parseLine(String line, char separator){
        return parse(line, separator, DEFAULT_QUOTE_CHAR).toArray(String[]::new);

    }
    private  List<String> parse(String line, char separator, char quoteChar) {

        List<String> result = new ArrayList<>();

        boolean inQuotes = false;


        StringBuilder field = new StringBuilder();// Va a ser el string qu

        for (char c : line.toCharArray()) { //Convierte a la linea en un array de chars e itera sobre eso
            if (c == quoteChar) { //Si encuentra una comilla (")
                inQuotes = !inQuotes;
            } else {
                if (c == separator && !inQuotes) {  //Si encuentra una coma(,) y no esta entre comillas lo agrega
                    result.add(field.toString());
                    field.setLength(0);             // Vacia field para que este preparado para el proximo campo
                } else {
                    field.append(c);                // Si no, agrega el char a field.
                }
            }

        }
        result.add(field.toString());           // Deja de iterar, y agrega el ultimo field al resultado.


        return result;

    }

}

