package fi.haagahelia.pizza.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tuote",catalog="pizzadb")

public class Tuote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nimi")
    private String nimi;
    @Column(name = "kuvaus")
    private String kuvaus;
    @Column(name = "hinta")
    private float hinta;
    @Column(name = "tyyppi_id")
    private int tyyppiId;
    
    public Tuote() {
    }

    public Tuote(Integer id) {
        this.id = id;
    }

    public Tuote(Integer id, float hinta) {
        this.id = id;
        this.hinta = hinta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public float getHinta() {
        return hinta;
    }

    public void setHinta(float hinta) {
        this.hinta = hinta;
    }

    public int getTyyppiId() {
        return tyyppiId;
    }

    public void setTyyppiId(int tyyppi_Id) {
        this.tyyppiId = tyyppi_Id;
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
        if (!(object instanceof Tuote)) {
            return false;
        }
        Tuote other = (Tuote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.haagahelia.pizza.domain.Tuote[ id=" + id + " ]";
    }
    
}
