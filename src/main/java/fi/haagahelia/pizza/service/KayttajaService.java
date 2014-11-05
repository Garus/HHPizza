package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;

public interface KayttajaService {

    List<Kayttaja> haeKaikkiKayttajat();

    Kayttaja haeKayttajaTunnuksella(int id);

    void lisääKayttaja(Kayttaja p);

    void poistaKayttaja(Kayttaja p);

    void päivitäKayttaja(Kayttaja p);

    public List<Roolit> haeKayttajaRoolit();
}
