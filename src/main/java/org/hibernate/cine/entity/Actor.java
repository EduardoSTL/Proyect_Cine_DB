package org.hibernate.cine.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Data
@Builder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodActor")
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

    private Date convertirFecha(LocalDateTime fecha) {
        if (fecha != null) {
            return (Date) Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
        }
        return null;
    }

    public Actor(Long id, String nombre, Date fechaNacimiento, String lugarNacimiento, String nacionalidad,
                 Date fechaMuerte, String lugarMuerte) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.fechaMuerte = fechaMuerte;
        this.lugarMuerte = lugarMuerte;
    }

    public void setFechaMuerte(LocalDateTime localDateTime) {
        this.fechaMuerte = fechaMuerte;
    }

    public void setFechaNacimiento(LocalDateTime localDateTime) {
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public String toString() {
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd,MM,yyyy");
        return "id: "+id+
                ", nombre: " + nombre+
                ", fechaNacimiento: " + fechaNacimiento +
                ", lugarNacimiento: " + lugarNacimiento +
                ", nacionalidad: " + nacionalidad +
                ", fechaMuerte: " + fechaMuerte +
                ", lugarMuerte: " + lugarMuerte;
    }

    public void setFechaNacimiento(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fechaNacimiento = Date.valueOf(LocalDate.parse(fechaStr, formatter));
    }
}

//Backup
    /*public Actor(String Nombre, Date FNacimiento, String LNacimiento,
                 String Nacionalidad, Date FMuerte, String LMuerte) {
        this.nombre = Nombre;
        this.fechaNacimiento = FNacimiento;
        this.lugarNacimiento = LNacimiento;
        this.nacionalidad = Nacionalidad;
        this.fechaMuerte = FMuerte;
        this.lugarMuerte = LMuerte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Fecha Nacimiento=" + fechaNacimiento +
                ", Lugar Nacimiento='" + lugarNacimiento + '\'' +
                ", Nacionalidad='" + nacionalidad + '\'' +
                ", Fecha Muerte=" + fechaMuerte +
                ", Lugar Muerte='" + lugarMuerte + '\'' +
                '}';
    }*/
