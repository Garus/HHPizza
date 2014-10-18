package fi.haagahelia.pizza.exceptions;

public class PizzaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1246103173814828219L;
	private String pizzaId;

	public PizzaNotFoundException(String id) {
		pizzaId = id;
	}

	public String getPizzaId() {
		return pizzaId;
	}
}
