package com.example.inspiration.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"@"
            +"[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"\\.[a-zA-Z]{2,}$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
