package OOPJ_Assinment.Assignment_2;

class Shape {

    void printShape() {
        System.out.println("This is shape");
    }
}

class Rectangle extends Shape {

    void printRectangle() {
        System.out.println("This is rectangular shape");
    }
}

class Circle extends Shape {

    void printCircle() {
        System.out.println("This is circular shape");
    }
}

class Square extends Rectangle {

    void printSquare() {
        System.out.println("Square is a rectangle");
    }
}

public class Q4_Shape {

    public static void main(String[] args) {

        Square square = new Square();

        // Method of Shape class using Square object
        square.printShape();

        // Method of Rectangle class using Square object
        square.printRectangle();

        // Method of Square class using Square object
        square.printSquare();
    }
}

