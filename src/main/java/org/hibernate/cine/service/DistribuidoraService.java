package org.hibernate.cine.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cine.entity.Pelicula;

public class DistribuidoraService {
    public static String buscarDistribuidoraPelicula(long idPelicula) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCine");
        EntityManager em = emf.createEntityManager();

        try {
            Pelicula pelicula = em.find(Pelicula.class, idPelicula);

            if (pelicula != null) {
                return pelicula.getDistribuidora();
            } else {
                System.out.println("No se encontró la película.");
            }

        } catch (Exception e) {
            System.out.println("Error al buscar la distribuidora de la película: " + e.getMessage());

        } finally {
            em.close();
            emf.close();
        }

        return null;
    }
}
