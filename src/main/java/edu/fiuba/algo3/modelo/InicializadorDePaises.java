package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

public class InicializadorDePaises {
    public InicializadorDePaises(){}


    public static ArrayList<Pais>  inicializarPaisesDesdeArchivo(String path) throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> listaDePaises = parser.readFromFile(path);
        ArrayList<Pais> paises = new ArrayList<>();
        Hashtable<String, String> NombrePaisYLimitrofes = new Hashtable<String, String>();

        for(String[] pais: listaDePaises){
            Pais nuevoPais = new Pais(pais[0], new Continente(pais[1]));
            NombrePaisYLimitrofes.put(pais[0], pais[2]);
            paises.add(nuevoPais);
        }

        for(Pais pais: paises){

            String[] limitrofes = (NombrePaisYLimitrofes.get(pais.getNombre())).split(",");

            for(String limitrofe:limitrofes){

                pais.agregarPaisLimitrofe(buscarPais(paises, limitrofe));
            }

        }

        return paises;
    }
    private static Pais buscarPais(ArrayList<Pais> paises, String nombrePais){
        for(Pais pais: paises){
            if(pais.getNombre().equals(nombrePais))
                return pais;
        }
        return null;
    }
}
