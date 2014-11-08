package fi.haagahelia.pizza.dao;

import fi.haagahelia.pizza.domain.Tilaus;

public interface TilausDAO {
    int tallennaTilaus(Tilaus tilaus);
}
