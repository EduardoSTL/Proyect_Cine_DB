package org.hibernate.cine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.cine.entity.Pelicula;
import org.hibernate.cine.util.JpaUtil;

import java.util.List;

import static org.hibernate.cine.service.DistribuidoraService.buscarDistribuidoraPelicula;

public class BusquedaDistribuidora {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();
        try {
            long idPelicula = 6;

            String distribuidora = buscarDistribuidoraPelicula(idPelicula);
            if (distribuidora != null) {
                System.out.println("La distribuidora de la película es: " + distribuidora);
            }
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
