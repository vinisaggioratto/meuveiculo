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
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cpf_cnpj;

    @ManyToOne
    private TipoFornecedor tipoFornecedor;
    
    private String telefone_fixo;
    private String telefone_celular;
    private String endereco;
    private Integer cep;

    @ManyToOne
    private Estado estado;
    
    @ManyToOne
    private Pais pais;

    private String contato;

    private static List<Fornecedor> fornecedorList = new ArrayList<>();

    @Override
    public String toString() {
        return "\nID: " + this.getId()
                + "\nNome: " + this.getNome()
                + "\nCpf/Cnpj: " + this.getCpf_cnpj()
                + "\nTipo fornecedor: " + this.getTipoFornecedor().getDescricao()
                + "\nTelefone fixo: " + this.getTelefone_fixo()
                + "\nTelefone celular: " + this.getTelefone_celular()
                + "\nEndereço: " + this.getEndereco()
                + "\nCep: " + this.getCep()
                + "\nEstado: " + this.getEstado().getNome()
                + "\nPaís: " + this.getPais().getNome()
                + "\nContato: " + this.getContato();
    }
}
