package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.Tilaus;
/**
 * Model tason käyttöliittymä tilauksiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja service tason KayttajaService-luokasta model tason Kayttaja
 * hibernate luokalle.
 *
 * @author Heikki Telinen
 * @version %I%
 *
 * @see fi.haagahelia.pizza.service.TilausService'
 * @see fi.haagahelia.pizza.domain.Tilaus
 */
public interface TilausDAO {
    /**
     * Tallentaa session sisältämän Tilaus-luokan olion tietokantaan
     * 
     * @param tilaus session sisältämä Tilaus-luokan olio
     * @return kokonaisluku
     */
    int tallennaTilaus(Tilaus tilaus);
}
