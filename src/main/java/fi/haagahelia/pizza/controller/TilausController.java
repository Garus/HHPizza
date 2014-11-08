package fi.haagahelia.pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/tilaus")
public class TilausController {

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("answer",new Integer(new Random().nextInt(50-40) + 40));
        return "tilaus";
    }
}
