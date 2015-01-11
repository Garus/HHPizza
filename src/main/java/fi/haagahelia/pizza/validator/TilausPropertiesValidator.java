package fi.haagahelia.pizza.validator;

import fi.haagahelia.pizza.domain.Tilaaja;
import fi.haagahelia.pizza.domain.Tilaus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TilausPropertiesValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Tilaus.class.isAssignableFrom(clazz);
    }

    public void validate(Object var1, Errors errors) {
        Tilaus tilaus = (Tilaus) var1;
        Tilaaja tilaaja = tilaus.getTilaaja();
        if (tilaaja.getNimi().length() < 3 || tilaaja.getNimi().length() > 50) {
            errors.rejectValue("tilaaja.nimi", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.nimi_virhe");
        }

        if (tilaus.getOsoite().length() < 2 || tilaus.getOsoite().length() > 100) {
            errors.rejectValue("osoite", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.tilaus_katuosoite_virhe");
        }

        SahkopostiValidator sähköpostiValidator = new SahkopostiValidator();

        if (!sähköpostiValidator.validate(tilaaja.getEmail())) {
            errors.rejectValue("tilaaja.email", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.email_virhe");
        }

        if (tilaaja.getOsoite().getKatuOsoite().length() < 2 || tilaaja.getOsoite().getKatuOsoite().length() > 100) {
            errors.rejectValue("tilaaja.osoite.katuOsoite", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.katuosoite_virhe");
        }
        if (tilaaja.getOsoite().getPostinumero().getPostiNumero().length() != 5) {
            errors.rejectValue("tilaaja.osoite.postinumero.postiNumero", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.postinumero_virhe");
        }
        if (tilaaja.getOsoite().getPostinumero().getPostiToimiPaikka().length() < 2 || tilaaja.getOsoite().getPostinumero().getPostiToimiPaikka().length() > 100) {
            errors.rejectValue("tilaaja.osoite.postinumero.postiToimiPaikka", "fi.haagahelia.pizza.validator.TilausPropertiesValidator.postitoimipaikka_virhe");
        }

    }
}

