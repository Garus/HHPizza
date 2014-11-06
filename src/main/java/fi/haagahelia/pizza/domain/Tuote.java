package fi.haagahelia.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tuotteet")
public class Tuote {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nimi;
	private double hinta;
	private String kuvaus;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuote other = (Tuote) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Tuote() {
		super();
	}

	public Tuote(int id, String nimi, double hinta) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String name) {
		this.nimi = name;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double price) {
		this.hinta = price;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String description) {
		this.kuvaus = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return this.nimi + " (" + id + ")";
	}
}
