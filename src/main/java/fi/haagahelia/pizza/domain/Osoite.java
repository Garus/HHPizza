package fi.haagahelia.pizza.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Osoite implements Serializable {

    @Size(min=5, max=255, message="Osoitteen minimipituus=5 ja maksimipituus 255")
    private String katuOsoite;
    @Embedded
    private Postinumero postinumero;

    public Osoite(){
        postinumero = new Postinumero();
    }

    public Osoite(String katuOsoite, Postinumero postinumero) {
        this.katuOsoite = katuOsoite;
        this.postinumero = postinumero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoite)) return false;

        Osoite osoite = (Osoite) o;

        if (!katuOsoite.equals(osoite.katuOsoite)) return false;
        if (!postinumero.equals(osoite.postinumero)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = katuOsoite.hashCode();
        result = 31 * result + postinumero.hashCode();
        return result;
    }

    public String getKatuOsoite() {
        return katuOsoite;
    }

    public void setKatuOsoite(String katuOsoite) {
        this.katuOsoite = katuOsoite;
    }

    public Postinumero getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(Postinumero postinumero) {
        this.postinumero = postinumero;
    }

    public static void main(String[] args) {
        Postinumero n = new Postinumero("00100", "Helsinki");
        Postinumero m = new Postinumero("00100", "Helsinki");
        Osoite x = new Osoite("Foostreet", n);
        Osoite y = new Osoite("Foostreet", m);
        System.out.println(y == x);
        System.out.println(x.equals(y));
    }
}
