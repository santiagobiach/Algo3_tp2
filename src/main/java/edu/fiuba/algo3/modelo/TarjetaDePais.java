package edu.fiuba.algo3.modelo;

public class TarjetaDePais {
    private Pais pais;
    private String simbolo;
    public TarjetaDePais(Pais pais, String simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
    }
    public Pais pais(){
        return this.pais;
    }
    public String simbolo(){
        return this.simbolo;
    }
}
