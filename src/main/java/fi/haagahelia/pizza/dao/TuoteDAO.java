package fi.haagahelia.pizza.dao;

import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.LisaAine;
import fi.haagahelia.pizza.domain.Tuote;

public interface TuoteDAO {

	public void addTuote(Tuote p);

	public void updateTuote(Tuote p);

	public List<Tuote> haeKaikkiTuotteet();

	public Tuote haeTuoteTunnuksella(int id);

	public void poistaTuote(Tuote p);

	public List<Kategoria> haeKaikkiKategoriat();

	public List<Tuote> haeKategorianTuotteet(String kategoriaNimi);

	public List<LisaAine> haeKaikkiLisaAineet();
}
