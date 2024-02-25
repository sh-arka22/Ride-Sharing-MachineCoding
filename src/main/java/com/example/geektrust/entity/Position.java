package com.example.geektrust.entity;

public class Position {
    private final Double x_axis;
    private final Double y_axis;

    public Position(Position position){
        this.x_axis = position.x_axis;
        this.y_axis = position.y_axis;
    }

    public Position(Double x_axis, Double y_axis){
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    public Double getX_axis() {
        return x_axis;
    }

    public Double getY_axis() {
        return y_axis;
    }
}
