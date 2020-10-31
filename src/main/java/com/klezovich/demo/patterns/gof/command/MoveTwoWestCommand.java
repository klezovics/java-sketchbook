package com.klezovich.demo.patterns.gof.command;

public class MoveTwoWestCommand implements RobotCommand {

    @Override
    public Robot.Coordinates execute(Robot r) {
        r.moveWest();
        r.moveWest();
        return r.getCoordinates();
    }
}
