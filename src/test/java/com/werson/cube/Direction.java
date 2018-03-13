package com.werson.cube;

public enum Direction {
    turn_up("1"),
    turn_down("2"),
    turn_right("3"),
    turn_left("4");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @SuppressWarnings("unused")
    public String getDirection() {
        return direction;
    }
}
