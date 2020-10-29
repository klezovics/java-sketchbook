package com.klezovich.demo.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsBiggerThanThousand  extends TypeSafeMatcher {

    @Override
    protected boolean matchesSafely(Object o) {

        var val = ((Number)o).intValue();
        if( val > 1000 ){
            return true;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {

    }

    public static Matcher biggerThanThousand() {
        return new IsBiggerThanThousand();
    }
}
