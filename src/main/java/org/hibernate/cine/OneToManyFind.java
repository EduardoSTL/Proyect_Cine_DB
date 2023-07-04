package org.hibernate.cine;

import jakarta.persistence.EntityManager;
import org.hibernate.cine.entity.Pelicula;
import org.hibernate.cine.util.JpaUtil;

public class OneToManyFind {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            Pelicula pelicula = manager.find(Pelicula.class, 2L);
            manager.persist(pelicula);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
