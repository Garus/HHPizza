package fi.haagahelia.pizza.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OstoskoriTest {

    private Ostoskori ostoskori;
    private Tuote tuote;

    @Before
    public void setUp() throws Exception {
        ostoskori = new Ostoskori();
        tuote = new Tuote(100, "sata", 100.00);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLisääTuote() throws Exception {
        ostoskori.lisääTuoteKoriin(tuote);
        assertTrue(ostoskori.getCount() == 1);
    }

    @Test
    public void testPoistaTuote() throws Exception {
        ostoskori.lisääTuoteKoriin(tuote);
        assertTrue(ostoskori.poistaTuoteKorista(new Tuote(100, "sata", 100.00), true));
    }

    @Test
    public void testGetCount() throws Exception {
        ostoskori.lisääTuoteKoriin(new Tuote(1, "yksi", 1.0));
        assertTrue(1 == ostoskori.getCount());
    }

    @Test
    public void testPoistaKaikki() throws Exception {
        ostoskori.lisääTuoteKoriin(tuote);
        ostoskori.poistaKaikki();
        assertTrue(0 == ostoskori.getCount());
    }

    @Test
    public void testGetSum() throws Exception {
        ostoskori.lisääTuoteKoriin(tuote);
        ostoskori.lisääTuoteKoriin(tuote);
        ostoskori.lisääTuoteKoriin(tuote);
        assertTrue(ostoskori.getSum() == (3 * tuote.getHinta()));

    }
}