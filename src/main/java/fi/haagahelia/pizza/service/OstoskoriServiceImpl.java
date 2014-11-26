package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.MuokattavatPizzat;
import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.Tuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("request")
public class OstoskoriServiceImpl implements OstoskoriService {

    @Autowired
    private Ostoskori ostoskori;

    @Autowired
    private MuokattavatPizzat muokkaPizza;

    @Override
    public Ostoskori getOstoskori() {
        return ostoskori;
    }

    @Override
    public void setMuokattavaTuote(Tuote tuote) {
        muokkaPizza.setTuote(tuote);
    }

    @Override
    public Tuote getMuokattavaTuote(int id) {
        return muokkaPizza.getTuote(id);
    }

    @Override
    public List<Tuote> getTuotteet() {
        return muokkaPizza.getTuotteetAsList();
    }


    @Override
    public void lisaaTuote(Tuote tuote) {
        ostoskori.lisääTuoteKoriin(tuote);
    }

    @Override
    public boolean poistaTuote(Tuote tuote) {
        return ostoskori.poistaTuoteKorista(tuote, true);
    }

    @Override
    public boolean vahennaTuote(Tuote tuote) {
        return ostoskori.poistaTuoteKorista(tuote, false);
    }

    @Override
    public double getOstoskorinSumma() {
        return ostoskori.getSum();
    }

    @Override
    public int getTuotteitaKorissa() {
        return ostoskori.getCount();
    }

    @Override
    public void tyhjennaOstoskori() {
        ostoskori.poistaKaikki();
    }
}
