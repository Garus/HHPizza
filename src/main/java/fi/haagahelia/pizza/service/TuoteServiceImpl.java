package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kategoria;
import fi.haagahelia.pizza.domain.Tuote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.TuoteDAO;

@Service
public class TuoteServiceImpl implements TuoteService {

    private TuoteDAO tuoteDAO;

    public void setTuoteDAO(TuoteDAO tuoteDAO) {
        this.tuoteDAO = tuoteDAO;
    }

    @Override
    @Transactional
    public List<Tuote> haeKaikkiTuotteet() {

        return tuoteDAO.haeKaikkiTuotteet();
    }

    @Override
    @Transactional
    public Tuote haeTuoteTunnuksella(int id) {

        return tuoteDAO.haeTuoteTunnuksella(id);
    }

    @Override
    @Transactional
    public void lisääTuote(Tuote p) {
        tuoteDAO.addTuote(p);

    }

    @Override
    @Transactional
    public void päivitäTuote(Tuote p) {
        tuoteDAO.updateTuote(p);

    }

    @Override
    @Transactional
    public void poistaTuote(Tuote p) {
        tuoteDAO.poistaTuote(p);

    }

    @Override
    @Transactional
    public List<Kategoria> haeKaikkiKategoriat() {
        return tuoteDAO.haeKaikkiKategoriat();
    }

    @Override
    @Transactional
    public List<Tuote> haeKategorianTuotteet(String kategoria) {
        return tuoteDAO.haeKategorianTuotteet(kategoria);
    }
}
