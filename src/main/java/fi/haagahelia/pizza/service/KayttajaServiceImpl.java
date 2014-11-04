package fi.haagahelia.pizza.service;

import java.util.List;

import fi.haagahelia.pizza.domain.Kayttaja;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.haagahelia.pizza.dao.KayttajaDAO;

@Service
public class KayttajaServiceImpl implements KayttajaService {

	private KayttajaDAO kayttajaDAO;

	public void setKayttajaDAO(KayttajaDAO kayttajaDAO) {
		this.kayttajaDAO = kayttajaDAO;
	}

	@Override
	@Transactional
	public List<Kayttaja> haeKaikkiKayttajat() {

		return kayttajaDAO.haeKaikkiKayttajat();
	}

	@Override
	@Transactional
	public Kayttaja haeKayttajaTunnuksella(int id) {

		return kayttajaDAO.haeKayttajaTunnuksella(id);
	}

	@Override
	@Transactional
	public void lisääKayttaja(Kayttaja p) {
		kayttajaDAO.addKayttaja(p);
		
	}

    @Override
    @Transactional
    public void päivitäKayttaja(Kayttaja p) {
        kayttajaDAO.updateKayttaja(p);

    }

	@Override
	@Transactional
	public void poistaKayttaja(Kayttaja p) {
		kayttajaDAO.poistaKayttaja(p);
		
	}

}
