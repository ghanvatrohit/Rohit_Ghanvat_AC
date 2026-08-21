package Logic_building.Assignments.Assignment_4;

import java.util.Scanner;

public class PrintStringArrayNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;
        String arr[] = new String[n];

        System.out.print("Enter " + n + " names: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String name : arr) {
            System.out.print(name + " ");
        }
        sc.close();
    }
}
