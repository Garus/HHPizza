package fi.haagahelia.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.pizza.domain.Tuote;
import fi.haagahelia.pizza.service.TuoteService;

@Controller
@RequestMapping("/pizzat")
public class PizzaController {
        //Valitaan asetettu tuotetyyppi
        int type = 1;
	// @Autowired
	private TuoteService tuoteService;

	@Autowired(required = true)
	@Qualifier(value = "tuoteService")
	public void setTuoteService(TuoteService ps) {
		this.tuoteService = ps;
	}

	@RequestMapping
	public String list(Model model) {

		model.addAttribute("pizzat", tuoteService.getAllTuote(type));

		return "pizzat";
	}

	@RequestMapping("/kaikki")
	public String getAllPizzas(Model model) {
		model.addAttribute("pizzat", tuoteService.getAllTuote(type));
		return "pizzat";
	}

	@RequestMapping("/pizza")
	public String getPizzaById(Model model, @RequestParam("id") Integer id) {
		model.addAttribute("pizza", tuoteService.getTuoteById(id));
		return "pizza";
	}

	@RequestMapping(value = "/uusi", method = RequestMethod.GET)
	public String getAddNewPizza(Model model) {
		Tuote pizza = new Tuote();
		model.addAttribute("uusipizza", pizza);
		return "uusipizza";
	}

	@RequestMapping(value = "/uusi", method = RequestMethod.POST)
	public String processAddNewProduct(
			@ModelAttribute("uusipizza") Tuote pizza) {
		tuoteService.addTuote(pizza);
		return "redirect:/pizzat";
	}
	@RequestMapping("/poista")
	public String removePizzaById(Model model, @RequestParam("id") Integer id) {
		Tuote p = tuoteService.getTuoteById(id);
		tuoteService.removeTuote(p);
		return "redirect:/pizzat";
	}
}
