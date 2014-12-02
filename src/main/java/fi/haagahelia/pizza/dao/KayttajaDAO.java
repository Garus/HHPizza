package fi.haagahelia.pizza.dao;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;

/**
 * Model tason käyttöliittymä käyttäjiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja service tason KayttajaService-luokasta model tason Kayttaja
 * hibernate luokalle.
 *
 * @author Gabriel Herrera
 * @version %I%
 *
 * @see fi.haagahelia.pizza.service.KayttajaService'
 * @see fi.haagahelia.pizza.domain.Kayttaja
 */
public interface KayttajaDAO {

    /**
     * Lisää Kayttaja-luokan olion malliin
     *
     * @param p Kayttaja-luokan olio, lisattava käyttäjä
     */
    public void addKayttaja(Kayttaja p);

    /**
     * Päivittää Kayttaja-luokan olion tietoja
     *
     * @param p Kayttaja-luokan olio päivitetyillä tiedoilla. Korvaa vastaavalla
     * id numerolla olevan käyttäjän mallista.
     */
    public void updateKayttaja(Kayttaja p);
    /**
     * Luo listan kaikista käyttäjistä
     * 
     * @return lista käyttäjistä
     */
    public List<Kayttaja> haeKaikkiKayttajat();
    /**
     * Luo Kayttaja-luokan olion tietystä käyttäjästä.
     * 
     * @param id kokonaisluku, halutun käyttäjän id numero
     * @return Kayttaja-luokan olio
     */
    public Kayttaja haeKayttajaTunnuksella(int id);

    /**
     * Poistaa Kayttaja-luokan olion mallista
     *
     * @param p Kayttaja-luokan olio, poistettava käyttäjä. Hakee id numeroa
     * vastaavan käyttäjän ja poistaa sen mallista.
     */
    public void poistaKayttaja(Kayttaja p);
    /**
     * Tuottaa listan mahdollisista käyttäjä-rooleista
     * 
     * @return käyttäjärooli lista
     */
    public List<Roolit> haeKayttajaRoolit();
}
