package com.klezovich.demo.patterns.gof.command;

public class MoveTwoEastCommand implements RobotCommand {

    @Override
    public Robot.Coordinates execute(Robot r) {
        r.moveEast();
        r.moveEast();
        return r.getCoordinates();
    }
}
