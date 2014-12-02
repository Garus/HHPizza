package fi.haagahelia.pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;
/**
 * Controller tilauksiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja metodeissa kartoitettujen view tason jsp sivujen ja model
 * tason tuoteService luokan välillä. Kartoitus /tilaus
 *
 * @author Heikki Telinen
 * @version %I%
 *
 * @see fi.haagahelia.pizza.service.tilausService
 */

@Controller
@RequestMapping("/tilaus")
public class TilausController {
    /**
     * Sitoo model olioon tilausService-olion kaikki tilaukset ja palauttaa tämän
     * listan. Kartoitus /tilaus
     * 
     * @param model malli jota käytetään
     * @return tilaus joka lisättiin
     */
    @RequestMapping
    public String list(Model model) {
        model.addAttribute("answer",new Integer(new Random().nextInt(50-40) + 40));
        return "tilaus";
    }
}
