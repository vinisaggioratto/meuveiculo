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
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private TipoDespesa tipoDespesa;

    private String descricao;
    private Date data_despesa;
    private Double valor;
    private String observacoes;

    private static List<Despesa> despesaList = new ArrayList<>();

    @Override
    public String toString() {
        return 
                "\nID: " + this.getId()
                + "\nTipo da despesa: " + this.getTipoDespesa().getDescricao()
                + "\nDescrição: " + this.getDescricao()
                + "\nData da despesa: " + this.getData_despesa()
                + "\nValor: " + this.getValor()
                + "\nObservações: " + this.getObservacoes();
    }

}
