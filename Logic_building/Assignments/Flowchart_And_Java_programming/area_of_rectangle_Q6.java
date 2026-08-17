package Logic_building.Assignments.Flowchart_And_Java_programming;
import java.util.Scanner;

public class area_of_rectangle_Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of rectangle = ");
        int length = sc.nextInt();

        System.out.print("Enter the width of rectangle = ");
        int width = sc.nextInt();

        int area = length * width;

        System.out.println("Length of rectangle = "+length);
        System.out.println("Width of rectangle = "+width);
        System.out.println("Area of rectangle = "+area);
        sc.close();
    }
}
