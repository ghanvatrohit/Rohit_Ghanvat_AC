class Triangle {

    int side1;
    int side2;
    int side3;

    // Constructor
    Triangle(int a, int b, int c) {
        side1 = a;
        side2 = b;
        side3 = c;
    }

    // Calculate perimeter
    int perimeter() {
        return side1 + side2 + side3;
    }

    // Calculate area
    double area() {
        return 0.5 * side1 * side2;
    }

    public static void main(String[] args) {

        // Creating object
        Triangle t = new Triangle(3, 4, 5);

        System.out.println("Perimeter of Triangle: " + t.perimeter());
        System.out.println("Area of Triangle: " + t.area());
    }
}