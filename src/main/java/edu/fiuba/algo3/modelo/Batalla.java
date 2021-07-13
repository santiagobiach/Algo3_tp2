package edu.fiuba.algo3.modelo;

public class Batalla {

    private int cantidadDadosAtacante;
    private int cantidadDadosDefensor;

    //int cantidadDeComparaciones = Math.min(cantidadDadosAtacante, cantidadDadosDefensor);

    public void combatir(){

    }
    public Batalla(Pais unPais, Pais otroPais, int cantidad) throws ExcepcionBatallaInvalida{
        if(!unPais.esLimitrofe(otroPais))
            throw new ExcepcionBatallaInvalida("Batalla entre paises no limítrofes");

        else if(unPais.esAliado(otroPais))
            throw new ExcepcionBatallaInvalida("Ataque entre paises aliados");

        cantidadDadosAtacante = Math.min(3,cantidad);
        cantidadDadosDefensor = Math.min(3,otroPais.getCantidadDeTropas());
    }
}
