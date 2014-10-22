package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Tuote;

public interface TuoteService {

    List<Tuote> haeKaikkiTuotteet();

    Tuote haeTuoteTunnuksella(int id);

    void lisääTuote(Tuote p);

    void poistaTuote(Tuote p);

    void päivitäTuote(Tuote p);
}
