package com.klezovich.demo.patterns.gof.command;

import static com.klezovich.demo.patterns.gof.command.Robot.Orientation.NORTH;

public class Robot {

    private final Coordinates coordinates;

    Robot() {
        coordinates = new Coordinates();
    }

    public Coordinates moveWest() {
        coordinates.setX(coordinates.getX() - 1);
        return new Coordinates(coordinates);
    }

    public Coordinates moveEast() {
        coordinates.setX(coordinates.getX() + 1);
        return new Coordinates(coordinates);
    }

    public Coordinates getCoordinates() {
        return new Coordinates(coordinates);
    }

    static class Coordinates {

        private int x;
        private int y;
        private Orientation orientation;

        Coordinates() {
            this.x = 0;
            this.y = 0;
            this.orientation = NORTH;
        }

        Coordinates(int x, int y, Orientation orientation) {
            this.x = x;
            this.y = y;
            this.orientation = orientation;
        }

        Coordinates(Coordinates coordinates) {
            this.x = coordinates.getX();
            this.y = coordinates.getY();
            this.orientation = coordinates.getOrientation();
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Orientation getOrientation() {
            return orientation;
        }

        public void setOrientation(Orientation orientation) {
            this.orientation = orientation;
        }
    }

    static enum Orientation {
        NONE,
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
}
