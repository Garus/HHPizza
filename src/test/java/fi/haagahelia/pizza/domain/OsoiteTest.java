package fi.haagahelia.pizza.domain;

import static org.junit.Assert.*;

public class OsoiteTest {

    Osoite osoite;
    @org.junit.Before
    public void setUp() throws Exception {
        osoite = new Osoite("Foostreet 1", new Postinumero("00100", "Helsinki"));
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testEquals() throws Exception {

    }

    @org.junit.Test
    public void testGetPostinumero() throws Exception {
        Postinumero p = new Postinumero("00100", "Helsinki");
        assertEquals(osoite.getPostinumero(), p);
    }

    public  void testGetOsoite() throws Exception {
        String os = "Foostreet 1";
        assertEquals(os, osoite.getKatuOsoite());
    }
}