package OOPJ_Assinment.Assignment_2;
class Rectangle {

    private float length;
    private float breadth;

    // Parameterized Constructor
    Rectangle(float length, float breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void printArea() {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    public void printPerimeter() {
        System.out.println("Perimeter of Rectangle: " + (2 * (length + breadth)));
    }
}

class Square extends Rectangle {

    // Parameterized Constructor
    Square(float side) {
        super(side, side);
    }
}

public class Q3_Rectangle {

    public static void main(String[] args) {

        System.out.print("Enter length of rectangle: ");
        float length = ConsoleInput.getFloat();

        System.out.print("Enter breadth of rectangle: ");
        float breadth = ConsoleInput.getFloat();

        Rectangle rectangle = new Rectangle(length, breadth);

        System.out.print("Enter side of square: ");
        float side = ConsoleInput.getFloat();

        Square square = new Square(side);

        System.out.println("\n--- Rectangle ---");
        rectangle.printArea();
        rectangle.printPerimeter();

        System.out.println("\n--- Square ---");
        square.printArea();
        square.printPerimeter();
    }
}

