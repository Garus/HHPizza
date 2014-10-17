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
@Table(name = "roolit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roolit.findAll", query = "SELECT r FROM Roolit r"),
    @NamedQuery(name = "Roolit.findById", query = "SELECT r FROM Roolit r WHERE r.id = :id"),
    @NamedQuery(name = "Roolit.findByRooli", query = "SELECT r FROM Roolit r WHERE r.rooli = :rooli")})
public class Roolit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rooli")
    private String rooli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rooliId")
    private List<Kayttaja> kayttajaList;

    public Roolit() {
    }

    public Roolit(Integer id) {
        this.id = id;
    }

    public Roolit(Integer id, String rooli) {
        this.id = id;
        this.rooli = rooli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRooli() {
        return rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }

    @XmlTransient
    public List<Kayttaja> getKayttajaList() {
        return kayttajaList;
    }

    public void setKayttajaList(List<Kayttaja> kayttajaList) {
        this.kayttajaList = kayttajaList;
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
        if (!(object instanceof Roolit)) {
            return false;
        }
        Roolit other = (Roolit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Roolit[ id=" + id + " ]";
    }
    
}
