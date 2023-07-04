package org.hibernate.cine.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPelicula")
    private Long id;

    @Column(name = "Titulo")
    @NotNull
    private String titulo;

    @Column(name = "Anyo")
    @NotNull
    private String year;

    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @Column(name = "Duracion")
    private Float duracion;

    @Column(name = "FechaEstreno")
    private Date fechaEstreno;

    @Column(name = "Taquilla")
    private Double taquilla;

    @Column(name = "Productora")
    private String productora;

    @Column(name = "Distribuidora")
    private String distribuidora;

    @OneToOne
    @JoinColumn(name = "Genero")
    private Genero genero;

    @OneToOne
    @JoinColumn(name = "Director")
    private  Director director;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinTable(name="participa"
            ,joinColumns = @JoinColumn(name = "CodPelicula")
            ,inverseJoinColumns = @JoinColumn(name = "CodActor")
            ,uniqueConstraints = @UniqueConstraint(
            columnNames = {"CodActor"}
    ))
    private List<Actor> actores = new ArrayList<>();
}
//Backup
    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "participa", joinColumns = @JoinColumn(name = "CodPelicula")
            , inverseJoinColumns = @JoinColumn(name = "CodActor")
            , uniqueConstraints = @UniqueConstraint(columnNames = {"CodActor"}))
    private List<Pelicula> peliculas;*/

//@ManyToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "peliculas")
    /*@ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "CodDirector", nullable = false)
    private List<Director> directores;*/

//@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pelicula")
//private Genero genero;
    /*@ManyToMany
    @JoinTable(
            name = "pelicula_genero",
            joinColumns = @JoinColumn(name = "CodPelicula"),
            inverseJoinColumns = @JoinColumn(name = "CodGenero")
    )
    private List<Genero> genero = new ArrayList<>();*/

    /*OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Genero> genero;

    @ManyToOne
    private Director director;*/


    /*public Pelicula() {
        //directores = new ArrayList<>();
        this.genero = new ArrayList<>();
    }

    public Pelicula(String Titulo, String Year) {
        this();
        titulo = Titulo;
        year = Year;
    }

    public Pelicula(Long id, String Titulo, String Year, String Nacionalidad,
                    Float Duracion, Date FechaEstreno, Double Taquilla, String Productora, String Distribuidora) {
        this.id = id;
        titulo = Titulo;
        year = Year;
        nacionalidad = Nacionalidad;
        duracion = Duracion;
        fechaEstreno = FechaEstreno;
        taquilla = Taquilla;
        productora = Productora;
        distribuidora = Distribuidora;
    }*/

    /*public void addGenero(Genero genero) {
        this.genero = (List<Genero>) genero;
        genero.setPelicula(this);
    }*/

    /*public void addGenero(String generoNombre) {
        if (genero == null) {
            genero = new ArrayList<>();
        }

        Genero generos = new Genero(generoNombre);
        genero.add(generos);
    }*/

    /*public void addGenero(Genero generos) {
        genero.add(generos);
        generos.setPelicula(this);
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id) && Objects.equals(Titulo, pelicula.Titulo) && Objects.equals(Anyo, pelicula.Anyo) && Objects.equals(Nacionalidad, pelicula.Nacionalidad) && Objects.equals(Duracion, pelicula.Duracion) && Objects.equals(FechaEstreno, pelicula.FechaEstreno) && Objects.equals(Taquilla, pelicula.Taquilla) && Objects.equals(Productora, pelicula.Productora) && Objects.equals(Distribuidora, pelicula.Distribuidora) && Objects.equals(genero, pelicula.genero) && Objects.equals(director, pelicula.director);
    }*/
