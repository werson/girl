package com.werson.cube;

public enum  Side {
    row_one(1),
    row_two(2),
    row_three(3),
    col_one(4),
    col_two(5),
    col_three(6);

    private Integer side;

    Side(int side){
        this.side = side;
    }

    public int getSide(){
        return this.side;
    }
}
