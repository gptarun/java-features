package com.java17features.sealedclass;

public class SealedClass {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        describeShape(circle);
        describeShape(rectangle);
        describeShape(triangle);
    }

    public static void describeShape(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Circle it is");
        } else if (shape instanceof Rectangle) {
            System.out.println("rectangle it is");
        } else if (shape instanceof Triangle) {
            System.out.println("triangle it is");
        }
    }
}
