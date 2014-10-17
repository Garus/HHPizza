/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "tyyppi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tyyppi.findAll", query = "SELECT t FROM Tyyppi t"),
    @NamedQuery(name = "Tyyppi.findById", query = "SELECT t FROM Tyyppi t WHERE t.id = :id"),
    @NamedQuery(name = "Tyyppi.findByTuote", query = "SELECT t FROM Tyyppi t WHERE t.tuote = :tuote")})
public class Tyyppi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tuote")
    private String tuote;
    @OneToMany(mappedBy = "tyyppiId")
    private List<Tuote> tuoteList;

    public Tyyppi() {
    }

    public Tyyppi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuote() {
        return tuote;
    }

    public void setTuote(String tuote) {
        this.tuote = tuote;
    }

    @XmlTransient
    public List<Tuote> getTuoteList() {
        return tuoteList;
    }

    public void setTuoteList(List<Tuote> tuoteList) {
        this.tuoteList = tuoteList;
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
        if (!(object instanceof Tyyppi)) {
            return false;
        }
        Tyyppi other = (Tyyppi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Tyyppi[ id=" + id + " ]";
    }
    
}
