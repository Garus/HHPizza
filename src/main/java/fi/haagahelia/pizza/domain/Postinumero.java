package fi.haagahelia.pizza.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Postinumero {
    private String postiNumero;
    private String postiToimiPaikka;

public Postinumero() {}

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
