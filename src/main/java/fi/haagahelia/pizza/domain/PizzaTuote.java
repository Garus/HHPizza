package fi.haagahelia.pizza.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "pizzat")
//@NamedQuery(name = "kategorianTuotteet", query = "select t from Kategoria k join k.pizzat t where k.kategoriaNimi = :kategoriaNimi")
public class PizzaTuote extends Tuote {

    public PizzaTuote() {
        super();
    }

    public PizzaTuote(int id, String nimi, double hinta) {
        super(id, nimi, hinta);
    }

    @Transient
    private List<TuotteenLisaAine> aineet = new ArrayList<>();

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

    public double getSumma() {
        double sum = hinta;
        for (TuotteenLisaAine aine : aineet) {
            sum += aine.getSumma();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuote)) return false;

        PizzaTuote tuote = (PizzaTuote) o;

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
