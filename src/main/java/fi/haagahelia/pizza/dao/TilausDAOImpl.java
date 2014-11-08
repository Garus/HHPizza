package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.Tilaus;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TilausDAOImpl implements TilausDAO {

    private static final Logger logger = Logger.getLogger(TilausDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public int tallennaTilaus(Tilaus tilaus) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tilaus);
        logger.info("Tilaus tallennettu:: " + tilaus);
        return 0;
    }
}
