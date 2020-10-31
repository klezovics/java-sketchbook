package com.klezovich.demo.patterns.gof.command;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RobotCommandTest {

    @Test
    public void testRobotCommandSequence() {
        Robot r = new Robot();
        assertThat(r.getCoordinates().getX(), is(0));
        new MoveTwoEastCommand().execute(r);
        assertThat(r.getCoordinates().getX(), is(2));
        new MoveTwoWestCommand().execute(r);
        assertThat(r.getCoordinates().getX(), is(0));
    }
}