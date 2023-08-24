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
@Table(name = "abastecimento")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private TipoCombustivel tipoCombustivel;

    private Date data_abastecimento;
    private Double odometro_anterior;
    private Double odometro_atual;
    private Double valor_unitario;
    private Double quantidade;
    private Double valor_total;
    private Double media;
    private String observacoes;

    private static List<Abastecimento> abastecimentoList = new ArrayList<>();

    @Override
    public String toString() {
        return 
                "\nID: " + this.getId()
                + "\nVeículo: " + this.getVeiculo().getPlaca()
               // + "\nFornecedor: " + this.getFornecedor().getNome()
                + "\nTipo do combustível: " + this.getTipoCombustivel().getDescricao()
                + "\nData de abastecimento: " + this.getData_abastecimento()
                + "\nOdômetro anterior: " + this.getOdometro_anterior()
                + "\nOdômetro atual: " + this.getOdometro_atual()
                + "\nValor unitário combustível: " + this.getValor_unitario()
                + "\nQuantidade: " + this.getQuantidade()
                + "\nValor total: " + this.getValor_total()
                + "\nMédia: " + this.getMedia()
                + "\nObservações: " + this.getObservacoes();
    }
}
