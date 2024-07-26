package com.java17features.patternmatching;

public class PatternMatchingSwitchExample {

    public static void main(String[] args) {
        Object shape = getShape();

        String result = switch (shape) {
            case Circle c -> "Circle with radius " + c.radius();
            case Rectangle r -> "Rectangle with length " + r.length() + " and width " + r.width();
            case Square s -> "Square with side " + s.side();
            case null -> "No shape";
            default -> "Unknown shape";
        };

        System.out.println(result);
    }

    static Object getShape() {
        // Return a shape instance, for example:
        return new Circle(5);
    }

    // Shape classes
    static class Circle {
        private final int radius;

        Circle(int radius) {
            this.radius = radius;
        }

        public int radius() {
            return radius;
        }
    }

    static class Rectangle {
        private final int length;
        private final int width;

        Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public int length() {
            return length;
        }

        public int width() {
            return width;
        }
    }

    static class Square {
        private final int side;

        Square(int side) {
            this.side = side;
        }

        public int side() {
            return side;
        }
    }
}

