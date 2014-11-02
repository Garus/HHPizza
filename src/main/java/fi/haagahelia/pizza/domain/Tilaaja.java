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
@Table(name = "tilaaja")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Tilaaja.findAll", query = "SELECT t FROM Tilaaja t"),
        @NamedQuery(name = "Tilaaja.findById", query = "SELECT t FROM Tilaaja t WHERE t.id = :id"),
        @NamedQuery(name = "Tilaaja.findByNimi", query = "SELECT t FROM Tilaaja t WHERE t.nimi = :nimi"),
        @NamedQuery(name = "Tilaaja.findByKantaAsiakas", query = "SELECT t FROM Tilaaja t WHERE t.kantaAsiakas = :kantaAsiakas"),
        @NamedQuery(name = "Tilaaja.findByOsoite", query = "SELECT t FROM Tilaaja t WHERE t.osoite = :osoite"),
        @NamedQuery(name = "Tilaaja.findByEmail", query = "SELECT t FROM Tilaaja t WHERE t.email = :email"),
        @NamedQuery(name = "Tilaaja.findByPuhelin", query = "SELECT t FROM Tilaaja t WHERE t.puhelin = :puhelin")})
public class Tilaaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nimi")
    private String nimi;
    @Basic(optional = false)
    @Column(name = "kanta-asiakas")
    private short kantaAsiakas;
    @Column(name = "osoite")
    private String osoite;
    @Column(name = "email")
    private String email;
    @Column(name = "puhelin")
    private String puhelin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tilaajaId")
    private List<Tilaus> tilausList;

    public Tilaaja() {
    }

    public Tilaaja(Integer id) {
        this.id = id;
    }

    public Tilaaja(Integer id, String nimi, short kantaAsiakas) {
        this.id = id;
        this.nimi = nimi;
        this.kantaAsiakas = kantaAsiakas;
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

    public short getKantaAsiakas() {
        return kantaAsiakas;
    }

    public void setKantaAsiakas(short kantaAsiakas) {
        this.kantaAsiakas = kantaAsiakas;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuhelin() {
        return puhelin;
    }

    public void setPuhelin(String puhelin) {
        this.puhelin = puhelin;
    }

    @XmlTransient
    public List<Tilaus> getTilausList() {
        return tilausList;
    }

    public void setTilausList(List<Tilaus> tilausList) {
        this.tilausList = tilausList;
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
        if (!(object instanceof Tilaaja)) {
            return false;
        }
        Tilaaja other = (Tilaaja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Tilaaja[ id=" + id + " ]";
    }

}
