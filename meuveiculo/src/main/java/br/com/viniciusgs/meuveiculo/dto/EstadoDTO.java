/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.dto;

import br.com.viniciusgs.meuveiculo.entity.Estado;
import br.com.viniciusgs.meuveiculo.entity.Pais;
import br.com.viniciusgs.meuveiculo.persistence.PersistenciaJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author FROTA01-PC
 */
public class EstadoDTO {

    public List<Estado> getAll() {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT estado FROM Estado estado");
            List<Estado> estado_List = consulta.getResultList();
            return estado_List;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }    
}
