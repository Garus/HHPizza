package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;
/**
 *  Service tason käyttöliittymä käyttäjiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja controller tason KayttajaController-luokasta model tason 
 * KayttajaDAO käyttöliittymälle.
 * 
 * @author Gabriel Herrera
 * @version %I%
 * 
 * @see fi.haagahelia.pizza.controller.KayttajaController
 * @see fi.haagahelia.pizza.dao.KayttajaDAO
 * @see fi.haagahelia.pizza.domain.Roolit
 */
public interface KayttajaService {
    /**
     * Luo listan kaikista käyttäjistä
     * 
     * @return lista käyttäjistä
     */
    List<Kayttaja> haeKaikkiKayttajat();
    /**
     * Luo Kayttaja-luokan olion tietystä käyttäjästä.
     * 
     * @param id kokonaisluku, halutun käyttäjän id numero
     * @return Kayttaja-luokan olio
     */
    Kayttaja haeKayttajaTunnuksella(int id);
    /**
     * Lisää Kayttaja-luokan olion malliin
     * 
     * @param p Kayttaja-luokan olio, lisattava käyttäjä
     */
    void lisääKayttaja(Kayttaja p);
    /**
     * Poistaa Kayttaja-luokan olion mallista
     * 
     * @param p Kayttaja-luokan olio, poistettava käyttäjä. Hakee id numeroa
     * vastaavan käyttäjän ja poistaa sen mallista.
     */
    void poistaKayttaja(Kayttaja p);
    /**
     * Päivittää Kayttaja-luokan olion tietoja
     * 
     * @param p Kayttaja-luokan olio päivitetyillä tiedoilla. Korvaa vastaavalla
     * id numerolla olevan käyttäjän mallista.
     */
    void päivitäKayttaja(Kayttaja p);
    /**
     * Tuottaa listan mahdollisista käyttäjä-rooleista
     * 
     * @return käyttäjärooli lista
     */
    public List<Roolit> haeKayttajaRoolit();
}
