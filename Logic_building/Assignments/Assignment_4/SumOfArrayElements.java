package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class SumOfArrayElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int arr[] = new int[n];
        System.out.print("Enter the "+n+" integers: ");

        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int num : arr){
            sum += num;
        }

        System.out.println("The sum of all numbers is: "+sum);
        sc.close();
    }
}
