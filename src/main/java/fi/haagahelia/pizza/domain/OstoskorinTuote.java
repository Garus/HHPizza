package fi.haagahelia.pizza.domain;

/**
 * 1 rivi ostoskorissa
 */
public class OstoskorinTuote<T extends Tuote> {

    private T tuote;
    private int maara;

    public OstoskorinTuote(T tuote) {
        this.tuote = tuote;
        this.maara = 1;
    }

    /**
     * Hae ostoskorissa olevan tuotteen summa
     * @return summa
     */
    public double getSumma() {
        double summa = 0;
        summa = maara * tuote.getSumma();
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
