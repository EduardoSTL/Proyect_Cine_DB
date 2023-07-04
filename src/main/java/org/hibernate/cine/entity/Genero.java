package org.hibernate.cine.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodGenero")
    @NotNull
    private Long id;

    @Column(name = "Nombre")
    @NotNull
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "CodPelicula")
    private Pelicula pelicula;

    @Override
    public String toString() {
        return "Genero{" +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
}
