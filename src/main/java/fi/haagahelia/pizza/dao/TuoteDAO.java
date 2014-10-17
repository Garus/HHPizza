package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.Tuote;
import java.util.List;


public interface TuoteDAO {
    
	public void addTuote(Tuote p);

	public void updateTuote(Tuote p);

	public List<Tuote> getAllTuote(int type);

	public Tuote getTuoteById(int id);

	public void removeTuote(Tuote p);
}
