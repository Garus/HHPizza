package fi.haagahelia.pizza.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "juomat")
public class PerusTuote extends Tuote {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuote tuote = (Tuote) o;

        if (id != tuote.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public double getSumma() {
        return hinta;
    }
}
