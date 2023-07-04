package org.hibernate.cine.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "premio")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPremio")
    private Long id;

    @Column(nullable = false,name = "Premio ")
    private String premio;

}
/*public Premio() {
    }

    public Premio(Long id, String Premio) {
        this.id = id;
        premio = Premio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premio premio = (Premio) o;
        return Objects.equals(id, premio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, premio);
    }

    @Override
    public String toString() {
        return "Premio{" +
                "id=" + id +
                ", Premio='" + premio + '\'' +
                '}';
    }*/
