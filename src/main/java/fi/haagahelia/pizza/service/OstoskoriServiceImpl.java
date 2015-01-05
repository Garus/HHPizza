package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.MuokattavatTuotteet;
import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.PizzaTuote;
import fi.haagahelia.pizza.domain.Tuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * {@inheritDoc}
 */
@Service
@Scope("request")
public class OstoskoriServiceImpl implements OstoskoriService {
    /**
     * Ostoskori-luokan olio ostoskori
     */
    @Autowired
    private Ostoskori ostoskori;
    /**
     * MuokattavatTuotteet luokan olio muokkaPizza
     */
    @Autowired
    private MuokattavatTuotteet muokkaPizza;
    /**
     * {@inheritDoc}
     */
    @Override
    public Ostoskori getOstoskori() {
        return ostoskori;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setMuokattavaTuote(Tuote tuote) {
        muokkaPizza.setTuote(tuote);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Tuote getMuokattavaTuote(int id) {
        return muokkaPizza.getTuote(id);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tuote> getTuotteet() {
        return muokkaPizza.getTuotteetAsList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void lisaaAinePizzaan(int pizzaiId, LisaAine aine) {
        PizzaTuote tuote = (PizzaTuote) muokkaPizza.getTuote(pizzaiId);
        tuote.lisaaAinePizzaan(aine);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void poistaAinePizzasta(int pizzaId, LisaAine aine) {
        PizzaTuote tuote = (PizzaTuote) muokkaPizza.getTuote(pizzaId);
        tuote.poistaAinePizzasta(aine, true);
    }

    @Override
    public void poistaMuokattavaPizza(int pizzaid) {
        muokkaPizza.poistaTuote(pizzaid);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void lisaaTuote(Tuote tuote) {
        ostoskori.lisääTuoteKoriin(tuote);
    }

    @Override
    public void lisaaTuote(int tuoteId) {
        ostoskori.lisääTuoteKoriin(tuoteId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean poistaTuote(int tuoteId) {
        return ostoskori.poistaTuoteKorista(tuoteId, true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean vahennaTuote(int tuoteId) {
        return ostoskori.poistaTuoteKorista(tuoteId, false);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getOstoskorinSumma() {
        return ostoskori.getSum();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getTuotteitaKorissa() {
        return ostoskori.getCount();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void tyhjennaOstoskori() {
        ostoskori.poistaKaikki();
    }
}
