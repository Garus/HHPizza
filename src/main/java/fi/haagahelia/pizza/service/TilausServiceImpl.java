package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.dao.TilausDAO;
import fi.haagahelia.pizza.domain.Tilaus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * {@inheritDoc}
 */
@Service
public class TilausServiceImpl implements TilausServise {
    @Autowired
    private TilausDAO tilausDAO;

    public void setTilausDAO(TilausDAO tilausDAO) {
        this.tilausDAO = tilausDAO;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int tallennaTilaus(Tilaus tilaus) {
        int tilaus_id = tilausDAO.tallennaTilaus(tilaus);
        return tilaus_id;
    }
}
