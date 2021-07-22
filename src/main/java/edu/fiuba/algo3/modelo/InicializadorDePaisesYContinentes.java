package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class InicializadorDePaisesYContinentes {
    public InicializadorDePaisesYContinentes(){}

    public static ArrayList<Continente> InicializarContinentes(){
        ArrayList<Continente> continentes = new ArrayList<Continente>();
        continentes.add(new Continente("Europa"));
        continentes.add(new Continente("Asia"));
        continentes.add(new Continente("Africa"));
        continentes.add(new Continente("America del Norte"));
        continentes.add(new Continente("America del Sur"));
        continentes.add(new Continente("Oceania"));
        return continentes;
    }

    public static ArrayList<TarjetaDePais> inicializarCartasDesdeArchivo(String path, ArrayList<Pais> paises)throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> listaDeTarjetas = parser.readFromFile(path);
        ArrayList<TarjetaDePais> tarjetas = new ArrayList<>();

        for(String[] tarjeta: listaDeTarjetas){
            TarjetaDePais nuevaTarjeta = new TarjetaDePais(buscarPais(paises, tarjeta[0]), tarjeta[1]);
            tarjetas.add(nuevaTarjeta);
        }
        return tarjetas;
    }

    public static ArrayList<Pais>  inicializarPaisesDesdeArchivo(String path, ArrayList<Continente> continentes) throws Exception{
        CSVParser parser = new CSVParser();
        ArrayList<String[]> listaDePaises = parser.readFromFile(path);
        ArrayList<Pais> paises = new ArrayList<>();
        Hashtable<String, String> NombrePaisYLimitrofes = new Hashtable<String, String>();

        for(String[] pais: listaDePaises){
            Pais nuevoPais = new Pais(pais[0], buscarContinente(continentes, pais[1]));
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
    private static Continente buscarContinente(ArrayList<Continente> continentes, String nombreContinente){
        for(Continente continente: continentes){
            if(continente.getNombre().equals(nombreContinente))
                return continente;
        }
        return null;
    }
}
