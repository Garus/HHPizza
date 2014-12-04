package fi.haagahelia.pizza.domain;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope("session")
public class MuokattavatTuotteet {

    private static final Logger logger = Logger.getLogger(MuokattavatTuotteet.class);
    private Map<Integer, Tuote> tuotteet = new HashMap<>();

    public Map<Integer, Tuote> getTuotteet() {
        return tuotteet;
    }

    /**
     * palauttaa kaikki sessiossa olevat tuotteet listana
     * @return tuote lista
     */
    public List<Tuote> getTuotteetAsList() {
        List<Tuote> tuoteLista = new ArrayList<>(tuotteet.values());
        return tuoteLista;
    }

    /**
     *
     * @param id tuote id
     * @return Tuote
     */
    public Tuote getTuote(int id) {
        return tuotteet.get(id);
    }

    public void setTuote(Tuote tuote) {

        if (tuotteet.containsKey(tuote.getId())) {
            logger.info("existing Tuote: " + tuote.toString());
        } else {
            tuotteet.put(tuote.getId(), tuote);
            logger.info("put new Tuote: " + tuote.toString());
        }

    }

    public void poistaTuote(int tuoteId) {

        if (tuotteet.containsKey(tuoteId)) {
            tuotteet.remove(tuoteId);
        }

    }

    public MuokattavatTuotteet() {
        super();
    }


}
