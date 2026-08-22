package Logic_building.Assignments.Assignment_4;
import java.util.Arrays;
import java.util.Scanner;

public class SearchElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        Integer arr[] = new Integer[n];
        System.out.print("Enter the " + n + " integers: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number to search: ");
        int search = sc.nextInt();

        if(Arrays.asList(arr).contains(search)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
        sc.close();
    }
}
