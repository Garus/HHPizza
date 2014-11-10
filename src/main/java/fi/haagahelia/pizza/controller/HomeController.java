package fi.haagahelia.pizza.controller;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.service.TuoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    private TuoteService tuoteService;

    @Autowired(required = true)
    @Qualifier(value = "tuoteService")
    public void setTuoteService(TuoteService ps) {
        this.tuoteService = ps;
    }

    @RequestMapping("/")
    public ModelAndView welcome(Model model) {

        ModelAndView mav = new ModelAndView();
        List<Kategoria> kategoriat = tuoteService.haeKaikkiKategoriat();
        mav.addObject("kategoriat", kategoriat);
//		mav.addObject("kategoriat", tuoteService.haeEtusivunTarjoukset());
        mav.setViewName("index");
        return mav;
    }
}