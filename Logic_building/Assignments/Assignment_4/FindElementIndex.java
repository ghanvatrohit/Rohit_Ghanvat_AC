package Logic_building.Assignments.Assignment_4;
import java.util.Arrays;
import java.util.Scanner;

public class FindElementIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        Integer arr[] = new Integer[n];
        System.out.print("Enter the " + n + " integers: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.print("Enter the number to search: ");
        int search = sc.nextInt();

        int index = Arrays.binarySearch(arr, search);

        if(index >=0 ){
            System.out.print("The number "+search+" is found at index "+ index);
        }else{
            System.out.println("Not Found");
        }

        sc.close();
    }
}
