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

/**
 * Controller tuotteisiin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja metodeissa kartoitettujen view tason jsp sivujen ja model
 * tason TuoteService luokan välillä. Kartoitus /tuotteet
 *
 * @author Heikki Telinen
 * @version %I%
 *
 * @see TuoteService
 */
@Controller
@RequestMapping("/tuotteet")
public class TuoteController {

    private static final Logger logger = Logger.getLogger(TuoteController.class);
    /**
     * Service-taso luokan olio
     */
    private TuoteService tuoteService;

    /**
     * @param ps tuoteService luokan olio 
     */
    @Autowired(required = true)
    @Qualifier(value = "tuoteService")
    public void setTuoteService(TuoteService ps) {
        this.tuoteService = ps;
    }

    /**
     * Sitoo model olioon tuoteService-olion kaikki tuotteet ja palauttaa tämän
     * listan. Kartoitus /tuotteet
     *
     * @param model malli jota käytetään
     * @return tuotteet lista kaikista tuotteista
     */
    @RequestMapping
    public String list(Model model) {
        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());
        return "tuotteet";
    }

    /**
     * Palauttaa kaikki mallin sisältämät tuotteet. Kartoitus /tuotteet/kaikki
     * 
     * @param model malli jota käytetään
     * @return tuotteet lista kaikista tuoteService olion tuotteista
     */
    @RequestMapping("/kaikki")
    public String haeKaikkiTuotteet(Model model) {
        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());
        return "tuotteet";
    }
    
    /**
     * Palauttaa kaikki mallin sisältämät hallinnoitavat tuotteet.
     * Kartoitus /tuotteet/admin
     * 
     * @param model
     * @return admintuotteet lista kaikista tuoteService olion tuotteista
     */
    @RequestMapping(value = "/admin")
    public String haeKaikkiAdminTuotteet(Model model) {
        model.addAttribute("tuotteet", tuoteService.haeKaikkiTuotteet());
        return "admintuotteet";
    }
    
    /**
     * Palauttaa yksittäisen mallin sisältämän tuotteen id numeron mukaan.
     * Kartoitus /tuotteet/admin
     * 
     * @param model malli jota käytetään
     * @param id kokonaisluku, tuotteen id, jsp sivusta haettu
     * @return tuote id lukua vastannut tuote
     */

    @RequestMapping("/tuote")
    public String haeTuoteTunnuksella(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("tuote", tuoteService.haeTuoteTunnuksella(id));
        return "tuote";
    }
    /**
     * Käsittelee virhetilanteet kun tuotetta ei löydy
     * 
     * @param req servletille menevä http pyyntö
     * @param exception poikkeama, TuoteNotFoundException luokan olio
     * @return mav virhetiedon sisältävä model ja view tason olio
     */
    @ExceptionHandler(TuoteNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req,
            TuoteNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidTuoteId", exception.haeTuoteTunnuksella());
        mav.addObject("exception", exception);
        mav.setViewName("tuoteNotFound");
        return mav;
    }
    /**
     * Tuottaa uuden tuotteen lisäysnäkymän. Kartoitus /tuotteet/admin/uusi 
     * 
     * @param model malli jota käytetään
     * @param id kokonaisluku, lisättävän tuotteen id. Jos 0, menee 
     * autoinkrementillä
     * @return uusituote tuote joka on lisätty
     */
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
    /**
     * Lisää uuden tuotteen. Kartoitus /tuotteet/admin/uusi
     * 
     * @param tuote 
     * @return uudelleenohjaus sivulle /tuotteet/admin
     */
    @RequestMapping(value = "/admin/uusi", method = RequestMethod.POST)
    public String getLisääUusiTuote(@ModelAttribute("uusituote") Tuote tuote) {

        if (tuote.getId() == 0) {
            tuoteService.lisääTuote(tuote);
        } else {
            tuoteService.päivitäTuote(tuote);
        }
        return "redirect:/tuotteet/admin";
    }
    /**
     * Poistaa tuotteen id numerolla. Kartoitus /tuotteet/admin/poista
     * 
     * @param model malli jota käytetään
     * @param id kokonaisluku poistettavan tuotteen id luku
     * @return jäljellä olevat tuottet
     */
    @RequestMapping("/admin/poista")
    public String poistaTuote(Model model, @RequestParam("id") Integer id) {
        Tuote p = tuoteService.haeTuoteTunnuksella(id);
        tuoteService.poistaTuote(p);
        return "redirect:/tuotteet/admin";
    }
    /**
     * Näyttää tietyn kategorian tuotteet. Kartoitus /tuotteet/{kategoria} 
     * kategorian nimi 
     * 
     * @param model malli jota käytetään
     * @param kategoria merkkijono, halutun tuotekategorian nimi
     * @return kategorian tuotteet mallin attribuuttina
     */
    @RequestMapping("/{kategoria}")
    public String getProductsByCategory(Model model, @PathVariable("kategoria") String kategoria) {
        model.addAttribute("tuotteet", tuoteService.haeKategorianTuotteet(kategoria));

        return "tuotteet";
    }
}
