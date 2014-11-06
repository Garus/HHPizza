/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Koordinaattori
 */
@Entity
@Table(name = "kayttaja")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Kayttaja.findAll", query = "SELECT k FROM Kayttaja k"),
        @NamedQuery(name = "Kayttaja.findById", query = "SELECT k FROM Kayttaja k WHERE k.id = :id"),
        @NamedQuery(name = "Kayttaja.findByNimi", query = "SELECT k FROM Kayttaja k WHERE k.nimi = :nimi")})
public class Kayttaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "nimi")
    private String nimi;
    @Column(name = "tunnus", nullable = false)
    private String kayttajaTunnus;
    @Column(name = "salasana")
    private String salasana;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "luotu_pvm", nullable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    @Generated(value = GenerationTime.INSERT)
    private Date luotuPvm;
    @JoinColumn(name = "rooli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roolit rooli;

    public Kayttaja() {
    }

    public Kayttaja(int id, String nimi, String kayttajaTunnus) {
        this.id = id;
        this.nimi = nimi;
        this.kayttajaTunnus = kayttajaTunnus;
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

    public Roolit getRooli() {
        return rooli;
    }

    public void setRooli(Roolit rooli) {
        this.rooli = rooli;
    }

    public Date getLuotuPvm() {
        return luotuPvm;
    }

    public void setLuotuPvm(Date liitymisPvm) {
        this.luotuPvm = liitymisPvm;
    }

    public String getKayttajaTunnus() {
        return kayttajaTunnus;
    }

    public void setKayttajaTunnus(String kayttajaTunnus) {
        this.kayttajaTunnus = kayttajaTunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kayttaja)) return false;

        Kayttaja kayttaja = (Kayttaja) o;

        if (id != kayttaja.id) return false;
        if (!nimi.equals(kayttaja.nimi)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nimi.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Kayttaja{" +
                "id=" + id +
                ", nimi='" + nimi + '\'' +
                ", kayttajaTunnus='" + kayttajaTunnus + '\'' +
                ", salasana='" + salasana + '\'' +
                ", liitymisPvm=" + luotuPvm +
                ", rooli=" + rooli +
                '}';
    }

}
