package array_practice;
import java.util.Scanner;

class MaxMin{
    void find(int arr[]) {
        if(arr.length == 0){
            System.out.println("Array is empty. ");
            return;
        }

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < 10; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
            if(min>arr[i]){
                min = arr[i];
            }
        }
        System.out.println("Maximum value is: "+max);
        System.out.println("Minimum valur is: "+ min);
    }
}
public class FindMaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array");
        int size = sc.nextInt();

        int[] myArray = new int[size];

        System.out.println("Enter "+size+" elements: ");
        for(int i=0 ; i<size ;i++){
            myArray[i] = sc.nextInt();
        }

        MaxMin obj = new MaxMin();

        obj.find(myArray);

        sc.close();

    }
}

// Time Complexity: O(n) <- main O(n) +  find O(n)
// Space Complexity: O(n)

// Algorithm
// Read the desired size of the array from the user.

// Allocate memory for an array of the specified size.

// Loop through the array to accept n integer inputs from the user.

// Pass the populated array to the target function to evaluate it.

// Check if the array is empty. If it is, terminate the operation to prevent errors.

// Initialize two variables, max and min, and set both to the value of the first element in the array (index 0).

// Iterate through the array starting from the first element to the last.

// During each iteration:

// If the current element is strictly greater than max, update max with the current element's value.

// If the current element is strictly less than min, update min with the current element's value.

// Print the final values of max and min.


// Here is the breakdown of the time complexity, algorithm, and pseudocode for finding the maximum and minimum values in an array.

// *Note: The analysis below assumes you have corrected the hardcoded loop `for (int i = 0; i < 10; i++)` in your `find` method to `for (int i = 0; i < arr.length; i++)` so the code scales with the user's input size.*

// ### Time & Space Complexity

// * **Time Complexity: O(n)**
// Where *n* is the size of the array. The `main` method has a loop that runs *n* times to take user input. The `find` method has a separate loop that traverses the array of size *n* exactly once to compare the elements. Since these loops run sequentially (not nested), the total time complexity is O(n) + O(n), which simplifies to **O(n)** linear time.
// *(Note: If the loop strictly ran 10 times as written in your snippet, the time complexity for that specific block would technically be O(1) constant time, but it would crash for arrays smaller than 10).*
// * **Space Complexity: O(n)**
// The program creates a new array of size *n* dynamically in the memory (`new int[size]`). The auxiliary space used by the variables `max`, `min`, and `i` is minimal and constant O(1), making the total space complexity strictly dependent on the array size, which is **O(n)**.

// ### Algorithm

// 1. Read the desired size of the array from the user.
// 2. Allocate memory for an array of the specified size.
// 3. Loop through the array to accept *n* integer inputs from the user.
// 4. Pass the populated array to the target function to evaluate it.
// 5. Check if the array is empty. If it is, terminate the operation to prevent errors.
// 6. Initialize two variables, `max` and `min`, and set both to the value of the first element in the array (index 0).
// 7. Iterate through the array starting from the first element to the last.
// 8. During each iteration:
// * If the current element is strictly greater than `max`, update `max` with the current element's value.
// * If the current element is strictly less than `min`, update `min` with the current element's value.


// 9. Print the final values of `max` and `min`.

// ### Pseudocode

// ```text
// BEGIN
//     // Main Method Execution
//     PRINT "Enter the size of array"
//     INPUT size
    
//     CREATE myArray of size
    
//     PRINT "Enter elements:"
//     FOR i = 0 TO size - 1
//         INPUT myArray[i]
//     END FOR
    
//     CALL findMaxMin(myArray)
// END

// PROCEDURE findMaxMin(arr)
//     // Edge case check
//     IF length of arr == 0 THEN
//         PRINT "Array is empty."
//         RETURN
//     END IF
    
//     // Initialization
//     SET max = arr[0]
//     SET min = arr[0]
    
//     // Traversal and Comparison
//     FOR i = 0 TO length of arr - 1
//         IF arr[i] > max THEN
//             SET max = arr[i]
//         END IF
        
//         IF arr[i] < min THEN
//             SET min = arr[i]
//         END IF
//     END FOR
    
//     PRINT "Maximum value is: " + max
//     PRINT "Minimum value is: " + min
// END PROCEDURE

// ```