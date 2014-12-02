package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.Tuote;

import java.util.List;
/**
 *  Service tason käyttöliittymä ostoskoriin liittyviin toimintoihin.
 * <p>
 * Välittää tietoja controller tason OstoskoriController-luokasta model tason 
 * OstoskoriDAO käyttöliittymälle.
 * 
 * @author Heikki Telinen
 * @version %I%
 * 
 * @see fi.haagahelia.pizza.controller.OstoskoriController
 * @see fi.haagahelia.pizza.dao.OstoskoriDAO
 * @see fi.haagahelia.pizza.domain.Ostoskori
 */
public interface OstoskoriService {
    /**
     * Lisää sessioon Tuote luokan olion.
     * <p>
     * Jos vastaavia Tuote-luokan olioita on jo mallissa, näkyy tämä kasvavana
     * lukuna.
     * 
     * @param tuote Tuote-luokan olio
     */
    void lisaaTuote(Tuote tuote);
    /**
     * Poistaa sessiosta tietyn Tuote-luokan olion. Tarkennus tapahtuu
     * tuote-olion id attribuutin perusteella.
     * 
     * @param tuote
     * @return tosi jos tuote poistettiin, epätosi jos ei
     */
    boolean poistaTuote(Tuote tuote);
    /**
     * Poistaa tietyn tuote-olion instanssin sessiosta.
     * 
     * @param tuote
     * @return tosi jos vähennys onnistui, muuten epätosi
     */
    boolean vahennaTuote(Tuote tuote);
    /**
     * Ostoskorissa olevien tuotteiden hinta-attribuutit yhteenlaskettuina.
     * 
     * @return yhteenlaskettu summa.
     */
    double getOstoskorinSumma();
    /**
     * Hakee ja palauttaa sessiossa olevien tuotteiden määrän
     * 
     * @return kokonaisluku, session sisältämien Tuote olioiden määrä
     */
    int getTuotteitaKorissa();
    /**
     * Poistaa kaikki sessiossa olevat Tuote-luokan oliot.
     */
    void tyhjennaOstoskori();
    /**
     * Palauttaa Ostoskori-luokan olion, jonka aliolioina ovat kaikki sen
     * sisältämät tuotteet
     * 
     * @return Ostoskori-luokan olio, session sisältämä ostoskori
     */
    Ostoskori getOstoskori();
    /**
     * Valitsee sessiosta Tuote-luokan olion lisäasetuksia varten
     * 
     * @param tuote Tuote-luokan olio jota muokataan
     */
    void setMuokattavaTuote(Tuote tuote);
    /**
     * Palauttaa sessiosta Tuote-luokan olion tietyllä id-attribuutilla 
     * tunnistaen
     * 
     * @param id kokonaisluku, Tuote-luokan olion id attribuutti
     * @return Tuote-luokan olio jota muokataan
     */
    Tuote getMuokattavaTuote(int id);
    /**
     * Listaa kaikki session sisältämät Tuote-luokan oliot
     * 
     * @return Lista, session sisältämät Tuote-luokan oliot
     */
    List<Tuote> getTuotteet();
    /**
     * Muokkaa tiettyä session sisältämää Tuote-luokan oliota, liittämällä
     * siihen LisaAine-luokan olion id:n attribuutiksi
     * 
     * @param pizzaiId kokonaisluku, muokattavan tuotteen id attribuutti
     * @param aine LisaAine-luokan olio
     */
    void lisaaAinePizzaan(int pizzaiId, LisaAine aine);
    /**
     * Muokkaa tiettyä session sisältämää Tuote-luokan oliota, poistamalla
     * siihen liitetyn LisaAine-luokan olion
     * 
     * @param pizzaiId kokonaisluku, muokattavan pizzan id attribuutti 
     * @param aine LisaAine-luokan olio
     */
    void poistaAinePizzasta(int pizzaiId, LisaAine aine);
}
