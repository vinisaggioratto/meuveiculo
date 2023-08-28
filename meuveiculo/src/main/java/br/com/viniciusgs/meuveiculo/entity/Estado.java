/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="estado")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;
    
    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais pais;
    
    private static List<Estado> estadoList = new ArrayList<>();
    
    @Override
    public String toString(){
        return
                "\nID: " + this.getId() +
                "\nEstado: " + this.getNome() +
                "\nPaís: " + this.getPais().getNome();
    }
}
