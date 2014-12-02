package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Tuote;
/**
 *  Service tason käyttöliittymä tuotteisiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja controller tason TuoteController-luokasta model tason 
 * TuoteDAO käyttöliittymälle.
 * 
 * @author Heikki Telinen
 * @version %I%
 * 
 * @see fi.haagahelia.pizza.controller.TuoteController
 * @see fi.haagahelia.pizza.dao.TuoteDAO
 * @see fi.haagahelia.pizza.domain.Tuote
 */
public interface TuoteService {
    /**
     * Luo listan kaikista tuotteista
     * 
     * @return lista kaikista tuotteista
     */
    List<Tuote> haeKaikkiTuotteet();
    /**
     * Luo Tuote-luokan olion tietyn id:n sisältävästä tuotteesta
     * @param id kokonaisluku, luotavan tuotteen id numero
     * 
     * @return Tuote-luokan olio
     */
    Tuote haeTuoteTunnuksella(int id);
    /**
     * Lisää Tuote-luokan olion malliin
     * 
     * @param p lisättävä Tuote-luokan olio
     */
    void lisääTuote(Tuote p);
    /**
     * Poistaa valitun Tuote-luokan olion mallista olion id attribuutin 
     * perusteella
     * 
     * @param p poistettava Tuote-luokan olio. 
     */
    void poistaTuote(Tuote p);
    /**
     * Vaihtaa mallin sisältämän tuote-olion attribuutit toiseen.
     * Tunnistus id-attribuutin perusteella
     * 
     * @param p Tuote-luokan olio jonka attribuutteja muokataan
     */
    void päivitäTuote(Tuote p);
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
    public List<Tuote> haeKategorianTuotteet(String kategoria);

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
