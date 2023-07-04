package org.hibernate.cine;


import static org.hibernate.cine.service.InsertarActorReparto.insertarActorEnReparto;

public class InsertarActorReparto {
    public static void main(String[] args) {
            long idPelicula = 7;
            long idActor = 8;

            insertarActorEnReparto(idPelicula, idActor);
    }
}
