package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.Ostoskori;
import fi.haagahelia.pizza.domain.Tuote;

import java.util.List;

public interface OstoskoriService {
    void lisaaTuote(Tuote tuote);

    boolean poistaTuote(Tuote tuote);

    boolean vahennaTuote(Tuote tuote);

    double getOstoskorinSumma();

    int getTuotteitaKorissa();

    void tyhjennaOstoskori();

    Ostoskori getOstoskori();

    void setMuokattavaTuote(Tuote tuote);

    Tuote getMuokattavaTuote(int id);

    List<Tuote> getTuotteet();


}
