/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Koordinaattori
 */
@Entity
@Table(name = "tilaus")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Tilaus.findAll", query = "SELECT t FROM Tilaus t"),
        @NamedQuery(name = "Tilaus.findById", query = "SELECT t FROM Tilaus t WHERE t.id = :id"),
        @NamedQuery(name = "Tilaus.findByToimitustapa", query = "SELECT t FROM Tilaus t WHERE t.toimitustapa = :toimitustapa"),
        @NamedQuery(name = "Tilaus.findByMaksutapa", query = "SELECT t FROM Tilaus t WHERE t.maksutapa = :maksutapa"),
        @NamedQuery(name = "Tilaus.findByOsoite", query = "SELECT t FROM Tilaus t WHERE t.osoite = :osoite")})
public class Tilaus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "toimitustapa")
    private String toimitustapa;
    @Column(name = "maksutapa")
    private String maksutapa;
    @Column(name = "osoite")
    private String osoite;
    @JoinColumn(name = "tilaaja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tilaaja tilaajaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tilausId")
    private List<Tilaustuote> tilaustuoteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tilausId")
    private List<Tilausloki> tilauslokiList;

    public Tilaus() {
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

    public Tilaaja getTilaajaId() {
        return tilaajaId;
    }

    public void setTilaajaId(Tilaaja tilaajaId) {
        this.tilaajaId = tilaajaId;
    }

    @XmlTransient
    public List<Tilaustuote> getTilaustuoteList() {
        return tilaustuoteList;
    }

    public void setTilaustuoteList(List<Tilaustuote> tilaustuoteList) {
        this.tilaustuoteList = tilaustuoteList;
    }

    @XmlTransient
    public List<Tilausloki> getTilauslokiList() {
        return tilauslokiList;
    }

    public void setTilauslokiList(List<Tilausloki> tilauslokiList) {
        this.tilauslokiList = tilauslokiList;
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
        return "fi.haagahelia.pizza.domain.Tilaus[ id=" + id + " ]";
    }

}
