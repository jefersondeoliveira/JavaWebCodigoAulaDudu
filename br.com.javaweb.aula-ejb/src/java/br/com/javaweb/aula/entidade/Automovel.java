package br.com.javaweb.aula.entidade;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Automovel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutomovel", nullable = false)
    private Integer idAutomovel;
    
    @NotNull(message = "Informe o ano")
    @Column(name = "ano", nullable = false)
    private Integer ano;
    
    @NotNull(message = "Informe o valor")
    @Column(name = "valor",nullable = true)
    private Double valor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCombustivel", nullable = false)
    private Combustivel combustivel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCor", nullable = false)
    private Cor cor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModelo", nullable = false)
    private Modelo modelo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AutomovelOpcional",
       joinColumns = @JoinColumn(name="idAutomovel"),
       inverseJoinColumns = @JoinColumn(name = "idOpcional"))
    private List<Opcional> opcionais;
    
    @NotNull(message = "Informe a quantidade de portas")
    @Column(name = "quantidadePortas", nullable = false)
    private Short quantidadePortas;

    public List<Opcional> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<Opcional> opcionais) {
        this.opcionais = opcionais;
    }

    
    public Integer getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Short getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Short quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
     
    
}
