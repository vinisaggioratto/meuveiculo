/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.controller;

import br.com.viniciusgs.meuveiculo.entity.Estado;
import br.com.viniciusgs.meuveiculo.entity.Pais;
import br.com.viniciusgs.meuveiculo.persistence.PersistenciaJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class EstadoController {
    
    public void cadastrar(Estado estado) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o novo"
                    + " estado.");
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public void atualizar(Estado estado) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(estado);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Estado atualizado com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o"
                    + " estado.");
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public void excluir(int id) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            Estado estado = em.find(Estado.class, id);
            if (estado != null) {
                em.getTransaction().begin();
                em.remove(estado);
                em.getTransaction().commit();
            }
            JOptionPane.showMessageDialog(null, "Estado excluído com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao excluir estado.");
            throw e;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }

    public List<Estado> listarEstado() {
        EntityManager em = PersistenciaJPA.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT estado FROM Estado estado");
            List<Estado> estado = consulta.getResultList();
            return estado;
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
    }
    
//        public List<Pais> retornarIdPais(String estadoNome) {
//        EntityManager em = PersistenciaJPA.getEntityManager();
//        try {
//            Pais p = new Pais();
//            Query consulta = em.createQuery("select p.id from Estado e "
//                    + "inner join e.pais p where e.nome = '"+estadoNome+"'");
//            
//            List<Pais> paisList = consulta.getResultList();
//            System.out.println("Conteudo da pesquisa: " + paisList);
//            return paisList;
//        } finally {
//            PersistenciaJPA.closeEntityManager();
//        }
//
//    }

    public List<Estado> listar(String filtroDescricao) {
        EntityManager em = PersistenciaJPA.getEntityManager();
        List estado = null;
        try {

//            String textoQuery = "SELECT nomePais FROM Pais nomePais "
//                    + " WHERE (:nome is null OR nomePais.nome LIKE :nome )";
//            Query consulta = em.createQuery(textoQuery);
//            consulta.setParameter(
//                    "nome", filtroDescricao.isEmpty() ? null : "%" + filtroDescricao + "%");
//            estado = consulta.getResultList();
        } finally {
            PersistenciaJPA.closeEntityManager();
        }
        return estado;
    }    
}
