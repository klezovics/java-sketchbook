package com.klezovich.demo.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsRedCar extends TypeSafeMatcher {

    @Override
    protected boolean matchesSafely(Object o) {
        if(  !(o instanceof Car) ) {
            return false;
        }

        Car car = (Car) o;
        if( !"red".equals(car.getColor()) ) {
            return false;
        }

        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Not a red car");
    }

    public static Matcher redCar() {
        return new IsRedCar();
    }

}
