package fi.haagahelia.pizza.controller;

import javax.servlet.http.HttpServletRequest;

import fi.haagahelia.pizza.domain.Tuote;
import fi.haagahelia.pizza.exceptions.TuoteNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fi.haagahelia.pizza.service.TuoteService;

@Controller
@RequestMapping("/tuotteet")
public class TuoteController {

    private static final Logger logger = Logger.getLogger(TuoteController.class);

    private TuoteService tuoteService;

    @Autowired(required = true)
    @Qualifier(value = "tuoteService")
    public void setTuoteService(TuoteService ps) {
        this.tuoteService = ps;
    }

    @RequestMapping
    public String list(Model model) {

        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());

        return "tuotteet";
    }

    @RequestMapping("/kaikki")
    public String haeKaikkiTuotteet(Model model) {
        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());
        return "tuotteet";
    }

    @RequestMapping(value = "/admin")
    public String haeKaikkiAdminTuotteet(Model model) {
        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());
        return "admintuotteet";
    }

    @RequestMapping("/tuote")
    public String haeTuoteTunnuksella(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("tuote", tuoteService.haeTuoteTunnuksella(id));
        return "tuote";
    }

    @ExceptionHandler(TuoteNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req,
                                    TuoteNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidTuoteId", exception.haeTuoteTunnuksella());
        mav.addObject("exception", exception);
        mav.setViewName("tuoteNotFound");
        return mav;
    }

    @RequestMapping(value = "/admin/uusi", method = RequestMethod.GET)
    public String getLisääUusiTuote(Model model, @RequestParam(required = false) Integer id) {
        Tuote tuote;

        if (id == null) {
            tuote = new Tuote();
        } else {
            tuote = tuoteService.haeTuoteTunnuksella(id);
        }

        model.addAttribute("uusituote", tuote);
        return "uusituote";
    }

    @RequestMapping(value = "/admin/uusi", method = RequestMethod.POST)
    public String getLisääUusiTuote(@ModelAttribute("uusituote") Tuote tuote) {

        if (tuote.getId() == 0) {
            tuoteService.lisääTuote(tuote);
        } else {
            tuoteService.päivitäTuote(tuote);
        }
        return "redirect:/tuotteet/admin";
    }

    @RequestMapping("/admin/poista")
    public String poistaTuote(Model model, @RequestParam("id") Integer id) {
        Tuote p = tuoteService.haeTuoteTunnuksella(id);
        tuoteService.poistaTuote(p);
        return "redirect:/tuotteet/admin";
    }

    @RequestMapping("/{kategoria}")
    public String getProductsByCategory(Model model, @PathVariable("kategoria")
    String kategoria) {
        model.addAttribute("tuotteet", tuoteService.haeKategorianTuotteet(kategoria));

        return "tuotteet";
    }
}

