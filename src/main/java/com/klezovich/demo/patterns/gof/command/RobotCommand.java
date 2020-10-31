package com.klezovich.demo.patterns.gof.command;

public interface RobotCommand {

    Robot.Coordinates execute(Robot r);
}
