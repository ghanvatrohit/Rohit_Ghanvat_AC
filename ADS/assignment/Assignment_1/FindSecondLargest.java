package array_practice;

import java.util.Scanner;

class firsSec {

    void findSecondLargest(int arr[]) {
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];

                if (secondLargest < largest && secondLargest != largest) {
                    largest = arr[i];
                }
            }
        }

        System.out.println("Largest Number is " + largest);
        System.out.println("Second Largest Number is " + secondLargest);
    }

}

public class FindSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array = ");
        int size = sc.nextInt();

        if (size < 3) {
            System.out.println("Enter atleast 3 number in array.");
            sc.close();
            return;
        }
        int[] arr = new int[size];

        System.out.println("Enter the " + size + " Numbers");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array :- ");
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
        firsSec fs = new firsSec();
        fs.findSecondLargest(arr);
        sc.close();
    }
}
