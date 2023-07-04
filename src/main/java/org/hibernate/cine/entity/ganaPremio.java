package org.hibernate.cine.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@IdClass(GanaPremioId.class)
@Table(name = "ganaPremio")
public class ganaPremio {

    @Id
    @ManyToOne
    @JoinColumn(name = "CodPelicula")
    private Pelicula pelicula;

    @Id
    @ManyToOne
    @JoinColumn (name = "CodPremio")
    private Premio premio;

    @Column(name = "Anyo")
    @NotNull
    private Integer year;

    public ganaPremio(Pelicula pelicula, Premio premio, @NonNull Integer year) {
        this.pelicula = pelicula;
        this.premio = premio;
        this.year = year;
    }
}
