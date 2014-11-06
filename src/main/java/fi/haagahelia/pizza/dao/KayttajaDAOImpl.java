package fi.haagahelia.pizza.dao;

import java.util.Date;
import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class KayttajaDAOImpl implements KayttajaDAO {

    private static final Logger logger = Logger.getLogger(KayttajaDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addKayttaja(Kayttaja kayttaja) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(kayttaja);
        logger.info("Kayttaja tallennettu:: " + kayttaja);
    }

    @Override
    public void updateKayttaja(Kayttaja kayttaja) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(kayttaja);
        logger.info("Kayttaja päivitetty:: " + kayttaja);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Kayttaja> haeKaikkiKayttajat() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Kayttaja> tuotteetList = session.createQuery("from Kayttaja").list();

        for (Kayttaja kayttaja : tuotteetList) {
            logger.info("Kayttaja:: " + kayttaja);
        }
        return tuotteetList;
    }

    @Override
    public Kayttaja haeKayttajaTunnuksella(int id) {
        Kayttaja kayttaja = null;
        Session session = this.sessionFactory.getCurrentSession();

        kayttaja = (Kayttaja) session.get(Kayttaja.class, new Integer(id));
        logger.info("haetaan käyttäjää " + kayttaja + " ja id:Stä: " + id);
        return kayttaja;
    }

    @Override
    public void poistaKayttaja(Kayttaja p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(p);
        logger.info("kayttaja :: " + p + " poistettu.");

    }

    public List<Roolit> haeKayttajaRoolit() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Roolit ").list();
    }
}
