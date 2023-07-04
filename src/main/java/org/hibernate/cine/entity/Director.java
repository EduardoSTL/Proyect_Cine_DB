package org.hibernate.cine.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodDirector")
    private Long id;

    @Column(name = "Nombre")
    @NotNull
    private String nombre;

    @Column(name = "FNacimiento")
    private Date fechaNacimiento;

    @Column(name = "LNacimiento")
    private String lugarNacimiento;

    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @Column(name = "FMuerte")
    private Date fechaMuerte;

    @Column(name = "LMuerte")
    private String lugarMuerte;

    public Director(Long id, String nombre, Date fechaNacimiento, String lugarNacimiento,
                    String nacionalidad, Date fechaMuerte, String lugarMuerte) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.fechaMuerte = fechaMuerte;
        this.lugarMuerte = lugarMuerte;
    }
}

//Backup
    /*@OneToMany
    @JoinColumn(name = "CodPelicula")
    private Pelicula pelicula;*/

    /*@OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pelicula> pelicula;*/

    /*public Director(String Nombre, Timestamp FNacimiento, String LNacimiento
            , String nacionalidad, Timestamp FMuerte, String LMuerte) {
        nombre = Nombre;
        this.fechaNacimiento = FNacimiento;
        this.lugarNacimiento = LNacimiento;
        this.nacionalidad = nacionalidad;
        this.fechaMuerte = FMuerte;
        this.lugarMuerte = LMuerte;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Fecha Nacimiento=" + fechaNacimiento +
                ", Lugar Nacimiento='" + lugarNacimiento + '\'' +
                ", Nacionalidad='" + nacionalidad + '\'' +
                ", Fecha Muerte=" + fechaMuerte +
                ", Lugar Muerte='" + lugarMuerte + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(id, director.id) && Objects.equals(Nombre, director.Nombre) && Objects.equals(FNacimiento, director.FNacimiento) && Objects.equals(LNacimiento, director.LNacimiento) && Objects.equals(Nacionalidad, director.Nacionalidad) && Objects.equals(FMuerte, director.FMuerte) && Objects.equals(LMuerte,
                director.LMuerte) && Objects.equals(pelicula, director.pelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
