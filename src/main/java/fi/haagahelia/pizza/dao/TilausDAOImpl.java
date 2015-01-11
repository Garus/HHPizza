package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.OstoskorinTuote;
import fi.haagahelia.pizza.domain.Tilaus;
import fi.haagahelia.pizza.domain.Tilaustuote;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TilausDAOImpl implements TilausDAO {

    private static final Logger logger = Logger.getLogger(TilausDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int tallennaTilaus(Tilaus tilaus) {
        List<OstoskorinTuote> tuotteet = tilaus.getOstoskori().getTuotteet();
        List<Tilaustuote> tilaustuoteet = new ArrayList<>();
        for (OstoskorinTuote tuote : tuotteet) {
            Tilaustuote tilaustuote = new Tilaustuote(tuote.getSumma(), tuote.getTuote().getId(), tilaus);
            tilaustuoteet.add(tilaustuote);
        }
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tilaus);
        for (Tilaustuote tilaustuote : tilaustuoteet) {
            session.persist(tilaustuote);
        }

        logger.info("Tilaus tallennettu:: " + tilaus);
        return tilaus.getId();
    }
}
