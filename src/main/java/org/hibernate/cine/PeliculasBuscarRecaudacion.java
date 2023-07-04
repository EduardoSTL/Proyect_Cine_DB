package org.hibernate.cine;

import jakarta.persistence.EntityManager;
import org.hibernate.cine.util.JpaUtil;

import static org.hibernate.cine.service.PeliculasRecaudacionTotalPorNacionalidad.calcularRecaudacionTotal;

public class PeliculasBuscarRecaudacion {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            double recaudacionTotal = calcularRecaudacionTotal();
            System.out.println("La recaudación total de las películas realizadas en España es: " + recaudacionTotal);
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
