package Logic_building.Assignments.Flowchart_And_Java_programming;
import java.util.Scanner;

public class area_of_square_Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side of the Square = ");
        int side =  sc.nextInt();

        int area = side * side;
        System.out.println("Area of the square = " + area);
        sc.close();
    }
}
