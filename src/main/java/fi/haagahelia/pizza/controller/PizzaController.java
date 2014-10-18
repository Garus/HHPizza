package fi.haagahelia.pizza.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fi.haagahelia.pizza.domain.Pizza;
import fi.haagahelia.pizza.exceptions.PizzaNotFoundException;
import fi.haagahelia.pizza.service.PizzaService;

@Controller
@RequestMapping("/pizzat")
public class PizzaController {

	// @Autowired
	private PizzaService pizzaService;

	@Autowired(required = true)
	@Qualifier(value = "pizzaService")
	public void setPizzaService(PizzaService ps) {
		this.pizzaService = ps;
	}

	@RequestMapping
	public String list(Model model) {

		model.addAttribute("pizzat", pizzaService.getAllPizzas());

		return "pizzat";
	}

	@RequestMapping("/kaikki")
	public String getAllPizzas(Model model) {
		model.addAttribute("pizzat", pizzaService.getAllPizzas());
		return "pizzat";
	}

	@RequestMapping("/pizza")
	public String getPizzaById(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("pizza", pizzaService.getPizzaById(id));
		return "pizza";
	}

	@ExceptionHandler(PizzaNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req,
			PizzaNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidPizzaId", exception.getPizzaId());
		mav.addObject("exception", exception);
		mav.setViewName("pizzaNotFound");
		return mav;
	}

	@RequestMapping(value = "/uusi", method = RequestMethod.GET)
	public String getAddNewPizza(Model model) {
		Pizza pizza = new Pizza();
		model.addAttribute("uusipizza", pizza);
		return "uusipizza";
	}

	@RequestMapping(value = "/uusi", method = RequestMethod.POST)
	public String processAddNewProduct(@ModelAttribute("uusipizza") Pizza pizza) {
		pizzaService.addPizza(pizza);
		return "redirect:/pizzat";
	}

	@RequestMapping("/poista")
	public String removePizzaById(Model model, @RequestParam("id") Integer id) {
		Pizza p = pizzaService.getPizzaById(id);
		pizzaService.removePizza(p);
		return "redirect:/pizzat";
	}
}
