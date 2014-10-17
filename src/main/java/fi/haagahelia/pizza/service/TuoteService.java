/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.haagahelia.pizza.service;

import fi.haagahelia.pizza.domain.Tuote;
import java.util.List;

public interface TuoteService {
    
	List<Tuote> getAllTuote(int type);

	Tuote getTuoteById(int id);

	void addTuote(Tuote p);

	void removeTuote(Tuote p);
}
