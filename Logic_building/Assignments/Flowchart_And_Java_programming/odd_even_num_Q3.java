package Logic_building.Assignments.Flowchart_And_Java_programming;

import java.util.Scanner;

public class odd_even_num_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of X :- ");

        int X = sc.nextInt();

        if (X == 0) {
            System.out.println("The given number is zero.");
        } else if (X %2== 0) {
            System.out.println("The given number is even");
        } else {
            System.out.println("The given number is odd");
        }
        sc.close();
    }
}
