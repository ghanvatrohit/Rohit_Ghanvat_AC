package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;
import java.util.Arrays;

public class SortArrayAscending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int arr[] = new int[n];
        System.out.print("Enter the " + n + " integers: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
        sc.close();
    }
}
