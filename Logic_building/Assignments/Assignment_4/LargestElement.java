package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;
import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int arr[] = new int[n];

        System.out.println("Enter "+n+" integers: ");

        for(int i=0 ; i<n ;i++){
            arr[i] = sc.nextInt();
        }

        int largest = Arrays.stream(arr).max().getAsInt();
        
        System.out.println("The largest element is : "+ largest);
        sc.close();
    }
}
