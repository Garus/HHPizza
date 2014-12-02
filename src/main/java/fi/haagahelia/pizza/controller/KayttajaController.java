package fi.haagahelia.pizza.controller;

import javax.servlet.http.HttpServletRequest;

import fi.haagahelia.pizza.domain.Kayttaja;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fi.haagahelia.pizza.service.KayttajaService;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Controller käyttäjiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja metodeissa kartoitettujen view tason jsp sivujen ja model
 * tason KayttajaService luokan välillä. Kartoitus /kayttajat
 *
 * @author Heikki Telinen
 * @version %I%
 *
 * @see fi.haagahelia.pizza.service.KayttajaService
 */
@Controller
@RequestMapping("/kayttajat")
public class KayttajaController {

    private static final Logger logger = Logger.getLogger(KayttajaController.class);
    /**
     * Service-tason luokan olio 
     */
    @Autowired
    private KayttajaService kayttajaService;
    /**
     * 
     * @param ps kayttajaService luokan olio jota käytetään controllerissa 
     */
    @Autowired(required = true)
    @Qualifier(value = "kayttajaService")
    public void setKayttajaService(KayttajaService ps) {
        this.kayttajaService = ps;
    }

    /**
     * Sitoo model olioon kayttajaService-olion kaikki kayttajat ja roolit ja 
     * palauttaa tämän listan. Kartoitus /kayttajat
     *
     * @param model malli jota käytetään
     * @return kayttajat lista kaikista kayttajista
     */
    @RequestMapping
    public String list(Model model) {
        model.addAttribute("kayttajat", kayttajaService.haeKaikkiKayttajat());
        model.addAttribute("roolit", kayttajaService.haeKayttajaRoolit());
        return "kayttajat";
    }

    /**
     * Palauttaa kaikki mallin sisältämät käyttäjät. Kartoitus /kayttajat/kaikki
     * 
     * @param model malli jota käytetään
     * @return mallin sisältämät käyttäjät
     */
    @RequestMapping("/kaikki")
    public String haeKaikkiKayttajat(Model model) {

        model.addAttribute("kayttajat", kayttajaService.haeKaikkiKayttajat());
        model.addAttribute("roolit", kayttajaService.haeKayttajaRoolit());
        return "kayttajat";
    }
    /**
     * Hakee tietyn käyttäjän tietokannassa olevan id numeron perusteella. 
     * Kartoitus /kayttajat/kayttaja
     * 
     * @param model malli jota käytetään
     * @param id kokonaisluku, halutun käyttäjän id numero
     * @return id numeroa vastaava käyttäjä
     */
    @RequestMapping("/kayttaja")
    public String haeKayttajaTunnuksella(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("kayttaja", kayttajaService.haeKayttajaTunnuksella(id));
        return "kayttaja";
    }
    /**
     * Asettaa tiedot uuden käyttäjän lisäystä tai olemassaolevan muokkausta
     * varten. Kartoitus /kayttajat/admin/uusi
     * 
     * @param model malli jota käytetään
     * @param id kokonaisluku, käyttäjän id, jos null, lisätään uusi käyttäjä
     * @return palauttaa uuden tai muokatun käyttäjän
     */
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
    /**
     * Välittää tiedot käyttäjien lisäys jsp sivulta käyttäjän lisäyksestä
     * vastaavalle metodille. Kartoitus /kayttajat/admin/uusi
     * 
     * @param kayttaja kayttaja-luokan olio joka lisätään
     * @return uudelleenohjaus /kayttajat/kaikki
     */
    @RequestMapping(value = "/admin/uusi", method = RequestMethod.POST)
    public String getLisääUusiKayttaja(@ModelAttribute("uusikayttaja") Kayttaja kayttaja) {

        if (kayttaja.getId() == 0) {
            logger.info("Tallenetaan uusi käyttäjä"); 
            kayttajaService.lisääKayttaja(kayttaja);
        } else {
            logger.info("Muokataan olemassaolevaa käyttäjää: " + kayttaja);
            kayttajaService.päivitäKayttaja(kayttaja);
        }
  
        return "redirect:/kayttajat/kaikki";
    }
    /**
     * Poistaa käyttäjän id numerolla. Kartoitus /kayttajat/admin/poista
     * 
     * @param model malli jota noudatetaan
     * @param id kokonaisluku, poistettavan käyttäjän id
     * @return uudelleenohjaus /kayttajat/admin
     */
    @RequestMapping("/admin/poista")
    public String poistaKayttaja(Model model, @RequestParam("id") Integer id) {
        Kayttaja p = kayttajaService.haeKayttajaTunnuksella(id);
        kayttajaService.poistaKayttaja(p);
        return "redirect:/kayttajat/admin";
    }
    /**
     * Spring MVC:n mukainen annotoitu luokka jossa määritellään tietojen
     * muotoilurajoitteet.
     * 
     * @param binder WebDataBinder luokan olio, jonka atribuutteina ovat 
     * rajoitteet
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
