import java.util.Scanner;

class Complex {

    double real;
    double imaginary;

    // Constructor
    Complex(double r, double i) {
        real = r;
        imaginary = i;
    }

    // Method for sum
    Complex sum(Complex c) {
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    // Method for difference
    Complex difference(Complex c) {
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    // Method for product
    Complex product(Complex c) {
        double r = (real * c.real) - (imaginary * c.imaginary);
        double i = (real * c.imaginary) + (imaginary * c.real);

        return new Complex(r, i);
    }

    // Display complex number
    void display() {
        System.out.println(real + " + " + imaginary + "i");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First complex number
        System.out.print("Enter real part of first number: ");
        double r1 = sc.nextDouble();

        System.out.print("Enter imaginary part of first number: ");
        double i1 = sc.nextDouble();

        // Second complex number
        System.out.print("Enter real part of second number: ");
        double r2 = sc.nextDouble();

        System.out.print("Enter imaginary part of second number: ");
        double i2 = sc.nextDouble();

        // Creating objects
        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        // Operations
        Complex addition = c1.sum(c2);
        Complex subtraction = c1.difference(c2);
        Complex multiplication = c1.product(c2);

        // Display results
        System.out.print("Sum: ");
        addition.display();

        System.out.print("Difference: ");
        subtraction.display();

        System.out.print("Product: ");
        multiplication.display();

        sc.close();
    }
}