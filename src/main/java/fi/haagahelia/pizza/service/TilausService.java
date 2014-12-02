package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.Tilaus;
/**
 *  Service tason käyttöliittymä tilaukseen liittyviin toimintoihin.
 * <p>
 * Välittää tietoja controller tason TilausController-luokasta model tason 
 * TilausDAO käyttöliittymälle.
 * 
 * @author Heikki Telinen
 * @version %I%
 * 
 * @see fi.haagahelia.pizza.controller.TilausController
 * @see fi.haagahelia.pizza.dao.TilausDAO
 * @see fi.haagahelia.pizza.domain.Tilaus
 */
public interface TilausService {
    /**
     * Tallentaa session sisältämän Tilaus-luokan olion tietokantaan
     * 
     * @param tilaus session sisältämä Tilaus-luokan olio
     * @return kokonaisluku
     */
    int tallennaTilaus(Tilaus tilaus);
}
