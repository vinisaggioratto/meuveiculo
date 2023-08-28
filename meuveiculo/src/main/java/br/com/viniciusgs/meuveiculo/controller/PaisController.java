/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.controller;

import br.com.viniciusgs.meuveiculo.entity.Pais;
import br.com.viniciusgs.meuveiculo.persistence.PersistenciaJPA;
import static br.com.viniciusgs.meuveiculo.persistence.PersistenciaJPA.entityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class PaisController {

    public void cadastrar(Pais pais) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pais);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "País cadastrado com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o novo"
                    + " país.");
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public void atualizar(Pais pais) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pais);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "País atualizado com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o"
                    + " país.");
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public void excluir(int id) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            Pais pais = em.find(Pais.class, id);
            if (pais != null) {
                em.getTransaction().begin();
                em.remove(pais);
                em.getTransaction().commit();
            }
            JOptionPane.showMessageDialog(null, "País excluído com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao excluir país.");
            throw e;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public List<Pais> listarPais() {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT pais FROM Pais pais");
            List<Pais> pais = consulta.getResultList();
            return pais;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public List<Pais> listar(String filtroDescricao) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        List pais = null;
        try {

            String textoQuery = "SELECT nomePais FROM Pais nomePais "
                    + " WHERE (:nome is null OR nomePais.nome LIKE :nome )";
            Query consulta = em.createQuery(textoQuery);
            consulta.setParameter(
                    "nome", filtroDescricao.isEmpty() ? null : "%" + filtroDescricao + "%");
            pais = consulta.getResultList();
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
        return pais;
    }

    public Pais retornarIdPais(String nome) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT p FROM Pais p WHERE p.nome = :nome");
            consulta.setParameter("nome", nome);
            Pais pais = (Pais) consulta.getSingleResult();
            
            System.out.println("País retornado no método: " + pais);
            return pais;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }    
//    public Pais buscarPaisPorNome(String nome) {
//        TypedQuery<Pais> query = entityManager.createQuery(
//                "SELECT p FROM Pais p WHERE p.nome = :nome", Pais.class);
//        query.setParameter("nome", nome);
//        System.out.println("Pais: ");
//        
//        return query.getSingleResult();
//    }
}
