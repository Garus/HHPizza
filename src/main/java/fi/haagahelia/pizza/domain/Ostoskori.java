package fi.haagahelia.pizza.domain;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope("session")
public class Ostoskori {

    private static final Logger logger = Logger.getLogger(Ostoskori.class);
    private List<OstoskorinTuote> tuotteet;

    public Ostoskori() {
        super();
        tuotteet = new ArrayList<>();
    }

    public List<OstoskorinTuote> getTuotteet() {
        return tuotteet;
    }

    public void lisääTuoteKoriin(Tuote tuote) {

        boolean isTuoteKorissa = true;
        for (OstoskorinTuote korinTuote : tuotteet) {
            if (korinTuote.getTuote().equals(tuote)) {
                korinTuote.lisaaLukumaara();
                isTuoteKorissa = false;
            }
        }

        if (isTuoteKorissa) {
            tuotteet.add(new OstoskorinTuote(tuote));
        }
    }

    public boolean poistaTuoteKorista(Tuote tuote, boolean poistaKaikki) {
        boolean ok = false;
        for (Iterator<OstoskorinTuote> it = tuotteet.iterator(); it.hasNext();) {
            OstoskorinTuote korinTuote = it.next();
            if (korinTuote.getTuote().equals(tuote)) {
                if (poistaKaikki) {
                    it.remove();
                    ok = true;
                } else {
                    if (korinTuote.getMaara() == 1) {
                        it.remove();
                        ok = true;
                    } else {
                        korinTuote.vahennaLukumaara();
                    }
                }
            }
        }
        return ok;
    }

    public int getCount() {
        int lkm = 0;
        for (OstoskorinTuote korinTuote : tuotteet) {
            lkm += korinTuote.getMaara();
        }
        return lkm;
    }

    public void poistaKaikki() {
        this.tuotteet.clear();
    }

    public double getSum() {
        double sum = 0;

        for (OstoskorinTuote korinTuote : tuotteet) {
            sum += korinTuote.getSumma();
        }

        return sum;
    }
}
