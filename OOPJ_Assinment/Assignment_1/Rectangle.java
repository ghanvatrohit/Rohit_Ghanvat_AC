class Rectangle {

    int length;
    int breadth;

    // Constructor
    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    // Method to calculate area
    int area() {
        return length * breadth;
    }

    public static void main(String[] args) {

        // First rectangle
        Rectangle r1 = new Rectangle(4, 5);

        // Second rectangle
        Rectangle r2 = new Rectangle(5, 8);

        System.out.println("Area of first rectangle: " + r1.area());
        System.out.println("Area of second rectangle: " + r2.area());
    }
}