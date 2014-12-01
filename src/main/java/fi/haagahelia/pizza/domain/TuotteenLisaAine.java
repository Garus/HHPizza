package fi.haagahelia.pizza.domain;

/**
 * 1 lisä aineen tietue tuotteessa
 */
public class TuotteenLisaAine<T extends LisaAine> {

    private T tuote;
    private int maara;

    public TuotteenLisaAine(T tuote) {
        this.tuote = tuote;
        this.maara = 1;
    }

    /**
     * Hae ostoskorissa olevan tuotteen summa
     * @return summa
     */
    public double getSumma() {
        double summa = 0;
        summa = maara * tuote.getHinta();
        return summa;
    }

    /**
     * Lisää tuotteen lukumäärä yhdellä
     */
    public void lisaaLukumaara() {
        maara++;
    }

    /**
     * Vähennä tuotteen lukumäärä yhdellä
     */
    public void vahennaLukumaara() {
        maara--;
    }

    /**
     *
     * @return tuote
     */
    public T getTuote() {
        return tuote;
    }

    public int getMaara() {
        return maara;
    }

    public String toString() {
        return "Tuote: " + tuote + "; maara: " + maara;
    }
}
