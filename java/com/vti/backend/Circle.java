package com.vti.backend;

public class Circle extends Geometry {
    private double hemimorph;
    public Circle(double hemimorph) throws GeometryException{
        super();
        this.hemimorph = hemimorph;
    }

    public double perimeter() {
        return 2 * Math.PI ;
    }


    public double area() {
        return Math.PI ;
    }
}
