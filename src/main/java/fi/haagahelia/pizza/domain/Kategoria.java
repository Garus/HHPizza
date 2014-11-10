package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "kategoriat")
public class Kategoria {

    @Id
    @Column(name = "kategoriaId")
    @GeneratedValue
    private int kategoriaId;
    private String kategoriaNimi;

    @OneToMany
    @JoinTable(name="kategoria_tuotteet")
    private Collection<Tuote> tuotteet = new ArrayList<>();

    @Override
    public String toString() {
        return "Kategoria{" +
                "kategoriaId=" + kategoriaId +
                ", kategoriaNimi='" + kategoriaNimi + '\'' +
                ", tuotteet=" + tuotteet +
                '}';
    }

    public int getKategoriaId() {
        return kategoriaId;
    }

    public void setKategoriaId(int kategoriaId) {
        this.kategoriaId = kategoriaId;
    }

    public String getKategoriaNimi() {
        return kategoriaNimi;
    }

    public void setKategoriaNimi(String kategoriaNimi) {
        this.kategoriaNimi = kategoriaNimi;
    }

    public Collection<Tuote> getTuotteet() {
        return tuotteet;
    }

    public void setTuotteet(Collection<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    public Kategoria() {
    }

    public Kategoria(String kategoriaNimi) {
        this.kategoriaNimi = kategoriaNimi;
    }

}
