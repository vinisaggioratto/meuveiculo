package br.com.viniciusgs.meuveiculo.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author FROTA01-PC
 */
public class PersistenciaJPA {

    //CenaflixPodcast
    private static final String PERSISTENCE_UNIT = "veiculo-PU";

    public static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;

    }

    public static void closeEntityManager() {
        if (entityManager.isOpen() && entityManager != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
