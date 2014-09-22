package fi.haagahelia.pizza.dao;

import java.util.List;

import fi.haagahelia.pizza.domain.Pizza;

public interface PizzaDAO {

	public void addPizza(Pizza p);

	public void updatePizza(Pizza p);

	public List<Pizza> getAllPizzas();

	public Pizza getPizzaById(int id);

	public void removePizza(int id);
}
