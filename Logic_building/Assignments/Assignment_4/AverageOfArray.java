package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class AverageOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=5;
        int arr[] = new int[n];
        System.out.print("Enter "+5+" integers: ");
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        float sum=0;
        for(int i=0 ; i<n ; i++){
            sum += arr[i];
        }
        float average = sum/n;
        System.out.println("The average of the number is: "+average);
        sc.close();
    }
}
