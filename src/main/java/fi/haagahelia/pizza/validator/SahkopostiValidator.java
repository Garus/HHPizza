package fi.haagahelia.pizza.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tämä koodi on osoitteesta:
 * This code is from:
 * http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
 */
public class SahkopostiValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public SahkopostiValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
