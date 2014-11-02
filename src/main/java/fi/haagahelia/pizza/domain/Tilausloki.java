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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Koordinaattori
 */
@Entity
@Table(name = "tilausloki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tilausloki.findAll", query = "SELECT t FROM Tilausloki t"),
    @NamedQuery(name = "Tilausloki.findById", query = "SELECT t FROM Tilausloki t WHERE t.id = :id"),
    @NamedQuery(name = "Tilausloki.findByAikakoodi", query = "SELECT t FROM Tilausloki t WHERE t.aikakoodi = :aikakoodi")})
public class Tilausloki implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "aikakoodi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aikakoodi;
    @JoinColumn(name = "kayttaja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kayttaja kayttajaId;
    @JoinColumn(name = "tilat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tilat tilatId;
    @JoinColumn(name = "tilaus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tilaus tilausId;

    public Tilausloki() {
    }

    public Tilausloki(Integer id) {
        this.id = id;
    }

    public Tilausloki(Integer id, Date aikakoodi) {
        this.id = id;
        this.aikakoodi = aikakoodi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAikakoodi() {
        return aikakoodi;
    }

    public void setAikakoodi(Date aikakoodi) {
        this.aikakoodi = aikakoodi;
    }

    public Kayttaja getKayttajaId() {
        return kayttajaId;
    }

    public void setKayttajaId(Kayttaja kayttajaId) {
        this.kayttajaId = kayttajaId;
    }

    public Tilat getTilatId() {
        return tilatId;
    }

    public void setTilatId(Tilat tilatId) {
        this.tilatId = tilatId;
    }

    public Tilaus getTilausId() {
        return tilausId;
    }

    public void setTilausId(Tilaus tilausId) {
        this.tilausId = tilausId;
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
        if (!(object instanceof Tilausloki)) {
            return false;
        }
        Tilausloki other = (Tilausloki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Tilausloki[ id=" + id + " ]";
    }
    
}
