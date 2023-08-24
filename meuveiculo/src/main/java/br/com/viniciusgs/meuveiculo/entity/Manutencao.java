/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author FROTA01-PC
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private TipoManutencao tipoManutencao;
    private String descricao;
    private Date data_manutencao;
    private Integer nota_fiscal;
    private Double valor;

    private static List<Manutencao> manutencaoList = new ArrayList<>();

    @Override
    public String toString() {
        return 
                "\nID: " + this.getId()
                + "\nVeículo: " + this.getVeiculo().getPlaca()
                //+ "\nFornecedor: " + this.getFornecedor().getNome()
                + "\nTipo manutenção: " + this.getTipoManutencao().getDescricao()
                + "\nDescrição: " + this.getDescricao()
                + "\nData da manutenção: " + this.getData_manutencao()
                + "\nNota fiscal: " + this.getNota_fiscal()
                + "\nValor: " + this.getValor();
    }

}
