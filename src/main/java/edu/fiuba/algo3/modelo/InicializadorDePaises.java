package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class InicializadorDePaises {
    public InicializadorDePaises(){}


    public ArrayList<Pais>  inicializarPaisesDesdeArchivo(String path) throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> listaDePaises = parser.readFromFile(path);
        ArrayList<Pais> paises = new ArrayList<>();
        for(String[] pais: listaDePaises){
            Pais nuevoPais = new Pais(pais[0], new Continente(pais[1]));

            paises.add(nuevoPais);
        }


        return paises;
    }
}
