package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import fi.haagahelia.pizza.domain.Roolit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.KayttajaDAO;

/**
 * {@inheritDoc}
 */
@Service
public class KayttajaServiceImpl implements KayttajaService {

    /**
     * KäyttäjäDAO luokan olio
     */
    private KayttajaDAO kayttajaDAO;

    /**
     * {@inheritDoc}
     */
    public void setKayttajaDAO(KayttajaDAO kayttajaDAO) {
        this.kayttajaDAO = kayttajaDAO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Kayttaja> haeKaikkiKayttajat() {

        return kayttajaDAO.haeKaikkiKayttajat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Kayttaja haeKayttajaTunnuksella(int id) {

        return kayttajaDAO.haeKayttajaTunnuksella(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void lisääKayttaja(Kayttaja p) {
        kayttajaDAO.addKayttaja(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void päivitäKayttaja(Kayttaja p) {
        kayttajaDAO.updateKayttaja(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void poistaKayttaja(Kayttaja p) {
        kayttajaDAO.poistaKayttaja(p);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Roolit> haeKayttajaRoolit() {
        return kayttajaDAO.haeKayttajaRoolit();
    }

}
