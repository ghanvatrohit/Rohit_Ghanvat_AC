package Logic_building.Assignments.Assignment_3;

import java.util.Scanner;

public class positive_number_do_while_P4 {
    public static void askForPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter the number = ");
            num = sc.nextInt();
        } while (num <= 0);
        System.out.println("You entered a positive number = " + num);
        sc.close();
    }

    public static void main(String[] args) {
        askForPositiveNumber();
    }

}
