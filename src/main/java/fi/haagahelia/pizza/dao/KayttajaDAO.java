package fi.haagahelia.pizza.dao;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;

public interface KayttajaDAO {

	public void addKayttaja(Kayttaja p);

	public void updateKayttaja(Kayttaja p);

	public List<Kayttaja> haeKaikkiKayttajat();

	public Kayttaja haeKayttajaTunnuksella(int id);

	public void poistaKayttaja(Kayttaja p);

    public List<Roolit> haeKayttajaRoolit();
}
    