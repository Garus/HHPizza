package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.dao.TilausDAO;
import fi.haagahelia.pizza.domain.Tilaus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@inheritDoc}
 */
@Service
public class TilausServiceImpl implements TilausService {
    @Autowired
    private TilausDAO tilausDAO;

    public void setTilausDAO(TilausDAO tilausDAO) {
        this.tilausDAO = tilausDAO;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public int tallennaTilaus(Tilaus tilaus) {
        System.err.println("tilaus: " + tilaus.toString());
        int tilaus_id = tilausDAO.tallennaTilaus(tilaus);
        return tilaus_id;
    }
}
