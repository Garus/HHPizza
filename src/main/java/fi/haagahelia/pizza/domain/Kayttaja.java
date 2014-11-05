/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @Column(name = "liittymis_pvm",
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date liitymisPvm;
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

    public Date getLiitymisPvm() {
        return liitymisPvm;
    }

    public void setLiitymisPvm(Date liitymisPvm) {
        this.liitymisPvm = liitymisPvm;
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
                ", liitymisPvm=" + liitymisPvm +
                ", rooli=" + rooli +
                '}';
    }

}
