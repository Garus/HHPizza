package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.Tuote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.TuoteDAO;

/**
 * {@inheritDoc}
 */
@Service
public class TuoteServiceImpl implements TuoteService {

    /**
     * TuoteDAO-luokan olio
     */
    private TuoteDAO tuoteDAO;

    /**
     * {@inheritDoc}
     */
    public void setTuoteDAO(TuoteDAO tuoteDAO) {
        this.tuoteDAO = tuoteDAO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Tuote> haeKaikkiTuotteet() {

        return tuoteDAO.haeKaikkiTuotteet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Tuote haeTuoteTunnuksella(int id) {

        return tuoteDAO.haeTuoteTunnuksella(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void lisääTuote(Tuote p) {
        tuoteDAO.addTuote(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void päivitäTuote(Tuote p) {
        tuoteDAO.updateTuote(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void poistaTuote(Tuote p) {
        tuoteDAO.poistaTuote(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Kategoria> haeKaikkiKategoriat() {
        return tuoteDAO.haeKaikkiKategoriat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Tuote> haeKategorianTuotteet(String kategoria) {
        return tuoteDAO.haeKategorianTuotteet(kategoria);
    }
}
