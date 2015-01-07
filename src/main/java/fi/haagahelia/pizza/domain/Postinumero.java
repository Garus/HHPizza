package fi.haagahelia.pizza.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Postinumero implements Serializable {

    @Pattern(regexp = "[0-9]{5}", message = "Tarkista postinumero")
    private String postiNumero;
    @Size(min = 3, max = 255, message = "Postitoimipaikan minimipituus=3 ja maksimipituus 255")
    private String postiToimiPaikka;

    public Postinumero() {
    }

    public Postinumero(String postiNumero, String postiToimiPaikka) {
        this.postiNumero = postiNumero;
        this.postiToimiPaikka = postiToimiPaikka;
    }

    @Override
    public String toString() {
        return "Postinumero{" +
                "postiNumero='" + postiNumero + '\'' +
                ", postiToimiPaikka='" + postiToimiPaikka + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postinumero)) return false;

        Postinumero that = (Postinumero) o;

        if (!postiNumero.equals(that.postiNumero)) return false;
        if (!postiToimiPaikka.equals(that.postiToimiPaikka)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postiNumero.hashCode();
        result = 31 * result + postiToimiPaikka.hashCode();
        return result;
    }

    public String getPostiNumero() {
        return postiNumero;
    }

    public void setPostiNumero(String postiNumero) {
        this.postiNumero = postiNumero;
    }

    public String getPostiToimiPaikka() {
        return postiToimiPaikka;
    }

    public void setPostiToimiPaikka(String postiToimiPaikka) {
        this.postiToimiPaikka = postiToimiPaikka;
    }

    public static void main(String[] args) {
        Postinumero n = new Postinumero("00100", "Helsinki");
        Postinumero m = new Postinumero("00100", "Helsinki");
        System.out.println(m == n);
        System.out.println(m.equals(n));
    }
}
