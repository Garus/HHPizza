package fi.haagahelia.pizza.controller;

import javax.servlet.http.HttpServletRequest;

import fi.haagahelia.pizza.domain.Kayttaja;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fi.haagahelia.pizza.service.KayttajaService;

@Controller
@RequestMapping("/kayttajat")
public class KayttajaController {

    private static final Logger logger = Logger.getLogger(KayttajaController.class);
    @Autowired
    private KayttajaService kayttajaService;

    @Autowired(required = true)
    @Qualifier(value = "kayttajaService")
    public void setKayttajaService(KayttajaService ps) {
        this.kayttajaService = ps;
    }

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("kayttajat", kayttajaService.haeKaikkiKayttajat());
        model.addAttribute("roolit", kayttajaService.haeKayttajaRoolit());
        return "kayttajat";
    }

    @RequestMapping("/kaikki")
    public String haeKaikkiKayttajat(Model model) {

        model.addAttribute("kayttajat", kayttajaService.haeKaikkiKayttajat());
        model.addAttribute("roolit", kayttajaService.haeKayttajaRoolit());
        return "kayttajat";
    }

    @RequestMapping("/kayttaja")
    public String haeKayttajaTunnuksella(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("kayttaja", kayttajaService.haeKayttajaTunnuksella(id));
        return "kayttaja";
    }

    @RequestMapping(value = "/admin/uusi", method = RequestMethod.GET)
    public String getLisääUusiKayttaja(Model model, @RequestParam(required = false) Integer id) {
        Kayttaja kayttaja;

        if (id == null) {
            kayttaja = new Kayttaja();
        } else {
            kayttaja = kayttajaService.haeKayttajaTunnuksella(id);
        }

        model.addAttribute("uusikayttaja", kayttaja);
        model.addAttribute("roolit", kayttajaService.haeKayttajaRoolit());
        return "uusikayttaja";
    }

    @RequestMapping(value = "/admin/uusi", method = RequestMethod.POST)
    public String getLisääUusiKayttaja(@ModelAttribute("uusikayttaja") Kayttaja kayttaja) {

        if (kayttaja.getId() == 0) {
            logger.info("Tallenetaan uusi käyttäjä"); 
            kayttajaService.lisääKayttaja(kayttaja);
        } else {
            kayttajaService.päivitäKayttaja(kayttaja);
        }
  
        return "redirect:/kayttajat/kaikki";
    }

    @RequestMapping("/admin/poista")
    public String poistaKayttaja(Model model, @RequestParam("id") Integer id) {
        Kayttaja p = kayttajaService.haeKayttajaTunnuksella(id);
        kayttajaService.poistaKayttaja(p);
        return "redirect:/kayttajat/admin";
    }
}
