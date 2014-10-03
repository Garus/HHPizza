package fi.haagahelia.pizza.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.PizzaDAO;
import fi.haagahelia.pizza.domain.Pizza;

@Service
public class PizzaServiceImpl implements PizzaService {

	private PizzaDAO pizzaDAO;

	public void setPizzaDAO(PizzaDAO pizzaDAO) {
		this.pizzaDAO = pizzaDAO;
	}

	@Override
	@Transactional
	public List<Pizza> getAllPizzas() {

		return pizzaDAO.getAllPizzas();
	}

	@Override
	@Transactional
	public Pizza getPizzaById(int id) {

		return pizzaDAO.getPizzaById(id);
	}

	@Override
	@Transactional
	public void addPizza(Pizza p) {
		pizzaDAO.addPizza(p);
		
	}

	@Override
	@Transactional
	public void removePizza(Pizza p) {
		pizzaDAO.removePizza(p);
		
	}

}
