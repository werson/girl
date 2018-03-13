package com.werson.cube;

public abstract class Rotate {

    protected Direction direction;

    protected Side side;

    protected int rotateNum;

    Rotate(){}

    Rotate (Direction direction, Side side, int rotateNum){
        this.direction = direction;
        this.side = side;
        this.rotateNum = rotateNum;
    }

    public abstract void action(String[][] magicCube);
}
