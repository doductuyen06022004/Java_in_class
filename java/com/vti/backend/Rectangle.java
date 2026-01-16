package com.vti.backend;

public class Rectangle extends Geometry {
    private int length;
    private int with;
    public Rectangle(int length, int with) throws GeometryException{
        super();
        this.length = length;
        this.with = with;
    }


}
