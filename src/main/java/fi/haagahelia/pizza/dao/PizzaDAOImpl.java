package fi.haagahelia.pizza.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fi.haagahelia.pizza.domain.Pizza;
import fi.haagahelia.pizza.exceptions.PizzaNotFoundException;

@Repository
public class PizzaDAOImpl implements PizzaDAO {

	private static final Logger logger = Logger.getLogger(PizzaDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPizza(Pizza p) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Trying to save pizza :: " + p);
		session.persist(p);
		logger.info("Pizza saved:: " + p);

	}

	@Override
	public void updatePizza(Pizza p) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> getAllPizzas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pizza> pizzaList = session.createQuery("from Pizza").list();

		for (Pizza p : pizzaList) {
			logger.info("Pizza list:: " + p);
		}
		return pizzaList;
	}

	@Override
	public Pizza getPizzaById(int id) {
		Pizza p = null;
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Trying to loaded pizza with ID " + id);
		p = (Pizza) session.get(Pizza.class, new Integer(id));
		logger.info("Pizza loaded successfully, Pizza = " + p);

		if (p == null) {
			throw new PizzaNotFoundException("No pizza found by id " + id);
		}

		return p;
	}

	@Override
	public void removePizza(Pizza p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(p);
		logger.info("Pizza :: " + p + " removed.");

	}

}
