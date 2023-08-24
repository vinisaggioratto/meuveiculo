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
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String placa;

    @ManyToOne
    private TipoVeiculo tipoVeiculo;
    @ManyToOne
    private MarcaVeiculo marcaVeiculo;

    private String modelo;
    private String renavam;
    private String cor;
    private Integer ano;

    @ManyToOne
    private Usuario usuario;

    private static List<Veiculo> veiculoList = new ArrayList<>();

    @Override
    public String toString() {
        return "\nID: " + this.getId()
                + "\nPlaca: " + this.getPlaca()
                + "\nTipo do veículo: " + this.getTipoVeiculo().getDescricao()
                + "\nMarca do veículo: " + this.getMarcaVeiculo().getMarca()
                + "\nModelo: " + this.getModelo()
                + "\nRenavam: " + this.getRenavam()
                + "\nCor: " + this.getCor()
                + "\nAno: " + this.getAno()
                + "\nUsuário: " + this.getUsuario().getNome();
    }
}
