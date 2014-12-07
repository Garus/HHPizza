package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lisa_aineet")
public class LisaAine implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nimi;
    private double hinta;

    public LisaAine(){}

    public LisaAine(int id, String nimi, double hinta){
        this.id = id;
        this.nimi = nimi;
        this.hinta = hinta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LisaAine)) return false;

        LisaAine lisaAine = (LisaAine) o;

        if (id != lisaAine.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "LisaAine{" +
                "id=" + id +
                ", nimi='" + nimi + '\'' +
                ", hinta=" + hinta +
                '}';
    }
}
