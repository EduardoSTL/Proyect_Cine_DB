package org.hibernate.cine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.cine.entity.Actor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reparto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoCine");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crea un nuevo objeto Actor
            Actor actor = new Actor();
            actor.setNombre("Eduardo Melgar");
            actor.setNacionalidad("El Salvador");
            actor.setLugarNacimiento("San Salvador");
            actor.setFechaNacimiento("2004-03-01");
            actor.setLugarMuerte(null);
            actor.setFechaMuerte(null);
            em.persist(actor);
            em.getTransaction().commit();
            System.out.println("Nuevo actor agregado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al agregar el actor: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }


        /*try {
            em.getTransaction().begin();

            // Crea un nuevo objeto Actor
            Actor actor = new Actor();
            actor.setNombre("Paul Danno");
            actor.setNacionalidad("Inglaterra");
            actor.setLugarNacimiento("Manchester");
            actor.setFechaNacimiento("1998-05-09");
            actor.setLugarMuerte(null);
            actor.setFechaMuerte(null);
            em.persist(actor);
            em.getTransaction().commit();
            System.out.println("Nuevo actor agregado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al agregar el actor: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }*/
    }
}
