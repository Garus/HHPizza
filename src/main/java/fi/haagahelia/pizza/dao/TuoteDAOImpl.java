package fi.haagahelia.pizza.dao;

import java.util.Date;
import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Tuote;
import fi.haagahelia.pizza.exceptions.TuoteNotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TuoteDAOImpl implements TuoteDAO {

	private static final Logger logger = Logger.getLogger(TuoteDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addTuote(Tuote tuote) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(tuote);
		logger.info("Tuote tallennettu:: " + tuote);

	}

	@Override
	public void updateTuote(Tuote tuote) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tuote);
        logger.info("Tuote päivitetty:: " + tuote);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tuote> haeKaikkiTuotteet() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Tuote> tuotteetList = session.createQuery("from Tuote").list();

		for (Tuote tuote : tuotteetList) {
			logger.info("Tuote:: " + tuote);
		}
		return tuotteetList;
	}

	@Override
	public Tuote haeTuoteTunnuksella(int id) {
		Tuote tuote = null;
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Trying to loaded pizza with ID " + id);
		tuote = (Tuote) session.get(Tuote.class, new Integer(id));
		logger.info("Pizza loaded successfully, Pizza = " + tuote);

		if (tuote == null) {
			throw new TuoteNotFoundException("Ei löydetty tuotetta jonka id on: " + id);
		}

		return tuote;
	}

	@Override
	public void poistaTuote(Tuote p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(p);
		logger.info("tuote :: " + p + " poistettu.");

	}

	@Override
	public List<Kategoria> haeKaikkiKategoriat() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kategoria> kategoriat = session.createQuery("from Kategoria ").list();
		logger.info("Kategoriat:: " + kategoriat);
		return kategoriat;
	}

	@Override
	public List<Tuote> haeKategorianTuotteet(String kategoriaNimi) {
		Session session = this.sessionFactory.getCurrentSession();
		// select t.* from tuotteet t join kategoria_tuotteet kt on kt.tuotteet_id = t.id
		// join kategoriat k on kt.kategoriat_kategoriaId = k.kategoriaId where k.kategoriaNimi = 'Pizzat';
		List<Tuote> tuotteet = session.getNamedQuery("kategorianTuotteet").setString("kategoriaNimi", kategoriaNimi).list();
		return tuotteet;
	}

	@Override
	public List<LisaAine> haeKaikkiLisaAineet() {
		List<LisaAine> lisaAineet = this.sessionFactory.getCurrentSession().createQuery("from LisaAine  ").list();
		return lisaAineet;
	}
}
