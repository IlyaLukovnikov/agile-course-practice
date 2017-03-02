package ru.unn.agile.IntersectLineAndPlane.viewmodel;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class RegexMatcher extends BaseMatcher {
    private final String reg;

    public RegexMatcher(final String regex) {
        this.reg = regex;
    }

    public boolean matches(final Object o) {
        return ((String) o).matches(reg);
    }

    public void describeTo(final Description description) {
        description.appendText("matches reg = ");
        description.appendText(reg);
    }

    public static Matcher<? super String> matchesPattern(final String reg) {
        RegexMatcher matcher = new RegexMatcher(reg);
        @SuppressWarnings (value = "unchecked")
        Matcher<? super String> castedMatcher = (Matcher<? super String>)   matcher;
        return castedMatcher;
    }
}
