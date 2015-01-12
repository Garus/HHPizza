package fi.haagahelia.pizza.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostinumeroValidator {

    private static final String regex = "[0-9]{5}";
    private static Pattern pattern;


    public PostinumeroValidator() {
    }

    public static boolean validate(String postinumero) {
        pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(postinumero);
        return matcher.matches();
    }

    public static void main(String[] args) {

        String[] postinumerot = {"1234a", "00120", " 0123", "asXca"};
        for (String postinumero : postinumerot) {
            System.out.println(PostinumeroValidator.validate(postinumero));
        }
    }
}
