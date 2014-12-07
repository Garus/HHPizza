package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tuotteet")
@NamedQuery(name = "kategorianTuotteet", query = "select t from Kategoria k join k.tuotteet t where k.kategoriaNimi = :kategoriaNimi")
public class Tuote implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nimi;
    private double hinta;
    private String kuvaus;

    @Transient
    private List<TuotteenLisaAine> aineet = new ArrayList<>();

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

    public List<TuotteenLisaAine> getAineet() {
        return aineet;
    }

    public void lisaaAinePizzaan(LisaAine aine) {
        boolean isAinePizzassa = true;
        for (TuotteenLisaAine korinTuote : aineet) {
            if (korinTuote.getTuote().equals(aine)) {
                korinTuote.lisaaLukumaara();
                isAinePizzassa = false;
            }
        }

        if (isAinePizzassa) {
            aineet.add(new TuotteenLisaAine(aine));
        }
    }

    public boolean poistaAinePizzasta(LisaAine aine, boolean poistaKaikki) {
        boolean ok = false;
        for (Iterator<TuotteenLisaAine> it = aineet.iterator(); it.hasNext(); ) {
            TuotteenLisaAine lisaAine = it.next();
            if (lisaAine.getTuote().equals(aine)) {
                if (poistaKaikki) {
                    it.remove();
                    ok = true;
                } else {
                    if (lisaAine.getMaara() == 1) {
                        it.remove();
                        ok = true;
                    } else {
                        lisaAine.vahennaLukumaara();
                    }
                }
            }
        }
        return ok;
    }

    public void setAineet(List<TuotteenLisaAine> aineet) {
        this.aineet = aineet;
    }

    public String toString() {
        return this.nimi + " (" + id + ")";
    }

    public double getSumma() {
        double sum = this.hinta;
        for (TuotteenLisaAine aine : aineet) {
            sum += aine.getSumma();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuote)) return false;

        Tuote tuote = (Tuote) o;

        if (id != tuote.id) return false;
        if (!aineet.equals(tuote.aineet)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + aineet.hashCode();
        return result;
    }
}
