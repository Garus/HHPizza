package fi.haagahelia.pizza.controller;

import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.Tuote;
import fi.haagahelia.pizza.service.OstoskoriService;
import fi.haagahelia.pizza.service.TuoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@Scope("request")
@RequestMapping("/ostoskori")
public class OstoskoriController {

    private static final Logger logger = Logger.getLogger(OstoskoriController.class);

//    @Autowired
//    private Ostoskori cart;

    @Autowired
    private TuoteService tuoteService;
    @Autowired
    private OstoskoriService ostoskoriService;

    @RequestMapping
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ostoskori", ostoskoriService.getOstoskori());
        modelAndView.setViewName("ostoskori");
        return modelAndView;
    }

    @RequestMapping("/lisaa")
    public String lisääKoriin(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        ostoskoriService.lisaaTuote(tuote);
        return "redirect:/ostoskori";
    }

    @RequestMapping("/vahenna")
    public String vahennaTuoteKorista(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        boolean succ = ostoskoriService.vahennaTuote(tuote);
        logger.info("Tuotteen poisto: " + (succ == true ? "onnistui" : "epäonnistui"));

        return "redirect:/ostoskori";
    }

    @RequestMapping("/poista")
    public String poistaKorista(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        boolean succ = ostoskoriService.poistaTuote(tuote);
        logger.info("Tuotteen poisto: " + (succ == true ? "onnistui" : "epäonnistui"));

        return "redirect:/ostoskori";
    }

    @RequestMapping("/tyhjenna")
    public String poistaKaikkiTuotteet() {
        ostoskoriService.tyhjennaOstoskori();
        return "redirect:/ostoskori";
    }
}
