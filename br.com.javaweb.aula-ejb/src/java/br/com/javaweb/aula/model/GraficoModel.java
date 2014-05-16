package br.com.javaweb.aula.model;

public class GraficoModel {

    private String nomeMarca;
    private int quantidadeModelos;

    public GraficoModel(String nomeMarca, int quantidadeModelos) {
        this.nomeMarca = nomeMarca;
        this.quantidadeModelos = quantidadeModelos;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public int getQuantidadeModelos() {
        return quantidadeModelos;
    }

    public void setQuantidadeModelos(int quantidadeModelos) {
        this.quantidadeModelos = quantidadeModelos;
    }

}
