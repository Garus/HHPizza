/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Koordinaattori
 */
@Entity
@Table(name = "tilaukset")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Tilaus.findAll", query = "SELECT t FROM Tilaus t"),
        @NamedQuery(name = "Tilaus.findById", query = "SELECT t FROM Tilaus t WHERE t.id = :id"),
        @NamedQuery(name = "Tilaus.findByToimitustapa", query = "SELECT t FROM Tilaus t WHERE t.toimitustapa = :toimitustapa"),
        @NamedQuery(name = "Tilaus.findByMaksutapa", query = "SELECT t FROM Tilaus t WHERE t.maksutapa = :maksutapa"),
//        @NamedQuery(name = "Tilaus.findByOsoite", query = "SELECT t FROM Tilaus t WHERE t.osoite = :osoite")
})
public class Tilaus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = true)
    @Column(name = "toimitustapa")
    private String toimitustapa;
    @Column(name = "maksutapa")
    private String maksutapa;
    @Column(name = "osoite")
    private String osoite;
    @JoinColumn(name = "tilaaja_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Tilaaja tilaaja;

    public Ostoskori getOstoskori() {
        return ostoskori;
    }

    public void setOstoskori(Ostoskori ostoskori) {
        this.ostoskori = ostoskori;
    }

    @Transient
    private Ostoskori ostoskori;

    public Tilaus() {
        this.tilaaja = new Tilaaja();
    }

    public Tilaus(Integer id) {
        this.id = id;
    }

    public Tilaus(Integer id, String toimitustapa) {
        this.id = id;
        this.toimitustapa = toimitustapa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToimitustapa() {
        return toimitustapa;
    }

    public void setToimitustapa(String toimitustapa) {
        this.toimitustapa = toimitustapa;
    }

    public String getMaksutapa() {
        return maksutapa;
    }

    public void setMaksutapa(String maksutapa) {
        this.maksutapa = maksutapa;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public Tilaaja getTilaaja() {
        return tilaaja;
    }

    public void setTilaaja(Tilaaja tilaaja) {
        this.tilaaja = tilaaja;
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
        if (!(object instanceof Tilaus)) {
            return false;
        }
        Tilaus other = (Tilaus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tilaus{" +
                "id=" + id +
                ", toimitustapa='" + toimitustapa + '\'' +
                ", maksutapa='" + maksutapa + '\'' +
                ", osoite='" + osoite + '\'' +
                ", tilaaja=" + tilaaja +
                ", ostoskori=" + ostoskori +
                '}';
    }
}
