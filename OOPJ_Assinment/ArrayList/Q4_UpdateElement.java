package ArrayList;

import java.util.ArrayList;

public class Q4_UpdateElement {

    public static void main(String[] args) {

        // Create an ArrayList of String
        ArrayList<String> colors = new ArrayList<>();

        // Add colors to the ArrayList
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        // Display the original ArrayList
        System.out.println("Before updating: " + colors);

        // Update the element at index 2
        colors.set(2, "Purple");

        // Display the updated ArrayList
        System.out.println("After updating: " + colors);
    }
}
