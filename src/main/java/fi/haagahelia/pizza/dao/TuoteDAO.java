package fi.haagahelia.pizza.dao;

import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Tuote;

/**
 * Model tason käyttöliittymä tuotteisiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja service tason TuoteService-luokasta model tason Tuote
 * hibernate luokalle.
 *
 * @author Heikki Telinen
 * @version %I%
 *
 * @see fi.haagahelia.pizza.service.TuoteService'
 * @see fi.haagahelia.pizza.domain.Tuote
 */
public interface TuoteDAO {

    /**
     * Lisää Tuote-luokan olion malliin
     *
     * @param p lisättävä Tuote-luokan olio
     */
    public void addTuote(Tuote p);

    /**
     * Vaihtaa mallin sisältämän tuote-olion attribuutit toiseen. Tunnistus
     * id-attribuutin perusteella
     *
     * @param p Tuote-luokan olio jonka attribuutteja muokataan
     */
    public void updateTuote(Tuote p);

    /**
     * Luo listan kaikista tuotteista
     *
     * @return lista kaikista tuotteista
     */
    public List<Tuote> haeKaikkiTuotteet();

    /**
     * Luo Tuote-luokan olion tietyn id:n sisältävästä tuotteesta
     *
     * @param id kokonaisluku, luotavan tuotteen id numero
     *
     * @return Tuote-luokan olio
     */
    public Tuote haeTuoteTunnuksella(int id);

    /**
     * Poistaa valitun Tuote-luokan olion mallista olion id attribuutin
     * perusteella
     *
     * @param p poistettava Tuote-luokan olio.
     */
    public void poistaTuote(Tuote p);

    /**
     * Listaa kaikki kategoriat joihin tuote voi kuulua
     *
     * @return Lista kaikista Kategoria-luokan olioista
     */
    public List<Kategoria> haeKaikkiKategoriat();

    /**
     * Listaa tietyn kategorian kaikki tuotteet
     *
     * @param kategoria merkkijono, kategorian nimi
     * @return Lista Tuote-luokan olioista halutussa kategoriassa
     */
    public List<Tuote> haeKategorianTuotteet(String kategoriaNimi);

    /**
     * Listaa kaikki mahdolliset lisäaineet
     *
     * @return Lista LisaAine-luokan olioista
     */

    public List<LisaAine> haeKaikkiLisaAineet();

    /**
     * Palauttaa tietyn id-attribuutilla tunnistettavan LisaAine-luokan olion
     *
     * @param id kokonaisluku, jolla palautettava LisaAine-luokan olion id
     * attribuutti tunnistetaan
     * @return LisaAine-luokan olio
     */
    public LisaAine haeLisaAineTunnuksella(int id);
}
