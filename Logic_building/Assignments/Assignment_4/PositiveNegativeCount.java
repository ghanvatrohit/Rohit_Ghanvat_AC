package Logic_building.Assignments.Assignment_4;

import java.util.Scanner;

public class PositiveNegativeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int arr[] = new int[n];
        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pos = 0;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos++;
            } else if (arr[i] < 0) {
                neg++;
            }
        }
        System.out.println("Positive numbers : " + pos + "\nNegative numbers : " + neg);
        sc.close();
    }
}
