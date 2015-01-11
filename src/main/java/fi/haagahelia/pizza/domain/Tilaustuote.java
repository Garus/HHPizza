/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import java.io.Serializable;
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
 *
 * @author Koordinaattori
 */
@Entity
@Table(name = "tilaustuote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tilaustuote.findAll", query = "SELECT t FROM Tilaustuote t"),
    @NamedQuery(name = "Tilaustuote.findById", query = "SELECT t FROM Tilaustuote t WHERE t.id = :id"),
    @NamedQuery(name = "Tilaustuote.findByHinta", query = "SELECT t FROM Tilaustuote t WHERE t.hinta = :hinta")})
public class Tilaustuote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "hinta")
    private double hinta;
//    @JoinColumn(name = "tuote_id", referencedColumnName = "id")
//    @ManyToOne(optional = true)
//    private Tuote tuote;
    private int tuote_id;
    @JoinColumn(name = "tilaus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tilaus tilaus;

    public Tilaustuote() {
    }

    public Tilaustuote(double hinta, int tuote_id, Tilaus tilaus) {
        this.hinta = hinta;
        this.tuote_id = tuote_id;
        this.tilaus = tilaus;
    }

    public Tilaustuote(Integer id) {
        this.id = id;
    }

    public Tilaustuote(Integer id, float hinta) {
        this.id = id;
        this.hinta = hinta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public int getTuote_id() {
        return tuote_id;
    }

    public void setTuote_id(int tuote_id) {
        this.tuote_id = tuote_id;
    }

    public Tilaus getTilaus() {
        return tilaus;
    }

    public void setTilaus(Tilaus tilausId) {
        this.tilaus = tilausId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tilaustuote)) {
            return false;
        }
        Tilaustuote other = (Tilaustuote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tilaustuote{" +
                "id=" + id +
                ", hinta=" + hinta +
                ", tuote_id=" + tuote_id +
                ", tilaus=" + tilaus +
                '}';
    }
}
