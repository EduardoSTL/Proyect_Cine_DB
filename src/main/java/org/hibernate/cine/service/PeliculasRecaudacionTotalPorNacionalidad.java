package org.hibernate.cine.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PeliculasRecaudacionTotalPorNacionalidad {
    public static double calcularRecaudacionTotal() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCine");
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT SUM(p.taquilla) FROM Pelicula p WHERE p.nacionalidad = 'España'");
            Double recaudacionTotal = (Double) query.getSingleResult();

            if (recaudacionTotal != null) {
                return recaudacionTotal;
            } else {
                System.out.println("No se encontraron películas realizadas en España.");
            }

        } catch (Exception e) {
            System.out.println("Error al calcular la recaudación total: " + e.getMessage());

        } finally {
            em.close();
            emf.close();
        }

        return 0.0;
    }
}
