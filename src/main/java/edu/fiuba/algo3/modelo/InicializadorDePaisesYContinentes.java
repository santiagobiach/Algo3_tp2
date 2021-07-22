package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class InicializadorDePaisesYContinentes {
    public InicializadorDePaisesYContinentes(){}

    public static ArrayList<Continente> InicializarContinentes(){
        ArrayList<Continente> continentes = new ArrayList<Continente>();
        Continente europa = new Continente("Europa");
        Continente africa = new Continente("Africa");
        Continente asia = new Continente("Asia");
        Continente americaDelNorte = new Continente("America del Norte");
        Continente americaDelSur = new Continente("America del Sur");
        Continente oceania = new Continente("Oceania");

        europa.setBonusPorConquista(5);
        africa.setBonusPorConquista(3);
        asia.setBonusPorConquista(7);
        americaDelNorte.setBonusPorConquista(5);
        americaDelSur.setBonusPorConquista(3);
        oceania.setBonusPorConquista(2);

        continentes.add(europa);
        continentes.add(africa);
        continentes.add(asia);
        continentes.add(americaDelNorte);
        continentes.add(americaDelSur);
        continentes.add(oceania);

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

