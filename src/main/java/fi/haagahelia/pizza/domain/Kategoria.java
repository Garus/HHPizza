package fi.haagahelia.pizza.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Luo java-oliot tietokannan taulusta 'kategoriat', joka mahdollistaa yhden
 * tyyppiselle tuotteelle useamman alikategorian. Luokka mahdollistaa olion
 * tallentamisen tietokantaan persist kommennolla.
 * 
 * @author Heikki Telinen
 * @version %I%
 */

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
    /**
     * Asettaa oliolle kokoelman tuotteita muuttujalla tuotteet.
     * 
     * @param tuotteeet kokoelma tuotteita
     */

    public void setTuotteet(Collection<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    public Kategoria() {
    }
    /**
     * Luo oliolle attribuutin kategorianimi muuttujalla kategroiaNimi.
     * 
     * @param kategoriaNimi Merkkijono jossa mainitaan kategorian nimi
     */
    public Kategoria(String kategoriaNimi) {
        this.kategoriaNimi = kategoriaNimi;
    }

}
