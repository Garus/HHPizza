package fi.haagahelia.pizza.controller;

import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.Tuote;
import fi.haagahelia.pizza.service.OstoskoriService;
import fi.haagahelia.pizza.service.TuoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller ostoskoriin liittyviin toimintoihin.
 * <p/>
 * Välittää tietoja metodeissa kartoitettujen view tason jsp sivujen ja model
 * tason tuoteService ja ostoskoriService luokkien välillä. Kartoitus /ostoskori
 *
 * @author Heikki Telinen
 * @version %I%
 * @see TuoteService
 * @see OstoskoriService
 */
@Controller
@Scope("request")
@RequestMapping("/ostoskori")
public class OstoskoriController {

    private static final Logger logger = Logger.getLogger(OstoskoriController.class);

//    @Autowired
//    private Ostoskori cart;
    /**
     * Service-tason luokan olio
     */
    @Autowired
    private TuoteService tuoteService;
    /**
     * Service-tason luokan olio
     */
    @Autowired
    private OstoskoriService ostoskoriService;

    /**
     * Määrittelee mallin ja näkymän välisen yhteyden sitomalla OstoskoriService
     * olion malliin.
     *
     * @param model malli jota käytetään
     * @return ModelAndView olio jossa määritelty ostoskori näkyymä
     */
    @RequestMapping
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ostoskori", ostoskoriService.getOstoskori());
        modelAndView.setViewName("ostoskori");
        return modelAndView;
    }

    /**
     * Lisää OstoskoService luokan olioon TuoteService-luokan olion uutena
     * tuotteena. Kartoitus /ostoskori/lisää
     *
     * @param id kokonaisluku, ostoskoriin lisättävän tuotteen id
     * @return uudelleenohjaus /ostoskori
     */
    @RequestMapping("/lisaa")
    public String lisääKoriin(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        ostoskoriService.lisaaTuote(tuote);
        return "redirect:/ostoskori";
    }

    /**
     * Vähentää OstoskoriService-luokan oliosta yhden TuoteService-luokan
     * tuotteen id numerolla määritellyistä olioista. /ostoskori/vahenna
     *
     * @param id kokonaisluku, mallista vähennettävän tuotteen id
     * @return uudelleenohjaus /ostoskori
     */
    @RequestMapping("/vahenna")
    public String vahennaTuoteKorista(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        boolean succ = ostoskoriService.vahennaTuote(tuote);
        logger.info("Tuotteen poisto: " + (succ == true ? "onnistui" : "epäonnistui"));

        return "redirect:/ostoskori";
    }

    /**
     * Poistaa OstoskoriService-luokan oliosta yhden TuoteService-luokan
     * tuotteen id numerolla määritellyistä olioista. Kartoitus
     * /ostoskori/poista
     *
     * @param id kokonaisluku, mallista vähennettävän tuotteen id
     * @return uudelleenohjaus /ostoskori
     */
    @RequestMapping("/poista")
    public String poistaKorista(@RequestParam("id") int id) {

        Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
        logger.info("Löydettiin tuote: " + tuote);
        boolean succ = ostoskoriService.poistaTuote(tuote);
        logger.info("Tuotteen poisto: " + (succ == true ? "onnistui" : "epäonnistui"));

        return "redirect:/ostoskori";
    }

    /**
     * Poistaa OstoskoriService-luokan oliosta kaikki TuoteService-luokan
     * tuotteet. Kartoitus /ostoskori/tyhjenna
     *
     * @return uudelleenohjaus /ostoskori
     */

    @RequestMapping("/tyhjenna")
    public String poistaKaikkiTuotteet() {
        ostoskoriService.tyhjennaOstoskori();
        return "redirect:/ostoskori";
    }

    /**
     * Lisää muokattava pizza sessioon
     *
     * @param model
     * @param id    tuote (pizza) id
     * @return uudelleenphjaus muokkaapizzaa nkäymään
     */
    @RequestMapping(value = "/muokkaapizza/id", method = RequestMethod.GET)
    public String muokkaaPizzaa(Model model, @RequestParam(required = false) Integer id) {

        if (id != null && id > 0) {
            Tuote tuote = tuoteService.haeTuoteTunnuksella(id);
            ostoskoriService.setMuokattavaTuote(tuote);
        }
        return "redirect:/ostoskori/muokkaapizza";
    }

    /**
     * hae kategorian kaikki tuotteet
     *
     * @param model
     * @param kategoria kategorian id
     * @return
     */
    @RequestMapping("/{kategoria}")
    public String getProductsByCategory(Model model, @PathVariable("kategoria") String kategoria) {
        model.addAttribute("tuotteet", tuoteService.haeKategorianTuotteet(kategoria));

        return "tuotteet";
    }

    /**
     * lisää aine pizzaan
     *
     * @param model
     * @param aine  aineen id
     * @param pizza pizzan id
     * @return
     */
    @RequestMapping(value = "/muokkaapizza/lisaa", method = RequestMethod.GET)
    public String lisaAinePizzaan(Model model, @RequestParam(required = true) Integer aine, @RequestParam(required = true) Integer pizza) {

        if (aine != null || pizza != null) {
            LisaAine lisaAine = tuoteService.haeLisaAineTunnuksella(aine);
            if (lisaAine != null) {
                ostoskoriService.lisaaAinePizzaan(pizza, lisaAine);
            }
        }
        return "redirect:/ostoskori/muokkaapizza";
    }

    /**
     * Poista aine pizzasta
     *
     * @param model
     * @param pizza pizzan id
     * @param aine  aineen id
     * @return
     */
    @RequestMapping(value = "/muokkaapizza/aine/{pizza}/{aine}", method = RequestMethod.GET)
    public String poistaAinePizzasta(Model model, @PathVariable("pizza") Integer pizza, @PathVariable("aine") Integer aine) {

        if (aine != null && pizza != null) {
            LisaAine lisaAine = tuoteService.haeLisaAineTunnuksella(aine);
            if (lisaAine != null) {
                ostoskoriService.poistaAinePizzasta(pizza, lisaAine);
            }
        }
        return "redirect:/ostoskori/muokkaapizza";
    }

    /**
     * @param model
     * @return muokkaa pizzaa näkymä
     */
    @RequestMapping("/muokkaapizza")
    public String pizzaa(Model model) {

        List<LisaAine> aineet = tuoteService.haeKaikkiLisaAineet();
        List<Tuote> tuotteet = ostoskoriService.getTuotteet();

        model.addAttribute("tuotteet", tuotteet);
        model.addAttribute("lisaAineet", aineet);

        return "muokkaapizza";
    }

    /**
     * lisää muokattu tuote (pizza) ostoskoriin
     *
     * @param id pizzan id
     * @return uudelleenohjaus ostoskoriin
     */
    @RequestMapping("/lisaamuokattu")
    public String lisääMuokattuTuoteKoriin(@RequestParam("id") int id) {

        Tuote tuote = ostoskoriService.getMuokattavaTuote(id);
        logger.info("Löydettiin sessiosta tuote: " + tuote);
        ostoskoriService.lisaaTuote(tuote);
        return "redirect:/ostoskori";
    }
}
