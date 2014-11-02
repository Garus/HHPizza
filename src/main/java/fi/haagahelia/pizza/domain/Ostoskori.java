package fi.haagahelia.pizza.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("session")
public class Ostoskori {

    private List<Tuote> tuotteet;

    public Ostoskori() {
        super();
        tuotteet = new ArrayList<>();
    }

    public List<Tuote> getTuotteet() {
        return tuotteet;
    }
    public boolean lisääTuote(Tuote tuote) {
        return tuotteet.add(tuote);
    }

    public boolean poistaTuote(Tuote tuote) {
        return tuotteet.remove(tuote);
    }

    public int getCount() {
        return tuotteet.size();
    }

    public double getSum() {
        double sum = 0;

        for (Tuote tuote: tuotteet) {
            sum += tuote.getPrice();
        }

        return sum;
    }
}
