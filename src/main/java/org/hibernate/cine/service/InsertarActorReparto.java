package org.hibernate.cine.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.cine.entity.Actor;
import org.hibernate.cine.entity.Pelicula;

public class InsertarActorReparto {
    public static void insertarActorEnReparto(long idPelicula, long idActor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCine");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Pelicula pelicula = em.find(Pelicula.class, idPelicula);
            Actor actor = em.find(Actor.class, idActor);

            if (pelicula != null && actor != null) {
                pelicula.getActores().add(actor);
                em.persist(pelicula);
                tx.commit();
                System.out.println("Actor insertado en el reparto de la película.");
            } else {
                System.out.println("No se encontró la película o el actor.");
            }

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error al insertar el actor en el reparto: " + e.getMessage());

        } finally {
            em.close();
            emf.close();
        }
    }
}
