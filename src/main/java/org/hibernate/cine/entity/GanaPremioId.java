package org.hibernate.cine.entity;

import org.hibernate.cine.entity.Pelicula;
import org.hibernate.cine.entity.Premio;
import java.io.Serializable;

public class GanaPremioId implements Serializable {
    private Pelicula pelicula;
    private Premio premio;
}