package fi.haagahelia.pizza.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.TuoteDAO;
import fi.haagahelia.pizza.domain.Tuote;

@Service
public class TuoteServiceImpl implements TuoteService {

    private TuoteDAO tuoteDAO;

    public void setTuoteDAO(TuoteDAO tuoteDAO) {
            this.tuoteDAO = tuoteDAO;
    }
    
    @Override
    @Transactional
    public List<Tuote> getAllTuote(int type) {
        return tuoteDAO.getAllTuote(type);
    }

    @Override
    @Transactional
    public Tuote getTuoteById(int id) {
        return tuoteDAO.getTuoteById(id);
    }

    @Override
    @Transactional
    public void addTuote(Tuote p) {
        tuoteDAO.addTuote(p);
    }

    @Override
    @Transactional
    public void removeTuote(Tuote p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
