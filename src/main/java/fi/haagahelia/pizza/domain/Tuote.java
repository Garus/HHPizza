package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tuotteet")
@NamedQuery(name = "kategorianTuotteet", query = "select t from Kategoria k join k.tuotteet t where k.kategoriaNimi = :kategoriaNimi")
public abstract class Tuote implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nimi;
    protected double hinta;
    protected String kuvaus;

    public Tuote() {
        super();
    }

    public Tuote(int id, String nimi, double hinta) {
        this.id = id;
        this.nimi = nimi;
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String name) {
        this.nimi = name;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double price) {
        this.hinta = price;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String description) {
        this.kuvaus = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.nimi + " (" + id + ")";
    }

    public abstract double getSumma();

}
