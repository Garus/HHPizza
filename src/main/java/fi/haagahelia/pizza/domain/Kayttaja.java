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
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nimi")
    private String nimi;
    @JoinColumn(name = "rooli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roolit rooliId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kayttajaId")
    private List<Tilausloki> tilauslokiList;

    public Kayttaja() {
    }

    public Kayttaja(Integer id) {
        this.id = id;
    }

    public Kayttaja(Integer id, String nimi) {
        this.id = id;
        this.nimi = nimi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Roolit getRooliId() {
        return rooliId;
    }

    public void setRooliId(Roolit rooliId) {
        this.rooliId = rooliId;
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
        if (!(object instanceof Kayttaja)) {
            return false;
        }
        Kayttaja other = (Kayttaja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Kayttaja[ id=" + id + " ]";
    }
    
}
