package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.Tuote;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TuoteDAOImpl implements TuoteDAO {

    private static final Logger logger = Logger.getLogger(PizzaDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
            this.sessionFactory = sf;
    }    
    
    
    @Override
    public void addTuote(Tuote p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTuote(Tuote p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Tuote> getAllTuote(int type) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tuote> tuoteList = session.createQuery("FROM Tuote t WHERE t.tyyppiId = " + type).list();

        for (Tuote p : tuoteList) {
                logger.info("Tuote list:: " + p);
        }
        return tuoteList;
    }

    @Override
    public Tuote getTuoteById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tuote p = (Tuote) session.load(Tuote.class, new Integer(id));
        logger.info("Tuote was loaded successfully, Tuote = " + p);
        return p;
    }

    @Override
    public void removeTuote(Tuote p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
